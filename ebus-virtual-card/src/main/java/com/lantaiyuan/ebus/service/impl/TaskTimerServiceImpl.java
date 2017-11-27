package com.lantaiyuan.ebus.service.impl;

import java.math.BigDecimal;
import java.security.SignatureException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import javax.annotation.Resource;

import com.lantaiyuan.ebus.constants.BasicConstans;
import com.lantaiyuan.ebus.zookeeper.ZKClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.lanqiao.ssm.common.rsa.BalanceSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.dao.BaseStationMapper;
import com.lantaiyuan.ebus.dao.TaskTimerScannerMapper;
import com.lantaiyuan.ebus.model.BaseStation;
import com.lantaiyuan.ebus.model.BaseTravelOrder;
import com.lantaiyuan.ebus.model.Favoriate;
import com.lantaiyuan.ebus.model.RelRouteStation;
import com.lantaiyuan.ebus.service.TaskTimerServiceI;
import com.lantaiyuan.ebus.util.SnowflakeIdWorker;
import com.lantaiyuan.ebus.virtual.card.dao.RouteTicketPriceMapper;
import com.lantaiyuan.ebus.virtual.card.dao.VirtualCardExpenseHistoryMapper;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandard;
import com.lantaiyuan.ebus.virtual.card.model.RouteTicketPrice;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccount;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistory;
import com.lantaiyuan.ebus.virtual.card.model.enummodel.VirtualCardRecordHeaderTypeEnum;
import com.lantaiyuan.ebus.virtual.card.service.RouteChargeStandardServiceI;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardAccountHistoryServiceI;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardAccountServiceI;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardAccountSignServiceI;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardExpenseHistoryServiceI;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardSwipeHistoryServiceI;

/**
 * 描述:定时器实现车票及订单状态更改业务 作者:温海金 最后更改时间:下午2:52:51
 */
@Service("taskTimerService")
public class TaskTimerServiceImpl implements TaskTimerServiceI {

    private static Logger log = LoggerFactory.getLogger(TaskTimerServiceImpl.class);

    @Resource
    private TaskTimerScannerMapper taskTimerScannerMapper;
    @Resource
    private VirtualCardAccountHistoryServiceI virtualCardAccountHistoryService;
    @Resource
    private VirtualCardExpenseHistoryServiceI virtualCardExpenseHistoryService;
    @Resource
    private VirtualCardSwipeHistoryServiceI virtualCardSwipeHistoryService;
    @Resource
    private RouteChargeStandardServiceI routeChargeStandardService;
    @Resource
    private VirtualCardAccountServiceI virtualCardAccountService;
    @Resource
    private VirtualCardAccountSignServiceI virtualCardAccountSignService;
    @Resource
    private RouteTicketPriceMapper routeTicketPriceMapper;
    @Resource
    private BaseStationMapper baseStationMapper;
    @Resource
    private VirtualCardExpenseHistoryMapper virtualCardExpenseHistoryMapper;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private CuratorFramework curatorFramework;
    @Resource
    private InterProcessMutex lock1;
    @Resource
    private InterProcessMutex lock2;
    @Resource
    private ThreadPoolExecutor executor;

    @Value("${thread.handleSize}")
    private int handleSize;
    @Value("${thread.maxSize}")
    private int maxSize;
    @Value("${system.name}")
    private String systemName;

    public TaskTimerScannerMapper getDao() {
        return taskTimerScannerMapper;
    }

    private SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 1);

    /**
     * 功能描述:若30分钟没有付款则更改订单表的状态为订单失效 同时将包车状态改为已取消 作者:温海金 最后更改时间 : 2016年11月21日
     * 上午10:28:42 方法说明: cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） cron表达式：*(秒0-59)
     * *(分钟0-59) *(小时0-23)*(日期1-31) *(月份1-12或是JAN-DEC)
     * *(星期1-7或是SUN-SAT) @Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次
     */
    @Override
    public int updateOrderStatus2Invalid() {
        taskTimerScannerMapper.invalidOrderStatus(new Date());// 更改订单表状态
        return taskTimerScannerMapper.invalidBookBusStatus(new Date());// 更改车辆表状态为已取消
    }

    /**
     * 查出未付款的记录(1. 一票制，2. 分段制：已完成上下车刷卡)
     *
     * @author yangyang
     * @date 2017/8/12 11:07
     */
    @Override
    public List<VirtualCardExpenseHistory> getUnpaidRecords() {
        return virtualCardExpenseHistoryService.getUnpaidRecords();
    }

    /**
     * 功能描述:定时器实现车票是否提供给用户购买的状态修改（每天凌晨12点执行一次）
     * 状态修改规则：小于当前日期且isOpenToBuy=1的票改为isOpenToBuy=0（不开放购买） 作者:温海金 最后更改时间 :
     * 2016年11月22日 下午4:02:35
     */
    @Override
    public int updateTickcetStatusBeforeNow() {
        return taskTimerScannerMapper.updateTickcetStatusBeforeNow(new Date());
    }

    /**
     * 功能描述:定时器实现车票是否提供给用户购买的状态修改 状态修改规则：开放购买当前日期到当月最后一天的票 (系统初始化的时候执行一次) 作者:温海金
     * 最后更改时间 : 2016年11月22日 下午4:02:35
     */
    @Override
    public int updateTickcetStatus4now2lastDay() {
        return taskTimerScannerMapper.updateTickcetStatus4now2lastDay(new Date());
    }

    /**
     * 功能描述:定时器实现车票是否提供给用户购买的状态修改 状态修改规则：开放购买下个月的票(每月27号执行一次) 作者:温海金 最后更改时间 :
     * 2016年11月22日 下午4:02:35
     */
    @Override
    public int updateTickcetStatusNextMonth() {
        return taskTimerScannerMapper.updateTickcetStatusNextMonth();
    }

    @Override
    public int modifyTickcetStatusToExpired() {
        return taskTimerScannerMapper.modifyTickcetStatusToExpired(new Date());
    }

    @Override
    public void modifyUnPaidTickcetOrderStatus() {
        List<String> unPaidOrderNumList = taskTimerScannerMapper.queryUnPaidTicketOrderNum();
        unPaidOrderNumList.forEach(orderNo -> {
            taskTimerScannerMapper.modifyTicketOrderStatus(orderNo);
            taskTimerScannerMapper.addRemainTicketNum(orderNo);
        });
    }

    /**
     * 功能描述:每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC 作者:温海金 最后更改时间 :
     * 2017年2月24日 上午10:41:17
     */
    @Override
    public void clearTheDataOfAlreadyAlert() {
        taskTimerScannerMapper.clearTheDataOfAlreadyAlert();
    }

    /**
     * 功能描述: 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where
     * IS_REMIND = TRUE; 作者:温海金 最后更改时间 : 2017年3月21日 下午6:01:29
     */
    @Override
    public void clearTheDataInLeavingCarAlert() {
        taskTimerScannerMapper.clearTheDataInLeavingCarAlert();
    }

    @Override
    public int updateStatusToUsed(String ticketId) {
        return taskTimerScannerMapper.updateStatusToUsed(ticketId);
    }

    @Override
    public List<Favoriate> findFavoriateByRouteAndCity(String routeId, String cityCode) {
        return taskTimerScannerMapper.findFavoriateByRouteAndCity(routeId, cityCode);
    }

    @Override
    public void modifyUnPaidTravelOrderStatus() {
        taskTimerScannerMapper.updateBaseOrderStatusToInvalid();
        List<BaseTravelOrder> travelOrderList = taskTimerScannerMapper.queryUnPaidTravelOrderTicketNum();
        travelOrderList.forEach(order -> {
            taskTimerScannerMapper.updateTravelTicketNumById(order.getId(), order.getNum());
        });
        taskTimerScannerMapper.updateTravelOrderStatusToInvalid();
    }

    @Override
    public void dealWithUnCheckedSwipeRecord() {
        String parentNode = BasicConstans.LOCK_PATH_PREFIX + "1" + systemName;
        List<VirtualCardSwipeHistory> unCheckedSwipeList = null;
        try {
            lock1.acquire();
            // step1：获取父节点中数据信息（用于存放当前处理的最后一条记录id）
            String id = ZKClientUtils.getData(curatorFramework, parentNode);
            if (BasicConstans.LOCK_PATH_INIT_DATA.equals(id)) {
                id = null;
            }
            // 获取数据
            unCheckedSwipeList = virtualCardSwipeHistoryService.queryUnCheckRecord(id, maxSize);
            if (CollectionUtils.isEmpty(unCheckedSwipeList)) {
                try {
                    // 待处理数据处理完毕后，初始化父节点数据，下次处理重新开始
                    ZKClientUtils.updateNodeDate(curatorFramework, parentNode, BasicConstans.LOCK_PATH_INIT_DATA);
                } catch (Exception e) {
                    log.error("更新父节点数据为:" + unCheckedSwipeList.get(unCheckedSwipeList.size() - 1).getId() + "异常！", e);
                }
                return;
            }
            // 释放锁之前，将最后Id存入父节点中
            ZKClientUtils.updateNodeDate(curatorFramework, parentNode, String.valueOf(unCheckedSwipeList.get(unCheckedSwipeList.size() - 1).getId()));
        } catch (Exception e) {
            log.error("线程运行异常! {}", e);
        } finally {
            try {
                lock1.release();
            } catch (Exception e) {
                log.error("分布式锁释放异常!", e);
            }
        }
        int count = 0;
        int total = maxSize % handleSize == 0 ? maxSize / handleSize : maxSize / handleSize + 1;
        while (count < total) {
            count++;
            List<VirtualCardSwipeHistory> finalUnCheckedSwipeList = unCheckedSwipeList.subList((count - 1) * handleSize, count * handleSize);
            int finalCount = count;
            executor.execute(new Thread(() -> {
                log.info("线程" + finalCount + "处理开始");
                synchronized (this) {
                    for (int i = 0; i < finalUnCheckedSwipeList.size(); i++) {
                        print(String.valueOf(finalUnCheckedSwipeList.get(i).getId()) + ",");
                    }
                    System.out.println();
                }
                if (CollectionUtils.isEmpty(finalUnCheckedSwipeList)) {
                    return;
                }
                finalUnCheckedSwipeList.forEach(unCheckedRecord -> {
                    log.info(unCheckedRecord.getId() + "处理开始！");
                    String cityCode = unCheckedRecord.getCardNo().substring(0, 6);
                    String direction = String.valueOf(unCheckedRecord.getRouteDirection() ? 1 : 0);
                    String routeId = unCheckedRecord.getRouteId();
                    RouteChargeStandard routeChargeStandard = routeChargeStandardService.queryByCityRouteDirction(cityCode,
                            direction, routeId);
                    // 基础数据不成在直接不处理 返回
                    if (!Objects.isNull(routeChargeStandard)) {
                        // 一票制
                        if (routeChargeStandard.getChargeType() == 1) {
                            dealWithSingleSwipeRecord(unCheckedRecord, routeChargeStandard);
                        }
                        // 分段制
                        if (routeChargeStandard.getChargeType() == 2) {
                            dealWithLadderSwipeRecord(unCheckedRecord, routeChargeStandard);
                        }
                    }
                    log.info(unCheckedRecord.getId() + "处理完毕！");
                });
                log.info("线程" + finalCount + "处理结束");
            }));
        }

    }

    /*
     * 一票制收费
     */
    private void dealWithSingleSwipeRecord(VirtualCardSwipeHistory unCheckedRecord,
                                           RouteChargeStandard routeChargeStandard) {

        VirtualCardAccount account = virtualCardAccountService.queryByCardNo(unCheckedRecord.getCardNo());
        if (Objects.isNull(account)) {
            return;
        }

        String accountSign = virtualCardAccountSignService.querySignByUserAndCardNo(account.getUserId(),
                account.getCardNo());
        if (StringUtils.isEmpty(accountSign)) {
            return;
        }

        String genSign = "";
        try {
            genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo()
                    + new BigDecimal(account.getBalance().doubleValue()).multiply(new BigDecimal(1000000)));
        } catch (SignatureException e) {
            return;
        }
        // 账户异常或冻结
        if (account.getStatus() || !genSign.equals(accountSign)) {
            return;
        }

        VirtualCardExpenseHistory expenseHistory = new VirtualCardExpenseHistory();
        String takeId = VirtualCardRecordHeaderTypeEnum.TAKE_BUS.getRecordType() + routeChargeStandard.getCityCode()
                + snowflakeIdWorker.nextId();
        expenseHistory.setTakeId(takeId);
        expenseHistory.setUserId(account.getUserId());
        expenseHistory.setUserName(account.getUserName());
        expenseHistory.setCityCode(account.getCityCode());
        expenseHistory.setCardNo(account.getCardNo());
        expenseHistory.setAmount(routeChargeStandard.getCheapestPrice());
        expenseHistory.setRouteId(routeChargeStandard.getRouteId());
        expenseHistory.setRouteName(routeChargeStandard.getRouteName());
        expenseHistory.setVehicleId(unCheckedRecord.getVehicleId());
        expenseHistory.setRouteDirection(unCheckedRecord.getRouteDirection());
        expenseHistory.setDiverId(unCheckedRecord.getDiverId());
        expenseHistory.setBusSeq(unCheckedRecord.getBusSeq());
        expenseHistory.setUpSwipeId(unCheckedRecord.getSwipeId());
        expenseHistory.setUpSwipeTime(unCheckedRecord.getSwipeTime());
        expenseHistory.setUpSwipeUtcTime(unCheckedRecord.getSwipeUtcTime());
        expenseHistory.setUpStationId(unCheckedRecord.getStationId());
        expenseHistory.setUpStationNo(unCheckedRecord.getStationNo());
        //计算站点名称
        RelRouteStation query = new RelRouteStation();
        query.setCitycode(account.getCityCode());
        query.setRouteid(routeChargeStandard.getRouteId());
        query.setDirection(routeChargeStandard.getDirection());
        query.setStationno(unCheckedRecord.getStationNo());
        RelRouteStation result = routeTicketPriceMapper.querySingleStationByNo(query);
        if (!Objects.isNull(result)) {
            BaseStation station = baseStationMapper.getStationByStationIdAndCityCode(Integer.valueOf(result.getStationid()), account.getCityCode());
            if (!Objects.isNull(station)) {
                expenseHistory.setUpStationName(station.getName());
            }
        }
        int updatExpenseHistoryFlag = virtualCardExpenseHistoryService.insertSelective(expenseHistory);
        if (updatExpenseHistoryFlag == 1) {

            unCheckedRecord.setDealStatus(true);
            virtualCardSwipeHistoryService.updateByPrimaryKeySelective(unCheckedRecord);

            // 操作类型-2：消费
            String optType = "2";
            // 虚拟卡
            String payType = "3";
            BigDecimal newBalance = account.getBalance().subtract(routeChargeStandard.getCheapestPrice());

            try {
                genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo()
                        + new BigDecimal(newBalance.doubleValue()).multiply(new BigDecimal(1000000)));
            } catch (SignatureException e) {
                return;
            }

            // 流水号
            String transactionId = VirtualCardRecordHeaderTypeEnum.TRANSACTION.getRecordType() + account.getCityCode()
                    + snowflakeIdWorker.nextId();
            VirtualCardAccountHistory accountHistory = new VirtualCardAccountHistory(transactionId, account.getUserId(),
                    account.getUserName(), account.getCityCode(), account.getCardNo(),
                    routeChargeStandard.getCheapestPrice().multiply(new BigDecimal(-1)), optType, payType);
            accountHistory.setPayStatus(true);
            accountHistory.setBalance(newBalance);
            accountHistory.setPayTime(new Date());
            virtualCardAccountHistoryService.insertSelective(accountHistory);

            account.setBalance(newBalance);
            virtualCardAccountService.updateByPrimaryKeySelective(account);
            virtualCardAccountService
                    .updateSignByCardNo(new VirtualCardAccountSign(account.getUserId(), account.getCardNo(), genSign));

            VirtualCardExpenseHistory expenseHistoryInDb = virtualCardExpenseHistoryService.queryByTakeid(takeId);
            expenseHistoryInDb.setTransactionId(transactionId);
            expenseHistoryInDb.setTransStatus(true);
            expenseHistoryInDb.setDealStatus(true);
            expenseHistoryInDb.setFinishTime(new Date());
            virtualCardExpenseHistoryService.updateByPrimaryKeySelective(expenseHistoryInDb);
        } else {
            return;
        }

    }

    /*
     * 分段收费
     */
    private void dealWithLadderSwipeRecord(VirtualCardSwipeHistory unCheckedRecord,
                                           RouteChargeStandard routeChargeStandard) {
        VirtualCardAccount account = virtualCardAccountService.queryByCardNo(unCheckedRecord.getCardNo());
        if (Objects.isNull(account)) {
            return;
        }

        String accountSign = virtualCardAccountSignService.querySignByUserAndCardNo(account.getUserId(),
                account.getCardNo());
        if (StringUtils.isEmpty(accountSign)) {
            return;
        }

        String genSign = "";
        try {
            genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo()
                    + new BigDecimal(account.getBalance().doubleValue()).multiply(new BigDecimal(1000000)));
        } catch (SignatureException e) {
            return;
        }
        // 账户异常或冻结
        if (account.getStatus() || !genSign.equals(accountSign)) {
            return;
        }
        String cardNo = unCheckedRecord.getCardNo();
        String cityCode = cardNo.substring(0, 6);
        String routeId = unCheckedRecord.getRouteId();
        String direction = String.valueOf(unCheckedRecord.getRouteDirection() ? 1 : 0);
        String vehicleId = unCheckedRecord.getVehicleId();
        VirtualCardExpenseHistory expenseHistoryInDb = virtualCardExpenseHistoryService
                .queryOnlyOneByCardNoAndCityAndTime(cardNo, cityCode, routeId, direction, vehicleId);
        if (Objects.isNull(expenseHistoryInDb)) {
            VirtualCardExpenseHistory expenseHistory = new VirtualCardExpenseHistory();
            String takeId = VirtualCardRecordHeaderTypeEnum.TAKE_BUS.getRecordType() + routeChargeStandard.getCityCode()
                    + snowflakeIdWorker.nextId();
            expenseHistory.setTakeId(takeId);
            expenseHistory.setUserId(account.getUserId());
            expenseHistory.setUserName(account.getUserName());
            expenseHistory.setCityCode(account.getCityCode());
            expenseHistory.setCardNo(account.getCardNo());
            // 2-分段收费
            expenseHistory.setChargeType("2");
            expenseHistory.setRouteId(routeChargeStandard.getRouteId());
            expenseHistory.setRouteName(routeChargeStandard.getRouteName());
            expenseHistory.setVehicleId(unCheckedRecord.getVehicleId());
            expenseHistory.setRouteDirection(unCheckedRecord.getRouteDirection());
            expenseHistory.setDiverId(unCheckedRecord.getDiverId());
            expenseHistory.setBusSeq(unCheckedRecord.getBusSeq());
            expenseHistory.setUpSwipeId(unCheckedRecord.getSwipeId());
            expenseHistory.setUpSwipeTime(unCheckedRecord.getSwipeTime());
            expenseHistory.setUpSwipeUtcTime(unCheckedRecord.getSwipeUtcTime());
            expenseHistory.setUpStationId(unCheckedRecord.getStationId());
            expenseHistory.setUpStationNo(unCheckedRecord.getStationNo());
            //计算站点名称
            RelRouteStation query = new RelRouteStation();
            query.setCitycode(account.getCityCode());
            query.setRouteid(routeChargeStandard.getRouteId());
            query.setDirection(routeChargeStandard.getDirection());
            query.setStationno(unCheckedRecord.getStationNo());
            RelRouteStation result = routeTicketPriceMapper.querySingleStationByNo(query);
            if (!Objects.isNull(result)) {
                BaseStation station = baseStationMapper.getStationByStationIdAndCityCode(Integer.valueOf(result.getStationid()), account.getCityCode());
                if (!Objects.isNull(station)) {
                    expenseHistory.setUpStationName(station.getName());
                }
            }

            int updatExpenseHistoryFlag = virtualCardExpenseHistoryService.insertSelective(expenseHistory);
            if (updatExpenseHistoryFlag == 1) {
                unCheckedRecord.setDealStatus(true);
                virtualCardSwipeHistoryService.updateByPrimaryKeySelective(unCheckedRecord);
            }
            return;
        }
        // 数据库存在记录 判断时间差如果大于全程时间就默认逃票扣最高款，小于全程就按正常查询该付款金额然后扣钱
        int UpSwipeUtcTimeInDb = expenseHistoryInDb.getUpSwipeUtcTime();
        int swipeUtcTime = unCheckedRecord.getSwipeUtcTime();
        int Timedifference = swipeUtcTime - UpSwipeUtcTimeInDb;
        // 线路最高用时=全程最高用时+延误时间
        int seconds = (routeChargeStandard.getMinutes() + routeChargeStandard.getLateMinutes()) * 60 * 2;
        if (Timedifference > seconds) {
            // 超过全程最高用时： 1 新增新纪录，2 扣原先消费记录表的钱
            VirtualCardExpenseHistory expenseHistory = new VirtualCardExpenseHistory();
            String takeId = VirtualCardRecordHeaderTypeEnum.TAKE_BUS.getRecordType() + routeChargeStandard.getCityCode()
                    + snowflakeIdWorker.nextId();
            expenseHistory.setTakeId(takeId);
            expenseHistory.setUserId(account.getUserId());
            expenseHistory.setUserName(account.getUserName());
            expenseHistory.setCityCode(account.getCityCode());
            expenseHistory.setCardNo(account.getCardNo());
            // 2-分段收费
            expenseHistory.setChargeType("2");
            expenseHistory.setRouteId(routeChargeStandard.getRouteId());
            expenseHistory.setRouteName(routeChargeStandard.getRouteName());
            expenseHistory.setVehicleId(unCheckedRecord.getVehicleId());
            expenseHistory.setRouteDirection(unCheckedRecord.getRouteDirection());
            expenseHistory.setDiverId(unCheckedRecord.getDiverId());
            expenseHistory.setBusSeq(unCheckedRecord.getBusSeq());
            expenseHistory.setUpSwipeId(unCheckedRecord.getSwipeId());
            expenseHistory.setUpSwipeTime(unCheckedRecord.getSwipeTime());
            expenseHistory.setUpSwipeUtcTime(unCheckedRecord.getSwipeUtcTime());
            expenseHistory.setUpStationId(unCheckedRecord.getStationId());
            expenseHistory.setUpStationNo(unCheckedRecord.getStationNo());
            //计算站点名称
            RelRouteStation query = new RelRouteStation();
            query.setCitycode(account.getCityCode());
            query.setRouteid(routeChargeStandard.getRouteId());
            query.setDirection(routeChargeStandard.getDirection());
            query.setStationno(unCheckedRecord.getStationNo());
            RelRouteStation result = routeTicketPriceMapper.querySingleStationByNo(query);
            if (!Objects.isNull(result)) {
                BaseStation station = baseStationMapper.getStationByStationIdAndCityCode(Integer.valueOf(result.getStationid()), account.getCityCode());
                if (!Objects.isNull(station)) {
                    expenseHistory.setUpStationName(station.getName());
                }
            }

            int updatExpenseHistoryFlag = virtualCardExpenseHistoryService.insertSelective(expenseHistory);
            if (updatExpenseHistoryFlag == 1) {
                unCheckedRecord.setDealStatus(true);
                virtualCardSwipeHistoryService.updateByPrimaryKeySelective(unCheckedRecord);
                // 操作类型-2：消费
                String optType = "2";
                // 虚拟卡
                String payType = "3";
                BigDecimal newBalance = account.getBalance().subtract(routeChargeStandard.getHighestPrice());

                try {
                    genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo()
                            + new BigDecimal(newBalance.doubleValue()).multiply(new BigDecimal(1000000)));
                } catch (SignatureException e) {
                    return;
                }

                // 流水号
                String transactionId = VirtualCardRecordHeaderTypeEnum.TRANSACTION.getRecordType()
                        + account.getCityCode() + snowflakeIdWorker.nextId();
                VirtualCardAccountHistory accountHistory = new VirtualCardAccountHistory(transactionId,
                        account.getUserId(), account.getUserName(), account.getCityCode(), account.getCardNo(),
                        routeChargeStandard.getHighestPrice().multiply(new BigDecimal(-1)), optType, payType);
                accountHistory.setPayStatus(true);
                accountHistory.setBalance(newBalance);
                accountHistory.setPayTime(new Date());
                virtualCardAccountHistoryService.insertSelective(accountHistory);

                account.setBalance(newBalance);
                virtualCardAccountService.updateByPrimaryKeySelective(account);
                virtualCardAccountService.updateSignByCardNo(
                        new VirtualCardAccountSign(account.getUserId(), account.getCardNo(), genSign));

                expenseHistoryInDb.setAmount(routeChargeStandard.getHighestPrice());
                expenseHistoryInDb.setTransactionId(transactionId);
                expenseHistoryInDb.setTransStatus(true);
                expenseHistoryInDb.setDealStatus(true);
                expenseHistoryInDb.setFinishTime(new Date());
                virtualCardExpenseHistoryService.updateByPrimaryKeySelective(expenseHistoryInDb);
            }
            return;
        }
        // 正常时间扣款
        expenseHistoryInDb.setDownSwipeId(unCheckedRecord.getSwipeId());
        expenseHistoryInDb.setDownSwipeTime(unCheckedRecord.getSwipeTime());
        expenseHistoryInDb.setDownSwipeUtcTime(unCheckedRecord.getSwipeUtcTime());
        expenseHistoryInDb.setDownStationId(unCheckedRecord.getStationId());
        expenseHistoryInDb.setDownStationNo(unCheckedRecord.getStationNo());
        //计算站点名称
        RelRouteStation query = new RelRouteStation();
        query.setCitycode(account.getCityCode());
        query.setRouteid(routeChargeStandard.getRouteId());
        query.setDirection(routeChargeStandard.getDirection());
        query.setStationno(unCheckedRecord.getStationNo());
        RelRouteStation result = routeTicketPriceMapper.querySingleStationByNo(query);
        if (!Objects.isNull(result)) {
            BaseStation station = baseStationMapper.getStationByStationIdAndCityCode(Integer.valueOf(result.getStationid()), account.getCityCode());
            if (!Objects.isNull(station)) {
                expenseHistoryInDb.setDownStationName(station.getName());
            }
        }
        // 根据上下车站点ID计算票价 如果查询不到扣最低票价
        RouteTicketPrice ticketPriceQuery = new RouteTicketPrice();
        ticketPriceQuery.setCityCode(expenseHistoryInDb.getCityCode());
        ticketPriceQuery.setRouteId(expenseHistoryInDb.getRouteId());
        ticketPriceQuery.setDirection(expenseHistoryInDb.getRouteDirection() ? 1 : 0);
        ticketPriceQuery.setUpStationId(expenseHistoryInDb.getUpStationId());
        ticketPriceQuery.setDownStationId(expenseHistoryInDb.getDownStationId());
        BigDecimal amount;
        //根据上下车站序计算票价 如果查询不到扣最低票价
        ticketPriceQuery.setUpStationNo(expenseHistoryInDb.getUpStationNo());
        ticketPriceQuery.setDownStationNo(expenseHistoryInDb.getDownStationNo());
        RouteTicketPrice routeTicketPrice = routeTicketPriceMapper.queryByUpDownStationNo(ticketPriceQuery);
        //RouteTicketPrice routeTicketPrice = routeTicketPriceMapper.queryByUpDownStationId(ticketPriceQuery);
        if (Objects.isNull(routeTicketPrice)) {
            amount = routeChargeStandard.getCheapestPrice();
        } else {
            amount = routeTicketPrice.getPrice();
        }
        expenseHistoryInDb.setAmount(amount);
        int updatExpenseHistoryFlag = virtualCardExpenseHistoryService.updateByPrimaryKeySelective(expenseHistoryInDb);
        if (updatExpenseHistoryFlag == 1) {
            unCheckedRecord.setDealStatus(true);
            virtualCardSwipeHistoryService.updateByPrimaryKeySelective(unCheckedRecord);
            // 操作类型-2：消费
            String optType = "2";
            // 虚拟卡
            String payType = "3";
            BigDecimal newBalance = account.getBalance().subtract(amount);

            try {
                genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo()
                        + new BigDecimal(newBalance.doubleValue()).multiply(new BigDecimal(1000000)));
            } catch (SignatureException e) {
                return;
            }
            // 流水号
            String transactionId = VirtualCardRecordHeaderTypeEnum.TRANSACTION.getRecordType() + account.getCityCode()
                    + snowflakeIdWorker.nextId();
            VirtualCardAccountHistory accountHistory = new VirtualCardAccountHistory(transactionId, account.getUserId(),
                    account.getUserName(), account.getCityCode(), account.getCardNo(),
                    amount.multiply(new BigDecimal(-1)), optType, payType);
            accountHistory.setPayStatus(true);
            accountHistory.setBalance(newBalance);
            accountHistory.setPayTime(new Date());
            virtualCardAccountHistoryService.insertSelective(accountHistory);

            account.setBalance(newBalance);
            virtualCardAccountService.updateByPrimaryKeySelective(account);
            virtualCardAccountService
                    .updateSignByCardNo(new VirtualCardAccountSign(account.getUserId(), account.getCardNo(), genSign));

            expenseHistoryInDb.setTransactionId(transactionId);
            expenseHistoryInDb.setTransStatus(true);
            expenseHistoryInDb.setDealStatus(true);
            expenseHistoryInDb.setFinishTime(new Date());
            virtualCardExpenseHistoryService.updateByPrimaryKeySelective(expenseHistoryInDb);
            kafkaTemplate.setDefaultTopic("transactionRecordTopic");
            kafkaTemplate.sendDefault("{\"header\":{\"msg_flag\":4,\"msg_sn\":9,\"msg_id\":458759},\"body\":{\"dev_id\":0,\"tdc_flag\":3,\"v_card_code\":\"" + unCheckedRecord.getCardNo() + "\",\"up_time\":" + unCheckedRecord.getSwipeUtcTime() + ",\"verify_code\":\"" + unCheckedRecord.getVerifyCode() + "\",\"gps_data\":{\"gps_time\":" + unCheckedRecord.getSwipeUtcTime() +
                    ",\"lon\":" + unCheckedRecord.getLongitude() + ",\"lat\":" + unCheckedRecord.getLatitude() + ",\"vec1\":0,\"vec2\":0,\"distance\":0,\"direction\":0,\"altitude\":0},\"bus_station_code\":" + unCheckedRecord.getStationId() + ",\"bus_station_no\":" + unCheckedRecord.getStationNo() + ",\"line_id\":" + unCheckedRecord.getRouteId() + ",\"driver_id\":\"" + unCheckedRecord.getDiverId() + "\",\"vehicle_id\":"
                    + unCheckedRecord.getVehicleId() + ",\"bus_req\":0, \"onbus_flag\":" + unCheckedRecord.getOnBusFlag() + ",\"ondirection_flag\":" + unCheckedRecord.getRouteDirection() + "}}");
        }
    }

    /*
     * 处理未扣款的的消费记录
     */
    @Override
    public void dealWithUnDealExpenseRecord(VirtualCardExpenseHistory unDealExpenseRecord) {
        VirtualCardAccount account = virtualCardAccountService.queryByCardNo(unDealExpenseRecord.getCardNo());
        if (Objects.isNull(account)) {
            return;
        }

        String accountSign = virtualCardAccountSignService.querySignByUserAndCardNo(account.getUserId(), account.getCardNo());
        if (StringUtils.isEmpty(accountSign)) {
            return;
        }

        String genSign = "";
        try {
            genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo() + new BigDecimal(account.getBalance().doubleValue()).multiply(new BigDecimal(1000000)));
        } catch (SignatureException e) {
            return;
        }
        //账户异常或冻结
        if (account.getStatus() || !genSign.equals(accountSign)) {
            return;
        }
        // 操作类型-2：消费
        String optType = "2";
        //虚拟卡
        String payType = "3";
        BigDecimal newBalance = account.getBalance().subtract(unDealExpenseRecord.getAmount());

        try {
            genSign = BalanceSignUtil.rsaSign(account.getUserId() + account.getCityCode() + account.getCardNo() + new BigDecimal(newBalance.doubleValue()).multiply(new BigDecimal(1000000)));
        } catch (SignatureException e) {
            return;
        }

        // 流水号
        String transactionId = VirtualCardRecordHeaderTypeEnum.TRANSACTION.getRecordType() + account.getCityCode() + snowflakeIdWorker.nextId();
        VirtualCardAccountHistory accountHistory = new VirtualCardAccountHistory(transactionId, account.getUserId(), account.getUserName()
                , account.getCityCode(), account.getCardNo(), unDealExpenseRecord.getAmount().multiply(new BigDecimal(-1)), optType, payType);
        accountHistory.setPayStatus(true);
        accountHistory.setBalance(newBalance);
        accountHistory.setPayTime(new Date());
        virtualCardAccountHistoryService.insertSelective(accountHistory);

        account.setBalance(newBalance);
        virtualCardAccountService.updateByPrimaryKeySelective(account);
        virtualCardAccountService.updateSignByCardNo(new VirtualCardAccountSign(account.getUserId(), account.getCardNo(), genSign));

        unDealExpenseRecord.setTransactionId(transactionId);
        unDealExpenseRecord.setTransStatus(true);
        unDealExpenseRecord.setDealStatus(true);
        unDealExpenseRecord.setFinishTime(new Date());
        virtualCardExpenseHistoryService.updateByPrimaryKeySelective(unDealExpenseRecord);
    }

    @Override
    public void dealWithOverTimeLadderRecord() {
        List<VirtualCardExpenseHistory> list = virtualCardExpenseHistoryMapper.getOverTimeRecord();
        for (VirtualCardExpenseHistory virtualCardExpenseHistory : list) {
            String cityCode = virtualCardExpenseHistory.getCityCode();
            String direction = String.valueOf(virtualCardExpenseHistory.getRouteDirection() ? 1 : 0);
            String routeId = virtualCardExpenseHistory.getRouteId();
            RouteChargeStandard routeChargeStandard = routeChargeStandardService.queryByCityRouteDirction(cityCode,
                    direction, routeId);
            // 基础数据不成在直接不处理 返回
            if (Objects.isNull(routeChargeStandard)) {
                continue;
            }
            virtualCardExpenseHistory.setAmount(routeChargeStandard.getHighestPrice());
            if (virtualCardExpenseHistoryService.updateByPrimaryKeySelective(virtualCardExpenseHistory) == 1) {
                dealWithUnDealExpenseRecord(virtualCardExpenseHistory);
            }
        }
    }

    synchronized void print(String msg) {
        System.out.print(msg);
    }
}


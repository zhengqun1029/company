package com.lantaiyuan.ebus.scheme;

import javax.annotation.Resource;

import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lantaiyuan.ebus.service.TaskTimerServiceI;

import java.util.List;

/**
 * 描述:定时器 作者:温海金 最后更改时间:下午5:29:49
 */
@Component
public class TaskTimerScanner implements InitializingBean {
	private static Logger logger = LoggerFactory.getLogger(TaskTimerScanner.class);
	@Resource
	private TaskTimerServiceI taskTimerService;

	@Override
	public void afterPropertiesSet() throws Exception {
		// 系统初始化时 
		logger.debug("-------------------ebus-virtual-car 初始化--------------------------");
	}

	/** 
	 * 对未付款的刷卡记录进行扣费
	 * 
	 * @author yangyang
	 * @date 2017/8/12 11:09
	 */
	@Scheduled(cron = "${task.chargeUnpaidRecords}")
	public void chargeUnpaidRecords() {
		List<VirtualCardExpenseHistory> list = taskTimerService.getUnpaidRecords();
		//  调用扣款接口
		for (VirtualCardExpenseHistory virtualCardExpenseHistory : list) {
			taskTimerService.dealWithUnDealExpenseRecord(virtualCardExpenseHistory);
		}
	}
	
	
	/**
	 * 定时扫描lty_virtual_card_swipe_history，将未处理的记录转入到lty_virtual_card_expense_history
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年8月10日 下午4:02:35
	 */
	@Scheduled(cron = "${task.dealWithUnCheckedSwipeRecord}")
	public void dealWithUnCheckedSwipeRecord() {
		taskTimerService.dealWithUnCheckedSwipeRecord();
	}
	
	/**
	 * 每天凌晨0点处理超时未刷第二次卡的分段收费记录
	 * dealWithOverTimeLadderRecord
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年8月16日 下午4:02:35
	 */
	@Scheduled(cron = "${task.dealWithOverTimeLadderRecord}")
	public void dealWithOverTimeLadderRecord() {
		taskTimerService.dealWithOverTimeLadderRecord();
	}
}

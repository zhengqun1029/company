package com.lantaiyuan.ebus.virtual.card.service;

import java.math.BigDecimal;
import java.util.List;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistoryQueryModel;

/**
 * 用户乘车消费记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
public interface VirtualCardExpenseHistoryServiceI extends BaseServiceI<VirtualCardExpenseHistory, VirtualCardExpenseHistoryQueryModel> {
	 List<VirtualCardExpenseHistory> findStatisticsByPage(VirtualCardExpenseHistoryQueryModel queryModel);

	    BigDecimal totalSpendMoney(VirtualCardExpenseHistoryQueryModel queryModel);

		VirtualCardExpenseHistory queryByTakeid(String takeId);

		/*
		 * 根据卡号城市线路方向车辆ID 查询出消费记录表是否存在 只有上车记录且扣款的数据
		 */
		VirtualCardExpenseHistory queryOnlyOneByCardNoAndCityAndTime(String cardNo, String cityCode, 
				String routeId,String direction, String vehicleId);

    List<VirtualCardExpenseHistory> getUnpaidRecords();
}

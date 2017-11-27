package com.lantaiyuan.ebus.virtual.card.dao;

import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistoryQueryModel;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface VirtualCardExpenseHistoryMapper extends BaseDAO<VirtualCardExpenseHistory, VirtualCardExpenseHistoryQueryModel>{

    List<VirtualCardExpenseHistory> findStatisticsByPage(VirtualCardExpenseHistoryQueryModel queryModel);

    BigDecimal totalSpendMoney(VirtualCardExpenseHistoryQueryModel queryModel);

	VirtualCardExpenseHistory queryByTakeid(String takeId);

	/*
	 * 根据卡号城市线路方向车辆ID 查询出消费记录表是否存在 只有上车记录且扣款的数据
	 */
	VirtualCardExpenseHistory queryOnlyOneByCardNoAndCityAndTime(@Param("cardNo")String cardNo, @Param("cityCode")String cityCode
			, @Param("routeId")String routeId,@Param("routeDirection")String direction, @Param("vehicleId")String vehicleId);

	List<VirtualCardExpenseHistory> getUnpaidRecords();
	
	List<VirtualCardExpenseHistory> getOverTimeRecord();
}
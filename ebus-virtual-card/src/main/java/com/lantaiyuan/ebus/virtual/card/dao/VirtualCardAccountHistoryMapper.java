package com.lantaiyuan.ebus.virtual.card.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountHistoryQueryModel;
import java.math.BigDecimal;
@Mapper
public interface VirtualCardAccountHistoryMapper extends BaseDAO<VirtualCardAccountHistory, VirtualCardAccountHistoryQueryModel> {

    List<VirtualCardAccountHistory> findStatisticsByPage(VirtualCardAccountHistoryQueryModel queryModel);

    BigDecimal totalRechargeMoney(VirtualCardAccountHistoryQueryModel queryModel);

	List<VirtualCardAccountHistory> queryHistoryByUserAndCity(@Param("userId")int userId, @Param("cityCode")String cityCode);
	
	List<VirtualCardAccountHistory> queryConsumeHistoryByUserAndCity(@Param("userId")int userId, @Param("cityCode")String cityCode);
	
	List<VirtualCardAccountHistory> queryDepositHistoryByUserAndCity(@Param("userId")int userId, @Param("cityCode")String cityCode);

	VirtualCardAccountHistory queryByTransId(@Param("transId")String transId);

	int updateByTransIdSelective(VirtualCardAccountHistory virtualCardAccountHistory);
	
	List<VirtualCardAccountHistory> queryUnPaidHistoryByUserAndCity(@Param("userId")int userId, @Param("cityCode")String cityCode);
}
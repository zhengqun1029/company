package com.lantaiyuan.ebus.virtual.card.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistoryQueryModel;
@Mapper
public interface VirtualCardSwipeHistoryMapper extends BaseDAO<VirtualCardSwipeHistory, VirtualCardSwipeHistoryQueryModel>{
	
	List<VirtualCardSwipeHistory> queryUnCheckRecord(@Param("id")String id, @Param("length")int length);

	VirtualCardSwipeHistory queryExistRecord(@Param("cardNo")String cardNo, @Param("swipeUtcTime")int swipeUtcTime, @Param("routeId")String routeId, @Param("vehicleId")String vehicleId);
}
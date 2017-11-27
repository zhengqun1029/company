package com.lantaiyuan.ebus.virtual.card.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.model.RelRouteStation;
import com.lantaiyuan.ebus.virtual.card.model.RouteTicketPrice;
import com.lantaiyuan.ebus.virtual.card.model.RouteTicketPriceQueryModel;
@Mapper
public interface RouteTicketPriceMapper extends BaseDAO<RouteTicketPrice, RouteTicketPriceQueryModel>{
	/*
	 * 根据上下车站点ID计算票价 如果查询不到扣最低票价queryByUpDownStation
	 */
	RouteTicketPrice queryByUpDownStationId(RouteTicketPrice ticketPriceQuery);
	
	/*
	 * 根据上下车站点站序计算票价 如果查询不到扣最低票价queryByUpDownStationNo
	 */
	RouteTicketPrice queryByUpDownStationNo(RouteTicketPrice ticketPriceQuery);
	
	
	/*
	 * 根据上车站点站序查询站点名称 
	 */
	RouteTicketPrice queryUpDownStationByNo(RouteTicketPrice ticketPriceQuery);
	
	
	
	/*
	 * 查询线站关系表，根据城市线路方向站序查询一个记录站点ID
	 */
	RelRouteStation  querySingleStationByNo(RelRouteStation relRouteStationQuery);
}
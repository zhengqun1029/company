package com.lantaiyuan.ebus.virtual.card.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandard;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandardQueryModel;

@Mapper
public interface RouteChargeStandardMapper extends BaseDAO<RouteChargeStandard, RouteChargeStandardQueryModel>{
	RouteChargeStandard queryByCityRouteDirction(@Param("cityCode")String cityCode, @Param("direction")String direction, 
			@Param("routeId")String routeId);
}
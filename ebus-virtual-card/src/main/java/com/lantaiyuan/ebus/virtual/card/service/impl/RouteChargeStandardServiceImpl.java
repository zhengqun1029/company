package com.lantaiyuan.ebus.virtual.card.service.impl;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.virtual.card.dao.RouteChargeStandardMapper;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandard;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandardQueryModel;
import com.lantaiyuan.ebus.virtual.card.service.RouteChargeStandardServiceI;

/**
 * 用户乘车消费记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
@Service("routeChargeStandardService")
public class RouteChargeStandardServiceImpl extends BaseService<RouteChargeStandard, RouteChargeStandardQueryModel>
        implements RouteChargeStandardServiceI {

		@Resource
	   private RouteChargeStandardMapper routeChargeStandardMapper;

	    @Override
	    public BaseDAO<RouteChargeStandard, RouteChargeStandardQueryModel> getDao() {
	        return routeChargeStandardMapper;
	    }

		@Override
		public RouteChargeStandard queryByCityRouteDirction(String cityCode, String direction, String routeId) {
			return routeChargeStandardMapper.queryByCityRouteDirction(cityCode, direction, routeId);
		}

}

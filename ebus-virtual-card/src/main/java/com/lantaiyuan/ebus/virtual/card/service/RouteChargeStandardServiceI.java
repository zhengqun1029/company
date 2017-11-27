package com.lantaiyuan.ebus.virtual.card.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandard;
import com.lantaiyuan.ebus.virtual.card.model.RouteChargeStandardQueryModel;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:09
 * @email kekecany@163.com
 */
public interface RouteChargeStandardServiceI extends BaseServiceI<RouteChargeStandard, RouteChargeStandardQueryModel> {
	RouteChargeStandard queryByCityRouteDirction( String cityCode,  String direction, String routeId);
}

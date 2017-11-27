package com.lantaiyuan.ebus.virtual.card.service;

import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistoryQueryModel;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:09
 * @email kekecany@163.com
 */
public interface VirtualCardSwipeHistoryServiceI extends BaseServiceI<VirtualCardSwipeHistory, VirtualCardSwipeHistoryQueryModel> {
	List<VirtualCardSwipeHistory> queryUnCheckRecord(String id, int length);
	
	/**
	 * 根据卡号、UTC刷卡时间、线路ID、车辆ID
	 * @return
	 */
	VirtualCardSwipeHistory queryExistRecord(String cardNo,int swipeUtcTime,String routeId,String vehicleId);
}

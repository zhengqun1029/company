package com.lantaiyuan.ebus.virtual.card.service.impl;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.virtual.card.dao.VirtualCardSwipeHistoryMapper;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistoryQueryModel;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardSwipeHistoryServiceI;

/**
 * 用户乘车消费记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
@Service("virtualCardSwipeHistoryService")
public class VirtualCardSwipeHistoryServiceImpl extends BaseService<VirtualCardSwipeHistory, VirtualCardSwipeHistoryQueryModel>
        implements VirtualCardSwipeHistoryServiceI {

	  @Autowired
	   private VirtualCardSwipeHistoryMapper virtualCardSwipeHistoryMapper;

	    @Override
	    public BaseDAO<VirtualCardSwipeHistory, VirtualCardSwipeHistoryQueryModel> getDao() {
	        return virtualCardSwipeHistoryMapper;
	    }

		@Override
		public List<VirtualCardSwipeHistory> queryUnCheckRecord(String id, int length) {
			return virtualCardSwipeHistoryMapper.queryUnCheckRecord(id, length);
		}

		@Override
		public VirtualCardSwipeHistory queryExistRecord(String cardNo, int swipeUtcTime, String routeId,
				String vehicleId) {
			return virtualCardSwipeHistoryMapper.queryExistRecord(cardNo,swipeUtcTime,routeId,vehicleId);
		}

}

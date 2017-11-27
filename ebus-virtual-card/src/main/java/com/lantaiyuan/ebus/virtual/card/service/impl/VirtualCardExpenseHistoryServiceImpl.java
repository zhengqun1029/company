package com.lantaiyuan.ebus.virtual.card.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.virtual.card.dao.VirtualCardExpenseHistoryMapper;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardExpenseHistoryQueryModel;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardExpenseHistoryServiceI;

/**
 * 用户乘车消费记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
@Service("virtualCardExpenseHistoryService")
public class VirtualCardExpenseHistoryServiceImpl extends BaseService<VirtualCardExpenseHistory, VirtualCardExpenseHistoryQueryModel>
        implements VirtualCardExpenseHistoryServiceI {

	  @Autowired
	   private VirtualCardExpenseHistoryMapper virtualCardExpenseHistoryMapper;

	    @Override
	    public BaseDAO<VirtualCardExpenseHistory, VirtualCardExpenseHistoryQueryModel> getDao() {
	        return virtualCardExpenseHistoryMapper;
	    }

		@Override
		public List<VirtualCardExpenseHistory> findStatisticsByPage(VirtualCardExpenseHistoryQueryModel queryModel) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal totalSpendMoney(VirtualCardExpenseHistoryQueryModel queryModel) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VirtualCardExpenseHistory queryByTakeid(String takeId) {
			// TODO Auto-generated method stub
			return virtualCardExpenseHistoryMapper.queryByTakeid(takeId);
		}

		@Override
		public VirtualCardExpenseHistory queryOnlyOneByCardNoAndCityAndTime(String cardNo, String cityCode,
				String routeId, String direction, String vehicleId) {
			// TODO Auto-generated method stub
			return virtualCardExpenseHistoryMapper.queryOnlyOneByCardNoAndCityAndTime(cardNo, cityCode, routeId, direction, vehicleId);
		}

	/**
	 * 查找出未付款的记录(一票制、分段制:两次刷卡均已完成)
	 *
	 * @author yangyang
	 * @date 2017/8/12 11:00
	 */
	@Override
	public List<VirtualCardExpenseHistory> getUnpaidRecords() {
	    	return virtualCardExpenseHistoryMapper.getUnpaidRecords();
		}
}

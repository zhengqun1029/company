package com.lantaiyuan.ebus.virtual.card.service.impl;

import com.lantaiyuan.ebus.virtual.card.dao.VirtualCardAccountMapper;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccount;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountQueryModel;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardInfoQueryModel;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardAccountServiceI;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
@Service("virtualCardAccountService")
public class VirtualCardAccountServiceImpl extends BaseService<VirtualCardAccount, VirtualCardAccountQueryModel>
        implements VirtualCardAccountServiceI {

    @Autowired
    private VirtualCardAccountMapper virtualCardAccountMapper;

    @Override
    public BaseDAO<VirtualCardAccount, VirtualCardAccountQueryModel> getDao() {
        return virtualCardAccountMapper;
    }

	@Override
	public VirtualCardInfoQueryModel queryByUserAndCity(int userId, String cityCode) {
		return virtualCardAccountMapper.queryByUserAndCity(userId, cityCode);
	}

	@Override
	public String queryMaxCardNoByCity(String cityCode) {
		return virtualCardAccountMapper.queryMaxCardNoByCity(cityCode);
	}

	@Override
	public VirtualCardAccount queryByCardNo(String cardNo) {
		return virtualCardAccountMapper.queryByCardNo(cardNo);
	}

	@Override
	public int updateBalanceByCardNo(VirtualCardAccount virtualCardAccount) {
		return virtualCardAccountMapper.updateBalanceByCardNo(virtualCardAccount);
	}

	@Override
	public int updateSignByCardNo(VirtualCardAccountSign virtualCardAccountSign) {
		return virtualCardAccountMapper.updateSignByCardNo(virtualCardAccountSign);
	}

}

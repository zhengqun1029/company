package com.lantaiyuan.ebus.virtual.card.service.impl;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.virtual.card.dao.VirtualCardAccountSignMapper;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSignQueryModel;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardAccountSignServiceI;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
@Service("virtualCardAccountSignService")
public class VirtualCardAccountSignServiceImpl extends BaseService<VirtualCardAccountSign, VirtualCardAccountSignQueryModel>
        implements VirtualCardAccountSignServiceI {

    @Autowired
    private VirtualCardAccountSignMapper virtualCardAccountSignMapper;

    @Override
    public BaseDAO<VirtualCardAccountSign, VirtualCardAccountSignQueryModel> getDao() {
        return virtualCardAccountSignMapper;
    }

	@Override
	public String querySignByUserAndCardNo(int userId, String cardNo) {
		return virtualCardAccountSignMapper.querySignByUserAndCardNo(String.valueOf(userId), cardNo);
	}

}

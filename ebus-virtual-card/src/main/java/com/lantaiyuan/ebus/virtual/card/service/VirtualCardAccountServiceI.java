package com.lantaiyuan.ebus.virtual.card.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccount;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountQueryModel;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardInfoQueryModel;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:09
 * @email kekecany@163.com
 */
public interface VirtualCardAccountServiceI extends BaseServiceI<VirtualCardAccount, VirtualCardAccountQueryModel> {
	
	VirtualCardInfoQueryModel queryByUserAndCity(int userId, String cityCode);

	String queryMaxCardNoByCity(String  cityCode);
	
	VirtualCardAccount queryByCardNo(String cardNo);

	int updateBalanceByCardNo(VirtualCardAccount virtualCardAccount);

	int updateSignByCardNo(VirtualCardAccountSign virtualCardAccountSign);
}

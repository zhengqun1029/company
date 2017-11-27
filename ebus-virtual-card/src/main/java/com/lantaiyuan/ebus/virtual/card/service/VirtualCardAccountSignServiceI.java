package com.lantaiyuan.ebus.virtual.card.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSignQueryModel;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:09
 * @email kekecany@163.com
 */
public interface VirtualCardAccountSignServiceI extends BaseServiceI<VirtualCardAccountSign, VirtualCardAccountSignQueryModel> {
	String querySignByUserAndCardNo(int userId,String cardNo);
}

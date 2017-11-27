package com.lantaiyuan.ebus.virtual.card.model.enummodel;

/**
 * 
 * @Title: TopUpPayTypeEnum.java
 * @Description:(虚拟卡账户充值的支付类型)
 * @author YvanTan
 * @date 2017年8月9日 下午6:03:01
 */
public enum VirtualCardAccoutPayTypeEnum {
	WEIXIN("1"),
	ALIPAY("2"),
	CARD("3");
	private String payType;
	VirtualCardAccoutPayTypeEnum(String payType) {
		this.payType = payType;
	}
	public String getPayType() {
		return payType;
	} 
}
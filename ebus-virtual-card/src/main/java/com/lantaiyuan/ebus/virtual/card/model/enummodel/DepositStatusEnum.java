package com.lantaiyuan.ebus.virtual.card.model.enummodel;

/**
 * 描述:虚拟卡充值返回状态枚举
 * 作者:YvanTan
 * 最后更改时间:20170808上午11:09:11
 */
public enum DepositStatusEnum {
	SUCCESS(1, "生成成功"), AUTHENTICATION_FAILED(2, "身份验证失败"), ACCOUNT_EXCEPTION(3, "账户异常（冻结）"),
	CARD_NOT_MATCH_CITY(4, "卡号不属于该城市"),NO_CARD(5, "虚拟卡账户不存在"),NO_PAY_FUNCTION(6, "城市未开通充值功能");
	
	private int value;
	private String description;
	
	private DepositStatusEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public int value() {
		return value;
	}
	
	public String description() {
		return description;
	}
}

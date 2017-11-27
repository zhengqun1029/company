package com.lantaiyuan.ebus.virtual.card.model.enummodel;

/**
 * 描述:虚拟卡二维码生成状态枚举
 * 作者:YvanTan
 * 最后更改时间:20170808上午11:09:11
 */
public enum GenerateStatusEnum {
	SUCCESS(1, "生成成功"), AUTHENTICATION_FAILED(2, "身份验证失败"), ACCOUNT_EXCEPTION(3, "账户异常（冻结）"),
	NO_PERMISSION(4, "该城市没有开通二维码权限"),MAX_USER(6, "该城市虚拟卡账户已达最大值"),NO_BALANCE(5, "账户余额不足请充值");
	
	private int value;
	private String description;
	
	private GenerateStatusEnum(int value, String description) {
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

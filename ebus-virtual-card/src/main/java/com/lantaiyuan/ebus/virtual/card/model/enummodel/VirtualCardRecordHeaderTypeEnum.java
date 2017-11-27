package com.lantaiyuan.ebus.virtual.card.model.enummodel;

/**
 * 
 * @Title: TopUpPayTypeEnum.java
 * @Description:(虚拟卡模块生成的数据库流水记录的头部标志)
 * @author YvanTan
 * @date 2017年8月9日 下午6:03:01
 */
public enum VirtualCardRecordHeaderTypeEnum {
	TAKE_BUS("T"),
	SWIPE_CARD("S"),
	TRANSACTION("TAN");
	private String recordType;
	VirtualCardRecordHeaderTypeEnum(String recordType) {
		this.recordType = recordType;
	}
	public String getRecordType() {
		return recordType;
	} 
}
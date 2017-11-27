package com.lantaiyuan.ebus.virtual.card.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 虚拟公交卡用户账户交易记录表
 * virtualCardAccountHistory
 * 数据库表：lty_virtual_card_account_history
 */
public class VirtualCardAccountHistoryQueryModel extends BaseModel<VirtualCardAccountHistory>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String startDate;

	private String endDate;

	private String cityCode;

	private Integer payStatus;

	private Integer payType;


    public String getStartDate() {
        return startDate;
    }


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public Integer getPayStatus() {
		return payStatus;
	}


	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}


	public Integer getPayType() {
		return payType;
	}


	public void setPayType(Integer payType) {
		this.payType = payType;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
    
}
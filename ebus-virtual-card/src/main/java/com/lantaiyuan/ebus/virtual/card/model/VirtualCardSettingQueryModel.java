package com.lantaiyuan.ebus.virtual.card.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 城市虚拟卡基础配置表
 * virtualCardSetting
 * 数据库表：lty_virtual_card_setting
 */
public class VirtualCardSettingQueryModel extends BaseModel<VirtualCardSetting>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cityCode;

	private String startDate;

	private String endDate;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
package com.lantaiyuan.ebus.virtual.card.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 用户乘车消费记录表
 * virtualCardExpenseHistory
 * 数据库表：lty_virtual_card_expense _history
 */
public class VirtualCardExpenseHistoryQueryModel extends BaseModel<VirtualCardExpenseHistory> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String cityCode;

    private String routeName;

    private String vehicleId;

    private String upStation;

    private String startDate;

    private String endDate;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getUpStation() {
        return upStation;
    }

    public void setUpStation(String upStation) {
        this.upStation = upStation;
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
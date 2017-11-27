package com.lantaiyuan.ebus.virtual.card.model;

import java.math.BigDecimal;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 普通公交线路(一票制、分段)票价收费梯次表
 * routeTicketPrice
 * 数据库表：base_route_ticket_price
 */
public class RouteTicketPriceQueryModel extends BaseModel<RouteTicketPrice>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : base_route_ticket_price.id
     */
    private Integer id;

    /**
     * 线路ID(GPSID)
     * 表字段 : base_route_ticket_price.route_id
     */
    private String routeId;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : base_route_ticket_price.direction
     */
    private Integer direction;

    /**
     * 城市编码
     * 表字段 : base_route_ticket_price.city_code
     */
    private String cityCode;

    /**
     * 上车刷卡的站点ID:与下车刷卡的站点ID 一一对应不能重复
     * 表字段 : base_route_ticket_price.up_station_id
     */
    private Integer upStationId;

    /**
     * 上车在该线路中是几站
     * 表字段 : base_route_ticket_price.up_station_no
     */
    private Integer upStationNo;

    /**
     * 下车刷卡的站点ID
     * 表字段 : base_route_ticket_price.down_station_id
     */
    private Integer downStationId;

    /**
     * 下车在该线路中是几站
     * 表字段 : base_route_ticket_price.down_station_no
     */
    private Integer downStationNo;

    /**
     * 票价
     * 表字段 : base_route_ticket_price.price
     */
    private BigDecimal price;

    /**
     * 
     * 表字段 : base_route_ticket_price.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : base_route_ticket_price.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : base_route_ticket_price.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:base_route_ticket_price.id
     *
     * @return base_route_ticket_price.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:base_route_ticket_price.id
     *
     * @param id the value for base_route_ticket_price.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路ID(GPSID) 字段:base_route_ticket_price.route_id
     *
     * @return base_route_ticket_price.route_id, 线路ID(GPSID)
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 线路ID(GPSID) 字段:base_route_ticket_price.route_id
     *
     * @param routeId the value for base_route_ticket_price.route_id, 线路ID(GPSID)
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * 获取 线路方向 0-上行 1-下行 字段:base_route_ticket_price.direction
     *
     * @return base_route_ticket_price.direction, 线路方向 0-上行 1-下行
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 设置 线路方向 0-上行 1-下行 字段:base_route_ticket_price.direction
     *
     * @param direction the value for base_route_ticket_price.direction, 线路方向 0-上行 1-下行
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * 获取 城市编码 字段:base_route_ticket_price.city_code
     *
     * @return base_route_ticket_price.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:base_route_ticket_price.city_code
     *
     * @param cityCode the value for base_route_ticket_price.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 上车刷卡的站点ID:与下车刷卡的站点ID 一一对应不能重复 字段:base_route_ticket_price.up_station_id
     *
     * @return base_route_ticket_price.up_station_id, 上车刷卡的站点ID:与下车刷卡的站点ID 一一对应不能重复
     */
    public Integer getUpStationId() {
        return upStationId;
    }

    /**
     * 设置 上车刷卡的站点ID:与下车刷卡的站点ID 一一对应不能重复 字段:base_route_ticket_price.up_station_id
     *
     * @param upStationId the value for base_route_ticket_price.up_station_id, 上车刷卡的站点ID:与下车刷卡的站点ID 一一对应不能重复
     */
    public void setUpStationId(Integer upStationId) {
        this.upStationId = upStationId;
    }

    /**
     * 获取 上车在该线路中是几站 字段:base_route_ticket_price.up_station_no
     *
     * @return base_route_ticket_price.up_station_no, 上车在该线路中是几站
     */
    public Integer getUpStationNo() {
        return upStationNo;
    }

    /**
     * 设置 上车在该线路中是几站 字段:base_route_ticket_price.up_station_no
     *
     * @param upStationNo the value for base_route_ticket_price.up_station_no, 上车在该线路中是几站
     */
    public void setUpStationNo(Integer upStationNo) {
        this.upStationNo = upStationNo;
    }

    /**
     * 获取 下车刷卡的站点ID 字段:base_route_ticket_price.down_station_id
     *
     * @return base_route_ticket_price.down_station_id, 下车刷卡的站点ID
     */
    public Integer getDownStationId() {
        return downStationId;
    }

    /**
     * 设置 下车刷卡的站点ID 字段:base_route_ticket_price.down_station_id
     *
     * @param downStationId the value for base_route_ticket_price.down_station_id, 下车刷卡的站点ID
     */
    public void setDownStationId(Integer downStationId) {
        this.downStationId = downStationId;
    }

    /**
     * 获取 下车在该线路中是几站 字段:base_route_ticket_price.down_station_no
     *
     * @return base_route_ticket_price.down_station_no, 下车在该线路中是几站
     */
    public Integer getDownStationNo() {
        return downStationNo;
    }

    /**
     * 设置 下车在该线路中是几站 字段:base_route_ticket_price.down_station_no
     *
     * @param downStationNo the value for base_route_ticket_price.down_station_no, 下车在该线路中是几站
     */
    public void setDownStationNo(Integer downStationNo) {
        this.downStationNo = downStationNo;
    }

    /**
     * 获取 票价 字段:base_route_ticket_price.price
     *
     * @return base_route_ticket_price.price, 票价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置 票价 字段:base_route_ticket_price.price
     *
     * @param price the value for base_route_ticket_price.price, 票价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取  字段:base_route_ticket_price.field1
     *
     * @return base_route_ticket_price.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:base_route_ticket_price.field1
     *
     * @param field1 the value for base_route_ticket_price.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:base_route_ticket_price.field2
     *
     * @return base_route_ticket_price.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:base_route_ticket_price.field2
     *
     * @param field2 the value for base_route_ticket_price.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:base_route_ticket_price.field3
     *
     * @return base_route_ticket_price.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:base_route_ticket_price.field3
     *
     * @param field3 the value for base_route_ticket_price.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
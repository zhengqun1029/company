package com.lantaiyuan.ebus.virtual.card.model;

import java.math.BigDecimal;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 普通公交线路(一票制、分段)收费标准表
 * routeChargeStandard
 * 数据库表：base_route_charge_standard
 */
public class RouteChargeStandardQueryModel extends BaseModel<RouteChargeStandard>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : base_route_charge_standard.id
     */
    private Integer id;

    /**
     * 线路ID(GPSID)
     * 表字段 : base_route_charge_standard.route_id
     */
    private String routeId;

    /**
     * 线路名称
     * 表字段 : base_route_charge_standard.route_name
     */
    private String routeName;

    /**
     * 线路简称
     * 表字段 : base_route_charge_standard.short_name
     */
    private String shortName;

    /**
     * 线路类型(1-人民公交)
     * 表字段 : base_route_charge_standard.route_type
     */
    private Integer routeType;

    /**
     * 收费类型(1-一票制 2-分段)
     * 表字段 : base_route_charge_standard.charge_type
     */
    private Integer chargeType;

    /**
     * 线路总里程
     * 表字段 : base_route_charge_standard.distance
     */
    private BigDecimal distance;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : base_route_charge_standard.direction
     */
    private Integer direction;

    /**
     * 城市编码
     * 表字段 : base_route_charge_standard.city_code
     */
    private String cityCode;

    /**
     * 正常情况全程最高用时：分钟
     * 表字段 : base_route_charge_standard.minutes
     */
    private Integer minutes;

    /**
     * 晚点平均用时：分钟
     * 表字段 : base_route_charge_standard.late_minutes
     */
    private Integer lateMinutes;

    /**
     * 最低票价;一票制为固定票价，分段收费为起点到终点票价
     * 表字段 : base_route_charge_standard.cheapest_price
     */
    private BigDecimal cheapestPrice;

    /**
     * 最高票价：一票制为固定票价，分段收费为起点到终点票价
     * 表字段 : base_route_charge_standard.highest_price
     */
    private BigDecimal highestPrice;

    /**
     * 
     * 表字段 : base_route_charge_standard.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : base_route_charge_standard.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : base_route_charge_standard.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:base_route_charge_standard.id
     *
     * @return base_route_charge_standard.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:base_route_charge_standard.id
     *
     * @param id the value for base_route_charge_standard.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路ID(GPSID) 字段:base_route_charge_standard.route_id
     *
     * @return base_route_charge_standard.route_id, 线路ID(GPSID)
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 线路ID(GPSID) 字段:base_route_charge_standard.route_id
     *
     * @param routeId the value for base_route_charge_standard.route_id, 线路ID(GPSID)
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * 获取 线路名称 字段:base_route_charge_standard.route_name
     *
     * @return base_route_charge_standard.route_name, 线路名称
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * 设置 线路名称 字段:base_route_charge_standard.route_name
     *
     * @param routeName the value for base_route_charge_standard.route_name, 线路名称
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    /**
     * 获取 线路简称 字段:base_route_charge_standard.short_name
     *
     * @return base_route_charge_standard.short_name, 线路简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置 线路简称 字段:base_route_charge_standard.short_name
     *
     * @param shortName the value for base_route_charge_standard.short_name, 线路简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 获取 线路类型(1-人民公交) 字段:base_route_charge_standard.route_type
     *
     * @return base_route_charge_standard.route_type, 线路类型(1-人民公交)
     */
    public Integer getRouteType() {
        return routeType;
    }

    /**
     * 设置 线路类型(1-人民公交) 字段:base_route_charge_standard.route_type
     *
     * @param routeType the value for base_route_charge_standard.route_type, 线路类型(1-人民公交)
     */
    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    /**
     * 获取 收费类型(1-一票制 2-分段) 字段:base_route_charge_standard.charge_type
     *
     * @return base_route_charge_standard.charge_type, 收费类型(1-一票制 2-分段)
     */
    public Integer getChargeType() {
        return chargeType;
    }

    /**
     * 设置 收费类型(1-一票制 2-分段) 字段:base_route_charge_standard.charge_type
     *
     * @param chargeType the value for base_route_charge_standard.charge_type, 收费类型(1-一票制 2-分段)
     */
    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    /**
     * 获取 线路总里程 字段:base_route_charge_standard.distance
     *
     * @return base_route_charge_standard.distance, 线路总里程
     */
    public BigDecimal getDistance() {
        return distance;
    }

    /**
     * 设置 线路总里程 字段:base_route_charge_standard.distance
     *
     * @param distance the value for base_route_charge_standard.distance, 线路总里程
     */
    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    /**
     * 获取 线路方向 0-上行 1-下行 字段:base_route_charge_standard.direction
     *
     * @return base_route_charge_standard.direction, 线路方向 0-上行 1-下行
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 设置 线路方向 0-上行 1-下行 字段:base_route_charge_standard.direction
     *
     * @param direction the value for base_route_charge_standard.direction, 线路方向 0-上行 1-下行
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * 获取 城市编码 字段:base_route_charge_standard.city_code
     *
     * @return base_route_charge_standard.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:base_route_charge_standard.city_code
     *
     * @param cityCode the value for base_route_charge_standard.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 正常情况全程最高用时：分钟 字段:base_route_charge_standard.minutes
     *
     * @return base_route_charge_standard.minutes, 正常情况全程最高用时：分钟
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * 设置 正常情况全程最高用时：分钟 字段:base_route_charge_standard.minutes
     *
     * @param minutes the value for base_route_charge_standard.minutes, 正常情况全程最高用时：分钟
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * 获取 晚点平均用时：分钟 字段:base_route_charge_standard.late_minutes
     *
     * @return base_route_charge_standard.late_minutes, 晚点平均用时：分钟
     */
    public Integer getLateMinutes() {
        return lateMinutes;
    }

    /**
     * 设置 晚点平均用时：分钟 字段:base_route_charge_standard.late_minutes
     *
     * @param lateMinutes the value for base_route_charge_standard.late_minutes, 晚点平均用时：分钟
     */
    public void setLateMinutes(Integer lateMinutes) {
        this.lateMinutes = lateMinutes;
    }

    /**
     * 获取 最低票价;一票制为固定票价，分段收费为起点到终点票价 字段:base_route_charge_standard.cheapest_price
     *
     * @return base_route_charge_standard.cheapest_price, 最低票价;一票制为固定票价，分段收费为起点到终点票价
     */
    public BigDecimal getCheapestPrice() {
        return cheapestPrice;
    }

    /**
     * 设置 最低票价;一票制为固定票价，分段收费为起点到终点票价 字段:base_route_charge_standard.cheapest_price
     *
     * @param cheapestPrice the value for base_route_charge_standard.cheapest_price, 最低票价;一票制为固定票价，分段收费为起点到终点票价
     */
    public void setCheapestPrice(BigDecimal cheapestPrice) {
        this.cheapestPrice = cheapestPrice;
    }

    /**
     * 获取 最高票价：一票制为固定票价，分段收费为起点到终点票价 字段:base_route_charge_standard.highest_price
     *
     * @return base_route_charge_standard.highest_price, 最高票价：一票制为固定票价，分段收费为起点到终点票价
     */
    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    /**
     * 设置 最高票价：一票制为固定票价，分段收费为起点到终点票价 字段:base_route_charge_standard.highest_price
     *
     * @param highestPrice the value for base_route_charge_standard.highest_price, 最高票价：一票制为固定票价，分段收费为起点到终点票价
     */
    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    /**
     * 获取  字段:base_route_charge_standard.field1
     *
     * @return base_route_charge_standard.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:base_route_charge_standard.field1
     *
     * @param field1 the value for base_route_charge_standard.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:base_route_charge_standard.field2
     *
     * @return base_route_charge_standard.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:base_route_charge_standard.field2
     *
     * @param field2 the value for base_route_charge_standard.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:base_route_charge_standard.field3
     *
     * @return base_route_charge_standard.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:base_route_charge_standard.field3
     *
     * @param field3 the value for base_route_charge_standard.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
package com.lantaiyuan.ebus.virtual.card.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 用户乘车消费记录表
 * virtualCardExpenseHistory
 * 数据库表：lty_virtual_card_expense _history
 */
public class VirtualCardExpenseHistory extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : lty_virtual_card_expense _history.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_expense _history.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_expense _history.gmt_modified
     */
    private Date gmtModified;

    /**
     * 乘车ID
     * 表字段 : lty_virtual_card_expense _history.take_id
     */
    private String takeId;

    /**
     * 用户id，对应base_user
     * 表字段 : lty_virtual_card_expense _history.user_id
     */
    private Integer userId;

    /**
     * 用户名称
     * 表字段 : lty_virtual_card_expense _history.user_name
     */
    private String userName;

    /**
     * 城市编码
     * 表字段 : lty_virtual_card_expense _history.city_code
     */
    private String cityCode;

    /**
     * 虚拟卡号
     * 表字段 : lty_virtual_card_expense _history.card_no
     */
    private String cardNo;

    /**
     * 
     * 表字段 : lty_virtual_card_expense _history.amount
     */
    private BigDecimal amount;

    /**
     * 线路ID(GPSID)
     * 表字段 : lty_virtual_card_expense _history.route_id
     */
    private String routeId;

    /**
     * 线路名称
     * 表字段 : lty_virtual_card_expense _history.route_name
     */
    private String routeName;

    /**
     * 车辆编号
     * 表字段 : lty_virtual_card_expense _history.vehicle_id
     */
    private String vehicleId;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : lty_virtual_card_expense _history.route_direction
     */
    private Boolean routeDirection;

    /**
     * 司机ID
     * 表字段 : lty_virtual_card_expense _history.diver_id
     */
    private Integer diverId;

    /**
     * 收费类型（1-一票制  2-分段收费)
     * 表字段 : lty_virtual_card_expense _history.charge_type
     */
    private String chargeType;

    /**
     * 公交班次序号
     * 表字段 : lty_virtual_card_expense _history.bus_seq
     */
    private String busSeq;

    /**
     * 上车刷卡流水记录ID
     * 表字段 : lty_virtual_card_expense _history.up_swipe_id
     */
    private String upSwipeId;

    /**
     * 上车刷卡时间
     * 表字段 : lty_virtual_card_expense _history.up_swipe_time
     */
    private Date upSwipeTime;

    /**
     * 上车刷卡utc时间
     * 表字段 : lty_virtual_card_expense _history.up_swipe_utc_time
     */
    private Integer upSwipeUtcTime;

    /**
     * 上车刷卡的站点ID
     * 表字段 : lty_virtual_card_expense _history.up_station_id
     */
    private Integer upStationId;

    /**
     * 上车在该线路中是几站
     * 表字段 : lty_virtual_card_expense _history.up_station_no
     */
    private Integer upStationNo;

    /**
     * 上车站点名称
     * 表字段 : lty_virtual_card_expense _history.up_station_name
     */
    private String upStationName;

    /**
     * 下车刷卡流水记录ID
     * 表字段 : lty_virtual_card_expense _history.down_swipe_id
     */
    private String downSwipeId;

    /**
     * 下车刷卡时间
     * 表字段 : lty_virtual_card_expense _history.down_swipe_time
     */
    private Date downSwipeTime;

    /**
     * 下车刷卡utc时间
     * 表字段 : lty_virtual_card_expense _history.down_swipe_utc_time
     */
    private Integer downSwipeUtcTime;

    /**
     * 下车刷卡的站点ID
     * 表字段 : lty_virtual_card_expense _history.down_station_id
     */
    private Integer downStationId;

    /**
     * 下车在该线路中是几站
     * 表字段 : lty_virtual_card_expense _history.down_station_no
     */
    private Integer downStationNo;

    /**
     * 下车站点名称
     * 表字段 : lty_virtual_card_expense _history.down_station_name
     */
    private String downStationName;

    /**
     * 交易流水ID 对应虚拟公交卡用户账户交易记录表
     * 表字段 : lty_virtual_card_expense _history.transaction_id
     */
    private String transactionId;

    /**
     * 扣款状态 默认0:未扣款 当交易流水ID不为空证明扣款成功:1
     * 表字段 : lty_virtual_card_expense _history.trans_status
     */
    private Boolean transStatus;

    /**
     * 默认为0-记录不完整，分段收费将刷卡记录提前存入乘车记录表，若分段收费规定时间内未刷卡默认逃票（忘记刷票），当扣款成功即使该条记录分段收费没有下车记录，也置为1。特殊情况人工处理）
     * 表字段 : lty_virtual_card_expense _history.deal_status
     */
    private Boolean dealStatus;

    /**
     * 操作完成时间：一旦记录有值，标识完成，除特殊情况不允许修改该条记录
     * 表字段 : lty_virtual_card_expense _history.finish_time
     */
    private Date finishTime;

    /**
     * 
     * 表字段 : lty_virtual_card_expense _history.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_expense _history.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_expense _history.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:lty_virtual_card_expense _history.id
     *
     * @return lty_virtual_card_expense _history.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_expense _history.id
     *
     * @param id the value for lty_virtual_card_expense _history.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_expense _history.gmt_create
     *
     * @return lty_virtual_card_expense _history.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_expense _history.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_expense _history.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_expense _history.gmt_modified
     *
     * @return lty_virtual_card_expense _history.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_expense _history.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_expense _history.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 乘车ID 字段:lty_virtual_card_expense _history.take_id
     *
     * @return lty_virtual_card_expense _history.take_id, 乘车ID
     */
    public String getTakeId() {
        return takeId;
    }

    /**
     * 设置 乘车ID 字段:lty_virtual_card_expense _history.take_id
     *
     * @param takeId the value for lty_virtual_card_expense _history.take_id, 乘车ID
     */
    public void setTakeId(String takeId) {
        this.takeId = takeId == null ? null : takeId.trim();
    }

    /**
     * 获取 用户id，对应base_user 字段:lty_virtual_card_expense _history.user_id
     *
     * @return lty_virtual_card_expense _history.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:lty_virtual_card_expense _history.user_id
     *
     * @param userId the value for lty_virtual_card_expense _history.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户名称 字段:lty_virtual_card_expense _history.user_name
     *
     * @return lty_virtual_card_expense _history.user_name, 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名称 字段:lty_virtual_card_expense _history.user_name
     *
     * @param userName the value for lty_virtual_card_expense _history.user_name, 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 城市编码 字段:lty_virtual_card_expense _history.city_code
     *
     * @return lty_virtual_card_expense _history.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:lty_virtual_card_expense _history.city_code
     *
     * @param cityCode the value for lty_virtual_card_expense _history.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 虚拟卡号 字段:lty_virtual_card_expense _history.card_no
     *
     * @return lty_virtual_card_expense _history.card_no, 虚拟卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置 虚拟卡号 字段:lty_virtual_card_expense _history.card_no
     *
     * @param cardNo the value for lty_virtual_card_expense _history.card_no, 虚拟卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_expense _history.amount
     *
     * @return lty_virtual_card_expense _history.amount, 
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置  字段:lty_virtual_card_expense _history.amount
     *
     * @param amount the value for lty_virtual_card_expense _history.amount, 
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取 线路ID(GPSID) 字段:lty_virtual_card_expense _history.route_id
     *
     * @return lty_virtual_card_expense _history.route_id, 线路ID(GPSID)
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 线路ID(GPSID) 字段:lty_virtual_card_expense _history.route_id
     *
     * @param routeId the value for lty_virtual_card_expense _history.route_id, 线路ID(GPSID)
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * 获取 线路名称 字段:lty_virtual_card_expense _history.route_name
     *
     * @return lty_virtual_card_expense _history.route_name, 线路名称
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * 设置 线路名称 字段:lty_virtual_card_expense _history.route_name
     *
     * @param routeName the value for lty_virtual_card_expense _history.route_name, 线路名称
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    /**
     * 获取 车辆编号 字段:lty_virtual_card_expense _history.vehicle_id
     *
     * @return lty_virtual_card_expense _history.vehicle_id, 车辆编号
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置 车辆编号 字段:lty_virtual_card_expense _history.vehicle_id
     *
     * @param vehicleId the value for lty_virtual_card_expense _history.vehicle_id, 车辆编号
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
    }

    /**
     * 获取 线路方向 0-上行 1-下行 字段:lty_virtual_card_expense _history.route_direction
     *
     * @return lty_virtual_card_expense _history.route_direction, 线路方向 0-上行 1-下行
     */
    public Boolean getRouteDirection() {
        return routeDirection;
    }

    /**
     * 设置 线路方向 0-上行 1-下行 字段:lty_virtual_card_expense _history.route_direction
     *
     * @param routeDirection the value for lty_virtual_card_expense _history.route_direction, 线路方向 0-上行 1-下行
     */
    public void setRouteDirection(Boolean routeDirection) {
        this.routeDirection = routeDirection;
    }

    /**
     * 获取 司机ID 字段:lty_virtual_card_expense _history.diver_id
     *
     * @return lty_virtual_card_expense _history.diver_id, 司机ID
     */
    public Integer getDiverId() {
        return diverId;
    }

    /**
     * 设置 司机ID 字段:lty_virtual_card_expense _history.diver_id
     *
     * @param diverId the value for lty_virtual_card_expense _history.diver_id, 司机ID
     */
    public void setDiverId(Integer diverId) {
        this.diverId = diverId;
    }

    /**
     * 获取 收费类型（1-一票制  2-分段收费) 字段:lty_virtual_card_expense _history.charge_type
     *
     * @return lty_virtual_card_expense _history.charge_type, 收费类型（1-一票制  2-分段收费)
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * 设置 收费类型（1-一票制  2-分段收费) 字段:lty_virtual_card_expense _history.charge_type
     *
     * @param chargeType the value for lty_virtual_card_expense _history.charge_type, 收费类型（1-一票制  2-分段收费)
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    /**
     * 获取 公交班次序号 字段:lty_virtual_card_expense _history.bus_seq
     *
     * @return lty_virtual_card_expense _history.bus_seq, 公交班次序号
     */
    public String getBusSeq() {
        return busSeq;
    }

    /**
     * 设置 公交班次序号 字段:lty_virtual_card_expense _history.bus_seq
     *
     * @param busSeq the value for lty_virtual_card_expense _history.bus_seq, 公交班次序号
     */
    public void setBusSeq(String busSeq) {
        this.busSeq = busSeq == null ? null : busSeq.trim();
    }

    /**
     * 获取 上车刷卡流水记录ID 字段:lty_virtual_card_expense _history.up_swipe_id
     *
     * @return lty_virtual_card_expense _history.up_swipe_id, 上车刷卡流水记录ID
     */
    public String getUpSwipeId() {
        return upSwipeId;
    }

    /**
     * 设置 上车刷卡流水记录ID 字段:lty_virtual_card_expense _history.up_swipe_id
     *
     * @param upSwipeId the value for lty_virtual_card_expense _history.up_swipe_id, 上车刷卡流水记录ID
     */
    public void setUpSwipeId(String upSwipeId) {
        this.upSwipeId = upSwipeId == null ? null : upSwipeId.trim();
    }

    /**
     * 获取 上车刷卡时间 字段:lty_virtual_card_expense _history.up_swipe_time
     *
     * @return lty_virtual_card_expense _history.up_swipe_time, 上车刷卡时间
     */
    public Date getUpSwipeTime() {
        return upSwipeTime;
    }

    /**
     * 设置 上车刷卡时间 字段:lty_virtual_card_expense _history.up_swipe_time
     *
     * @param upSwipeTime the value for lty_virtual_card_expense _history.up_swipe_time, 上车刷卡时间
     */
    public void setUpSwipeTime(Date upSwipeTime) {
        this.upSwipeTime = upSwipeTime;
    }

    /**
     * 获取 上车刷卡utc时间 字段:lty_virtual_card_expense _history.up_swipe_utc_time
     *
     * @return lty_virtual_card_expense _history.up_swipe_utc_time, 上车刷卡utc时间
     */
    public Integer getUpSwipeUtcTime() {
        return upSwipeUtcTime;
    }

    /**
     * 设置 上车刷卡utc时间 字段:lty_virtual_card_expense _history.up_swipe_utc_time
     *
     * @param upSwipeUtcTime the value for lty_virtual_card_expense _history.up_swipe_utc_time, 上车刷卡utc时间
     */
    public void setUpSwipeUtcTime(Integer upSwipeUtcTime) {
        this.upSwipeUtcTime = upSwipeUtcTime;
    }

    /**
     * 获取 上车刷卡的站点ID 字段:lty_virtual_card_expense _history.up_station_id
     *
     * @return lty_virtual_card_expense _history.up_station_id, 上车刷卡的站点ID
     */
    public Integer getUpStationId() {
        return upStationId;
    }

    /**
     * 设置 上车刷卡的站点ID 字段:lty_virtual_card_expense _history.up_station_id
     *
     * @param upStationId the value for lty_virtual_card_expense _history.up_station_id, 上车刷卡的站点ID
     */
    public void setUpStationId(Integer upStationId) {
        this.upStationId = upStationId;
    }

    /**
     * 获取 上车在该线路中是几站 字段:lty_virtual_card_expense _history.up_station_no
     *
     * @return lty_virtual_card_expense _history.up_station_no, 上车在该线路中是几站
     */
    public Integer getUpStationNo() {
        return upStationNo;
    }

    /**
     * 设置 上车在该线路中是几站 字段:lty_virtual_card_expense _history.up_station_no
     *
     * @param upStationNo the value for lty_virtual_card_expense _history.up_station_no, 上车在该线路中是几站
     */
    public void setUpStationNo(Integer upStationNo) {
        this.upStationNo = upStationNo;
    }

    /**
     * 获取 上车站点名称 字段:lty_virtual_card_expense _history.up_station_name
     *
     * @return lty_virtual_card_expense _history.up_station_name, 上车站点名称
     */
    public String getUpStationName() {
        return upStationName;
    }

    /**
     * 设置 上车站点名称 字段:lty_virtual_card_expense _history.up_station_name
     *
     * @param upStationName the value for lty_virtual_card_expense _history.up_station_name, 上车站点名称
     */
    public void setUpStationName(String upStationName) {
        this.upStationName = upStationName == null ? null : upStationName.trim();
    }

    /**
     * 获取 下车刷卡流水记录ID 字段:lty_virtual_card_expense _history.down_swipe_id
     *
     * @return lty_virtual_card_expense _history.down_swipe_id, 下车刷卡流水记录ID
     */
    public String getDownSwipeId() {
        return downSwipeId;
    }

    /**
     * 设置 下车刷卡流水记录ID 字段:lty_virtual_card_expense _history.down_swipe_id
     *
     * @param downSwipeId the value for lty_virtual_card_expense _history.down_swipe_id, 下车刷卡流水记录ID
     */
    public void setDownSwipeId(String downSwipeId) {
        this.downSwipeId = downSwipeId == null ? null : downSwipeId.trim();
    }

    /**
     * 获取 下车刷卡时间 字段:lty_virtual_card_expense _history.down_swipe_time
     *
     * @return lty_virtual_card_expense _history.down_swipe_time, 下车刷卡时间
     */
    public Date getDownSwipeTime() {
        return downSwipeTime;
    }

    /**
     * 设置 下车刷卡时间 字段:lty_virtual_card_expense _history.down_swipe_time
     *
     * @param downSwipeTime the value for lty_virtual_card_expense _history.down_swipe_time, 下车刷卡时间
     */
    public void setDownSwipeTime(Date downSwipeTime) {
        this.downSwipeTime = downSwipeTime;
    }

    /**
     * 获取 下车刷卡utc时间 字段:lty_virtual_card_expense _history.down_swipe_utc_time
     *
     * @return lty_virtual_card_expense _history.down_swipe_utc_time, 下车刷卡utc时间
     */
    public Integer getDownSwipeUtcTime() {
        return downSwipeUtcTime;
    }

    /**
     * 设置 下车刷卡utc时间 字段:lty_virtual_card_expense _history.down_swipe_utc_time
     *
     * @param downSwipeUtcTime the value for lty_virtual_card_expense _history.down_swipe_utc_time, 下车刷卡utc时间
     */
    public void setDownSwipeUtcTime(Integer downSwipeUtcTime) {
        this.downSwipeUtcTime = downSwipeUtcTime;
    }

    /**
     * 获取 下车刷卡的站点ID 字段:lty_virtual_card_expense _history.down_station_id
     *
     * @return lty_virtual_card_expense _history.down_station_id, 下车刷卡的站点ID
     */
    public Integer getDownStationId() {
        return downStationId;
    }

    /**
     * 设置 下车刷卡的站点ID 字段:lty_virtual_card_expense _history.down_station_id
     *
     * @param downStationId the value for lty_virtual_card_expense _history.down_station_id, 下车刷卡的站点ID
     */
    public void setDownStationId(Integer downStationId) {
        this.downStationId = downStationId;
    }

    /**
     * 获取 下车在该线路中是几站 字段:lty_virtual_card_expense _history.down_station_no
     *
     * @return lty_virtual_card_expense _history.down_station_no, 下车在该线路中是几站
     */
    public Integer getDownStationNo() {
        return downStationNo;
    }

    /**
     * 设置 下车在该线路中是几站 字段:lty_virtual_card_expense _history.down_station_no
     *
     * @param downStationNo the value for lty_virtual_card_expense _history.down_station_no, 下车在该线路中是几站
     */
    public void setDownStationNo(Integer downStationNo) {
        this.downStationNo = downStationNo;
    }

    /**
     * 获取 下车站点名称 字段:lty_virtual_card_expense _history.down_station_name
     *
     * @return lty_virtual_card_expense _history.down_station_name, 下车站点名称
     */
    public String getDownStationName() {
        return downStationName;
    }

    /**
     * 设置 下车站点名称 字段:lty_virtual_card_expense _history.down_station_name
     *
     * @param downStationName the value for lty_virtual_card_expense _history.down_station_name, 下车站点名称
     */
    public void setDownStationName(String downStationName) {
        this.downStationName = downStationName == null ? null : downStationName.trim();
    }

    /**
     * 获取 交易流水ID 对应虚拟公交卡用户账户交易记录表 字段:lty_virtual_card_expense _history.transaction_id
     *
     * @return lty_virtual_card_expense _history.transaction_id, 交易流水ID 对应虚拟公交卡用户账户交易记录表
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置 交易流水ID 对应虚拟公交卡用户账户交易记录表 字段:lty_virtual_card_expense _history.transaction_id
     *
     * @param transactionId the value for lty_virtual_card_expense _history.transaction_id, 交易流水ID 对应虚拟公交卡用户账户交易记录表
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * 获取 扣款状态 默认0:未扣款 当交易流水ID不为空证明扣款成功:1 字段:lty_virtual_card_expense _history.trans_status
     *
     * @return lty_virtual_card_expense _history.trans_status, 扣款状态 默认0:未扣款 当交易流水ID不为空证明扣款成功:1
     */
    public Boolean getTransStatus() {
        return transStatus;
    }

    /**
     * 设置 扣款状态 默认0:未扣款 当交易流水ID不为空证明扣款成功:1 字段:lty_virtual_card_expense _history.trans_status
     *
     * @param transStatus the value for lty_virtual_card_expense _history.trans_status, 扣款状态 默认0:未扣款 当交易流水ID不为空证明扣款成功:1
     */
    public void setTransStatus(Boolean transStatus) {
        this.transStatus = transStatus;
    }

    /**
     * 获取 默认为0-记录不完整，分段收费将刷卡记录提前存入乘车记录表，若分段收费规定时间内未刷卡默认逃票（忘记刷票），当扣款成功即使该条记录分段收费没有下车记录，也置为1。特殊情况人工处理） 字段:lty_virtual_card_expense _history.deal_status
     *
     * @return lty_virtual_card_expense _history.deal_status, 默认为0-记录不完整，分段收费将刷卡记录提前存入乘车记录表，若分段收费规定时间内未刷卡默认逃票（忘记刷票），当扣款成功即使该条记录分段收费没有下车记录，也置为1。特殊情况人工处理）
     */
    public Boolean getDealStatus() {
        return dealStatus;
    }

    /**
     * 设置 默认为0-记录不完整，分段收费将刷卡记录提前存入乘车记录表，若分段收费规定时间内未刷卡默认逃票（忘记刷票），当扣款成功即使该条记录分段收费没有下车记录，也置为1。特殊情况人工处理） 字段:lty_virtual_card_expense _history.deal_status
     *
     * @param dealStatus the value for lty_virtual_card_expense _history.deal_status, 默认为0-记录不完整，分段收费将刷卡记录提前存入乘车记录表，若分段收费规定时间内未刷卡默认逃票（忘记刷票），当扣款成功即使该条记录分段收费没有下车记录，也置为1。特殊情况人工处理）
     */
    public void setDealStatus(Boolean dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 获取 操作完成时间：一旦记录有值，标识完成，除特殊情况不允许修改该条记录 字段:lty_virtual_card_expense _history.finish_time
     *
     * @return lty_virtual_card_expense _history.finish_time, 操作完成时间：一旦记录有值，标识完成，除特殊情况不允许修改该条记录
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置 操作完成时间：一旦记录有值，标识完成，除特殊情况不允许修改该条记录 字段:lty_virtual_card_expense _history.finish_time
     *
     * @param finishTime the value for lty_virtual_card_expense _history.finish_time, 操作完成时间：一旦记录有值，标识完成，除特殊情况不允许修改该条记录
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取  字段:lty_virtual_card_expense _history.field1
     *
     * @return lty_virtual_card_expense _history.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_expense _history.field1
     *
     * @param field1 the value for lty_virtual_card_expense _history.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_expense _history.field2
     *
     * @return lty_virtual_card_expense _history.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_expense _history.field2
     *
     * @param field2 the value for lty_virtual_card_expense _history.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_expense _history.field3
     *
     * @return lty_virtual_card_expense _history.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_expense _history.field3
     *
     * @param field3 the value for lty_virtual_card_expense _history.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
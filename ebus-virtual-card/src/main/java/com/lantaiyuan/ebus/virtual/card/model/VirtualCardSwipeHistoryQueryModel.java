package com.lantaiyuan.ebus.virtual.card.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 虚拟公交卡刷卡记录表
 * virtualCardSwipeHistory
 * 数据库表：lty_virtual_card_swipe_history
 */
public class VirtualCardSwipeHistoryQueryModel extends BaseModel<VirtualCardSwipeHistory>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : lty_virtual_card_swipe_history.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_swipe_history.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_swipe_history.gmt_modified
     */
    private Date gmtModified;

    /**
     * 刷卡流水记录ID
     * 表字段 : lty_virtual_card_swipe_history.swipe_id
     */
    private String swipeId;

    /**
     * 虚拟卡号
     * 表字段 : lty_virtual_card_swipe_history.card_no
     */
    private String cardNo;

    /**
     * 经度
     * 表字段 : lty_virtual_card_swipe_history.longitude
     */
    private BigDecimal longitude;

    /**
     * 纬度
     * 表字段 : lty_virtual_card_swipe_history.latitude
     */
    private BigDecimal latitude;

    /**
     * 刷卡时间
     * 表字段 : lty_virtual_card_swipe_history.swipe_time
     */
    private Date swipeTime;

    /**
     * 刷卡utc时间
     * 表字段 : lty_virtual_card_swipe_history.swipe_utc_time
     */
    private Integer swipeUtcTime;

    /**
     * 刷卡的站点ID
     * 表字段 : lty_virtual_card_swipe_history.station_id
     */
    private Integer stationId;

    /**
     * 在该线路中是几站
     * 表字段 : lty_virtual_card_swipe_history.station_no
     */
    private Integer stationNo;

    /**
     * 线路ID(GPSID)
     * 表字段 : lty_virtual_card_swipe_history.route_id
     */
    private String routeId;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : lty_virtual_card_swipe_history.route_direction
     */
    private Boolean routeDirection;

    /**
     * 上下车标识 1-上 2-下
     * 表字段 : lty_virtual_card_swipe_history.on_bus_flag
     */
    private String onBusFlag;

    /**
     * 司机ID
     * 表字段 : lty_virtual_card_swipe_history.diver_id
     */
    private Integer diverId;

    /**
     * 车辆编号
     * 表字段 : lty_virtual_card_swipe_history.vehicle_id
     */
    private String vehicleId;

    /**
     * 公交班次序号
     * 表字段 : lty_virtual_card_swipe_history.bus_seq
     */
    private String busSeq;

    /**
     * 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码
     * 表字段 : lty_virtual_card_swipe_history.verify_code
     */
    private String verifyCode;

    /**
     * 虚拟卡对应的验证码是否有误：0-正确 1-错误 当状态为1时不做任何处理（定时器扫描）
     * 表字段 : lty_virtual_card_swipe_history.code_status
     */
    private Boolean codeStatus;

    /**
     * 处理(该条记录是否已经处理完存,已经存入乘车记录表)状态 （0-No  1-Yes)
     * 表字段 : lty_virtual_card_swipe_history.deal_status
     */
    private Boolean dealStatus;

    /**
     * 
     * 表字段 : lty_virtual_card_swipe_history.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_swipe_history.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_swipe_history.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:lty_virtual_card_swipe_history.id
     *
     * @return lty_virtual_card_swipe_history.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_swipe_history.id
     *
     * @param id the value for lty_virtual_card_swipe_history.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_swipe_history.gmt_create
     *
     * @return lty_virtual_card_swipe_history.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_swipe_history.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_swipe_history.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_swipe_history.gmt_modified
     *
     * @return lty_virtual_card_swipe_history.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_swipe_history.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_swipe_history.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 刷卡流水记录ID 字段:lty_virtual_card_swipe_history.swipe_id
     *
     * @return lty_virtual_card_swipe_history.swipe_id, 刷卡流水记录ID
     */
    public String getSwipeId() {
        return swipeId;
    }

    /**
     * 设置 刷卡流水记录ID 字段:lty_virtual_card_swipe_history.swipe_id
     *
     * @param swipeId the value for lty_virtual_card_swipe_history.swipe_id, 刷卡流水记录ID
     */
    public void setSwipeId(String swipeId) {
        this.swipeId = swipeId == null ? null : swipeId.trim();
    }

    /**
     * 获取 虚拟卡号 字段:lty_virtual_card_swipe_history.card_no
     *
     * @return lty_virtual_card_swipe_history.card_no, 虚拟卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置 虚拟卡号 字段:lty_virtual_card_swipe_history.card_no
     *
     * @param cardNo the value for lty_virtual_card_swipe_history.card_no, 虚拟卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取 经度 字段:lty_virtual_card_swipe_history.longitude
     *
     * @return lty_virtual_card_swipe_history.longitude, 经度
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置 经度 字段:lty_virtual_card_swipe_history.longitude
     *
     * @param longitude the value for lty_virtual_card_swipe_history.longitude, 经度
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取 纬度 字段:lty_virtual_card_swipe_history.latitude
     *
     * @return lty_virtual_card_swipe_history.latitude, 纬度
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置 纬度 字段:lty_virtual_card_swipe_history.latitude
     *
     * @param latitude the value for lty_virtual_card_swipe_history.latitude, 纬度
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取 刷卡时间 字段:lty_virtual_card_swipe_history.swipe_time
     *
     * @return lty_virtual_card_swipe_history.swipe_time, 刷卡时间
     */
    public Date getSwipeTime() {
        return swipeTime;
    }

    /**
     * 设置 刷卡时间 字段:lty_virtual_card_swipe_history.swipe_time
     *
     * @param swipeTime the value for lty_virtual_card_swipe_history.swipe_time, 刷卡时间
     */
    public void setSwipeTime(Date swipeTime) {
        this.swipeTime = swipeTime;
    }

    /**
     * 获取 刷卡utc时间 字段:lty_virtual_card_swipe_history.swipe_utc_time
     *
     * @return lty_virtual_card_swipe_history.swipe_utc_time, 刷卡utc时间
     */
    public Integer getSwipeUtcTime() {
        return swipeUtcTime;
    }

    /**
     * 设置 刷卡utc时间 字段:lty_virtual_card_swipe_history.swipe_utc_time
     *
     * @param swipeUtcTime the value for lty_virtual_card_swipe_history.swipe_utc_time, 刷卡utc时间
     */
    public void setSwipeUtcTime(Integer swipeUtcTime) {
        this.swipeUtcTime = swipeUtcTime;
    }

    /**
     * 获取 刷卡的站点ID 字段:lty_virtual_card_swipe_history.station_id
     *
     * @return lty_virtual_card_swipe_history.station_id, 刷卡的站点ID
     */
    public Integer getStationId() {
        return stationId;
    }

    /**
     * 设置 刷卡的站点ID 字段:lty_virtual_card_swipe_history.station_id
     *
     * @param stationId the value for lty_virtual_card_swipe_history.station_id, 刷卡的站点ID
     */
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    /**
     * 获取 在该线路中是几站 字段:lty_virtual_card_swipe_history.station_no
     *
     * @return lty_virtual_card_swipe_history.station_no, 在该线路中是几站
     */
    public Integer getStationNo() {
        return stationNo;
    }

    /**
     * 设置 在该线路中是几站 字段:lty_virtual_card_swipe_history.station_no
     *
     * @param stationNo the value for lty_virtual_card_swipe_history.station_no, 在该线路中是几站
     */
    public void setStationNo(Integer stationNo) {
        this.stationNo = stationNo;
    }

    /**
     * 获取 线路ID(GPSID) 字段:lty_virtual_card_swipe_history.route_id
     *
     * @return lty_virtual_card_swipe_history.route_id, 线路ID(GPSID)
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 线路ID(GPSID) 字段:lty_virtual_card_swipe_history.route_id
     *
     * @param routeId the value for lty_virtual_card_swipe_history.route_id, 线路ID(GPSID)
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * 获取 线路方向 0-上行 1-下行 字段:lty_virtual_card_swipe_history.route_direction
     *
     * @return lty_virtual_card_swipe_history.route_direction, 线路方向 0-上行 1-下行
     */
    public Boolean getRouteDirection() {
        return routeDirection;
    }

    /**
     * 设置 线路方向 0-上行 1-下行 字段:lty_virtual_card_swipe_history.route_direction
     *
     * @param routeDirection the value for lty_virtual_card_swipe_history.route_direction, 线路方向 0-上行 1-下行
     */
    public void setRouteDirection(Boolean routeDirection) {
        this.routeDirection = routeDirection;
    }

    /**
     * 获取 上下车标识 1-上 2-下 字段:lty_virtual_card_swipe_history.on_bus_flag
     *
     * @return lty_virtual_card_swipe_history.on_bus_flag, 上下车标识 1-上 2-下
     */
    public String getOnBusFlag() {
        return onBusFlag;
    }

    /**
     * 设置 上下车标识 1-上 2-下 字段:lty_virtual_card_swipe_history.on_bus_flag
     *
     * @param onBusFlag the value for lty_virtual_card_swipe_history.on_bus_flag, 上下车标识 1-上 2-下
     */
    public void setOnBusFlag(String onBusFlag) {
        this.onBusFlag = onBusFlag;
    }

    /**
     * 获取 司机ID 字段:lty_virtual_card_swipe_history.diver_id
     *
     * @return lty_virtual_card_swipe_history.diver_id, 司机ID
     */
    public Integer getDiverId() {
        return diverId;
    }

    /**
     * 设置 司机ID 字段:lty_virtual_card_swipe_history.diver_id
     *
     * @param diverId the value for lty_virtual_card_swipe_history.diver_id, 司机ID
     */
    public void setDiverId(Integer diverId) {
        this.diverId = diverId;
    }

    /**
     * 获取 车辆编号 字段:lty_virtual_card_swipe_history.vehicle_id
     *
     * @return lty_virtual_card_swipe_history.vehicle_id, 车辆编号
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置 车辆编号 字段:lty_virtual_card_swipe_history.vehicle_id
     *
     * @param vehicleId the value for lty_virtual_card_swipe_history.vehicle_id, 车辆编号
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
    }

    /**
     * 获取 公交班次序号 字段:lty_virtual_card_swipe_history.bus_seq
     *
     * @return lty_virtual_card_swipe_history.bus_seq, 公交班次序号
     */
    public String getBusSeq() {
        return busSeq;
    }

    /**
     * 设置 公交班次序号 字段:lty_virtual_card_swipe_history.bus_seq
     *
     * @param busSeq the value for lty_virtual_card_swipe_history.bus_seq, 公交班次序号
     */
    public void setBusSeq(String busSeq) {
        this.busSeq = busSeq == null ? null : busSeq.trim();
    }

    /**
     * 获取 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码 字段:lty_virtual_card_swipe_history.verify_code
     *
     * @return lty_virtual_card_swipe_history.verify_code, 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 设置 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码 字段:lty_virtual_card_swipe_history.verify_code
     *
     * @param verifyCode the value for lty_virtual_card_swipe_history.verify_code, 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    /**
     * 获取 虚拟卡对应的验证码是否有误：0-正确 1-错误 当状态为1时不做任何处理（定时器扫描） 字段:lty_virtual_card_swipe_history.code_status
     *
     * @return lty_virtual_card_swipe_history.code_status, 虚拟卡对应的验证码是否有误：0-正确 1-错误 当状态为1时不做任何处理（定时器扫描）
     */
    public Boolean getCodeStatus() {
        return codeStatus;
    }

    /**
     * 设置 虚拟卡对应的验证码是否有误：0-正确 1-错误 当状态为1时不做任何处理（定时器扫描） 字段:lty_virtual_card_swipe_history.code_status
     *
     * @param codeStatus the value for lty_virtual_card_swipe_history.code_status, 虚拟卡对应的验证码是否有误：0-正确 1-错误 当状态为1时不做任何处理（定时器扫描）
     */
    public void setCodeStatus(Boolean codeStatus) {
        this.codeStatus = codeStatus;
    }

    /**
     * 获取 处理(该条记录是否已经处理完存,已经存入乘车记录表)状态 （0-No  1-Yes) 字段:lty_virtual_card_swipe_history.deal_status
     *
     * @return lty_virtual_card_swipe_history.deal_status, 处理(该条记录是否已经处理完存,已经存入乘车记录表)状态 （0-No  1-Yes)
     */
    public Boolean getDealStatus() {
        return dealStatus;
    }

    /**
     * 设置 处理(该条记录是否已经处理完存,已经存入乘车记录表)状态 （0-No  1-Yes) 字段:lty_virtual_card_swipe_history.deal_status
     *
     * @param dealStatus the value for lty_virtual_card_swipe_history.deal_status, 处理(该条记录是否已经处理完存,已经存入乘车记录表)状态 （0-No  1-Yes)
     */
    public void setDealStatus(Boolean dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 获取  字段:lty_virtual_card_swipe_history.field1
     *
     * @return lty_virtual_card_swipe_history.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_swipe_history.field1
     *
     * @param field1 the value for lty_virtual_card_swipe_history.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_swipe_history.field2
     *
     * @return lty_virtual_card_swipe_history.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_swipe_history.field2
     *
     * @param field2 the value for lty_virtual_card_swipe_history.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_swipe_history.field3
     *
     * @return lty_virtual_card_swipe_history.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_swipe_history.field3
     *
     * @param field3 the value for lty_virtual_card_swipe_history.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
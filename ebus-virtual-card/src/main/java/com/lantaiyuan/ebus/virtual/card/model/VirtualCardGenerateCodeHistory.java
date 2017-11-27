package com.lantaiyuan.ebus.virtual.card.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 用户虚拟卡二维码记录表
 * virtualCardGenerateCodeHistory
 * 数据库表：lty_virtual_card_generate_code _history
 */
public class VirtualCardGenerateCodeHistory extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : lty_virtual_card_generate_code _history.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_generate_code _history.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_generate_code _history.gmt_modified
     */
    private Date gmtModified;

    /**
     * 用户id，对应base_user
     * 表字段 : lty_virtual_card_generate_code _history.user_id
     */
    private Integer userId;

    /**
     * 城市编码
     * 表字段 : lty_virtual_card_generate_code _history.city_code
     */
    private String cityCode;

    /**
     * 虚拟卡号
     * 表字段 : lty_virtual_card_generate_code _history.card_no
     */
    private String cardNo;

    /**
     * 生成二维码的utc时间
     * 表字段 : lty_virtual_card_generate_code _history.utc_time
     */
    private Integer utcTime;

    /**
     * 基础码
     * 表字段 : lty_virtual_card_generate_code _history.card_base_code
     */
    private String cardBaseCode;

    /**
     * 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码
     * 表字段 : lty_virtual_card_generate_code _history.verify_code
     */
    private String verifyCode;

    /**
     * 虚拟卡二维码：基础码+验证码
     * 表字段 : lty_virtual_card_generate_code _history.card_code
     */
    private String cardCode;

    /**
     * 1-虚拟公交卡二维码
     * 表字段 : lty_virtual_card_generate_code _history.code_type
     */
    private Boolean codeType;

    /**
     * 
     * 表字段 : lty_virtual_card_generate_code _history.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_generate_code _history.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_generate_code _history.field3
     */
    private String field3;

    
    public VirtualCardGenerateCodeHistory(Integer userId, String cityCode, String cardNo, Integer utcTime,
			String cardBaseCode, String verifyCode, String cardCode) {
		super();
		this.userId = userId;
		this.cityCode = cityCode;
		this.cardNo = cardNo;
		this.utcTime = utcTime;
		this.cardBaseCode = cardBaseCode;
		this.verifyCode = verifyCode;
		this.cardCode = cardCode;
	}

	/**
     * 获取 自增主键 字段:lty_virtual_card_generate_code _history.id
     *
     * @return lty_virtual_card_generate_code _history.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_generate_code _history.id
     *
     * @param id the value for lty_virtual_card_generate_code _history.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_generate_code _history.gmt_create
     *
     * @return lty_virtual_card_generate_code _history.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_generate_code _history.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_generate_code _history.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_generate_code _history.gmt_modified
     *
     * @return lty_virtual_card_generate_code _history.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_generate_code _history.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_generate_code _history.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 用户id，对应base_user 字段:lty_virtual_card_generate_code _history.user_id
     *
     * @return lty_virtual_card_generate_code _history.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:lty_virtual_card_generate_code _history.user_id
     *
     * @param userId the value for lty_virtual_card_generate_code _history.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 城市编码 字段:lty_virtual_card_generate_code _history.city_code
     *
     * @return lty_virtual_card_generate_code _history.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:lty_virtual_card_generate_code _history.city_code
     *
     * @param cityCode the value for lty_virtual_card_generate_code _history.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 虚拟卡号 字段:lty_virtual_card_generate_code _history.card_no
     *
     * @return lty_virtual_card_generate_code _history.card_no, 虚拟卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置 虚拟卡号 字段:lty_virtual_card_generate_code _history.card_no
     *
     * @param cardNo the value for lty_virtual_card_generate_code _history.card_no, 虚拟卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取 生成二维码的utc时间 字段:lty_virtual_card_generate_code _history.utc_time
     *
     * @return lty_virtual_card_generate_code _history.utc_time, 生成二维码的utc时间
     */
    public Integer getUtcTime() {
        return utcTime;
    }

    /**
     * 设置 生成二维码的utc时间 字段:lty_virtual_card_generate_code _history.utc_time
     *
     * @param utcTime the value for lty_virtual_card_generate_code _history.utc_time, 生成二维码的utc时间
     */
    public void setUtcTime(Integer utcTime) {
        this.utcTime = utcTime;
    }

    /**
     * 获取 基础码 字段:lty_virtual_card_generate_code _history.card_base_code
     *
     * @return lty_virtual_card_generate_code _history.card_base_code, 基础码
     */
    public String getCardBaseCode() {
        return cardBaseCode;
    }

    /**
     * 设置 基础码 字段:lty_virtual_card_generate_code _history.card_base_code
     *
     * @param cardBaseCode the value for lty_virtual_card_generate_code _history.card_base_code, 基础码
     */
    public void setCardBaseCode(String cardBaseCode) {
        this.cardBaseCode = cardBaseCode == null ? null : cardBaseCode.trim();
    }

    /**
     * 获取 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码 字段:lty_virtual_card_generate_code _history.verify_code
     *
     * @return lty_virtual_card_generate_code _history.verify_code, 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 设置 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码 字段:lty_virtual_card_generate_code _history.verify_code
     *
     * @param verifyCode the value for lty_virtual_card_generate_code _history.verify_code, 验证码：对应虚拟卡号的在APP端生成二维码的后十位验证码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    /**
     * 获取 虚拟卡二维码：基础码+验证码 字段:lty_virtual_card_generate_code _history.card_code
     *
     * @return lty_virtual_card_generate_code _history.card_code, 虚拟卡二维码：基础码+验证码
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * 设置 虚拟卡二维码：基础码+验证码 字段:lty_virtual_card_generate_code _history.card_code
     *
     * @param cardCode the value for lty_virtual_card_generate_code _history.card_code, 虚拟卡二维码：基础码+验证码
     */
    public void setCardCode(String cardCode) {
        this.cardCode = cardCode == null ? null : cardCode.trim();
    }

    /**
     * 获取 1-虚拟公交卡二维码 字段:lty_virtual_card_generate_code _history.code_type
     *
     * @return lty_virtual_card_generate_code _history.code_type, 1-虚拟公交卡二维码
     */
    public Boolean getCodeType() {
        return codeType;
    }

    /**
     * 设置 1-虚拟公交卡二维码 字段:lty_virtual_card_generate_code _history.code_type
     *
     * @param codeType the value for lty_virtual_card_generate_code _history.code_type, 1-虚拟公交卡二维码
     */
    public void setCodeType(Boolean codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取  字段:lty_virtual_card_generate_code _history.field1
     *
     * @return lty_virtual_card_generate_code _history.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_generate_code _history.field1
     *
     * @param field1 the value for lty_virtual_card_generate_code _history.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_generate_code _history.field2
     *
     * @return lty_virtual_card_generate_code _history.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_generate_code _history.field2
     *
     * @param field2 the value for lty_virtual_card_generate_code _history.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_generate_code _history.field3
     *
     * @return lty_virtual_card_generate_code _history.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_generate_code _history.field3
     *
     * @param field3 the value for lty_virtual_card_generate_code _history.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
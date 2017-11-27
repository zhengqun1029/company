package com.lantaiyuan.ebus.virtual.card.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 虚拟公交卡用户账户表
 * virtualCardAccount
 * 数据库表：lty_virtual_card_account
 */
public class VirtualCardAccountQueryModel extends BaseModel<VirtualCardAccount>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : lty_virtual_card_account.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_account.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_account.gmt_modified
     */
    private Date gmtModified;

    /**
     * 用户id，对应base_user
     * 表字段 : lty_virtual_card_account.user_id
     */
    private Integer userId;

    /**
     * 用户名称
     * 表字段 : lty_virtual_card_account.user_name
     */
    private String userName;

    /**
     * 城市编码
     * 表字段 : lty_virtual_card_account.city_code
     */
    private String cityCode;

    /**
     * 虚拟卡号
     * 表字段 : lty_virtual_card_account.card_no
     */
    private String cardNo;

    /**
     * 
     * 表字段 : lty_virtual_card_account.balance
     */
    private BigDecimal balance;

    /**
     * 是否被冻结（0：否； 1：是）
     * 表字段 : lty_virtual_card_account.status
     */
    private Boolean status;

    /**
     * 
     * 表字段 : lty_virtual_card_account.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_account.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_account.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:lty_virtual_card_account.id
     *
     * @return lty_virtual_card_account.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_account.id
     *
     * @param id the value for lty_virtual_card_account.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_account.gmt_create
     *
     * @return lty_virtual_card_account.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_account.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_account.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_account.gmt_modified
     *
     * @return lty_virtual_card_account.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_account.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_account.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 用户id，对应base_user 字段:lty_virtual_card_account.user_id
     *
     * @return lty_virtual_card_account.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:lty_virtual_card_account.user_id
     *
     * @param userId the value for lty_virtual_card_account.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户名称 字段:lty_virtual_card_account.user_name
     *
     * @return lty_virtual_card_account.user_name, 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名称 字段:lty_virtual_card_account.user_name
     *
     * @param userName the value for lty_virtual_card_account.user_name, 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 城市编码 字段:lty_virtual_card_account.city_code
     *
     * @return lty_virtual_card_account.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:lty_virtual_card_account.city_code
     *
     * @param cityCode the value for lty_virtual_card_account.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 虚拟卡号 字段:lty_virtual_card_account.card_no
     *
     * @return lty_virtual_card_account.card_no, 虚拟卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置 虚拟卡号 字段:lty_virtual_card_account.card_no
     *
     * @param cardNo the value for lty_virtual_card_account.card_no, 虚拟卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account.balance
     *
     * @return lty_virtual_card_account.balance, 
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置  字段:lty_virtual_card_account.balance
     *
     * @param balance the value for lty_virtual_card_account.balance, 
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取 是否被冻结（0：否； 1：是） 字段:lty_virtual_card_account.status
     *
     * @return lty_virtual_card_account.status, 是否被冻结（0：否； 1：是）
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 是否被冻结（0：否； 1：是） 字段:lty_virtual_card_account.status
     *
     * @param status the value for lty_virtual_card_account.status, 是否被冻结（0：否； 1：是）
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取  字段:lty_virtual_card_account.field1
     *
     * @return lty_virtual_card_account.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_account.field1
     *
     * @param field1 the value for lty_virtual_card_account.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account.field2
     *
     * @return lty_virtual_card_account.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_account.field2
     *
     * @param field2 the value for lty_virtual_card_account.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account.field3
     *
     * @return lty_virtual_card_account.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_account.field3
     *
     * @param field3 the value for lty_virtual_card_account.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
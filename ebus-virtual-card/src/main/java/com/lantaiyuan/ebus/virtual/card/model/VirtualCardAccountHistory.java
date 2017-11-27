package com.lantaiyuan.ebus.virtual.card.model;

import org.lanqiao.ssm.common.model.Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 虚拟公交卡用户账户交易记录表
 * VirtualCardAccountHistory
 * 数据库表：lty_virtual_card_account_history
 */
public class VirtualCardAccountHistory extends Model{

    private static final long serialVersionUID = 8970191737951660111L;
    /**
     * 自增主键
     * 表字段 : lty_virtual_card_account_history.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_account_history.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_account_history.gmt_modified
     */
    private Date gmtModified;

    /**
     * 交易流水ID
     * 表字段 : lty_virtual_card_account_history.transaction_id
     */
    private String transactionId;

    /**
     * 用户id，对应base_user
     * 表字段 : lty_virtual_card_account_history.user_id
     */
    private Integer userId;

    /**
     * 用户名称
     * 表字段 : lty_virtual_card_account_history.user_name
     */
    private String userName;

    /**
     * 城市编码
     * 表字段 : lty_virtual_card_account_history.city_code
     */
    private String cityCode;

    /**
     * 虚拟卡号
     * 表字段 : lty_virtual_card_account_history.card_no
     */
    private String cardNo;

    /**
     * 交易金额
     * 表字段 : lty_virtual_card_account_history.amount
     */
    private BigDecimal amount;

    /**
     * 此次交易成功后 账户余额 当支付状态为0默认为0
     * 表字段 : lty_virtual_card_account_history.balance
     */
    private BigDecimal balance;

    /**
     * 操作类型（1：充值； 2:消费）
     * 表字段 : lty_virtual_card_account_history.opt_type
     */

    private String optType;
    /**
     * 支付类型（1：微信； 2：支付宝  3-虚拟卡 ）
     * 表字段 : lty_virtual_card_account_history.pay_type
     */

    private String payType;

    /**
     * 支付状态 （0-待支付  1-成功)
     * 表字段 : lty_virtual_card_account_history.pay_status
     */
    private Boolean payStatus;

    /**
     * 支付成功时间
     * 表字段 : lty_virtual_card_account_history.pay_time
     */
    private Date payTime;

    /**
     * 
     * 表字段 : lty_virtual_card_account_history.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_account_history.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_account_history.field3
     */
    private String field3;

    
    public VirtualCardAccountHistory(String transactionId, Integer userId, String userName, String cityCode,
			String cardNo, BigDecimal amount, String optType, String payType) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.userName = userName;
		this.cityCode = cityCode;
		this.cardNo = cardNo;
		this.amount = amount;
		this.optType = optType;
		this.payType = payType;
	}

    public VirtualCardAccountHistory(){
		 
	}
    
	/**
     * 获取 自增主键 字段:lty_virtual_card_account_history.id
     *
     * @return lty_virtual_card_account_history.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_account_history.id
     *
     * @param id the value for lty_virtual_card_account_history.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_account_history.gmt_create
     *
     * @return lty_virtual_card_account_history.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_account_history.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_account_history.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_account_history.gmt_modified
     *
     * @return lty_virtual_card_account_history.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_account_history.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_account_history.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 交易流水ID 字段:lty_virtual_card_account_history.transaction_id
     *
     * @return lty_virtual_card_account_history.transaction_id, 交易流水ID
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置 交易流水ID 字段:lty_virtual_card_account_history.transaction_id
     *
     * @param transactionId the value for lty_virtual_card_account_history.transaction_id, 交易流水ID
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * 获取 用户id，对应base_user 字段:lty_virtual_card_account_history.user_id
     *
     * @return lty_virtual_card_account_history.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:lty_virtual_card_account_history.user_id
     *
     * @param userId the value for lty_virtual_card_account_history.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户名称 字段:lty_virtual_card_account_history.user_name
     *
     * @return lty_virtual_card_account_history.user_name, 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名称 字段:lty_virtual_card_account_history.user_name
     *
     * @param userName the value for lty_virtual_card_account_history.user_name, 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 城市编码 字段:lty_virtual_card_account_history.city_code
     *
     * @return lty_virtual_card_account_history.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:lty_virtual_card_account_history.city_code
     *
     * @param cityCode the value for lty_virtual_card_account_history.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 虚拟卡号 字段:lty_virtual_card_account_history.card_no
     *
     * @return lty_virtual_card_account_history.card_no, 虚拟卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置 虚拟卡号 字段:lty_virtual_card_account_history.card_no
     *
     * @param cardNo the value for lty_virtual_card_account_history.card_no, 虚拟卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取 交易金额 字段:lty_virtual_card_account_history.amount
     *
     * @return lty_virtual_card_account_history.amount, 交易金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置 交易金额 字段:lty_virtual_card_account_history.amount
     *
     * @param amount the value for lty_virtual_card_account_history.amount, 交易金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取 此次交易成功后 账户余额 当支付状态为0默认为0 字段:lty_virtual_card_account_history.balance
     *
     * @return lty_virtual_card_account_history.balance, 此次交易成功后 账户余额 当支付状态为0默认为0
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置 此次交易成功后 账户余额 当支付状态为0默认为0 字段:lty_virtual_card_account_history.balance
     *
     * @param balance the value for lty_virtual_card_account_history.balance, 此次交易成功后 账户余额 当支付状态为0默认为0
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取 操作类型（1：充值； 2:消费） 字段:lty_virtual_card_account_history.opt_type
     *
     * @return lty_virtual_card_account_history.opt_type, 操作类型（1：充值； 2:消费）
     */

    public String getOptType() {
        return optType;
    }

    /**
     * 设置 操作类型（1：充值； 2:消费） 字段:lty_virtual_card_account_history.opt_type
     *
     * @param optType the value for lty_virtual_card_account_history.opt_type, 操作类型（1：充值； 2:消费）
     */

    public void setOptType(String optType) {
        this.optType = optType;
    }

    /**
     * 获取 支付类型（1：微信； 2：支付宝  3-虚拟卡 ） 字段:lty_virtual_card_account_history.pay_type
     *
     * @return lty_virtual_card_account_history.pay_type, 支付类型（1：微信； 2：支付宝  3-虚拟卡 ）
     */

    public String getPayType() {
        return payType;
    }

    /**
     * 设置 支付类型（1：微信； 2：支付宝  3-虚拟卡 ） 字段:lty_virtual_card_account_history.pay_type
     *
     * @param payType the value for lty_virtual_card_account_history.pay_type, 支付类型（1：微信； 2：支付宝  3-虚拟卡 ）
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取 支付状态 （0-待支付  1-成功) 字段:lty_virtual_card_account_history.pay_status
     *
     * @return lty_virtual_card_account_history.pay_status, 支付状态 （0-待支付  1-成功)
     */
    public Boolean getPayStatus() {
        return payStatus;
    }

    /**
     * 设置 支付状态 （0-待支付  1-成功) 字段:lty_virtual_card_account_history.pay_status
     *
     * @param payStatus the value for lty_virtual_card_account_history.pay_status, 支付状态 （0-待支付  1-成功)
     */
    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取 支付成功时间 字段:lty_virtual_card_account_history.pay_time
     *
     * @return lty_virtual_card_account_history.pay_time, 支付成功时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置 支付成功时间 字段:lty_virtual_card_account_history.pay_time
     *
     * @param payTime the value for lty_virtual_card_account_history.pay_time, 支付成功时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取  字段:lty_virtual_card_account_history.field1
     *
     * @return lty_virtual_card_account_history.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_account_history.field1
     *
     * @param field1 the value for lty_virtual_card_account_history.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account_history.field2
     *
     * @return lty_virtual_card_account_history.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_account_history.field2
     *
     * @param field2 the value for lty_virtual_card_account_history.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account_history.field3
     *
     * @return lty_virtual_card_account_history.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_account_history.field3
     *
     * @param field3 the value for lty_virtual_card_account_history.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
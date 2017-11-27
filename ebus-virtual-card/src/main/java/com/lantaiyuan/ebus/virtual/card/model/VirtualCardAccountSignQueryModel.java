package com.lantaiyuan.ebus.virtual.card.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 虚拟公交卡用户账户签名表
 * virtualCardAccountSign
 * 数据库表：lty_virtual_card_account_sign
 */
public class VirtualCardAccountSignQueryModel extends BaseModel<VirtualCardAccountSign>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : lty_virtual_card_account_sign.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_account_sign.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_account_sign.gmt_modified
     */
    private Date gmtModified;

    /**
     * 用户id，对应base_user
     * 表字段 : lty_virtual_card_account_sign.user_id
     */
    private Integer userId;

    /**
     * 虚拟卡号
     * 表字段 : lty_virtual_card_account_sign.card_no
     */
    private String cardNo;

    /**
     * 虚拟卡余额变动时对应的签名
     * 表字段 : lty_virtual_card_account_sign.sign
     */
    private String sign;

    /**
     * 
     * 表字段 : lty_virtual_card_account_sign.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_account_sign.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_account_sign.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:lty_virtual_card_account_sign.id
     *
     * @return lty_virtual_card_account_sign.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_account_sign.id
     *
     * @param id the value for lty_virtual_card_account_sign.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_account_sign.gmt_create
     *
     * @return lty_virtual_card_account_sign.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_account_sign.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_account_sign.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_account_sign.gmt_modified
     *
     * @return lty_virtual_card_account_sign.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_account_sign.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_account_sign.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 用户id，对应base_user 字段:lty_virtual_card_account_sign.user_id
     *
     * @return lty_virtual_card_account_sign.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:lty_virtual_card_account_sign.user_id
     *
     * @param userId the value for lty_virtual_card_account_sign.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 虚拟卡号 字段:lty_virtual_card_account_sign.card_no
     *
     * @return lty_virtual_card_account_sign.card_no, 虚拟卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置 虚拟卡号 字段:lty_virtual_card_account_sign.card_no
     *
     * @param cardNo the value for lty_virtual_card_account_sign.card_no, 虚拟卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取 虚拟卡余额变动时对应的签名 字段:lty_virtual_card_account_sign.sign
     *
     * @return lty_virtual_card_account_sign.sign, 虚拟卡余额变动时对应的签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置 虚拟卡余额变动时对应的签名 字段:lty_virtual_card_account_sign.sign
     *
     * @param sign the value for lty_virtual_card_account_sign.sign, 虚拟卡余额变动时对应的签名
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account_sign.field1
     *
     * @return lty_virtual_card_account_sign.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_account_sign.field1
     *
     * @param field1 the value for lty_virtual_card_account_sign.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account_sign.field2
     *
     * @return lty_virtual_card_account_sign.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_account_sign.field2
     *
     * @param field2 the value for lty_virtual_card_account_sign.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_account_sign.field3
     *
     * @return lty_virtual_card_account_sign.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_account_sign.field3
     *
     * @param field3 the value for lty_virtual_card_account_sign.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
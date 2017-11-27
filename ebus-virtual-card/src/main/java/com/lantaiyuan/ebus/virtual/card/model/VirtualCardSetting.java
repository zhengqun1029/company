package com.lantaiyuan.ebus.virtual.card.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.Model;

/**
 * 城市虚拟卡基础配置表
 * virtualCardSetting
 * 数据库表：lty_virtual_card_setting
 */
public class VirtualCardSetting extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : lty_virtual_card_setting.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : lty_virtual_card_setting.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : lty_virtual_card_setting.gmt_modified
     */
    private Date gmtModified;

    /**
     * 城市编码
     * 表字段 : lty_virtual_card_setting.city_code
     */
    private String cityCode;

    /**
     * 虚拟卡卡片使用说明
     * 表字段 : lty_virtual_card_setting.card_introduction
     */
    private String cardIntroduction;

    /**
     * 城市虚拟卡图片样式url
     * 表字段 : lty_virtual_card_setting.pics
     */
    private String pics;

    /**
     * 权限状态 （0-关闭  1-开启)
     * 表字段 : lty_virtual_card_setting.open_status
     */
    private Boolean openStatus;

    /**
     * 
     * 表字段 : lty_virtual_card_setting.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : lty_virtual_card_setting.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : lty_virtual_card_setting.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:lty_virtual_card_setting.id
     *
     * @return lty_virtual_card_setting.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:lty_virtual_card_setting.id
     *
     * @param id the value for lty_virtual_card_setting.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:lty_virtual_card_setting.gmt_create
     *
     * @return lty_virtual_card_setting.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:lty_virtual_card_setting.gmt_create
     *
     * @param gmtCreate the value for lty_virtual_card_setting.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:lty_virtual_card_setting.gmt_modified
     *
     * @return lty_virtual_card_setting.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:lty_virtual_card_setting.gmt_modified
     *
     * @param gmtModified the value for lty_virtual_card_setting.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 城市编码 字段:lty_virtual_card_setting.city_code
     *
     * @return lty_virtual_card_setting.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:lty_virtual_card_setting.city_code
     *
     * @param cityCode the value for lty_virtual_card_setting.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 虚拟卡卡片使用说明 字段:lty_virtual_card_setting.card_introduction
     *
     * @return lty_virtual_card_setting.card_introduction, 虚拟卡卡片使用说明
     */
    public String getCardIntroduction() {
        return cardIntroduction;
    }

    /**
     * 设置 虚拟卡卡片使用说明 字段:lty_virtual_card_setting.card_introduction
     *
     * @param cardIntroduction the value for lty_virtual_card_setting.card_introduction, 虚拟卡卡片使用说明
     */
    public void setCardIntroduction(String cardIntroduction) {
        this.cardIntroduction = cardIntroduction == null ? null : cardIntroduction.trim();
    }

    /**
     * 获取 城市虚拟卡图片样式url 字段:lty_virtual_card_setting.pics
     *
     * @return lty_virtual_card_setting.pics, 城市虚拟卡图片样式url
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置 城市虚拟卡图片样式url 字段:lty_virtual_card_setting.pics
     *
     * @param pics the value for lty_virtual_card_setting.pics, 城市虚拟卡图片样式url
     */
    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    /**
     * 获取 权限状态 （0-关闭  1-开启) 字段:lty_virtual_card_setting.open_status
     *
     * @return lty_virtual_card_setting.open_status, 权限状态 （0-关闭  1-开启)
     */
    public Boolean getOpenStatus() {
        return openStatus;
    }

    /**
     * 设置 权限状态 （0-关闭  1-开启) 字段:lty_virtual_card_setting.open_status
     *
     * @param openStatus the value for lty_virtual_card_setting.open_status, 权限状态 （0-关闭  1-开启)
     */
    public void setOpenStatus(Boolean openStatus) {
        this.openStatus = openStatus;
    }

    /**
     * 获取  字段:lty_virtual_card_setting.field1
     *
     * @return lty_virtual_card_setting.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:lty_virtual_card_setting.field1
     *
     * @param field1 the value for lty_virtual_card_setting.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_setting.field2
     *
     * @return lty_virtual_card_setting.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:lty_virtual_card_setting.field2
     *
     * @param field2 the value for lty_virtual_card_setting.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:lty_virtual_card_setting.field3
     *
     * @return lty_virtual_card_setting.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:lty_virtual_card_setting.field3
     *
     * @param field3 the value for lty_virtual_card_setting.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
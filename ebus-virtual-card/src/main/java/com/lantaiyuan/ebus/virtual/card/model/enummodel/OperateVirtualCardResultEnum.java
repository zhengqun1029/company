package com.lantaiyuan.ebus.virtual.card.model.enummodel;

/**
 * 城市公交卡操作结果枚举
 *
 * @author yangyang
 * @date 2017/8/8 13:52
 * @email kekecany@163.com
 */
public enum OperateVirtualCardResultEnum {

    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    ALREADY_EXIST(3, "已存在，不能再添加公交卡"),
    CANNOT_BE_REMOVED(4, "仍有用户使用中，不可删除"),
    DEFAULT(-1, "默认");

    private int val;

    private String desc;

    OperateVirtualCardResultEnum(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public int val() {
        return val;
    }

    public String desc() {
        return desc;
    }

}

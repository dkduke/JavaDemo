package com.dk.constant;

/**
 * @author: dengkun11
 * @date: 2022/09/13
 * @description: 券状态
 */
public enum CouponStatus {

    /**
     * 券发放状态
     */
    COUPON_EXPIRE(4000, "已过期", "过期"),
    COUPON_NONE(4001, "券已抢光", "券已抢光"),
    COUPON_WAIT_SEND(4002, "待发券", "待发券"),
    COUPON_SEND_FAIL(4005, "发放失败", "发放失败"),
    COUPON_HAS_SEND(4006, "发放成功", "发放成功")
    ;
    private Integer code;
    private String msg;
    private String msgDesc;

    CouponStatus(Integer code, String msg, String msgDesc) {
        this.code = code;
        this.msg = msg;
        this.msgDesc = msgDesc;
    }

    public static CouponStatus getCode(Integer status) {
        for (CouponStatus statusEnum : CouponStatus.values()) {
            if (statusEnum.getCode().equals(status)) {
                return statusEnum;
            }
        }

        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

}

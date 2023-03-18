package com.dk.constant;

import com.jd.interactive.play.annotation.CodeEnum;

/**
 * @author: dengkun11
 * @date: 2022/09/13
 * @description: 活动
 */


@CodeEnum


public enum ActivityStatusEnum {

    //活动状态
    ACT_SUCCESS(1000, "活动进行中","活动正常"),
    ACT_NOT_START(1001, "活动未开始","活动未开始"),
    ACT_END(1002,  "活动已结束","活动已结束"),
    ACT_OFFLINE(1003,  "活动已下线","活动已下线"),
    ACT_NOT_EXIST(1004,  "活动不存在","活动不存在");

    private Integer code;
    private String msg;
    private String msgDesc;

    ActivityStatusEnum(Integer code, String msg,String msgDesc){
        this.code = code;
        this.msg = msg;
        this.msgDesc = msgDesc;
    }

    public static ActivityStatusEnum getCode(Integer status) {
        for (ActivityStatusEnum statusEnum : ActivityStatusEnum.values()) {
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


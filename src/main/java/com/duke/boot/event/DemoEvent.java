package com.duke.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: dengkun11
 * @date: 2022/08/06
 * @description: 自定义事件
 */
public class DemoEvent  extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
        System.out.println(this.getClass() + "-构造方法");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

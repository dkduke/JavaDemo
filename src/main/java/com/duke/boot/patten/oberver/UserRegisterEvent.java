package com.duke.boot.patten.oberver;

import org.springframework.context.ApplicationEvent;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 创建 UserRegisterEvent 事件类，继承 ApplicationEvent 类，用户注册事件
 */
public class UserRegisterEvent extends ApplicationEvent {

    /**
     * 用户名
     */
    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}

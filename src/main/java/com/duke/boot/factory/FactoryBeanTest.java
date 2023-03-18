package com.duke.boot.factory;

import com.duke.boot.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: dengkun11
 * @date: 2023/01/05
 * @description: Bean
 */
public class FactoryBeanTest implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

package com.dk.constant.abc;

import java.io.Serializable;

/**
 * @author: dengkun11
 * @date: 2022/09/20
 * @description:
 */
public class EnumSingleObject implements Serializable {

    private static final long serialVersionUID = -6067417408438880338L;

    private EnumSingleObject() {
    }

    enum SingletonEnum {
        //
        INSTANCE;

        private EnumSingleObject instance;


        SingletonEnum() {
            instance = new EnumSingleObject();
        }

        public EnumSingleObject getInstance() {
            return INSTANCE.instance;
        }
    }

    //对外暴露一个获取EnumSingleObject对象的静态方法
    public static EnumSingleObject getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}

package com.duke.boot.patten.oberver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 创建 CouponService 类，优惠劵 Service。
 */
@Service
public class CouponService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener // <1> ，在方法上，添加 @EventListener 注解，并设置监听的事件为 UserRegisterEvent。这是另一种使用方式！
    public void addCoupon(UserRegisterEvent event) {
        logger.info("[addCoupon][给用户({}) 发放优惠劵]", event.getUsername());
    }

}

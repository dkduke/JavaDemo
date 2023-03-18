package com.duke.boot.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: dengkun11
 * @date: 2022/08/11
 * @description: 日志
 */
@Aspect
@Component
public class LogAdvice {

    /**
     * 定义一个切点：所有被GetMapping注解修饰的方法会织入advice
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut() {}

    /**
     * Before表示logAdvice将在目标方法执行前执行
     */
    @Before("logAdvicePointcut()")
    public void logAdvice() {
        System.out.println("get请求的before advice触发了");
    }

}

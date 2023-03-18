package com.duke.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: dengkun11
 * @date: 2022/08/11
 * @description:
 */
@Aspect
@Component
public class LogAspectHandler {

    private static final Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);

    @Pointcut("execution(* com.duke.boot.controller..*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("====doBefore方法进入了====");

        //获取签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String funName = signature.getName();

        logger.info("即将执行的方法为：{}, 属于{}包, 参数：{}", funName, declaringTypeName, Arrays.toString(joinPoint.getArgs()));

        // 也可以用来记录一些信息，比如获取请求的 URL 和 IP
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI().toString();
        String ip = request.getRemoteAddr();
        logger.info("请求的URL为：{}, ip地址为：{}", url, ip);
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {

        logger.info("====doAfter 方法进入了=====");

        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("方法{}已经执行完成", method);

        if (logger.isWarnEnabled()) {
            logger.warn("方法{}已经执行完成", method);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("方法{}已经执行完成", method);
        }
    }
}

package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloAspect.class);

    @Pointcut("execution(public * com.example.controller.HelloController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) {
        LOGGER.info("beforeLog");

        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        LOGGER.info("类名:{}", declaringTypeName);

        String name = joinPoint.getSignature().getName();
        LOGGER.info("方法名:{}", name);

        Object[] args = joinPoint.getArgs();
        LOGGER.info("args:{}", args);
    }

    @After("log()")
    public void afterLog() {
        LOGGER.info("afterLog");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturning(Object object) {
        LOGGER.info("response:{}", object);
    }


    // @Around("log()")
    // public void aroundLog() {
    //     LOGGER.info("around");
    // }
}

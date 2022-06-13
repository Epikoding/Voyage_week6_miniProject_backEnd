package com.tenzo.mini_project2.security;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAop {

    @Pointcut("execution(public * com.tenzo.mini_project2.security..*(..))")
    public void applicationPackagePointcut() {
    }
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing(pointcut = "applicationPackagePointcut()",throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }




}

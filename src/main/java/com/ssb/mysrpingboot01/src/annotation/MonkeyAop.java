package com.ssb.mysrpingboot01.src.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonkeyAop {

    @Pointcut("@annotation(MonkeyChao)，@a")
    public void getAnn(){

    }

    @Before("getAnn()")
    public void before(){
        System.out.println(111);
    }
    @After("getAnn()")
    public void after(){
        System.out.println(222);
    }

    @Around("getAnn()")
    public Object round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(333);
        Object proceed = proceedingJoinPoint.proceed();
        System.out.printf("444");
        return proceed;

    }
}

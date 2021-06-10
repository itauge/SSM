package com.fung.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FungAspect {
    //定義切點
    @Pointcut("execution(* com.fung.service..*.*(..))")
    public void pt(){

    }
    //進行增强
    @Before("pt()")
    public void before(){
        System.out.println("leaf01...");
    }
}

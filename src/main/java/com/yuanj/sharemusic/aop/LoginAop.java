package com.yuanj.sharemusic.aop;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


//声明切面
//@Component
@Aspect
public class LoginAop {

    LoginAop(){
        System.out.println("LoginAop");
    }


    //声明切入点
    @Pointcut("execution(* com.yuanj.sharemusic.controller..*(..))")
    public void operationLog(){
    }

    /**
     * advice在切入点匹配的方法执行之前，之后或周围运行
     */


    @Before("operationLog()")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println(joinPoint.toLongString());
        System.out.println("beforeLog");
    }

    @AfterReturning(pointcut = "operationLog()")
    public void afterLog(JoinPoint joinPoint){
        System.out.println(joinPoint.toLongString());
        System.out.println("afterLog");
    }

    @AfterThrowing(pointcut = "operationLog()")
    public void throwLog(){
        System.out.println("throwLog");
    }

    @After("operationLog()")
    public void logAfter(){
        System.out.println("logAfter");
    }

    @Around("operationLog()")
    public void around(){
        System.out.println("around");
    }
}

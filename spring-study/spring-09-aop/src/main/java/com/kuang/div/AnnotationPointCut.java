package com.kuang.div;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三：使用注解方式实现AOP
@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=====方法执行前======");
    }
}


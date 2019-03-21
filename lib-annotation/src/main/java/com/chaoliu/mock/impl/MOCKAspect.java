package com.chaoliu.mock.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * MOCK AOP注解实现
 *
 * @author chentong
 * @date 18/3/29
 */
@Aspect
public class MOCKAspect {
    private static long lastClickTime;

    @Pointcut("execution(@com.chaoliu.mock.annotation.MOCK * *(..))")

    //方法切入点
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        if (!isFastDoubleClick()) {
            return joinPoint.proceed();//执行原方法
        }
        return null;
    }

    public  boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 6000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
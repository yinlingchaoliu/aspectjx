package com.chaoliu.mock.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 防止View被连续点击,间隔时间600ms
 *
 * @author chentong
 * @date 18/3/29
 */
@Aspect
public class SingleClickAspect {
    private static long lastClickTime;

    @Pointcut("execution(@com.chaoliu.mock.annotation.SingleClick * *(..))")
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

//        View view = null;
//        for (Object arg : joinPoint.getArgs())
//            if (arg instanceof View) view = (View) arg;
//        if (view != null) {
//            Object tag = view.getTag(TIME_TAG);
//            long lastClickTime = ((tag != null) ? (long) tag : 0);
//            Log.i("SingleClickAspect", "lastClickTime:" + lastClickTime);
//            long currentTime = Calendar.getInstance().getTimeInMillis();
//            //过滤掉600毫秒内的连续点击
//            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
//                view.setTag(TIME_TAG, currentTime);
//                Log.i("SingleClickAspect", "currentTime:" + currentTime);
//                joinPoint.proceed();//执行原方法
//            }
//        }
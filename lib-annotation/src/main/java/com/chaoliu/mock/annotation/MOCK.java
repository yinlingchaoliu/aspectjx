package com.chaoliu.mock.annotation;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@Aspect
public @interface MOCK {
    String value() default "";
    boolean enable() default true;
}
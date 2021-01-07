package com.wondersgroup.nodeservice.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/1/7 16:40
 * @description: logger annotation
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}

package com.nokia.oss.primporter.orm.annotation;

import java.lang.annotation.*;

/**
 * User: j59chen
 * Date: 2016/5/24
 * Time: 22:55
 * TO-DO: class Description, need to be modified
 */
@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableProperty {
    public String value() default "";
}

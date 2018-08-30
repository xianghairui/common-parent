package com.xiang.demo.java.annotation;

import java.lang.annotation.*;

/**
 * Auther: xianghairui
 * Date: 2018/7/12 17:09
 * Description:
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节文件中存在，在运行时可以通过反射获取到
@Target({ElementType.FIELD, ElementType.METHOD}) // 定义注解的作用目标作用范围字段，枚举的常亮/方法
@Documented // 说明该注解将饱和在javadoc中
public @interface FieldMeta {

    /**
     * 是否序列号
     * @return
     */
    boolean id() default false;

    /**
     * 字段名称
     * @return
     */
    String name() default "";

    /**
     * 是否可编辑
     * @return
     */
    boolean editable() default true;

    /**
     * 是否列表中显示
     * @return
     */
    boolean summary() default  true;

    String descritpion() default "";

    /**
     * 排序字段
     * @return
     */
    int order() default 0;

}

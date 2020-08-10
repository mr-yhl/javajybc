package cn.com.mryhl.demo08_anno_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//运行有效
@Target(ElementType.METHOD)// 用在方法上
public @interface MyTest {
}

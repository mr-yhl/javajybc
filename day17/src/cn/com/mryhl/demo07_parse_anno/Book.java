package cn.com.mryhl.demo07_parse_anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 16:04
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Book {
    String name();
    int price();
    String author() default "佚名";
}

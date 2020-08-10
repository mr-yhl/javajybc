package cn.com.mryhl.demo06_meta_anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
@Retention: 用来限制注解的生命周期

如果某个注解不使用@Retention进行修饰，那么注解默认只在源代码阶段以及编译后的.class中有效，在运行时期内存中是没有的。

@Retention中有一个属性叫做value，这个属性表示被修饰的注解的声明周期。这个value属性是RetentionPolicy类型的，
RetentionPolicy是枚举类型。我们在使用@Retention这个注解时，可以给value属性赋值RetentionPolicy枚举的各个属性，
在RetentionPolicy中，每一个属性都有自己的作用
    RetentionPolicy.SOURCE：表示被修饰的注解只在源代码阶段有效，在编译后的.class文件中以及运行时内存中是没有的。
    RetentionPolicy.CLASS：表示被修饰的注解在源代码阶段以及编译后的class文件中有效，在运行时期内存中是没有的。（默认值）
    RetentionPolicy.RUNTIME：表示被修饰的注解在源代码阶段，以及编译后的class文件中，以及运行时内存中都有效
 */
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnno {
}

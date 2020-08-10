package cn.com.mryhl.demo05_meta_anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
元注解修饰注解的注解

@Target是一个元注解,作用是用来限制一个注解的使用位置。如果某个注解不使用@Target进行修饰，那么该注解可以用在类，方法，变量，构造方法等任何位置。

在@Target这个元注解中，只有一个属性叫做value,那么在给该属性威值时，可以省略属性名。value属性表示被修饰的
注解可以在哪个位置使用。

这个value属性是ElementType数组类型的，ElementType是枚举类型，枚举就是特殊的类，枚举就是特殊的类，枚举中的每一个属性都是自身的一个对象.
在给value属性赋值时，我们需要使用ElementType中的属性，每一个属性都有自己的作用.

ElementType中的每一个属性都有自己的作用。
    ElementType.TYPE，类，接口
    ElementType.FIELD, 成员变量
    ElementType.METHOD, 成员方法
    ElementType.PARAMETER, 方法参数
    ElementType.CONSTRUCTOR, 构造方法
    ElementType.LOCAL_VARIABLE, 局部变量
 */
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnno {
}

package cn.com.mryhl.demo04_anno;
/*
 注解中的特殊属性value
    如果注解中只有一个没有默认值的属性,并且这个属性叫做value,那么在给该属性赋值时,可以省略属性名
 */
public @interface Book {
    // 属性value,表示书名
    String value();
}

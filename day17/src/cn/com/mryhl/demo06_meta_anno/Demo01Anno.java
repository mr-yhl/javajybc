package cn.com.mryhl.demo06_meta_anno;
/*
    元注解
        元注解是修饰注解的注解

常见的元注解:
    @Target:用来限制注解的使用位置
    @Retention: 用来限制注解的生命周期
 */

@MyAnno
@MyAnno2
@MyAnno3
public class Demo01Anno {

    @MyAnno
    public void method(){

    }
}

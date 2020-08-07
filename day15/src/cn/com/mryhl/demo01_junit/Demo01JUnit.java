package cn.com.mryhl.demo01_junit;

import org.junit.Test;

/*
JUnit是单元测试，可以代替程序中的main方法，程序可以直接从单元测试方法直接开始执行。
如果在一个方法上加@Test这个注解，那么这个方法就是单元测试方法了，程序就可以从这个方法直接开始执行了。


单元测试方法的要求：
    1.方法一般以test开头（软性规定）
    2.方法用pubLic修饰，没有参数，没有返回值（硬性规定）

如何执行单元测试方法：
方式一：选中方法右键run
方式二：选中类，然后右键run【可以执行该类中所有的单元测试方法】
 */
public class Demo01JUnit {
    @Test
    public void testMethod(){
        System.out.println("testMethod");
    }
}

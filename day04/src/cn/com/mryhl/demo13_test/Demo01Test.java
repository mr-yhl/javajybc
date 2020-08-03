package cn.com.mryhl.demo13_test;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
模板方法模式:
    将固定 的流程定义在父类中,不同的地方使用抽象类,让子类去重写
 */
public class Demo01Test {
    public static void main(String[] args) {
        OldDriver oldDriver = new OldDriver();
        oldDriver.go();
        System.out.println("=============");
        NewDriver newDriver = new NewDriver();
        newDriver.go();
    }
}

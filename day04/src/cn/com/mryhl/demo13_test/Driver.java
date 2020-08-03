package cn.com.mryhl.demo13_test;
/*
司机类
    方法:
    开车
    驾驶
 */

public abstract class Driver {
    public void go(){
        System.out.println("开门");
        System.out.println("点火");
        //驾驶
        jiaShi();//在普通方法中可以调用抽象方法
        System.out.println("熄火");
        System.out.println("关门");
    }
    // 驾驶
    public abstract void jiaShi();

}

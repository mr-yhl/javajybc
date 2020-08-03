package cn.com.mryhl.demo01_quanxian;


import cn.com.mryhl.demo02_quanxian.MyClass;

public class MyOtherClass extends MyClass {
    //提供方法
    public void method() {
        //调用父类protected方法
        super.protectedMethod();

        //super.defaultMethod();
    }
}

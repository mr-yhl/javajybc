package cn.com.mryhl.demo01_static;

public class MyClass {
    int normalNum = 10;
    static int staticNum = 20;

    public void normalMethod(){
        System.out.println("非静态方法");
        System.out.println(normalNum);
        System.out.println(staticNum);


    }
    public static void staticMethod(){
        System.out.println("静态方法");
        //System.out.println(normalNum);
        System.out.println(staticNum);
    }
}

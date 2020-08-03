package cn.com.mryhl.demo09_duotai;
/*
接口多态(特殊的父类)
接口多态格式(接口类型指向实现类对象)
    接口类型 变量名 = new 实现类类型();
 */
public class Demo02Test {
    public static void main(String[] args) {
        Flyable f = new Bird();
        //调用方法
        f.fly();
    }
}

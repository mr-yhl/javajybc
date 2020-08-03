package cn.com.mryhl_copy_ex.demo01_static;
// 定义学生类
public class Student {
    // 姓名
    String name;
    // 年龄
    int age;
    // 静态属性[静态属性属于类,可以类名调用,也可以对象调用]
    static String school;
    public static void method(){
        // 静态方法中不能使用this 和 super关键字
        //this();
        //super();
    }
}

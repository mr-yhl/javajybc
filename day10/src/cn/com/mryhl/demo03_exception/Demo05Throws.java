package cn.com.mryhl.demo03_exception;

import java.io.IOException;
import java.sql.SQLException;

/*
throw:用来手动向外抛出异常
throws:用来进行异常声明，声明某个方法有可能出现异常，出现问题。


throws格式:
    修饰符 返回值类型方法名（参数列表）throws 异常类名{
    ...
    }
throws注意事项：
    1.如果在方法中抛出了编译时异常，那么必须要使用throws进行异常声明。
    2.如果调用了使用throws声明异常的方法，那么调用者要么使用try...catch解决，要么也要加throws声明。
    3.如果在方法中抛出了运行时异常，那么可以加throws声明，也可以不加
    4.如果方法中有可能推出多个异常，那么需要进行多异常的声明
    5.如果方法中有可能能出多个异常，那么也可以直接声明他们的父类异常

*/
public class Demo05Throws {
    public static void main(String[] args) throws Exception {
        method();
    }
    // 抛出多异常声明
    public static void method4() throws Exception {
        int num = 10;
        if (num%2==0)
            throw new IOException();
        else
            throw new SQLException();
    }
    // 抛出多异常声明
    public static void method2() throws IOException, SQLException {
        int num = 10;
        if (num%2==0)
            throw new IOException();
        else
            throw new SQLException();
    }
    // 运行时异常
    public static void method1(){
        throw new RuntimeException();
    }
    // 编译异常
    public static void method() throws Exception{
        // 抛异常
        throw new Exception();
    }
}

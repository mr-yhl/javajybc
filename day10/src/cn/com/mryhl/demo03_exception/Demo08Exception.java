package cn.com.mryhl.demo03_exception;

import java.io.IOException;

/*
    编译时异常和运行时异常的区别
编译时异常：在程序编译时期必须要处理，要么try...catch,要么throws
运行时异常：在程序运行时期，可以处理，也可以不处理。

 */
public class Demo08Exception {
    public static void main(String[] args) {
        method2();
    }
    // 运行时异常
    public static void method2(){
        throw new RuntimeException();
    }
    /*
    Exception in thread "main" java.lang.RuntimeException
	at cn.com.mryhl.demo03_exception.Demo08Exception.method2(Demo08Exception.java:17)
	at cn.com.mryhl.demo03_exception.Demo08Exception.main(Demo08Exception.java:13)
     */

    // 编译时异常
    public static void method() throws IOException {
        throw new IOException();
    }
}

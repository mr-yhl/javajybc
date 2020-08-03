package cn.com.mryhl.demo05_thread;
/*
每一个程序都至少包含一个线程，我们写的Java程序也一样。
当我们运行程序时，JVM会创建一个main线程，并执行main方法。

在程序中只有一个执行线程main线程，该程序是单线程程序。
单线程程序同时只能做一件事情，如果想要同时做多件事情，只能向执行一个在执行另一个.

如果想要同时做多件事情，需要使用多线程。
 */
public class Demo01MainThread {
    public static void main(String[] args) {
        System.out.println("main....start");
        //
        for (int i = 0; i < 100; i++) {
            System.out.println("hello world");
        }
        //
        for (int i = 0; i < 100; i++) {
            System.out.println("hello Java");
        }
        //结束
        System.out.println("main....end");
    }
}

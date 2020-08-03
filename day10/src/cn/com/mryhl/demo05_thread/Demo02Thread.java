package cn.com.mryhl.demo05_thread;
/*
Java中Thread表示线程，我们可以使用Thread类完成多线程的程序。

多线程的第一种实现方法
    1.定义一个类，继承Thread类
    2.在子类中重写run方法，并在run方法中定义线程要执行的任务。
    3.创建Thread子类对象
    4.通过Thread子类对象调用start方法，启动线程。

    Thread中的start方法
void start():让线程执行，线程会执行自己的run方法。
 */
public class Demo02Thread {
    public static void main(String[] args) {
        System.out.println("main....start");
        // 创建Thread子类对象
        // 创建一个新的线程
        MyThread myThread = new MyThread();
        // 调用start方法,启动线程
        // 线程启动,自动调用run方法
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("hello Java");
        }

    }
}

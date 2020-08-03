package cn.com.mryhl.demo13_semaphore;

import java.util.concurrent.Semaphore;

/*
Semaphore 可以控制某段代码有几个线程执行。
构造方法：
    Semaphore(int permits);参数表示允许几个线程执行代码。
Semaphore其他方法：
    public void acquire(): 表示获取许可 【获取锁】
    public void release(): 释放凭证【释放锁】

*/
public class Demo01Test {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        /*
        Thread-1进来了
        Thread-1出去了
        Thread-2进来了
        Thread-2出去了
        Thread-4进来了
        Thread-4出去了
        Thread-3进来了
        Thread-3出去了
        Thread-0进来了
        Thread-0出去了
        Thread-5进来了
        Thread-5出去了
        */
    }
}

package cn.com.mryhl.demo05_thread;
/*

Thread表示线程类，当使用MyThread继承Thread时，MyThread也就变成了线程类。

 */
public class MyThread extends Thread {
    // 重写Thread的run方法
    @Override
    public void run() {
       // 输出100次helloworld
        for (int i = 0; i < 100; i++) {
            System.out.println("hello world");
        }
    }
}

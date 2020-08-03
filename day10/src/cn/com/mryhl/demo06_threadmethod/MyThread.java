package cn.com.mryhl.demo06_threadmethod;
/*

Thread表示线程类，当使用MyThread继承Thread时，MyThread也就变成了线程类。

 */
public class MyThread extends Thread {


    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    // 重写Thread的run方法
    @Override
    public void run() {
        System.out.println(getName()+":线程执行了");

    }
}

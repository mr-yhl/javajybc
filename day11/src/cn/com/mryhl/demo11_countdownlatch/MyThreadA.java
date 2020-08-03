package cn.com.mryhl.demo11_countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyThreadA extends Thread {
    // 定义CountDownLatch
    CountDownLatch c;
    // 提供一个构造方法,接收外界的CountDownLatch
    public MyThreadA(){

    }
    public MyThreadA(CountDownLatch c){
        this.c=c;
    }
    @Override
    public void run() {
        try {
            System.out.println("A");
            c.await();
            System.out.println("C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

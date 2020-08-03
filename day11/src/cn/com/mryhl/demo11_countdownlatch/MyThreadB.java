package cn.com.mryhl.demo11_countdownlatch;


import java.util.concurrent.CountDownLatch;

public class MyThreadB extends Thread {
    CountDownLatch c;
    // 提供一个构造方法,接收外界的CountDownLatch
    public MyThreadB(){

    }
    public MyThreadB(CountDownLatch c){
        this.c=c;
    }
    @Override
    public void run() {
        System.out.println("B");
        //System.out.println("D");

        c.countDown();

    }
}

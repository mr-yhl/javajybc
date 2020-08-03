package cn.com.mryhl.demo14_exchanger;

import java.util.concurrent.Exchanger;

public class MyThreadA extends Thread {
    // 定义Exchanger
    Exchanger<String> e;

    public MyThreadA(Exchanger<String> e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程A等待来自线程B的礼物");
            System.out.println("线程A送出了自己的礼物,并受到线程B的礼物:"+e.exchange("礼物A"));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

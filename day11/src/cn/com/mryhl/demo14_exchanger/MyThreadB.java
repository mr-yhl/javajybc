package cn.com.mryhl.demo14_exchanger;

import java.util.concurrent.Exchanger;

public class MyThreadB extends Thread {
    // 定义Exchanger
    Exchanger<String> e;

    public MyThreadB(Exchanger<String> e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程B等待来自线程A的礼物");
            System.out.println("线程B送出了自己的礼物,并受到线程A的礼物:"+e.exchange("礼物B"));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

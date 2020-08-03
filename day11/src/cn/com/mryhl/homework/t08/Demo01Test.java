package cn.com.mryhl.homework.t08;

import java.util.concurrent.Exchanger;

/*线程A给线程B：一条娱乐新闻

线程B给线程A：一条体育新闻*/
public class Demo01Test {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"收到了：" + exchanger.exchange("一条娱乐新闻"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"收到了：" + exchanger.exchange("一条体育新闻"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

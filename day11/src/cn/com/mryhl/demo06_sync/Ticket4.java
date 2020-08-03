package cn.com.mryhl.demo06_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
如果多线程同时操作共享数据，就有可能会引发线程安全问题。

 */
@SuppressWarnings("all")
public class Ticket4 implements Runnable {

    int count = 100;
    // 创建lock对象
    Lock l=new ReentrantLock();

    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
           l.lock();

            if (count > 0) {
                // 套身份证用5毫秒
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + count + "张票.");
                count--;
            }
           l.unlock();
        }

    }
}

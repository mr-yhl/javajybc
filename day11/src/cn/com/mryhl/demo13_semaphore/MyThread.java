package cn.com.mryhl.demo13_semaphore;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
    // 定义Semaphore
    Semaphore s;
    // 构造方法,接收外界的Semaphore对象
    public MyThread(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            System.out.println(Thread.currentThread().getName() + "进来了");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "出去了");
            s.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

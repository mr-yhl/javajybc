package cn.com.mryhl.demo12_cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class PersonThread extends Thread {
    // 定义CyclicBarrier
    CyclicBarrier c;

    // 定义构造方法
    public PersonThread() {
    }

    public PersonThread(CyclicBarrier c) {
        this.c = c;
    }
    // 线程执行任务,让员工休眠随机毫秒值,然后到办公室
    @Override
    public void run() {
        try {
            // 产生随机数
            int randomTime = new Random().nextInt(3000);
            // 线程休眠
            Thread.sleep(randomTime);
            // 模拟到办公室
            System.out.println(Thread.currentThread().getName() + "来到办公室");
            // 让线程等待,直到所有人到达才能开会
            c.await();//线程等待,并通知到达同步点


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

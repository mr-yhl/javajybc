package cn.com.mryhl.demo05_atomic;


import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
    AtomicInteger num=new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int count = num.incrementAndGet();

            System.out.println("count = " + count);
        }
    }
}

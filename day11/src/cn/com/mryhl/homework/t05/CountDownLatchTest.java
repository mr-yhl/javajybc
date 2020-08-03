package cn.com.mryhl.homework.t05;
/*
线程A打印：”开始计算”

线程B：计算1--100所有数的累加和，并打印结果。

线程A打印：”计算完毕”

*/

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("开始计算");
                    countDownLatch.await();
                    System.out.println("计算完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                System.out.println("1-100的累加和为:" + sum);
                countDownLatch.countDown();
            }
        }.start();

    }
}

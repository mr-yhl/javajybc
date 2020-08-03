package cn.com.mryhl.demo01_thread_pool;

public class Task implements Runnable {
    // 定义线程任务
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "再输出hello world:" + i);
        }
    }
}

package cn.com.mryhl.demo06_sync;

/*
如果多线程同时操作共享数据，就有可能会引发线程安全问题。

 */
@SuppressWarnings("all")
public class Ticket2 implements Runnable {
    // 定义变量，表示票数
    int count = 100;
    // 创建对象,表示锁,可以是任何类型.
    // 多线程使用统一代码块,必须使用同一个锁
    Object lock = new Object();

    // 使用多线程卖票,定义卖票任务
    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
            // 判断是否有票,有就卖

            // 当线程执行到同步代码块时，会看一下同步代码块上面还有没有锁
            // 如果同步代码块上面还有锁，此时线程会获取到锁，然后进入到同步代码块中
            // 如果同步代码块上面没有锁，那么此时线程会一直在这里等着获取锁。
            synchronized (lock) {
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
            }
            // 如果线程离开同步代码块，线程会释放自己的锁【把锁还回去】
        }

    }
}

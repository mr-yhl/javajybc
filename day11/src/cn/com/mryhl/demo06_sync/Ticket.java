package cn.com.mryhl.demo06_sync;

public class Ticket implements Runnable {
    // 定义变量，表示票数
    int count = 100;

    // 使用多线程卖票,定义卖票任务
    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
            // 判断是否有票,有就卖
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

    }
}

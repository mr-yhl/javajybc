package cn.com.mryhl.demo06_sync;

/*

 */
@SuppressWarnings("all")
public class Ticket3 implements Runnable {
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
           sell2();

        }

    }
    /*
     定义一个方法,用于卖票
    如果某个方法的所有方法体都加了同步代码块，我们也可以使用不同方法。
    */
    public  void sell(){
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
    }
    /*
        定义方法，使用同步方法。
        同步方法相当于把整个方法体都加了同步代码块[锁对象是this]
     */
    public synchronized void sell2(){
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

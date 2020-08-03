package cn.com.mryhl.demo05_wait_notify;
// 吃货
public class ChiHuo extends Thread {
    private BaoZi baoZi;

    public ChiHuo(BaoZi baoZi) {

        this.baoZi = baoZi;
    }
    // 定义线程要执行的任务
    // 对于本类来说,任务就是chibaoz,等着包子铺蒸包子
    @Override
    public void run() {
        // 一直吃,用死循环
        while (true){
            // 吃货和包子铺操作的是同一个包子
            synchronized (baoZi){
                // 如果没有包子,吃货要等着生产包子
                if (!baoZi.flag){
                    // 调用wait方法等待
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果有包子,要吃包子
                System.out.println("吃了一个包子");
                // 更改标记
                baoZi.flag=false;
                // 叫醒包子铺进程
                baoZi.notify();

            }
        }
    }
}

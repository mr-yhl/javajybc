package cn.com.mryhl.demo05_wait_notify;
// 包子铺
public class BaoZiPu extends Thread {
    //铺要使用包子，包子铺使用的包子要和吃货使用的包子是同一个。所以定义Baozi类型的变量，然后通过构造方法的方式传递进来包子对象
    private BaoZi baozi;
    // 定义构造方法,接收传递进来的包子,把他赋值给baozi
    public BaoZiPu(BaoZi baozi) {
        this.baozi = baozi;
    }
    // 定义线程任务
    // 对于包子普来说,任务一直生成包子,等着吃货吃
    @Override
    public void run() {
        // 死循环代表一直生产包子
        while (true){
            // 包子铺和吃货都有操作包子,使用线程同步保证线程安全
            // 包子是唯一的,所以用作锁
            synchronized (baozi){
                // 如果有包子,等着吃货吃包子
                if (baozi.flag){
                    // 等待[wait方法通过锁调用]
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果没有包子,包子铺就要生成包子
                System.out.println("生产一个大包子");
                // 更改标记
                baozi.flag=true;
                // 叫醒吃货进程,执行吃包子任务
                baozi.notify();
            }
        }
    }
}

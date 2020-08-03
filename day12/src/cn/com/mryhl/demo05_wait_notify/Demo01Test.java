package cn.com.mryhl.demo05_wait_notify;
/*
在object中，有两种方法可以让线程等待以及喷醒线程。
    void wait():让线程等待，直到有其他线程唤醒他。
    void wait(long timeout):让线程等待，直到有其他线程唤醒他，或者时间到了也会自己醒。
    void notify():唤醒一个等待的线程
    void notifyALL():唤醒所有等待的线程。
    wait方法用于等待，notify方法用于唤醒，他们一起使用，一般叫做等待唤醒机制，一般用于线程间的通信。

    wait notify 是object中的方法
    wait notify（同步代码块或同步方法）,通过锁对象去调用。

    通过哪个锁调用的notify,那么唤醒的就是通过哪个锁调用的wait等待的进程
    当线程调用wait方法后会等待,并且释放自己的锁.
    wait:会释放自己的锁; sleep:不会释放锁.
 */
public class Demo01Test {
    public static void main(String[] args) {
       // 创建包子
        BaoZi baoZi = new BaoZi();
        // 创建包子铺和吃货线程
        new BaoZiPu(baoZi).start();
        new ChiHuo(baoZi).start();
    }
}

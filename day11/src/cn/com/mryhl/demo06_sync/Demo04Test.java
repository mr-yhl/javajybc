package cn.com.mryhl.demo06_sync;
/*

在JDK5的时候，提供了Lock接口，里面有手动锁和释放锁的方法
    void lock():获取锁
    void unlock():释放锁

lock是一个接口，接口不能直接去使用，如果要用，需要使用实现类，常用的是ReentrantLock
 */

public class Demo04Test {
    public static void main(String[] args) {
        Ticket4 ticket4 = new Ticket4();

        new Thread(ticket4).start();
        new Thread(ticket4).start();
        new Thread(ticket4).start();
    }
}

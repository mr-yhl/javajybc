package cn.com.mryhl.demo06_sync;
/*
使用synchronized解决线程安全问题【多行代码原子性的问题】
synchronized表示同步，可以修饰方法，也可以修饰代码块
如果synchronized修饰代码块，就叫做同步代码块。

同步代码块格式：
    synchronized(锁对象){
    ...
    }
锁对象就是一个普通的Java对象，镜对象可以是任何类型的，可以是student,ArrayList,object..
锁对象仅仅起到一个标记作用，除此之外,没有任何含义
同步代码块的作用：
    只有持有锁的线程才能够进入到同步代码块中。
    【多行代码如果加了同步代码块，那么只有一个线程能执行了，不允许被其他线程插队执行，就保证了多行代码的原子性】


线程同步会保证安全，但是会牺牲效率，
 */
public class Demo02Test {
    public static void main(String[] args) {
        // 创建Runnable实现类对象
        Ticket2 ticket2 = new Ticket2();
        // 三个线程卖票
        new Thread(ticket2).start();
        new Thread(ticket2).start();
        new Thread(ticket2).start();
    }
}

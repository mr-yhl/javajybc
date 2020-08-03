package cn.com.mryhl.demo11_countdownlatch;
/*

CountDownLatch允许一个或多个线程等待其他线程完成操作。
例如：线程1要执行打印：A和C，线程2要执行打印：B，但线程1在打印A后，
要线程2打印B之后才能打印C，所以：线程1在打印A后，必须等待线程2打印完B之后才能继续执行。

CountDownLatch构造方法:
    public CountDownLatch(int count):参数counr表示计数器

CountDownLatch重要方法:
    public void await(): 让当前线程等待 ,如果计算器变成0那么计数器向下执行
    public void countDown(): 计数器进行减1
 */


import java.util.concurrent.CountDownLatch;

public class Demo01Test {
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(1);
        new MyThreadA(c).start();

        new MyThreadB(c).start();
    }
}

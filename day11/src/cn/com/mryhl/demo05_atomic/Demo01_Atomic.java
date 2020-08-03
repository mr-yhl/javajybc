package cn.com.mryhl.demo05_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/*
AtomicInteger是整数原子类，里面支持原子性操作

举例：AtomicInteger进行自增操作，里面的自增操作是一个整体，这个整体不会被插队执行。

AtomicInteger构造方法：
    AtomicInteger():使用空参数构造方法创建的对象表示整数
    AtomicInteger(int initialvalue):根据指定的整数创速AtomicInteger对象。
AtomicInteger其他方法：
    int getAndIncrement():先获取当前值，然后自增。返回的是自增前的值。 相当于 int a = i++;
    int incrementAndGet():先自增，然后获取自增后的值。返回的是自增后的值。相当于 int a = ++i;
    int get(): 获取 AtomicInteger对象的int数字
 */
public class Demo01_Atomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        // System.out.println(atomicInteger);// 10
        /*
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println("andIncrement"+andIncrement);// andIncrement10
        System.out.println("atomicInteger"+atomicInteger);// atomicInteger11
        */
        int incrementAndGet = atomicInteger.incrementAndGet();
        System.out.println("incrementAndGet"+incrementAndGet);// incrementAndGet11
        System.out.println("atomicInteger"+atomicInteger);// atomicInteger11

        int i = atomicInteger.get();
        System.out.println(i);// 11
    }
}

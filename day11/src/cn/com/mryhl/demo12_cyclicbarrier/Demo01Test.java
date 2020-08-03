package cn.com.mryhl.demo12_cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/*
CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
它要做的事情是，让一组线程到达一个屏障 （也可以叫同步点）时被阻塞，
直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。

例如：公司召集5名员工开会，等5名员工都到了，会议开始。

创建5给员工线程,一个会议的线程任务,使用CyclicBarrier保证5名员工都到了,再开始开会.
CyclicBarrier构造方法：
    public CyclicBarrier(int count, Runnable barrierAction):当count个线程到达同步点时,会执行barrierAction任务
CyclicBarrier其他方法：
    public int await():让线程等待,会通知CyclicBarrier到达了同步点[屏障]



 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建会议对象
        Meeting meeting = new Meeting();
        // 创建CyclicBarrier对象,并指定5给线程到达同步点
        CyclicBarrier c = new CyclicBarrier(5, meeting);
        // 创建CyclicBarrier对象

        new PersonThread(c).start();
        new PersonThread(c).start();
        new PersonThread(c).start();
        new PersonThread(c).start();
        new PersonThread(c).start();
        /*
        Thread-1来到办公室
        Thread-3来到办公室
        Thread-2来到办公室
        Thread-4来到办公室
        Thread-0来到办公室
        人都到了.开始开会
         */

    }
}

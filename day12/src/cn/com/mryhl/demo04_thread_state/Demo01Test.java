package cn.com.mryhl.demo04_thread_state;
/*
线程的六种状态
    新建（NEW):刚刚创建出来并没有调用start方法启动的线程处于新建状态。
    运行（RUNNABLE):线程调用start方法会处于运行的状态。
    受阻塞（BLOCKED):等待获取锁的线程处于受阻塞的状态。
    无限等待（WAITING):当线程调用wait()方法后，处于无限等待状态【没有时间的等待，别人不叫我，我就一直等】
    计时等待（TIMED_WAITING):当线程调用sleep(毫秒）,wait(毫秒值）会进入到计时等待【有时间的等待，到了时间别人不叫我，我也会醒】
    退出（TERMINATED):如果线程执行完了run方法，或者线程调用了stop方法
 */
public class Demo01Test {
    public static void main(String[] args) {

    }
}

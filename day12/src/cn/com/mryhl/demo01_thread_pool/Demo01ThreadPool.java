package cn.com.mryhl.demo01_thread_pool;
/*
线程池就是一个容器，里面有很多线程，里面的每一个线程都可以去多次执行任务。

线程池相关API
    Executor:接口，该接收是线程池的根接口。这个接口中提供了提交线程任务的方法。
    ExecutorService：是Executor的子接口，也表示线程池。里面除了提供了执行线程任务的方法，还提供了管理线程池的方法
    Executors：线程的工具类。里面提供获取线程池的方法。

注意：线程池不是我们自己创建的。而是通过Execcutors进行获取的。

Executors获取线程池的方法：
    static ExecutorService newFixedThreadpool(int nThreads):创建一个定长的线程池，参数表示线程池的长度。

 ExecutorService表示线程池，里面有一些方法。
    submit(Runnable task):提交线程任务并执行.
    shutdown():销毁线程池.

线程池的使用步骤：
1.调用Executors的newFixedThreadPooL方法获取线程池。
2.定义一个Runnable实现类，表示线程任务
3.通过线程池调用submit,传递Runnable接口的实现类对象，执行线程任务。
4.销毁线程池(一般不做,频繁创建销毁对性能影响更大)

线程池创建的线程索引从1开始
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01ThreadPool {
    public static void main(String[] args) {
        // 调用Executors的newFixedThreadPooL方法获取线程池。
        // 长度为2
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // 定义一个Runnable实现类，表示线程任务
        Task task = new Task();
        // 通过线程池调用submit,传递Runnable接口的实现类对象，执行线程任务。
        threadPool.submit(task);
        threadPool.submit(task);
        threadPool.submit(task);//等线程空闲出来再执行

        // 销毁线程池(一般不做，频繁的创建销毁对性能影响大)
        threadPool.shutdown();


    }
}

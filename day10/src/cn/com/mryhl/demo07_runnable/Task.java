package cn.com.mryhl.demo07_runnable;
/*
在java中,Thread类才是线程类.
Task和Thread没有关系，所以Task并不是线程类

Runnable接口中只有一个run方法，run方法中只需要关注线程要执行的任务。Runnable接口只需要关注线程任务即可。
我们也可以把Runnable接口看成线程任务接口
Task实现了Runnable接口，只需要重写run方法，只需要在里面关注线程任务，所以我们可以把Task看成线程任务类。
 */
public class Task implements Runnable {
    // 在run方法中定义线程要执行的任务
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("新线程输出hello Java"+i);
        }
    }
}

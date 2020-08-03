package cn.com.mryhl.demo02_callable;
/*

多线程的第三种实现方式【实现CaLLabLe接口的方式（了解）】
步骤：
    1.定义类，然后实现CaLLable接口。
    2.重写Callable接口中的caLL方法，在caLL方法中定义线程要执行的任务
    3.获取一个线程池【该方式完成多线程必须要有线程池】
    4.调用线程池的submit方法，传递CaLLabLe接口的实现类对象，执行线程任务。
    5.处理结果
线程池的submit方法:
    Future submit(Callable task):提交线程任务。返回值Future类型，表示将来线程运行后产出的结果。
Future里面封装了线程执行后的结果：
    V get():获取线程执行结果[如果线程没有执行结束,get方法就会等着线程执行完毕]



 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo01Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 获取一个线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // 调用线程池的submit方法，传递CaLLabLe接口的实现类对象，执行线程任务。
        Future<String> future = threadPool.submit(new CallableImpl());
        // 调用get方法获取返回值
        String s = future.get();
        System.out.println(s);


    }
}

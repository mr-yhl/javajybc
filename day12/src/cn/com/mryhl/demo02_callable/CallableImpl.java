package cn.com.mryhl.demo02_callable;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
    // call方法中定义线程要执行的任务，该方法的返回值就是线程执行后产出的结果。
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("helloworld");
        }
        return "执行完成";
    }
}

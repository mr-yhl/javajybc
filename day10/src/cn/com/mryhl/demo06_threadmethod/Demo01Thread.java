package cn.com.mryhl.demo06_threadmethod;
/*
Thread里的常见的方法
    Thread(): 空参数的构造方法
    Thread(String name):参数可以传递字符申类型的线程名

Thread中的其他方法
    String getName():获取线程名字
    void setName(String name):设置线程名字
    (记住)static Thread currentThread():获取正在执行的线程对象。
    (记住)static void sleep(Long millis):线程休眠，参数是要休眠的喜秒值。


 */
public class Demo01Thread {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread m = new MyThread();
        // 调用方法给线程设置名字
        m.setName("何塞荡");
        //  Thread(String name):参数可以传递字符申类型的线程名
        MyThread m1 = new MyThread("舒嘏");
        m1.start();
        // 线程启动
        m.start();
        // 获取main线程的名字并输出
        // 1.获取当前正在执行的线程对象[该方法通过哪个线程调用执行的,那么获取到的就是哪个线程]
        // 因为下面代码是有main线程调用的,获取到的就是main线程对象.
        Thread t = Thread.currentThread();

        System.out.println("获取的是:"+t.getName());

       /* new MyThread().start();
        new MyThread().start();
        new MyThread().start();*/
        /*
        Thread-0:线程执行了
        Thread-2:线程执行了
        Thread-1:线程执行了
        Thread-3:线程执行了
         */
    }
}

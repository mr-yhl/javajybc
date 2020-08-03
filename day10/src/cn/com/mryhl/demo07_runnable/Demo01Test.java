package cn.com.mryhl.demo07_runnable;
/*
多线程的第二种实现方式
    1.定义类实现Runnable接口
    2.重写run方法，在run方法中定义线程要执行的任务。
    3.创建Runnable接口的实现类对象
    4.创建Thread线程对象，将RunnabLe接口的实现类对象作为参数传递。
    5.通过线程调用start方法，启动

多线程有两种实现方式
    1.继承Thread类
    2.实现Runnable接口
推荐第二种：
    1.可以解决类与类之间单继示的局限性。
    2.可以降低码合性（关联性）

 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        // 创建一个线程任务对象,表示要执行的方法
        Task task = new Task();
        // 创建线程对象
        Thread thread = new Thread(task);// 将创建的线程与线程对象绑定
        // 线程启动
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程在输出hello Java"+i);
        }
    }
}

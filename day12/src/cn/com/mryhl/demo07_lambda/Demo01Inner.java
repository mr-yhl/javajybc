package cn.com.mryhl.demo07_lambda;
/*
匿名内部类中有很多代码是冗余的
匿名内部类完成多线程的案例中
因为Thread构造方法中需要传递Runnable接口的实现类对象，所以不得不写了new Runnable
因为置名内部类中需要重写方法，重写方法时要求方法的声明部分一模一样，所以不得不写了public void run

整个匿名内部类中最重要的是方法的参数,方法体,返回值.
匿名内部类很多东西都是多余的，所以我们最好的情况就是只关注参数，方法体，返回值这三个关键字。
如果使用Lambda表达式，可以关注最核心的内容（参数，方法体，返回值）,解决了匿名内部类的元余。
lambda是匿名内部类的简化写法.

lambda表达式使用的是函数式编程思想
面向对象思想：怎么
函数式编程思想：做什么
*/
public class Demo01Inner {
    public static void main(String[] args) {
        // 使用匿名内部类的方法创建多线程

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        }).start();
        // lambda表达式初体验
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了");
        }).start();
    }
}

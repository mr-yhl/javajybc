package cn.com.mryhl.demo07_lambda;
/*
Lambda表达式的使用前提
    1. 必须要有接口（不能是抽象类），接口中有且仅有一个需要被重写的抽象方法。（比如Runnable或Comparator）
    2. 必须支持上下文推导。 要能够推导出来Lambda表达式表示的是哪个接口中的哪个方法。
       最常用的上下文推导的方式是使用函数式接口当做方法参数，然后传递Lambda表达式。


注意：
    如果一个接口中有且仅有一个需要被重写的抽象方法，那么该接口也叫做函数式接口。



 */

public class Demo05BeforLambda {
    public static void main(String[] args) {
        //() -> System.out.println(Thread.currentThread().getName() + "执行了");

        //因为Thread构造方法需要传递Runnable接口类型的参数，而Runnable接口中只有一个需要被重写的抽象方法叫做run
        //所以向Thread构造方法位置传递的Lambda表示必然表示Runnable接口中的run方法。
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "执行了")).start();
    }
}

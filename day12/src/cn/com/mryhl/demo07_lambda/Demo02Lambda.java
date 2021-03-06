package cn.com.mryhl.demo07_lambda;
/*
匿名内部类格式:
    new 父类或接口(){
        重写方法
    }
匿名内部类有很多东西是元余的，整个匿名内部类中最核心的东西是方法的参数，方法体，以及方法的返回值。
最好的情况是关注方法的参数，方法体，以及方法的返回值这三点。
如果使用Lambda表达式只需要关注方法参数，方法体，以及返回值。
Lambda标准格式：
        (参数类型 参数名) -> {
            方法体;
            return 返回值;
        }
    格式解释：
        1. 小括号中的参数和之前传统方法参数写法一样，如果有多个参数，使用逗号隔开。
        2. ->是一个运算符，表示指向性动作。
        3. 大括号中的内容之前传统方法大括号中的内容写法一样的。

Lambda表达式可以省去面向对象中的条条框框，让我们只关注最核心的内容。
Lambda表达式是函数式编程思想，函数式编程思想中，可推导，就是可省略。

因为在Thread的构造方法中需要传递Runnable接口类型的参数，所以可以省略new Runnable。
因为Runnable中只有一个抽象方法叫做run，所以在重写该方法时可以省略public void run
 */
public class Demo02Lambda {
    public static void main(String[] args) {
        // 使用匿名内部类的方法创建多线程

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        }).start();

        // 使用lambda标准格式完成多线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "执行了");
        }).start();
    }
}

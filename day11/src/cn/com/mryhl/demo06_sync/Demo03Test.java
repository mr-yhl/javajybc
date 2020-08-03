package cn.com.mryhl.demo06_sync;
/*
如果synchronized修饰方法，那么这个方法叫做同步方法，也可以解决线程安全问题
格式：
    修饰符 synchronized 返回值类型 方法名（参数列表）{
    ...
    }

同步方法其实相当于把整个方法体都加了同步代码块

同步方法也是有锁的
    如果同步方法是非静态的,同步方法的锁对象是this,this就是创建的对象
    如果同步方法是静态的,锁对象是类名.class[当前类的字节码文件对象]

两种同步方式
    1.同步代码块
    2.同步方法
同步代码块：
    优点，使用起来比较灵活
    缺点：语法不如同步方法简洁
同步方法：
    优点:语法简洁
    缺点：使用起来不如同步代码块灵活。
*/
public class Demo03Test {
    public static void main(String[] args) {
        Ticket3 ticket3 = new Ticket3();

        new Thread(ticket3).start();
        new Thread(ticket3).start();
        new Thread(ticket3).start();
    }
}

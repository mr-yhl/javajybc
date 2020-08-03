package cn.com.mryhl.demo08_noname;
/*
    匿名内部类实现多线程

    匿名内部类格式:
        new 父类或接口(){
            重写方法
        }
作用：
    创建某个类（接口）的子类（实现类）对象
举例：
    new Person(){
    重写的防法
    }
创建了一个Person的子类对象，但是这个子类叫什么我们不知道。

 */
public class Demo01Test {
    public static void main(String[] args) {
        /*// 创建Runnable接口的实现类
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "匿名内部类执行了");
            }
        };
        // 创建线程,传递Runnable接口的实现类,并启动线程
        new Thread(r).start();
*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "匿名内部类执行了");
            }
        }).start();*/
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "匿名内部类执行了")).start();
    }
}

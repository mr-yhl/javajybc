package cn.com.mryhl.demo04_volatile;
/*
volatile可以保证多线程中的可见性的问题
volatile修饰的成员变量，该变量每次修改后，对于其他变量是可见的。
volatile修饰的成员变量，每次线程在操作时，都会从主内存中读取数据。
 */
public class MyTheard extends Thread{
    // 成员位置定义变量
    volatile boolean flag = false;
    @Override
    public void run() {
        try {
            // 让程序休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 将flag改成true
        flag = true;
        System.out.println("flag已经改为" + flag);
    }
}

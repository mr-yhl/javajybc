package cn.com.mryhl.demo02_kejian;

public class MyTheard extends Thread{
    // 成员位置定义变量
    boolean flag = false;
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

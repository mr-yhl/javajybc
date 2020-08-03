package cn.com.mryhl.demo01_thread;

public class MyTheard extends Thread  {
    @Override
    public void run() {
        // 百次输出
        for (int i = 0; i < 100; i++) {
            System.out.println("helloworld" + i);
        }
    }
}

package cn.com.mryhl.demo01_thread;

public class Demo01Test {
    public static void main(String[] args) {
        // 创建MyThread对象
        MyTheard myTheard = new MyTheard();
        myTheard.start();
        // 百次输出
        for (int i = 0; i < 100; i++) {
            System.out.println("helloJava" + i);
        }
    }
}

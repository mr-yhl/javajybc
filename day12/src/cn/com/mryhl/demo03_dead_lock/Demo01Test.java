package cn.com.mryhl.demo03_dead_lock;

public class Demo01Test {
    public static void main(String[] args) {
        new MyThreadA().start();
        new MyThreadB().start();
    }
}

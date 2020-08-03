package cn.com.mryhl.homework.t03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>(); // 没有 ArrayList 的问题
        // List<Integer> list = new ArrayList<>(); // 有可能出现空指针、下标越界等错误
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 10000; i++) {
                    list.add(i);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 10001; i <= 20000; i++) {
                    list.add(i);
                }
            }
        }.start();
        Thread.sleep(10000);
        System.out.println(list.size());// 正确结果应当是 20000

    }
}
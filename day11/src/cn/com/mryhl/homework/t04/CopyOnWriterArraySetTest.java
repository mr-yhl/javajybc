package cn.com.mryhl.homework.t04;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriterArraySetTest {
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set = new CopyOnWriteArraySet<>(); // 没有 HashSet 的问题
//        Set<Integer> set = new HashSet<>(); // 有可能出现最后个数不足 20000
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 10000; i++) {
                    set.add(i);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 10001; i <= 20000; i++) {
                    set.add(i);
                }
            }
        }.start();

         Thread.sleep(1000);
        System.out.println(set.size());// 正确结果应当是 20000

    }
}

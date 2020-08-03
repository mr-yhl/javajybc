package cn.com.mryhl.demo09_set;


/*

HashSet线程不安全，如果多线程同时对HashSet集合进行操作，有可能会产生安全性的问题
CopyOnWriteArraySet是线程安全的，我们可以使用这个集合进行多线程操作
 */

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Task implements Runnable {
    //
    // Set<Integer> set = new HashSet<>();
    Set<Integer> set = new CopyOnWriteArraySet<>();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            set.add(i);
        }
        System.out.println("添加完毕");

    }
}

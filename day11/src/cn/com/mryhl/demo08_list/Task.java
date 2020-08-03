package cn.com.mryhl.demo08_list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/*

ArrayList是线程不安全的，多个线程一起对ArrayList进行操作有可能会有安全问题
CopyOnWriteArrayList是线程安全的，可以使用它来解决这个问题

 */

public class Task implements Runnable {

    //List<Integer> list=new ArrayList<>();
    List<Integer> list=new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
        }
        System.out.println("添加完毕");

    }
}

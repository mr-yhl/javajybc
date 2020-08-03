package cn.com.mryhl.homework.t05;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 10000; i++) {
                    map.put(i,i);
                }
            }
        }.start();
        Thread.sleep(10000);
        new Thread(){
            @Override
            public void run() {
                for (int i = 10001; i <= 20000; i++) {
                    map.put(i,i);
                }
            }
        }.start();
        Thread.sleep(10000);
        System.out.println(map.size());
    }
}

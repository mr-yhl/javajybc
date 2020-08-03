package cn.com.mryhl.demo10_map;


/*
HashMap是线程不安全的，如果多个线程同时操作HashMap,那么很有可能出现安全性的问题。
Hashtable是线程安全的，多线程同时操作Hashtable不会有线程安全问题，但是这个集合效事非常低，已经淘汰了。
ConcurrentHashMap是线程安全的,效率比Hashtable要高.ConcurrentHashMap内部使用的是分段锁+CAS
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task implements Runnable {

    // Map<String,String> map = new HashMap<>();
    //Map<String,String> map = new Hashtable<>();
    Map<String,String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 键不要重复
           map.put(Thread.currentThread().getName()+i,Thread.currentThread().getName()+i);
        }
        System.out.println("添加完毕");

    }
}

package cn.com.mryhl01.demo05_system;
/*
请定义一个集合：List<Integer>，并循环向集合中添加1千万个数字，
请计算这个循环运行的时间，并打印。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo01PrintTime {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 10000000; i > 0; i--) {
            list.add(random.nextInt(100));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - startTime);
    }
}

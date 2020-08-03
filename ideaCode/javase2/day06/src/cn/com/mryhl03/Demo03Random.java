package cn.com.mryhl03;

import java.util.Random;

/*
Random类的练习

        (1)产生10个88到188之间（包含88,包含188)的整数数字
*/
public class Demo03Random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("产生10个88到188之间（包含88,包含188)的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(101)+88;
            System.out.println(num);
        }

    }
}

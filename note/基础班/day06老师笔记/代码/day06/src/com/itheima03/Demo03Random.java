package com.itheima03;

import java.util.Random;

/*
    Random类的练习
        产生10个88到188之间(包含88,包含188)的整数数字

    自己证明该代码确实可以产生最小值88,也确实可以产生最大值188
 */
public class Demo03Random {
    public static void main(String[] args) {
        //创建产生随机数字的Random类的对象
        Random r = new Random();
        //产生10个88到188之间(包含88,包含188)的整数数字
        for (int i = 0; i < 100; i++) {
            //产生1个88到188之间(包含88,包含188)的整数数字
            //[88,188] --> [0,100] + 88 --> [0,101) + 88
            int num = r.nextInt(101) + 88;
            System.out.println(num);
        }

    }
}

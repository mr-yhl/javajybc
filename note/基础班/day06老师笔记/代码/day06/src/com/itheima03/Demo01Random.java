package com.itheima03;

import java.util.Random;

/*
    Random类的练习
        (1)产生10个int范围内的整数数字
        (2)产生10个0到100之间(包含0,但是不包含100)的整数数字
 */
public class Demo01Random {
    public static void main(String[] args) {
        //创建产生随机数字的Random类的对象
        Random r = new Random();
        //(1)产生10个int范围内的整数数字
        for (int i = 0; i < 10; i++) {
            //产生一个int范围内的随机数字,保存到int变量num中
            int num = r.nextInt();
            System.out.println(num);
        }
        System.out.println("------------");
        //(2)产生10个0到100之间(包含0,但是不包含100)的整数数字
        for (int i = 0; i < 10; i++) {
            //产生一个0到100之间(包含0,但是不包含100)的随机数字,保存到int变量num中
            int num = r.nextInt(100);
            System.out.println(num);
        }
        System.out.println("------------");
        //证明一定可以产生0,一定不能产生100
        while(true) {
            //产生一个0到100之间(包含0,但是不包含100)的随机数字,保存到int变量num中
            int num = r.nextInt(100);
            System.out.println(num);
            //if (num == 0) {//证明一定可以产生0
            if (num == 100) {//证明一定不可以产生100
                break;
            }
        }
    }
}

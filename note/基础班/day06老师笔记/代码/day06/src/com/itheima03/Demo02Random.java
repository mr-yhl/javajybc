package com.itheima03;

import java.util.Random;

/*
    Random类的练习
        (1)产生10个1到5之间(包含1,包含5)的整数数字
        (2)产生10个1到100之间(包含1,包含100)的整数数字
 */
public class Demo02Random {
    public static void main(String[] args) {
        //创建产生随机数字的Random类的对象
        Random r = new Random();
        /*
            //产生1个1到5之间(包含1,包含5)的整数数字

            可以先产生: 0,1,2,3,4            [0,4] --> [0,5) --> r.nextInt(5)
            再加1:            +1                                  +1
            ---------------------           --------------------------------
            结果:      1,2,3,4,5              r.nextInt(5) + 1
         */
        for (int i = 0; i < 10; i++) {
            //产生1个1到5之间(包含1,包含5)的整数数字
            //[1,5] --> [0,4] + 1 --> [0,5) + 1 --> r.nextInt(5) + 1
            int num = r.nextInt(5) + 1;
            System.out.println(num);
        }
        System.out.println("--------------------");

        //(2)产生10个1到100之间(包含1,包含100)的整数数字
        for (int i = 0; i < 10; i++) {
            //产生1个1到100之间(包含1,包含100)的整数数字
            //[1,100] --> [0,99] + 1 --> [0,100) + 1
            int num = r.nextInt(100) + 1;
            System.out.println(num);
        }
    }
}

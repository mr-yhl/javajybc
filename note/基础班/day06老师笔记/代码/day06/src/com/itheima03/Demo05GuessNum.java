package com.itheima03;

import java.util.Random;
import java.util.Scanner;

/*
    猜数字游戏案例
        1.需求：程序自动生成一个1-100之间(包含1,包含100)的数字，使用程序实现猜出这个数字是多少？

        2.效果：
            如果猜的数字比真实数字大，提示你猜的数据大了
            如果猜的数字比真实数字小，提示你猜的数据小了
            如果猜的数字与真实数字相等，提示恭喜你猜中了

        3.使用的知识点:
             1.使用产生随机数字的Random类(1.导包 2.创建对象 3.产生随机数字)
            2.使用获取键盘录入数据的Scanner类(1.导包 2.创建对象 3.获取键盘录入的数据)
            3.因为用户到底多少次可以猜测正确,是不确定的,使用死循环(while(true){...})
            4.使用if语句第三种格式对用户输入的数字和产生的随机数字做大小比较
            5.用户猜对了,使用break语句结束死循环

        4.实现步骤:
            (1)创建产生随机数字的Random类的对象
            (2)产生一个1-100之间(包含1,包含100)的数字,保存到int变量guessNum中,以供用户猜测
            (3)创建键盘录入Scanner类的对象
            (4)用户猜测数据是一个循环的过程,多少次可以猜对是不确定,也就是说循环次数不确定,
                使用死循环while(true),循环体是步骤(5)和(6)
            (5)获取键盘录入的用户猜测的数字,保存到int变量inputNum中
            (6)使用if语句的第三种格式对用户猜测的inputNum中的数字 和 产生的 guessNum中的数字进行大小比较
                a.如果 用户猜测的inputNum中的数字 大于 产生的 guessNum中的数字
                    提示 "你猜的数据大了"
                b.如果 用户猜测的inputNum中的数字 小于 产生的 guessNum中的数字
                    提示 "你猜的数据小了"
                c.如果 用户猜测的inputNum中的数字 等于 产生的 guessNum中的数字
                    提示 "恭喜你猜中了",同时结束死循环while(true)
 */
public class Demo05GuessNum {
    public static void main(String[] args) {
        //(1)创建产生随机数字的Random类的对象
        Random r = new Random();

        //(2)产生一个1-100之间(包含1,包含100)的数字,保存到int变量guessNum中,以供用户猜测
        //[1,100] --> [0,99] +1 --> [0,100) + 1
        int guessNum = r.nextInt(100) + 1;

        //(3)创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);

        //(4)用户猜测数据是一个循环的过程,多少次可以猜对是不确定,也就是说循环次数不确定,
        //使用死循环while(true),循环体是步骤(5)和(6)
        while(true) {
            //(5)获取键盘录入的用户猜测的数字,保存到int变量inputNum中
            System.out.println("请输入您猜测的数字(1-100之间的整数):");
            int inputNum = sc.nextInt();

            //(6)使用if语句的第三种格式对用户猜测的inputNum中的数字 和 产生的 guessNum中的数字进行大小比较
            if (inputNum > guessNum) {
                //a.如果 用户猜测的inputNum中的数字 大于 产生的 guessNum中的数字
                //提示 "你猜的数据大了"
                System.out.println("你猜的数据大了");
            } else if (inputNum < guessNum) {
                //b.如果 用户猜测的inputNum中的数字 小于 产生的 guessNum中的数字
                //提示 "你猜的数据小了"
                System.out.println("你猜的数据小了");
            } else {
                //c.如果 用户猜测的inputNum中的数字 等于 产生的 guessNum中的数字
                //提示 "恭喜你猜中了",同时结束死循环while(true)
                System.out.println("恭喜你猜中了");
                break;//结束循环
            }
        }
    }
}

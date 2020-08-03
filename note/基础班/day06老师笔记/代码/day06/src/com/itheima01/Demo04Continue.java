package com.itheima01;
/*
    continue的练习
 */
public class Demo04Continue {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            /*
                当i的值是5和10时,if后面()中是true,执行if后面{}中的代码
                执行continue,一旦执行continue,本次循环的循环体中continue后面的代码将被跳过,
                继续执行下次循环的步进表达式
             */
            if (i % 5 == 0) {

                continue;

            }

            System.out.println("HelloWorld..." + i);

        }

        System.out.println("main...end...");
    }
}
package com.itheima01;

/*
    break的练习
 */
public class Demo02Break {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            /*
                当i的值是5时,if后面()中是true,执行if后面{}中的代码
                执行break,一旦执行break,本次循环的循环体中break后面的代码将不再执行,而且剩余次数的循环也不再执行,
                    也就是说会直接结束for循环,执行for循环后面的其它代码
                    相当于执行break时,代码从break的位置跳转到了for循环后面的其它代码继续执行
             */
            if (i % 5 == 0) {
                break;
            }

            System.out.println("HelloWorld...." + i);

        }

        System.out.println("main...end...");
    }
}
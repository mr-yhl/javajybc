package com.itheima04;

public class Demo02DeBug {
    public static void main(String[] args) {

        System.out.println("main...start...");

        method();

        System.out.println("main...end...");
    }

    public static void method() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        return ;
    }
}
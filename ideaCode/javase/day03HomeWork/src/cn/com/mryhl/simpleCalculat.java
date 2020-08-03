package cn.com.mryhl;

import java.util.Scanner;

/*
        小李同学在学习了Scanner之后想要使用Java完成一个简易的加法计算器,
        在控制台输出两个整数之后输出两个整数的和,应该如何实现呢?
        */
public class simpleCalculat {
    public static void main(String[] args) {
        int Num1,Num2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first number (end by Enter key):");
        Num1 = sc.nextInt();
        System.out.println("Please enter the second number (end by Enter key):");
        Num2 = sc.nextInt();
        System.out.println("The numbers you enter are '"+Num1+"','"+Num2+"'.The sum is "+(Num1+Num2));
    }
}

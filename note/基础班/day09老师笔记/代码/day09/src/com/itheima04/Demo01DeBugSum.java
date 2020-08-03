package com.itheima04;
/*
    使用步骤:
        1.在代码的第一行左侧空白(行号后面)处单击鼠标左键,添加断点
        2.右键选择"debug...",进入断点调试界面
 */
public class Demo01DeBugSum {
    public static void main(String[] args) {

        System.out.println("main...start....");
        int a = 10;
        int b = 20;

        int sum = a + b;

        System.out.println("sum="+sum);

        System.out.println("main...end....");
    }
}

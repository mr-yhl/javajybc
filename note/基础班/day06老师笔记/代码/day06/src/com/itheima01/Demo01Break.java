package com.itheima01;
//吃包子案例演示break的用法
public class Demo01Break {
    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {
            /*
                当i的值是2时,if后面()中是true,执行if后面{}中的代码
                首先:执行输出语句打印一句话
                其次:执行break,一旦执行break,本次循环的循环体中break后面的代码将不再执行,而且剩余次数的循环也不再执行,
                    也就是说会直接结束for循环,执行for循环后面的其它代码
                    相当于执行break时,代码从break的位置跳转到了for循环后面的其它代码继续执行
             */
            if(i == 2) {
                System.out.println("发现第2个包子上有个大蟑螂,剩余的包子都不吃了,直接找老板投诉...");
                break;
            }
            System.out.println("顾客吃完第"+i+"个包子");
        }
        System.out.println("老板说: 非常抱歉,给您赔偿10000元....");
    }
}

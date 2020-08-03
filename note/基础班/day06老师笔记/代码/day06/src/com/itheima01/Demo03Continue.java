package com.itheima01;
//吃包子案例演示continue的用法
public class Demo03Continue {
    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {
            /*
                当i的值是2时,if后面()中是true,执行if后面{}中的代码
                首先:执行输出语句打印一句话
                其次:执行continue,一旦执行continue,本次循环的循环体中continue后面的代码将不再执行,
                    继续进行下次循环(执行下次循环的步进表达式)
                    相当于执行continue时,代码从continue的位置跳转到了for循环中的步进表达式继续执行
             */
            if(i == 2) {

                System.out.println("把第2个包子弄脏了,第二个包子不能吃了,继续吃其它包子....");

                continue;
            }
            System.out.println("顾客吃完第"+i+"个包子");
        }
        System.out.println("找老板结账....");
    }
}

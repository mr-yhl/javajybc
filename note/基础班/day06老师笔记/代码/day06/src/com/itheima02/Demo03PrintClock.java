package com.itheima02;
/*
    需求:
        模拟钟表的时针和分针
        时针(外层循环)走一个格,分钟(内层循环)走一圈
        对应:
        外层循环执行一次,内层循环执行完整的一遍

    问题:
        1.外层循环的初始化表达式  int h = 0 ,总共执行几次? 1次
        2.内层循环的初始化表达式  int m = 0 ,总共执行几次? 24次
        3.内层循环的循环体语句 输出时间 总共执行几次?      1440次
			外层循环次数*内层循环每遍执行的次数 = 24*60 = 1440
    总结: 外层循环执行一次,内层循环要执行完整的一遍(从初始化表达式开始)
 */
public class Demo03PrintClock {
    public static void main(String[] args) {
        //int count = 0;
        for(int h = 0;h<24;h++) {//外层循环: 控制每天的24小时
            for(int m = 0;m<60;m++) {//内层循环: 控制每小时的60分钟
                System.out.println(h+"点"+m+"分");
                //count++;
            }
        }
        System.out.println("main...end...");//模拟其它语句
        //System.out.println("main...end..."+count);//模拟其它语句

    }
}

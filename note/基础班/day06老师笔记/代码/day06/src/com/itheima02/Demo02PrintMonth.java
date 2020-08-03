package com.itheima02;
/*
    需求:
	    使用嵌套循环，打印2021年至2023年月份，格式：xxxx年x月

    问题:
        1.外层循环的初始化表达式  int y = 2021 ,总共执行几次? 1次
        2.内层循环的初始化表达式  int m = 1 ,总共执行几次? 3次
        3.内层循环的循环体语句 输出年月 总共执行几次?      36次
			外层循环次数*内层循环每遍执行的次数 = 3*12 = 36
    总结: 外层循环执行一次,内层循环要执行完整的一遍(从初始化表达式开始)
 */
public class Demo02PrintMonth {
    public static void main(String[] args) {

        for(int y = 2021;y<=2023;y++) {//外层循环: 控制年份
            for(int m = 1;m<=12;m++) {//内层循环: 控制每年都有12个月
                System.out.println(y+"年"+m+"月");
            }
        }
        System.out.println("main...end...");//模拟其它语句
    }
}

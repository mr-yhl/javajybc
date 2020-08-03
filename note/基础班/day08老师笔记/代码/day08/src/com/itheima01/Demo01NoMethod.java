package com.itheima01;

/*
    代码功能:模拟游戏中打怪物的场景

    发现问题:
        打怪物的代码是相同的,打了3次怪物,写了3次相同的代码,导致程序代码冗余,阅读性差

    怎么解决问题呢?
      1.能否将发射炮弹的代码,做成一个方法/功能
      2.使用的时候直接调用即可
	========================================================================
				这个代码大家不用写,直接拷贝
	========================================================================
 */
public class Demo01NoMethod {
    /*
        main是一个主方法,由JVM调用,是程序的入口
            1.public static:修饰符,目前固定写法
            2.void:返回值类型,表示方法内部的代码执行完毕,没有最终的结果,返回给调用者
            3.main:方法名称:固定写法
            4.String[] args:方法的参数
    */
    public static void main(String[] args) {
        System.out.println("游戏开始...");

        System.out.println("看到了一个怪物...血牙野猪...");
        System.out.println("准备发射5发炮弹");
        System.out.println("发射第1发炮弹* * * *");
        System.out.println("发射第2发炮弹* * * *");
        System.out.println("发射第3发炮弹* * * *");
        System.out.println("发射第4发炮弹* * * *");
        System.out.println("发射第5发炮弹* * * *");
        System.out.println("发射5发炮弹结束");
        System.out.println("...血牙野猪被打倒...");

        System.out.println("...走啊走啊走啊走...");
        System.out.println("看到了一个怪物...黄金虎鲨...");
        System.out.println("准备发射5发炮弹");
        System.out.println("发射第1发炮弹* * * *");
        System.out.println("发射第2发炮弹* * * *");
        System.out.println("发射第3发炮弹* * * *");
        System.out.println("发射第4发炮弹* * * *");
        System.out.println("发射第5发炮弹* * * *");
        System.out.println("发射5发炮弹结束");
        System.out.println("...黄金虎鲨被打倒...");

        System.out.println("...走啊走啊走啊走...");
        System.out.println("看到了一个怪物...吞天巨狼...");
        System.out.println("准备发射5发炮弹");
        System.out.println("发射第1发炮弹* * * *");
        System.out.println("发射第2发炮弹* * * *");
        System.out.println("发射第3发炮弹* * * *");
        System.out.println("发射第4发炮弹* * * *");
        System.out.println("发射第5发炮弹* * * *");
        System.out.println("发射5发炮弹结束");
        System.out.println("...吞天巨狼被打倒...");
        System.out.println("...走啊走啊走啊走...");

        System.out.println("游戏结束...");
    }
}
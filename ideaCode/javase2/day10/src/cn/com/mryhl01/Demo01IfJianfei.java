package cn.com.mryhl01;

import java.util.Scanner;

/*输入星期数[1,7],显示今天的减肥活动
        周一：跑步
        周二：游泳
        周三：慢走
        周四：动感单车
        周五：拳击
        周六：爬山
        周日：好好吃一顿*/
public class Demo01IfJianfei {
    public static void main(String[] args) {
        // 1.创建键盘录入scanner类的对象
        Scanner scanner = new Scanner(System.in);
        // 2.获取键盘录入的代表星期数的1到7之间的整数数字，保存到int变量i中
        System.out.println("输入1-7的数组:");
        int i = scanner.nextInt();
        // 3.因为i中的数字有7+1种情况，所以使用if语句第三种格式对i中的数字进行判断，并输出不同的结果
        if (i == 1)
            System.out.println("跑步");
        else if (i == 2) {
            System.out.println("游泳");
        } else if (i == 3) {
            System.out.println("慢走");
        } else if (i == 4) {
            System.out.println("动感单车");
        } else if (i == 5)
            System.out.println("拳击");
        else if (i == 6) {
            System.out.println("爬山");
        } else if (i == 7)
            System.out.println("好好吃一顿");
        else
            System.out.println("数组输入错误");
        System.out.println("main       end");
    }
}

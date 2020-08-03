package cn.com.mryhl01;

import java.util.Scanner;

/*输入星期数[1,7],显示今天的减肥活动
周一：跑步
周二：游泳
周三：慢走
周四：动感单车
周五：拳击
周六：爬山
周日：好好吃一顿
*/
public class Demo03SwitchJianfei {
    public static void main(String[] args) {
        // 1.创建键盘录入scanner类的对象
        Scanner scanner = new Scanner(System.in);
        // 2.获取键盘录入的代表星期数的1到7之间的整数数字，保存到int变量i中
        System.out.println("输入1-7的数组:");
        int i = scanner.nextInt();
        // 3.因为i中的数字有7+1种情况，所以使用switch语句第三种格式对i中的数字进行判断，并输出不同的结果
        //检查错误数据
        switch (i) {
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("游泳");
                break;
            case 3:
                System.out.println("慢走");
                break;
            case 4:
                System.out.println("动感单车");
                break;
            case 5:
                System.out.println("拳击");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("好好吃一顿");
                break;
            default:
                System.out.println("数组输入错误");
                break;
        }

        System.out.println("main       end");
    }
}

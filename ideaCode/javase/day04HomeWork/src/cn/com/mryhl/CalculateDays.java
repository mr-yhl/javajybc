package cn.com.mryhl;

import java.util.Scanner;

/*键盘录入一个月份数字，使用switch输出这个月对应的天数
1、3、5、7、8、10、12 为31天
4、6、9、11 为30天
2月不管平/润年都是29天
键盘录入月份并使用switch进行判断,可以使用case穿透来完成.*/
public class CalculateDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字代表月份(1-12):");
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + "月有31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + "月有30天");
                break;
            case 2:
                System.out.println(month + "月有29天");
                break;
            default:
                System.out.println("错误");
                break;
        }
    }
}

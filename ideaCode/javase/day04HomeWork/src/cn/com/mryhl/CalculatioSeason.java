package cn.com.mryhl;

import java.util.Scanner;

/*键盘录入一个月份数字,使用switch输出这个月份对应的季节.
        3,4,5为春季，6,7,8为夏季，9,10,11为秋季，12,1,2为冬季*/
public class CalculatioSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字代表月份(1-12):");
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("大约在冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春天的故事");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("错误");
                break;
        }
    }
}

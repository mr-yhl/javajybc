package cn.com.mryhl03;

import java.util.Scanner;

/*需求：
        一年有12个月，分属于春夏秋冬4个季节，
        键盘录入一个月份，请用程序实现判断该月份属于哪个季节，并输出。
        演示效果
        输入：1、2、12输出：冬季
        输入：3、4、5输出：春季
        输入：6、7、8输出：夏季
        输入：9、10、11输出：秋季
        输入：其它数字输出：数字有误*/
public class Demo02SwichJudgingTheSeason {
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
        System.out.println("main------end");
    }
}

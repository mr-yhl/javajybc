package cn.com.mryhl02;

import java.util.Scanner;

/*需求：
        小明快要期末考试了，小明爸爸对他说，会根据他不同的考试成绩，送他不同的礼物，
        假如你可以控制小明的得分，请用程序实现小明到底该获得什么样的礼物，并在控制台输出。
        [m,n]:从m到n,包含m,包含n
        (m,n):从m到n,不包含m,不包含n
        奖励规则：
        95~100山地自行车一辆
        包含95和100的数学中[95,100]表示95到100之间，包含95,包含100
        90~94游乐场玩一次
        包含90和94的数学中（95,100)表示95到100之间，不包含95,不包含100
        80~89变形金刚玩具一个包含80和89的
        80以下胖捧一顿
        不包含80分的
        */
public class Demo06IfElseIfAchieAward {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入小明的成绩:");
                int score = sc.nextInt();
                if(score>100||score<0)
                        System.out.println("输入数值错误了!");
                else if(score>=95)
                        System.out.println("奖励山地自行车一辆");
                else if(score>=90)
                        System.out.println("奖励游乐场玩一次");
                else if(score>=80)
                        System.out.println("奖励变形金刚玩具一个");
                else
                        System.out.println("胖捧一顿");
                System.out.println("main--------end");
        }
}

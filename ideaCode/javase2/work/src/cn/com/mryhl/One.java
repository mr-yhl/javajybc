package cn.com.mryhl;

import java.util.Scanner;

/*.在控制台录入用户输入的一个三位整数,
如果用户输入的数字大于等于100且小于等于999,
则把三位整数颠倒过来打印输出.*/
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个100-999的数字:");
        int num = sc.nextInt();
        if (num>=100&&num<=999){
            int ge = num%10;
            int shi= num/10%10;
            int bai = num/100;

            System.out.println("颠倒后的数字为:"+ge+shi+bai);
        }
        else
            System.out.println("输入数字错误");
    }
}

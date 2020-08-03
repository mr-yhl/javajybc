package cn.com.mryhl;

import java.util.Scanner;

/*定义一个方法，该方法用来获取三个整数中的最大值。
并在main方法中键盘录入三个整数，
然后调用方法，求出录入的三个整数中的最大值。*/
public class Three {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a,b,c;
        System.out.println("请输入一个数字");
        a=sc.nextInt();
        System.out.println("请再输入一个数字");
        b=sc.nextInt();
        System.out.println("请复输入一个数字");
        c=sc.nextInt();
        System.out.println("最大数为"+getMax(a,b,c));

    }
    public static int getMax(int a,int b,int c){
        int max=a>b?a:b;
        max = max>c?max:c;
        return max;

    }
}

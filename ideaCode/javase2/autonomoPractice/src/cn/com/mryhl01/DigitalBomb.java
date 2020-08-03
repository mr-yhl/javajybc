package cn.com.mryhl01;


//import java.util.Random;
import java.util.Scanner;
/*数字炸弹游戏规则：在一个数字范围内，有一个数字作为炸弹，谁猜中这个炸弹就被惩罚.
比如范围是1~99，炸弹是60，然后猜了一个数字是30，30不是炸弹，那么现在猜数字的范围就缩小到30~100；
又猜了一个数字80,80也不是炸弹，那么现在又缩小范围到30~80，每次猜不能猜边界上的值，
直到有人猜中这个炸弹，然后就受到惩罚。*/
public class DigitalBomb {
    public static void main(String[] args) {
        //随机生成一个数字不适用的原因的第一个数字是固定的
        // Random r = new Random(1);
        //随机生产10个数字双重随机
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
            //System.out.println(arr[i]);
        }
        int num1 = (int) (Math.random() * 10 + 1);
        num1 = arr[num1];
        //输入你猜测的数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请进行第一次猜测(1-100):");
        int num = sc.nextInt();
        //确定最多最小值
        int min = 1, max = 100;
        while (num != num1) {
            //错误判断
            if (num < min || num > max) {
                System.out.println("错误!请输入(" + min + "-" + max + ")之间的数字:");
                num = sc.nextInt();
                continue;
            }
            //最大最小值交换
            if (num < num1)
                min = num;
            else
                max = num;
            //再次猜测
            System.out.println("请进行再次猜测(" + min + "-" + max + "):");
            num = sc.nextInt();
        }
        //数字炸弹爆炸!
        System.out.println("炸了!!!!");
    }
}

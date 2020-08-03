package cn.com.mryhl03;

import java.util.Random;
/*
Random类的练习
        (1)产生10个int范围内的整数数字
        (2)产生10个0到100之间（包含0,但是不包含100)的整数数字
*/
public class Demo01Random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("产生10个int范围内的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt();
            System.out.println(num);
        }
        System.out.println("产生10个0到100之间（包含0,但是不包含100)的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(100);
            System.out.println(num);
        }
        while (true){
            int num = r.nextInt(100);
            System.out.println(num);
            if(num==99)break;
        }
    }
}

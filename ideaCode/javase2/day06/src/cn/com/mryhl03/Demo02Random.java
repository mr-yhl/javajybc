package cn.com.mryhl03;

import java.util.Random;

/*
Random类的练习

        (1)产生10个1到5之间（包含1,包含5)的整数数字
*/
public class Demo02Random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("产生10个1到5之间（包含1,包含5)的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(5)+1;
            System.out.println(num);
        }

    }
}

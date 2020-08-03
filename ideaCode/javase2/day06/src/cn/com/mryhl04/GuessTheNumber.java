package cn.com.mryhl04;

import java.util.Random;
import java.util.Scanner;

/*猜数字
 * 随机生成1-100(包含)的数字,再键盘上输入进行猜测*/
public class GuessTheNumber {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        int inputNum = 0, min = 1, max = 100;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入" + min + "到" + max + "之间的一个数字");
            inputNum = sc.nextInt();
            if(inputNum<min||inputNum>max){
                System.out.println("输入错误!!!");
                continue;
            }
            if (inputNum > num) {
                System.out.println("大了");
                max = inputNum;
            } else if (inputNum < num) {
                System.out.println("小了");
                min = inputNum;

            } else {
                System.out.println("猜中了");
                break;
            }

        }
    }
}

package cn.com.mryhl02;

/*需求：
在控制台输出所有的“水仙花数”
解释：什么是水仙花数？
水仙花数，指的是一个三位数，个位、十位、百位的数字立方和等于原数
例如1533*3*3+5*5*5+1*1*1=27+125+1=153*/
public class Demo02DaffoNumbe {
    public static void main(String[] args) {
        int ge, shi, bai, sum, num1 = 0;
        for (int num = 100; num < 999; num++) {
            ge = num % 10;
            shi = num / 10 % 10;
            bai = num / 100 % 10;
            sum = ge * ge * ge + shi * shi * shi + bai * bai * bai;
            //sum = ge ^ 3 + shi ^ 3 + bai ^ 3;
            if (sum == num)
                {
                    System.out.println(num);
                    num1++;
                }
            }
            System.out.println("共有" + num1 + "个水仙花数");
        }
    }

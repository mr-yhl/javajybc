package cn.com.mryhl;

import java.util.Random;

/*2. 定义一个长度为10的数组, 随机生成10个1 ~ 100之间的数字存入数组中，然后计算并输出平均值。

打印数组中的每一个元素, 然后打印平均值.*/
public class Two {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = r.nextInt(100)+1;
        }
        double avg = printArray(array);
        avg/=array.length;
        System.out.println("平均值为:"+avg);

    }
    public static int printArray(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
            sum+=array[i];
        }
        return sum;
    }
}

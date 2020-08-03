package cn.com.mryhl03;

import java.util.Scanner;

/*案例需求
        在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100的整数分。
        选手的最后得分为：去掉一个最高分和一个最低分后的4个评委平均值（不考虑小数部分）。*/
public class Demo03JudgesScore {
    public static void main(String[] args) {
        int[] array = new int[6];
        Scanner scanner = new Scanner(System.in);
        int sum=0, max, min;
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入第" + (i + 1) + "位评委的分数");
            array[i] = scanner.nextInt();
        }
        min = max = array[0];
        for (int j = 0; j < 6; j++) {
            if (max < array[j])
                max = array[j];
            if (min > array[j])
                min = array[j];
            sum += array[j];
        }
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        int avg = (sum - max -min)/4;
        System.out.println("该生的平均分为"+avg);

    }
}

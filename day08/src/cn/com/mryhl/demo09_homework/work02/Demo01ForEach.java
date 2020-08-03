package cn.com.mryhl.demo09_homework.work02;
/*
请定义一个Collection类型的集合，存储以下分数信息：

​              88.5,39.2,77.1,56.8,89,99,59.5

   请编程实现以下功能：

Ø  使用增强for遍历所有元素，并打印

Ø  使用增强for遍历所有元素，打印不及格的分数；

Ø  使用增强for遍历所有元素，计算不及格的分数的数量，和平均分，并打印计算结果。

Ø  使用增强for遍历所有元素，求出最高分，并打印；

(注意：以上所有功能写在一个main()方法中，但请单独实现)
 */

import java.util.ArrayList;
import java.util.Collection;

public class Demo01ForEach {
    public static void main(String[] args) {
//         请定义一个Collection类型的集合，存储以下分数信息：
// ​              88.5,39.2,77.1,56.8,89,99,59.5
        Collection<Double> doulist = new ArrayList<>();
        doulist.add(88.5);
        doulist.add(39.2);
        doulist.add(77.1);
        doulist.add(56.8);
        doulist.add(99.0);
        doulist.add(59.5);
        // 使用增强for遍历所有元素，并打印
        System.out.print("遍历所有元素:");
        for (Double aDouble : doulist) {

            System.out.print(aDouble+"  ");
        }
        System.out.println();
        // 使用增强for遍历所有元素，打印不及格的分数；
        System.out.print("不及格的分数:");
        for (Double aDouble : doulist) {
            if (aDouble<60)
            System.out.print(aDouble+"  ");
        }
        System.out.println();
        // 使用增强for遍历所有元素，计算不及格的分数的数量，和平均分，并打印计算结果。
        int count = 0;
        double agvSum=0.0;
        for (Double aDouble : doulist) {
            if (aDouble<60){
                count++;
                agvSum += aDouble;
            }

        }
        System.out.println("共有" + count + "个不及格的学生,平均分为:" + agvSum / count);
        // 使用增强for遍历所有元素，求出最高分，并打印；
        double max=0.0;
        for (Double aDouble : doulist) {
            if (aDouble>max)
                max=aDouble;
        }
        System.out.println("最高分是:" + max);
    }
}

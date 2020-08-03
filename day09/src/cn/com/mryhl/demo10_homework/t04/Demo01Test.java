package cn.com.mryhl.demo10_homework.t04;

import java.util.TreeSet;

/*定义一个可以存储“整数”的TreeSet对象

        Ø  存储以下整数

        30,20,50,10,30,20

        Ø  打印集合大小。为什么跟存入的数量不一致？

        Ø  遍历集合，打印大于25的元素*/
public class Demo01Test {
    public static void main(String[] args) {
        // 定义一个可以存储“整数”的TreeSet对象
        TreeSet<Integer> set = new TreeSet<>();
        // 存储以下整数 30,20,50,10,30,20
        set.add(30);
        set.add(20);
        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        int size = set.size();
        System.out.println(size);//4
        // 使用增强for遍历集合，打印大于25的元素

        for (Integer integer : set) {
            if (integer>25)
                System.out.println(integer);
        }
    }
}

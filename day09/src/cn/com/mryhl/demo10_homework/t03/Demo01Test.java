package cn.com.mryhl.demo10_homework.t03;

import java.util.LinkedHashSet;

/*
Ø  定义一个可以存储“整数”的LinkedHashSet对象
Ø  存储以下整数
20,30,50,10,30,20
Ø  打印集合大小。为什么跟存入的数量不一致？
Ø  使用增强for遍历集合，打印大于25的元素
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 定义一个可以存储“整数”的LinkedHashSet对象
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        // 存储以下整数
        // 20,30,50,10,30,20
        set.add(20);
        set.add(30);
        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        // 打印集合大小。为什么跟存入的数量不一致？
        int size = set.size();
        System.out.println(size);//4
        //因为Set的集合会对重复元素进行去重，所以 仅会保存 20,30,50,10 这4个元素
        // 因为重复的不能存
        // 使用增强for遍历集合，打印大于25的元素

        for (Integer integer : set) {
            if (integer>25)
                System.out.println(integer);
        }
    }
}

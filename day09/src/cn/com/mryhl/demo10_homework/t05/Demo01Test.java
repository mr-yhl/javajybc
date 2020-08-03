package cn.com.mryhl.demo10_homework.t05;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
​      请按以下要求顺序编码：
Ø  定义一个：键Integer，值String类型的HashMap集合
Ø  存储以下数据：
1，”张三”
2，“李四”
1，“王五”
Ø  打印集合大小；
Ø  使用“键找值”的方式遍历集合，打印键和值；
Ø  使用“键值对”的方式遍历集合，打印键和值；
Ø  获取键为1的值，并打印
Ø  获取键为10的值，并打印
Ø  判断集合中是否有键：10
Ø  删除键为1的键值对，删除完毕打印集合
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 定义一个：键Integer，值String类型的HashMap集合
        HashMap<Integer, String> map = new HashMap<>();
        // 存储以下数据：
        // 1，”张三”
        // 2，“李四”
        // 1，“王五”
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");
        // 打印集合大小；
        int size = map.size();
        System.out.println("size=" + size);//size=3
        // 使用“键找值”的方式遍历集合，打印键和值；
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            System.out.println(integer + "--" + map.get(integer));
        }
        /*size=3
        1--true
        2--true
        3--true*/
        // 使用“键值对”的方式遍历集合，打印键和值；
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
        /*1=张三
        2=李四
        3=王五*/
        // 获取键为1的值，并打印
        System.out.println(map.get(1));//张三

        // 获取键为10的值，并打印
        System.out.println(map.get(10));//null


        // 判断集合中是否有键：10

        System.out.println(map.containsKey(10));//false
        // 删除键为1的键值对，删除完毕打印集合
        map.remove(1);
        System.out.println(map);//{2=李四, 3=王五}

    }
}

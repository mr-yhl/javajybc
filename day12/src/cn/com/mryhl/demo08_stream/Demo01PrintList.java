package cn.com.mryhl.demo08_stream;

import java.util.ArrayList;
import java.util.List;
/*操作要求：
        1. 首先筛选所有姓张的人；
        2. 然后筛选名字有三个字的人；
        3. 最后进行对结果进行打印输出。*/
public class Demo01PrintList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //1. 首先筛选所有姓张的人；
        //定义集合，保存本次筛选后的结果
        List<String> zhangList = new ArrayList<>();
        //遍历集合，拿到每一个元素，判断是否以张开头
        for (String str : list) {
            if(str.startsWith("张")) {
                zhangList.add(str);
            }
        }
        // 2. 然后筛选名字有三个字的人；
        //定义集合，保存本次筛选后的结果
        List<String> threeList = new ArrayList<>();
        //遍历上次筛选后的结果，拿到里面的每一个元素，判断是否是三个字
        for (String str : zhangList) {
            if(str.length() == 3) {
                threeList.add(str);
            }
        }
        //3. 最后进行对结果进行打印输出。
        for (String str : threeList) {
            System.out.println(str);
        }
        System.out.println("===================");
        // Stream体验
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);
    }
}

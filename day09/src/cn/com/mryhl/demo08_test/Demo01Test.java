package cn.com.mryhl.demo08_test;

import java.util.ArrayList;
import java.util.List;

/*
假如有两个班的学生姓名，它们分别存储在两个集合中
在把这两个集合放到一个集合中
 */
public class Demo01Test {
    public static void main(String[] args) {
        //第一个班
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("丁萨关");
        list1.add("丁煞");
        list1.add("别煞");
        list1.add("匡煞");
        //第二个班
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("北山定");
        list2.add("北山煞");
        list2.add("龚煞");
        list2.add("平煞");

        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        //遍历list,输出里面每一个班级的学生

        for (List<String> stringList : list) {
            // 遍历stringList
            for (String s : stringList) {
                System.out.println(s);
            }
        }
    }
}

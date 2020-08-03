package cn.com.mryhl.demo03_test;
/*
保存字符串并遍历
 */

import java.util.ArrayList;

public class Demo01ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhang1");
        list.add("zhang2");
        list.add("zhang3");
        list.add("zhang4");
        list.add("zhang5");
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }
        // 灵活使用
        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);
            System.out.println(s);
        }
    }
}

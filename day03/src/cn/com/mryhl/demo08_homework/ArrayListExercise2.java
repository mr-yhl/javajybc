package cn.com.mryhl.demo08_homework;

import java.util.ArrayList;

/*
	现有如下字符串元素：["aaa", "bbb", "aaa", "aaa", "ccc", "bbb"]，
	请将所有的元素按顺序存入ArrayListArrayList集合中，并遍历集合查看存储结果。
 */
public class ArrayListExercise2 {
    public static void main(String[] args) {
        String[] strings= {"aaa", "bbb", "aaa", "aaa", "ccc", "bbb"};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

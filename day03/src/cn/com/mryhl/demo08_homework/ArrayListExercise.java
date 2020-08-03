package cn.com.mryhl.demo08_homework;

import java.util.ArrayList;

/*
	创建集并保存字符串["aa","bbbbb","ccc","ddddd","e","ffffff"]，
	遍历集合输出长度大于4的字符串。
 */
public class ArrayListExercise {
    public static void main(String[] args) {
        String[] strings = {"aa", "bbbbb", "ccc", "ddddd", "e", "ffffff"};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() > 4) {
                System.out.println("长度大于4的元素有");
                System.out.println(s);
            }
        }
    }
}

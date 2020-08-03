package cn.com.mryhl.demo05_test;

import java.util.ArrayList;

/*
对保存字符串的集合遍历
 */
public class Demo02Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        printArrayList(list);
    }
    /*
    定义方法,将字符串遍历
        参数:ArrayList<String>
        返回值:void

     */
    public static void printArrayList(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

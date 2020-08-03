package cn.com.mryhl.demo06_test;
/*
用集合存储Student对象,并遍历
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Demo01ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        addStuList(list);
        addStuList(list);
        addStuList(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "位学生的姓名为:" + list.get(i).getName() + ",年龄为:" + list.get(i).getAge());
        }


    }
    /*
    输入学生对象
     */
    public static void addStuList(ArrayList<Student> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生姓名:");
        String s = scanner.nextLine();
        System.out.println("请输入学生年龄:");
        String s1 = scanner.nextLine();
        Student student = new Student(s, s1);
        list.add(student);

    }
}

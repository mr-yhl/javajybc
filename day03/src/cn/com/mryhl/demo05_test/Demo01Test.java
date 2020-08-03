package cn.com.mryhl.demo05_test;

import java.util.ArrayList;
import java.util.Scanner;

/*
使用集合保存Student对象,并遍历
键盘输入姓名年龄
思路：
1.创建集合，用来保存学生。
2.为了提高代码的复用性，定义一个方法，用来将学生对象添加到集合。
    a.键盘录入学生的姓名和年龄。
    b.根据键盘录入的姓名和年龄创建学生对象。
    c.将学生对象添加到集合中。
3.遍历集合，输出集合中每一个对象的属性
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建集合,保存学生
        ArrayList<Student> list = new ArrayList<>();
        // 调用方法
        addStudent(list);
        addStudent(list);
        addStudent(list);
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
    /*
    定义方法,将学生对象添加到集合中
        参数:ArrayList<Student>
        返回值:void

     */
    public static void addStudent(ArrayList<Student> list){
        /*
        向list添加数据
         */
        //  a.键盘录入学生的姓名和年龄
        Scanner scanner = new Scanner(System.in);
        // b.根据键盘录入的姓名和年龄创建学生对象。
        System.out.println("输入姓名");
        String s = scanner.nextLine();
        System.out.println("输入年龄");
        String s1 = scanner.nextLine();
        Student student = new Student(s, s1);
        // c.将学生对象添加到集合中。
        list.add(student);
    }
}

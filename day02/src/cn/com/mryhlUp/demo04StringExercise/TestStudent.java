package cn.com.mryhlUp.demo04StringExercise;

import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);

        //接收用户输入
        System.out.println("请输入学生信息");
        String info = sc.nextLine();

        //处理数据
        info = info.replaceAll(" ", "");//空格替换成空字符串
        String[] split = info.split(",");//以逗号截取

        String name = split[0];
        int age = Integer.parseInt(split[1]);
        char gender = split[2].charAt(0);

        //封装数据到Student对象中
        Student stu = new Student(name, age, gender);

        //打印结果
        System.out.println(stu);
    }

}

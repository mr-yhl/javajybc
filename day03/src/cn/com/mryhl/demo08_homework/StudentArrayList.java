package cn.com.mryhl.demo08_homework;

import java.util.ArrayList;

/*
定义学生类，属性包括姓名和年龄。
​创建集合并存储多个学生对象，遍历集合，输出年龄大于15岁的学生对象的姓名和年龄
 */
public class StudentArrayList {
    public static void main(String[] args) {
        //创建一个集合，用来保存学生
        ArrayList<Student> list = new ArrayList<>();

        //创建3个学生对象
        Student s0 = new Student("李云龙", 10);
        Student s1 = new Student("二营长", 22);
        Student s2 = new Student("秀芹", 24);

        //将三个学生对象添加到集合中
        list.add(s0);
        list.add(s1);
        list.add(s2);

        //遍历集合，输出集合中的每一个对象的姓名和年龄
        for (int i = 0; i < list.size(); i++) {
            //获取遍历到的学生对象
            Student stu = list.get(i);
            //判断遍历到的学生年龄是否大于15
            if (stu.getAge() > 15) {
                System.out.println(stu.getName() + "-" + stu.getAge());
            }
        }
    }
}

package cn.com.mryhl.demo10_homework.t02;

import java.util.HashSet;

/*
定义测试类，及main()方法
Ø  定义一个存储Student类型的HashSet集合
Ø  创建以下三个Student对象
张三,男,20
李四,女,21
张三,男,20
Ø  将上述三个对象存储到Set集合中
Ø  使用增强for遍历集合，获取每个Student对象，并打印属性值；
Ø  请实现集合中不能存储姓名年龄相同的元素
 */
public class Demo01Test {
    public static void main(String[] args) {
        //定义一个存储Student类型的HashSet集合
        HashSet<Student> set = new HashSet<>();
        //创建以下三个Student对象
        set.add(new Student("张三","男",20));
        set.add(new Student("李四","女",21));
        set.add(new Student("张三","男",20));
        //使用增强for遍历集合，获取每个Student对象，并打印属性值；
        for (Student student : set) {
            System.out.println(student);
        }
    }
}

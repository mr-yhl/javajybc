package cn.com.mryhl01.demo01_object.o02;
/*
请按标准格式定义一个“学生类”，它有三个属性：姓名、性别、年龄

​    请编写测试类，创建两个“学生对象”并为它们的属性赋值，并能比较两个对象的所有属性值是否完全相等。
 */

public class Demo02StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("舒法凤", "男", 43);
        Student s2 = new Student("舒法凤", "男", 43);
        System.out.println(s1.equals(s2));

    }
}

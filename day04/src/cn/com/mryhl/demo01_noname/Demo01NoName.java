package cn.com.mryhl.demo01_noname;

import java.util.ArrayList;

/*
匿名对象 ,就是没有名字的对象,创建出来但是没有用变量去接收,那么就是匿名对象

new 数据类型();
好处:
    稍微简化我们的操作

使用场景:
    1.某个对象只需要调用一次,可以使用匿名对象[匿名对象没有变量接收,只能使用一次]
    2.匿名对象当作参数传递
 */
public class Demo01NoName {
    public static void main(String[] args) {
        // 原调用
        Student student = new Student();
        student.eat();
        // 匿名对象调用eat方法
        new Student().eat();
        // 只能使用一次(打印3次地址不同)
        System.out.println(new Student());// cn.com.mryhl.noname.Student@1b6d3586
        System.out.println(new Student());//  cn.com.mryhl.noname.Student@4554617c
        System.out.println(new Student());// cn.com.mryhl.noname.Student@74a14482
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("战术",23));
        list.add(new Student("李斯术",25));
        list.add(new Student("一百二十三",25));
        for (int i = 0; i < list.size(); i++) {
            Student student1 = list.get(i);
            System.out.println(student1.getName() + student1.getAge());
        }
    }
}

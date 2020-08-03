package cn.com.mryhl.demo05_private;
/*
测试类

目前可以在代码中随意使用对象的属性,所以可以之间给属性赋任何值,但这样并不安全
我们可以对属性进行限制,使用private关键字
*/
public class Demo01StudentTest {
    public static void main(String[] args) {
        // 创建对象
        Student student = new Student();
        // 赋值
        student.name="张三";
        student.setAge(18);
        // student.setAge(-18);

        // System.out.println(student.name);
        // System.out.println(student.getAge());
        // 调用成员方法
        student.show();


    }
}

package cn.com.mryhl.demo02_class;
/*
根据Student类创建Student对象

创建对象
1.导包
2.创建对象
    数据类型 对象名 = new 数据类型();
3.使用成员
    对象名.属性名
    对象名.成员方法()
*/

public class Demo01StudentTest {
    public static void main(String[] args) {
        //创建对象
        Student student = new Student();
        //输出默认姓名,年龄
        System.out.println(student.name);
        System.out.println(student.age);
        //赋值
        student.name="张三";
        student.age=18;

        System.out.println(student.name);
        System.out.println(student.age);
        //调用成员方法
        student.study();
        student.say();


    }
}

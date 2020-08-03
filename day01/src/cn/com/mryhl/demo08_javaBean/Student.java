package cn.com.mryhl.demo08_javaBean;
/*
JavaBean就是定义类的规范。只要一个类符合下面的规则，他就是一个JavaBean。
1.将属性私有
2.提供get和set方法
3.提供空参【必须提供】和带参【选择性提供】的构造方法。
 */
public class Student {
    // 姓名
    private String name;
    // 年龄
    private int age;
    //提供get / set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // 无参构造方法
    public Student() {
    }
    // 全参构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

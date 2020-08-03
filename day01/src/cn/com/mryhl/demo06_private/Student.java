package cn.com.mryhl.demo06_private;
/*
学生类
姓名 年龄
get/set方法
 */
public class Student {
    // 姓名
    private String name;
    // 年龄
    private int age;

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
}

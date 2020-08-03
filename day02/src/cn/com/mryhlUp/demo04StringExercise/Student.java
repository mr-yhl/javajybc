package cn.com.mryhlUp.demo04StringExercise;

/**
 * 学员
 */
public class Student {

    //成员变量
    private String name;    //姓名
    private int age;        //年龄
    private char gender;    //性别

    //空参构造
    public Student() {
    }

    //全参构造
    public Student(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //toString
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    //getter & setter 略
}
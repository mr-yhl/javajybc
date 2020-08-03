package cn.com.mryhl02_JavaBean;

/*
 * a.封装
 * b.2个构造
 **/
public class Student {
    private String name;
    private int age;
    private double score;
    //无参
    public Student() {

    }
    //满参
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;

    }

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

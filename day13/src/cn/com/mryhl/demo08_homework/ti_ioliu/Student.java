package cn.com.mryhl.demo08_homework.ti_ioliu;
/*请定义一个Student类，属性：姓名、性别、年龄、分数

​          无参、全参构造方法

​          get/set方法*/
public class Student {
    private String name;
    private String ssex;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name, String ssex, int age, double score) {
        this.name = name;
        this.ssex = ssex;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
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

    @Override
    public String toString() {
        return name + ',' + ssex + ',' +age + "," + score;
    }


}

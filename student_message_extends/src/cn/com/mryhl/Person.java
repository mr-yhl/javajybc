package cn.com.mryhl;

//import java.util.Date;
/*
人类
属性:
    编号,姓名,性别,年龄,出生日期
   对于年龄这个属性来说，手动赋值可能会有风险（年龄和出生日期不对应）
所以年龄最好是根据出生日期进行计算，在给出生日期赋值时，自动计算出年龄。
所以在人类中，要取消手动给年龄赋值的操作

方法:
    work
 */


public abstract class Person {
    private int id;
    private String name;
    private String ssex;
    private int age;
    private String birthday;

    public Person() {
    }

    public Person(int id, String name, String ssex, String birthday) {
        this.id = id;
        this.name = name;
        this.ssex = ssex;
        this.age = Utils.sumAge(birthday);
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    /*public void setAge(int age) {
        this.age = age;
    }*/


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.age = Utils.sumAge(birthday);
    }

    public abstract String work();

    @Override
    public String toString() {
        /*return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ssex='" + ssex + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';*/
        return id+"\t\t\t"+name+"\t\t"+ssex+"\t\t\t"+age+"\t\t\t"+birthday+"\t\t"+work();
    }
}

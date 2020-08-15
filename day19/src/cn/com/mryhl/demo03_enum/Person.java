package cn.com.mryhl.demo03_enum;

public class Person {
    //姓名
    private String name;
    //性别
    private Gender gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Person() {
    }

    public Person(String name, Gender gender) {

        this.name = name;
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
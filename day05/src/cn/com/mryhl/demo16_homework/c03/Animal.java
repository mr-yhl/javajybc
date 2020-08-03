package cn.com.mryhl.demo16_homework.c03;

public class Animal {
    private String name;
    private String age;
    private String ssex;

    public Animal() {
    }

    public Animal(String name, String age, String ssex) {
        this.name = name;
        this.age = age;
        this.ssex = ssex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void eat(){
        System.out.println("吃饭");
    }
}

package cn.com.mryhl01;

public class Dog {
    String name;
    int age;

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

    public void bark(){
        System.out.println("汪汪...");
    }
    public void eat(){
        System.out.println("吃骨头...");
    }

}

package cn.com.mryhl01;

public class Dog {
    private String name;
    private int age;
    //默认构造方法
    public Dog(){
        System.out.println("默认构造方法");
    }
    //构造方法重载
    public Dog(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Dog(String name){
        this.name=name;
        // this.age=age;
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
}

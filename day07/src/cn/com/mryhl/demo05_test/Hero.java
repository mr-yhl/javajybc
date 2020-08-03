package cn.com.mryhl.demo05_test;

/*
英雄类

属性：
姓名，年龄，宠物
方法：
攻击

                */
public class Hero {
    // 姓名
    private String name;
    // 年龄
    private int age;

    private Pet pet;

    public Hero() {
    }

    public Hero(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    // 攻击
    public void attack(){
        System.out.println("英雄" + name + ",今年" + age + ",要用宠物攻击了" );
        pet.hit();
    }
}

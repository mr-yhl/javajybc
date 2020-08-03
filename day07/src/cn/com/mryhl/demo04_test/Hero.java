package cn.com.mryhl.demo04_test;
/*
英雄类

属性：
姓名，年龄，武器
方法：
攻击
                */
public class Hero {
    private String name;
    private int age;

    private Weapon weapon;

    public Hero() {
    }

    public Hero(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void attack(){
        System.out.println("英雄" + name + ",今年" + age + ",使用" + weapon.getName() + "武器,可以造成" + weapon.getHurt() + "点伤害");
    }
}

package cn.com.mryhl.demo05_test;

public class Demo01Test {
    public static void main(String[] args) {
        // 创建英雄对象
        Hero hero = new Hero();
        //赋值
        hero.setName("魔里紫");
        hero.setAge(18);
        hero.setPet(new Dog());

        hero.attack();
    }
}

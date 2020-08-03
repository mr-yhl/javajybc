package cn.com.mryhl.demo04_test;

public class Demo01Test {
    public static void main(String[] args) {
        // 创建英雄对象
        Hero hero = new Hero();
        //赋值
        hero.setName("关羽");
        hero.setAge(18);
        hero.setWeapon(new Weapon("青龙偃月刀",646646));

        hero.attack();
    }
}

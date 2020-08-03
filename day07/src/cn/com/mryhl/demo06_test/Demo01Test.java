package cn.com.mryhl.demo06_test;

public class Demo01Test {
    public static void main(String[] args) {
        // 创建英雄对象
        Hero hero = new Hero();
        //赋值
        hero.setName("太上老君");
        hero.setAge(106661648);
        hero.setSkill(new SkillImpl());
        // 攻击
        hero.attack();
    }
}

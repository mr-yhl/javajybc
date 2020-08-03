package cn.com.mryhl.demo06_test;

/*
英雄类

属性：
    姓名，年龄，技能
方法：
    攻击

                */
public class Hero {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 技能
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, int age, Skill skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    // 攻击
    public void attack(){
        System.out.println("英雄" + name + ",今年" + age + ",要用技能攻击了" );
        skill.use();
    }
}

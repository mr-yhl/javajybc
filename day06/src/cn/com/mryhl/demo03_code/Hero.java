package cn.com.mryhl.demo03_code;
/*
构造代码块
格式:
    {
        代码块;


    }
位置：
    构造代码块要写在类的成员位置。
作用：
    构造代码块中的内容会在每次创建对象的时候执行。
    构造代码块会优先于构造方法执行


静态代码块（重要）

格式：
    static{
        静态代码块内容
    }

位置：
    静态代码块要定义在类的成员位置
作用：
    静态代码块中的内容会在类加载的时候执行，只会执行一次
    当我们使用一个类时，这个类必须先加载到方法区才能使用，这个过程就是类加载。当我们第一次使用某个类时，
    这个类会加载到方法区，类只会加载一次。

使用场景:
    一些项目的准备工作可以方法静态代码块中.
    比如jdbc阶段注册驱动的动作需要放在静态代码块中.
 */
public class Hero {
    static {
        System.out.println("静态代码块加载地图");
    }

    {
        System.out.println("构造代码块给英雄创建武器");
    }
    private String name;
    private int age;

    public Hero() {
       // System.out.println("给英雄创建武器");
       System.out.println("构造方法执行了");
    }

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
        //System.out.println("给英雄创建武器");
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

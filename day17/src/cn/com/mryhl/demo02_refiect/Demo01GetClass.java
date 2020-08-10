package cn.com.mryhl.demo02_refiect;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 9:19
 */
/*
 Class对象的三种获取方式
        1. 通过对象调用getClass方法获取
            Class getClass()：获取Class对象
        2. 通过类调用class属性获取（最简单）
            类名.class
        3. 通过Class的静态方法forName获取（最常用，最灵活）
            static Class forName(String className)：可以根据全类名（包含包的类名）获取类的Class对象

    一个类的Class对象只有一个，不管获取几次，获取的都是同一个Class对象。
 */



public class Demo01GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 通过对象调用getClass方法获取
        Person p = new Person();
        Class<? extends Person> clazz = p.getClass();
        System.out.println(clazz);
        // class cn.com.mryhl.demo02_refiect.Person
        // 2. 通过类调用class属性获取（最简单）
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        // 3. 通过Class的静态方法forName获取（最常用，最灵活）
        Class<?> person = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        System.out.println(person);
        // 验证3次获取的对象是否是同一个
        System.out.println(clazz == personClass);

    }
}

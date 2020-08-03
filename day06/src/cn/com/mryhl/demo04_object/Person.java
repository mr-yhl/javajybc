package cn.com.mryhl.demo04_object;

import java.util.Objects;

/*
    所有类都直接或间接继承Object类,是所有的父类
    如果一个类我们没有使用extends关健字继示其他类，那么这个类是继承自object的
 */
// 人类
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    /*@Override
    public String toString() {

        return "姓名:" + getName() + ",年龄:" + getAge();
    }*/
    // Alt+Ins快速生成

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //提供equals方法，用来根据属性比较两个对象是否相同。如果属性完全相同，那么就返回true表示对象相同。
    //在equals方法中，要比较调用者对象(this)和参数对象(obj)是否相同
    /*
    @Override
    public boolean equals(Object obj) {
        //为了保证程序的健壮性，对参数进行非空判断.
        if (obj == null) {
            //如果传递过来的参数是null，直接返回false。
            return false;
        }

        //对参数类型进行判断，必须参数传递过来的是一个Person类型的对象，那么才进行比较
        if (obj instanceof Person) {
            //如果判断成立，表示obj是Person对象，然后再比较对象的属性是否相同。
            //将obj参数向下转型成Person类型
            Person p = (Person) obj;
            //比较两个对象(this和p)的属性，如果姓名和年龄属性都一样，那么表示两个对象是相同的.
            return this.name.equals(p.name) && this.age == p.age;
        }

        //其他情况，都表示两个对象不同，直接返回false
        return false;
    }
    */


    // 重写equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}

package cn.com.mryhl.demo06_objectstream;

import java.io.Serializable;
/*
Serializable里面没有任何东西,这个接口只是起到标记作用,必须实现接口后
那么类的对象才可以被序列化，才可以写到文件中
Serializable也叫做序列化接口

当读取文件中的对象时，会对比文件中的序列号和当前类中的序列号是否一致，如果不一致，那么就会报错。
解决方案，我们可以给类分配一个固定的序列号，不管这个类如何修改，这个序列号都不变。

我们可以在类中提供一个属性叫做seriaLVersionUID,该属性就表示序列号
    1.属性名必须叫做seriaLVersionUID
    2.必须使用private static final修饰
    3.必须是Long类型
 */
public class Person implements Serializable {
    private String name;
    private /*static*/ /*transient*/ int age;
    //提供属性，表示类的版本号（序列号）
    //该类的办版本号（序列号）永远是,不管怎么修改这个类，版本号（序列号）永远是
    private static final long serialVersionUID = 6078236425251693931l;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

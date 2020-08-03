package cn.com.mryhl.demo06_genderic;
/*
泛型限定
作用：可以对泛型通配符？的取值范围进行限制。
<? extends A>:泛型要么是A类，要么是A类的子类。[上限]
<? super A>:泛型要么是A类，要么是A类的父类。[下限]

型主要用于代码重构，代码的优化

 */


import java.util.ArrayList;

public class Demo02Generic {
    public static void main(String[] args) {
        ArrayList<Student> stuList =new ArrayList<>();
        stuList.add(new Student("东郭",25));
        stuList.add(new Student("舒黛皋",24));
        stuList.add(new Student("公孙煞",21));
        //调用方法
        printArrayList(stuList);// 参数集合的泛型是Person的子类
        ArrayList<Person> personList =new ArrayList<>();
        printArrayList(personList);////参数集合的Person
        ArrayList<Object> objList =new ArrayList<>();
        // printArrayList(objList);//参数集合是Person的父类
        // method(stuList);//参数集合的泛型是person的子类
        method(personList);//参数集合的泛型是person
        method(objList);//参数集合的泛型是person 的父类
    }
    /*
    定义方法:用来保存遍历Person和Person的子类集合
     */
    public static void printArrayList(ArrayList<? extends Person> list){
        for (Person p:list)
            System.out.println(p);

    }
    /*
    定义方法,使用下限
     */
    public static void method(ArrayList<? super Person> list){
        /*for (Object p:list)
            System.out.println(p);*/

    }

}

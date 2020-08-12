package cn.com.mryhl.demo05_constructor_ref;
/*
  类的构造器引用

    类的构造器引用是在创建对象的时候使用的。
    格式：
        类名::new
 */

public class Demo01MethodRef {
    // 使用函数式接口作为参数
    public static void method(PersonBuilder personBuilder) {
        Person person = personBuilder.createPerson("张三", 15);
        System.out.println(person);
    }

    public static void main(String[] args) {
        //调用method方法，传递Lambda表达式
        method((name, age) -> new Person(name, age));

        //方法引用
        method(Person::new);
    }
}

package cn.com.mryhl.demo07_constructor;

/*
构造方法
作用: 可以在创建对象的时候给属性赋值

格式:
    public 构造方法名(参数列表){
    方法体;
    }
    构造方法没有返回值类型,连void都不许写
    构造方法名必须和类名相同
    构造放过不能有返回值     可以写return;


    构造方法会在创建对象时自动调用
    船舰对象的格式: 数据类型 对象名 = new 数据类型();
    真正创建对象的操作是有new 数据类型()完成.
    会根据()中的参数执行对应的方法

    注意:
    如果在一个类中没有定义构造方法,系统默认提供一个默认空参构造方法
    如果在一个类中我们定义了构造方法,系统就不会提供构造方法
    构造方法支持重载
 */
public class Student {
    /*
    定义一个空参数的构造方法
     */
    public Student() {
        System.out.println("空参数的构造方法执行了");
    }
    public Student(String s) {
        System.out.println("一个参数的构造方法执行了"+s);
    }
    public Student(String s,int i) {
        System.out.println("一个参数的构造方法执行了"+s+i);
    }
    public Student(int i,String s) {
        System.out.println(i+"一个参数的构造方法执行了"+s);
    }
    public Student(String s,String i) {
        System.out.println(i+"一个参数的构造方法执行了"+s);
    }
}

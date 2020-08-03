package cn.com.mryhl02;
/*无返回值无参数方法的定义和调用
        1.无返回值
        方法的功能代码执行完毕后，没有具体的结果数据返还给方法的调用者/处，
        此时方法内部只能写return;而且返回值类型必须固定写为void
        2.无参数
        方法没有参数，不需要写参数列表，但是必须保留()
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        定义方法method,方法内部输出一句话”我是一个方法”*/
public class Demo01PrintMethod {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        method();
        System.out.println("main..............end....");
    }
    public static void method(){
        System.out.println("我是一个方法");
        return;
    }
}

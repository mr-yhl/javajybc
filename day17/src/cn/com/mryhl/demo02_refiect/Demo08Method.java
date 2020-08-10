package cn.com.mryhl.demo02_refiect;
/*
使用反射获取成员方法并使用。

在Class中有一些功能，可以获取到类中的成员方法
    Method[] getMethods()：获取到类中所有的成员方法。
    Method getMethod(String name, Class... parameterTypes)：获取到类中指定的成员方法。参数name表示要获取的方法名，参数parameterTypes表示要获取的成员方法的参数列表。
    上面的两个功能只能获取到类中public权限的成员方法，其他权限无法获取。


Method表示成员方法，里面的功能：
    Object invoke(Object obj, Object... args)：让该方法执行。
            参数obj：表示通过哪个对象调用了该方法。如果是调用的静态方法，该参数可以是null。
            参数args：表示调用该方法时传递的实际参数
            返回值：方法调用的返回值
 */


import java.lang.reflect.Method;

public class Demo08Method {
    /*
        要求：获取有参数的成员方法并调用
        public String eat(string food)
     */

    public static void main(String[] args) throws Exception {
        // 获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        // 通过class对象,获取指定的成员方法
        // Method getMethod(String name, Class... parameterTypes)：获取到类中指定的成员方法。参数name表示要获取的方法名，参数parameterTypes表示要获取的成员方法的参数列表。
        // 第一个参数传递的是eat,表示方法名是eat
        // 第二个参数是可变参数,表示参数类别,传的是String.class,表示字符串
        Method eat = clazz.getMethod("eat", String.class);
        Object o = clazz.newInstance();

        //调用invoke,让eat方法执行
        //Object invoke(Object obj, Object...args):让该方法执行
        //因为eat表示的是eat方法，所以通过eat调用invoke方法时让eat方法执行
        //因为invoke方法第一个参数是o,表示通过o调用了eat方法
        //invoke方法第二个参数是可变参数，我们可以传递任意个数据
        // 返回值就是eat的结果

        Object o1 = eat.invoke(o, "法式鹅肝就米饭");
        System.out.println(o1);
    }
}

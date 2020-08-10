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

public class Demo07Method {
    public static void main(String[] args) throws Exception {
        method2();
    }

    /**
     * Method getMethod(String name, Class... parameterTypes)：获取到类中指定的成员方法。参数name表示要获取的方法名，参数parameterTypes表示要获取的成员方法的参数列表。
     */
    public static void method2() throws Exception {
        // 获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        // 获取成员方法
        //getMethod方法第一个参数传递的是sleep,表示获取的方法他的名字是sleep
        //getMethod方法第二个参数是可变参数，该参数位置我们没有传递任何东西，表示获取的方法是空参数的方法
        Method method1 = clazz.getMethod("sleep");
        //System.out.println(method1);
        // 创建Person对象
        Object o = clazz.newInstance();
        // 调用invoke,让方法执行
        // 因为通过method1调用incoke方法,method1表示sleep方法,所以表示sleep执行了
        // 因为invoke方法第一个参数传递的是obj,表示通过obj调用了
        // 因为invoke方法第二个参数没有传递任何数据，所以表示调用sLeep方法时，没有传递任何内容
        method1.invoke(o);
    }


    /**
     * Method[] getMethods()：获取到类中所有的成员方法。
     */
    public static void method() throws Exception {
        // 获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        // 获取成员方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}

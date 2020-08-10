package cn.com.mryhl.demo02_refiect;



/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 9:48
 */
/*
使用反射获取的构造方法并进行使用。

在Class中有一些方法可以获取到类的构造方法：
    Constructor[] getConstructors()：获取到类中所有的构造方法。
    Constructor getConstructor(Class... parameterTypes)：获取到类中指定的构造方法。 参数表示要获取的构造方法的参数列表。
    上面的方法只能获取到类中public权限的构造方法，其他权限无法获取。

Constructor表示构造方法，里面的功能：
    T newInstance(Object... initargs)：通过该构造方法创建对象。
        参数initargs：表示通过构造方法创建对象时传递的实际参数。
        返回值：创建出来的对象。
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class Demo03Constructor {
    public static void main(String[] args) throws ClassNotFoundException {
        method();
    }
    /*
    Constructor getConstructor(Class... parameterTypes)：获取到类中指定的构造方法。 参数表示要获取的构造方法的参数列表。
    上面的方法只能获取到类中public权限的构造方法，其他权限无法获取。
       要求：获取Person类中的空参数的构造方法，并使用该构造方法创建对象
     */

    public static void method2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException {
        //获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        //获取Person类空参数的构造方法
        //public Person()：空参构造
        //因为getConstructor方法参数没有传递任何内容，所以表示我们获取的是空参数的构造方法
        Constructor c = clazz.getConstructor();
        //通过获取到的构造方法调用newInstance方法，使用获取到的构造方法创建对象
        //newInstance方法的参数表示使用构造方法创建对象时传递的实际参数，因为使用空参数的构造方法创建对象，所以不需要传递任何实际参数。所以newInstance方法参数留空不写
        //newInstance方法参数留空不写表示没有传递任何实际参数
        Object obj = c.newInstance();
        System.out.println(obj);
    }




    /*
    Constructor[] getConstructors()：获取到类中所有的构造方法。
     */

    public static void method() throws ClassNotFoundException {
        // 获取Person类的Class
        Class<?> clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        // 获取该类的构造方法
        Constructor[] cs = clazz.getConstructors();
        //遍历数组，拿到每一个构造方法并输出
        for (Constructor c : cs) {
            System.out.println(c);
        }
    }
}

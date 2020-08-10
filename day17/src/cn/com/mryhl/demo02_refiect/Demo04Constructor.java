package cn.com.mryhl.demo02_refiect;

import java.lang.reflect.Constructor;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 10:09
 */

/*使用反射获取的构造方法并进行使用。

        在Class中有一些方法可以获取到类的构造方法：
        Constructor[] getConstructors()：获取到类中所有的构造方法。
        Constructor getConstructor(Class... parameterTypes)：获取到类中指定的构造方法。 参数表示要获取的构造方法的参数列表。
        上面的方法只能获取到类中public权限的构造方法，其他权限无法获取。

        Constructor表示构造方法，里面的功能：
        T newInstance(Object... initargs)：通过该构造方法创建对象。
        参数initargs：表示通过构造方法创建对象时传递的实际参数。
        返回值：创建出来的对象。*/

public class Demo04Constructor {
    /**
    *Constructor getConstructor(Class... parameterTypes)：获取到类中指定的构造方法。 参数表示要获取的构造方法的参数列表。
     *
     * 要求：通过反射获须person类的带参数的构造方法，并根据读构造方法创建对象
     *
     * */
    public static void main(String[] args) throws Exception {
        //获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        // 获取带参数的构造方法
        // Person(String name,int age)
        // 因为调用getConstructor方法第一个参数传递的是String.class，第二个是int.class，表示要获取的构造方法有两个参数，第一个是String，第二个是int
        Constructor c = clazz.getConstructor(String.class,int.class);
        // 根据构造方法创建对象
        // new Person("张三",13)
        // 因为在调用newInstance方法的时候传递的两个参数分别是张三和13,所以表示调用构造方法时传递的实际参数为张三13
        Object o = c.newInstance("张三", 13);// 相当于之前的new Person("张三",13)
        System.out.println(o);

    }
}

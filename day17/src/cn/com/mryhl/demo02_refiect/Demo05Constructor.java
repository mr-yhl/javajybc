package cn.com.mryhl.demo02_refiect;
/*暴力反射（不推荐，会破坏封装性）
暴力反射可以获取到类中任何权限（包括私有）的成员并进行使用。

在Class中，有一些方法可以获取到类中的所有权限的构造方法：
Constructor[] getDeclaredConstructors()：获取类中所有的构造方法
Constructor getDeclaredConstructor(Class... parameterTypes)：获取类中指定的构造方法，参数是构造方法的参数列表
上面的方法可以获取到任何权限的构造方法。

通过上面的方法虽然可以获取到私有的成员，但是不能直接使用。
因为Java中有一个权限检查机制，私有的东西是不能在外面使用的。
我们可以取消这个权限检查机制。

反射有关的类
Constructor：构造方法
Method：成员方法
Field：成员变量

上面这三个类都有一个父类叫做AccessibleObject，在AccessibleObject中有一个方法可以取消检查机制。
void setAccessible(boolean flag)：如果参数是true表示取消权限检查*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo05Constructor {
    public static void main(String[] args) throws Exception {
        //method();
        method2();
    }

    /*
    Constructor getDeclaredConstructor(Class... parameterTypes)：获取类中指定的构造方法，参数是构造方法的参数列表
    要求：使用反射获取私有的构造方法，并创建对象

     */

    public static void method2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException {
        //获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        //获取Person类空参数的构造方法
        //public Person()：空参构造
        //因为getConstructor方法参数没有传递任何内容，所以表示我们获取的是空参数的构造方法
        Constructor c = clazz.getDeclaredConstructor(String.class);
        //通过获取到的构造方法调用newInstance方法，使用获取到的构造方法创建对象
        // 取消权限检查机制
        c.setAccessible(true);
        Object obj = c.newInstance("张三丰");
        System.out.println(obj);
    }




    /*
    Constructor[] getDeclaredConstructors()：获取到类中所有的构造方法。
     */

    public static void method() throws Exception {
        // 获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        // 获取该类的构造方法
        Constructor[] cs = clazz.getDeclaredConstructors();
        //遍历数组，拿到每一个构造方法并输出
        for (Constructor c : cs) {
            System.out.println(c);
        }
    }
}

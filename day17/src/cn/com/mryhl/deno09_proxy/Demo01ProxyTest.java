package cn.com.mryhl.deno09_proxy;
/*
动态代理可以对一个类（对象）的功能进行【增强】
        动态：会在程序运行时期创建一个代理类以及代理对象
        代理：会创建一个代理对象对原有功能进行增强

在Proxy这个类中有一个方法叫做newProxyInstance，这个方法可以创建一个代理对象，并对另一个对象（被代理对象）进行增强。
    static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)：该方法用来创建动态代理对象并将该对象返回。
        参数loader：表示类加载器。 固定写法 当前类.class.getClassLoader();
        参数interfaces：代理对象实现的接口，一般这些接口要和被代理对象一致。  固定写法：被代理对象.getClass().getInterfaces()
        参数h：该参数是InvocationHandler类型，InvocationHandler表示执行处理类（接口），这个接口中有一个方法叫做invoke
            Object invoke(Object proxy, Method method, Object[] args)：这个invoke方法会在每次动态代理对象调用方法时执行
                参数proxy：表示代理对象
                参数method：表示代理对象调用的方法。
                参数args：表示代理对象调用方法时的实际参数。
                返回值：代理对象调用方法的返回值
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo01ProxyTest {
    public static void main(String[] args) {
        // 创建对象
        Carable car = new Car();
        // 创建动态代理对象
        Carable superCar =(Carable) Proxy.newProxyInstance(Demo01ProxyTest.class.getClassLoader(), car.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 判断一下调用的方法是否是run,如果是run,再增强
                if (method.getName().equals("run")){
                    System.out.println("起飞");
                }
                // 让method执行,通过被代理对象调用method方法,让方法执行【放行】
                Object result = method.invoke(car,args);
                return result;
            }
        });
        // 调用方法
        //System.out.println(superCar.getClass());
        superCar.run();
        String say = superCar.say();
        System.out.println(say);
    }
}

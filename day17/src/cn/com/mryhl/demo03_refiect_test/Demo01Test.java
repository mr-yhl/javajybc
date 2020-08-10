package cn.com.mryhl.demo03_refiect_test;
/*
 将类名与方法名放到文件中,通过读取文件的方法决定创建哪个类调用哪个方法
步骤：
    1.创建配置文件，保存类名和方法名
    2.创建Properties集合
    3.创建输入流
    4.调用Load方法，将文件中的键值对加载到Properties集合中
    5.通过Properties集合根据键获取值。
    6.获取该类的CLass对象
    7.通过CLass调用getMethod,获取对应的方法
    8.让方法执行。

 */

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo01Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 步骤：
        // 1.创建配置文件，保存类名和方法名
        // 2.创建Properties集合
        Properties p = new Properties();
        // 3.创建输入流
        FileInputStream is = new FileInputStream("day17\\config.properties");

        // 4.调用Load方法，将文件中的键值对加载到Properties集合中
        p.load(is);
        is.close();
        // 5.通过Properties集合根据键获取值。
        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");
        // 6.获取该类的CLass对象
        Class clazz = Class.forName(className);
        // 7.通过CLass调用getMethod,获取对应的方法
        Method m = clazz.getMethod(methodName);
        // 8.让方法执行。
        Object obj = clazz.newInstance();
        m.invoke(obj);


    }
}

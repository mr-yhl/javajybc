package cn.com.mryhl.demo08_anno_test;
/*
模拟JUnit单元测试

 要求：自定义@MyTest注解，然后在一个类中的多个方法上使用@MyTest注解，然后运行带有@MyTest注解的方法。

步骤：
    1. 获取TestDemo的Class对象
    2. 创建TestDemo对象
    3. 通过Class对象调用getMethods获取所有的成员方法
    4. 遍历这些成员方法，拿到里面的每一个方法（Method）
    5. 判断该方法上有没有@MyTest注解。
    6. 如果有该注解，就让这个方法执行。
 */

import java.lang.reflect.Method;

public class Demo01Test {
    public static void main(String[] args) throws Exception {
        //  1. 获取TestDemo的Class对象
        Class clazz = Class.forName("cn.com.mryhl.demo08_anno_test.TestDemo");
        // 2. 创建TestDemo对象
        Object obj = clazz.newInstance();
        // 3. 通过Class对象调用getMethods获取所有的成员方法
        Method[] methods = clazz.getMethods();
        // 4. 遍历这些成员方法，拿到里面的每一个方法（Method）
        for (Method method : methods) {
            // 5. 判断该方法上有没有@MyTest注解。
            if (method.isAnnotationPresent(MyTest.class)){
                // 6. 如果有该注解，就让这个方法执行。
                method.invoke(obj);
            }
        }



    }
}

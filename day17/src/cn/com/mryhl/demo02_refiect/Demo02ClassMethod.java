package cn.com.mryhl.demo02_refiect;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 9:43
 */
/*
 Class中的常见方法：
    String getName()：获取类的全限定类名（包含包的的类名）
    String getSimpleName(): 获取类的简单类名（不包含包的类名）

 */



public class Demo02ClassMethod {
    public static void main(String[] args) {
        // 获取Person类的Class
        Class clazz = Person.class;
        // String getName()：获取类的全限定类名（包含包的的类名）
        System.out.println(clazz.getName());
        // String getSimpleName(): 获取类的简单类名（不包含包的类名）
        System.out.println(clazz.getSimpleName());
    }
}

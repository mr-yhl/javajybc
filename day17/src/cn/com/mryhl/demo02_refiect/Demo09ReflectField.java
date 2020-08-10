package cn.com.mryhl.demo02_refiect;

import java.lang.reflect.Field;

/*
    使用反射操作成员变量（了解）

在Class中有一些方法可以获取到类中的成员变量
    Field[] getFields()：获取类中所有的成员变量
    Field getField(String name)：获取类中指定的成员变量，参数是成员变量的名字。
        上面的两个方法只能获取public权限的成员变量，其他权限无法获取。

Field表示成员变量，里面功能：
    void set(Object obj, Object value):给成员变量赋值。
        参数obj：表示给哪个对象的成员变量赋值。
        参数value：将该成员变量赋成什么值

Object get(Object obj)：获取成员变量的值。
    参数obj：表示获取哪个对象的成员变量的值。
    返回值：获取到的结果
 */

/**
 * @author 11063
 */
public class Demo09ReflectField {
    //获取Person类的hobby属性，然后进行赋值取值操作

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //获取Person类的Class
        Class clazz = Class.forName("com.itheima.demo01_reflect.Person");
        //获取Person类中的hobby属性
        Field field = clazz.getField("hobby");
        //创建Person对象
        Object obj = clazz.newInstance();
        //给对象hobby属性赋值
        field.set(obj, "写代码");
        //相当于 obj.hobby = "写代码";
        System.out.println(obj);
        //获取hobby属性的值
        //获取obj的hobby属性的值
        Object result = field.get(obj);
        System.out.println(result);
    }
}
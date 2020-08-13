package cn.com.mryhl.demo01_danli;
/*
饿汉式单例模式

    1. 将构造方法私有，防止外界使用new关键字创建对象。
    2. 提供静态的属性，并创建对象
    3. 提供静态方法，用来获取对象
 */
/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/13 8:54
 */
public class Cat {
    //将构造方法私有，防止外界使用new关键字创建对象。
    private Cat() {
    }

    //提供静态的属性，并创建对象【因为该属性是静态的，所以这段代码只执行一次，只创建一个Cat对象】
    private static Cat cat = new Cat();

    //提供静态方法，用来获取对象
    public static Cat getCat() {
        return cat;
    }
}

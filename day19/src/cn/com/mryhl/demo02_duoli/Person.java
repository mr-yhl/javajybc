package cn.com.mryhl.demo02_duoli;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
多例模式，要求程序中的Person对象创建三个
    步骤：
        1. 在类中将构造方法私有，让外界无法直接创建对象
        2. 创建集合，用来保存程序中所有的Person对象。
        3. 定义一个静态代码块，在静态代码块中创建Person对象，并添加到集合中。
        4. 定义方法，用来随机获取程序中的Person对象
  */
public class Person {
    /**
     * 在类中将构造方法私有，让外界无法直接创建对象
     *
     */
    private Person() {

    }

    /**
     * 创建集合，用来保存程序中所有的Person对象。
     */

    private static List<Person> list = new ArrayList<>();

    //定义一个静态代码块，在静态代码块中创建Person对象，并添加到集合中。
    static {
        for (int i = 0; i < 3; i++) {
            list.add(new Person());
        }
    }

    //定义方法，用来随机获取程序中的Person对象
    public static Person getPerson() {
        //生成随机的索引
        Random r = new Random();
        int randomIndex = r.nextInt(list.size());
        //根据这个随机的索引从集合中获取元素然后返回
        return list.get(randomIndex);
    }
}

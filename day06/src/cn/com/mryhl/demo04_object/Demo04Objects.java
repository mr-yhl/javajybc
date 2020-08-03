package cn.com.mryhl.demo04_object;

import java.util.Objects;

/*
在JDK7的时候，多了一个工具类叫做objects,这个工具类里面有很多方法，可以对对象进行操作。
static boolean equals(Object a, Object H):比较a和b两个对象是否相同。



 */
public class Demo04Objects {
    public static void main(String[] args) {
        Teacher s1 = new Teacher("小老鼠", 25);
        Teacher s2 = new Teacher("小老鼠", 25);
        // 重写equals后结果为true
        System.out.println(s1.equals(s2));// false
        System.out.println(Objects.equals(s1,s2));// false

        Teacher t3 = null;
        Teacher t4 = null;
        //使用object的equals比较两个对象是否相同
        //通过null访问任何非静态的方法和属性都会引发空指针异常
        //System.out.println(t3.equals(t4));
        System.out.println(Objects.equals(t3,t4));// false
    }
}

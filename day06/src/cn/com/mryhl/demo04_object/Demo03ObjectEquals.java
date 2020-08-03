package cn.com.mryhl.demo04_object;
/*
在0bject中还有一个方法叫做equaLs,可以比较两个对象是否相同。
boolean equals(object obj):比较两个对象是否相同。

当通过一个对象调用equaLs方法时，会先看一下自己有没有，如果没有，就会向上找父类。如果到bbject,
Object中的equaLs,是在使用==比较对象的地址值是否一样。

一般情况下，比较地址值是没有意，的，更多的我们是希望通过对象的属性比较两个对象是否相同。如果
两个对象的属性完全一样，那么我们可以看成是相同的对象。


如果想要调用equals根据属性比较两个对象是否相同，我们需要对equals方法进行重写。

 */
public class Demo03ObjectEquals {
    public static void main(String[] args) {
        Person p1 = new Person("冯瑟夫", 56);
        Person p2 = new Person("东方塞房", 66);
        Person p3 = new Person("东方塞房", 66);
        // 使用==比较
        System.out.println(p1 == p2);
        System.out.println(p2 == p3);
        System.out.println("============");
        //使用equals比较
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));

    }
}

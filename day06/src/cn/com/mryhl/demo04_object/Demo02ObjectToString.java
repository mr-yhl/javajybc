package cn.com.mryhl.demo04_object;

/*
在object中，有一个方法叫做tostring,可以将对象转成字符串
String toString():返回对象的字符申表示形式。
当我们通过一个对象调用tostring方法时，会先看一下自己有没有这个方法，如果自己没有，就向上找父类，如果到了object,
Object中的toString方法，是将对象转成地址值。
直接输出一个对象名，看到的也是地址值，原因是因为在输出对象名时，内部会调用这个对象的tostring方法，也就是这个对象的
tostring结果是什么，直接输出对象名看到的就是什么结果。
一般来说调用toString看到地址值没有意义，更多的我们是希望调用tostring看到对象的内容。如果想要看到对象的内容，我们
需要对tostring方法进行重写。
*/
public class Demo02ObjectToString {
    public static void main(String[] args) {
        Person p = new Person("张三丰", 102);
        //调用toString类,输出地址值
        System.out.println(p.toString());
        // 输出的地址值
        System.out.println(p);

    }
}

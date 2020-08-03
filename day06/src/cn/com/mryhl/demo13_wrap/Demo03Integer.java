package cn.com.mryhl.demo13_wrap;
/*
Integer中的常见方法
Integer(int value):根据int数字创建Integer对象
Integer(String s):根据字符申创建Integer对象。
static Integer valueof(int i):将int转成Integer并返回
static Integer valueof(String s):将String转成Integer并返回

 */

public class Demo03Integer {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        System.out.println(a);
        Integer b = new Integer("100");
        System.out.println(b);
        Integer c = Integer.valueOf(100);
        System.out.println(c);
        Integer d = Integer.valueOf("100");
        System.out.println(d);


    }
}

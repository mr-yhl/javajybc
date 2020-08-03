/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 10:02:56
 * @Topic request: 变量类型
 */ 
public class Demo1Var {
    public static void main(String[] args) {
        /* 1.格式一（先挖坑，后种萝卜）
        数据类型变量名称；//先挖一个坑
        变量名称=数据值；//再往坑中种一个萝卜*/
        //
        byte a;
        a=10;
        System.out.println(a);
        /*
        2.格式二（挖坑，同时向垦种种一个萝卜）
        数据类型变量名称=数据值；//挖坑，同时向垦种种一个萝卜
        */
        //挖一个short类型的坑(占2个字节),给这个坑起个名字叫b,同时向这个坑中放入数据20
        short b;
        b=20;
        System.out.println(b);
        /*3.格式三（先挖多个坑，然后向每个坑中种一个萝卜）
        数据类型变量名称1,变量名称2...;/先挖多个坑
        变量名称1=数据值1;//再往坑中种一个萝卜
        变量名称2=数据值2;//再往坑中种一个萝卜*/
        //挖了两个int类型的坑（占4个字节）,分别给这两个坑起名字为c和d
        int c,d;
        c=30;
        d=40;
        System.out.println(c);
        System.out.println(d);
        
        /*
        4.格式三（挖多个坑，同时向每个坑中种一个萝卜）
        数据类型变量名称1=数据值1,变量名称2=数据值2...;
         */
        long e=50L,f=60L;
        System.out.println(e);
        System.out.println(f);
    }
}

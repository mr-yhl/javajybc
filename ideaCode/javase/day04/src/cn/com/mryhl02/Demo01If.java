package cn.com.mryhl02;

public class Demo01If {
    public static void main(String[] args) {
        /*if语句的第一种格式练习
        需求1:判断a和的值是否相等，如果相等，就在控制台输出：a等于b
        需求2:判断a和c的值是否相等，如果相等，就在控制台输出：a等于c
        */
        int a = 10, b = 20, c = 10;
        if (a == b)
            System.out.println(a + "等于" + b);
        if (a != b)
            System.out.println(a + "不等于" + b);
        if (a == c)
            System.out.println(a + "等于" + c);
        System.out.println("main   end");
    }

}

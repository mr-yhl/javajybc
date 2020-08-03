package cn.com.mryhl02;

public class Demo02IfElseDaXiao {
    public static void main(String[] args) {
        /*if语句的第二种格式练习
        判断a是否大于b,如果是，在控制台输出：a的值大于b,否则，在控制台输出：a的值不大于b
        */
        int a = 10, b = 20;
        if (a > b)
            System.out.println(a + "大于" + b);
        else
            System.out.println(a + "不大于" + b);
        System.out.println("main   end");
    }

}

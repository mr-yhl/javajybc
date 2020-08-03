package cn.com.mryhl;
/*定义4个方法, 方法名为getSum, 形成重载的形式,
分别用于返回2个整数的和, 3个整数的和, 2个小数的和, 3个小数的和.
整数使用int类型
小数使用double类型*/
public class Demo01PrintSum {
    public static void main(String[] args) {
        System.out.println(getSum(5, 6));
        System.out.println(getSum(4, 5, 6));
        System.out.println(getSum(3.4, 5.6));
        System.out.println(getSum(2.3, 4.5, 6.7));
    }
    public static int getSum(int a, int b) {
        System.out.println("2int");
        return a + b;
    }

    public static int getSum(int a, int b, int c) {
        System.out.println("3int");
        return a + b + c;
    }

    public static double getSum(double a, double b) {
        System.out.println("2double");
        return a + b;
    }

    public static double getSum(double a, double b, double c) {
        System.out.println("3double");
        return a + b + c;
    }
}

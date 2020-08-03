package cn.com.mryhl;

/*数字是有绝对值的，负数的绝对值是它本身取反，非负数的绝对值是它本身。
例如: -3的绝对值是3, 3的绝对值还是3.
请定义一个方法，方法能够得到小数类型数字的绝对值并返回。请定义方法并测试*/
public class ReturnJueduizhi {
    public static void main(String[] args) {
        double num = -2.3;
        // System.out.println(method1(5));
        System.out.println(num+"的绝对值是"+getAbsoluteValue(num));
    }

    public static double getAbsoluteValue(double num) {
        if (num > 0)
            return num;
        else
            return -num;
    }
    /*public static boolean method1(int n){
        if(n < 10){
            return false;
        }else if(n >= 10){
            return true;
        }
        //return false;
    }*/
}

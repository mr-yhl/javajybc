package cn.com.mryhl.demo08_math;
/*
Math是数学工具类，里面有很多方法可以进行数学运算
static int abs(int a):求出绝对值并返回
static double ceil(double a):向上取整
static double floor(double a):向下取整
static Long round(double a):四舍五入
static double pow(double a,double b):求a的b次幂(房)
 */

public class Demo01Math {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(10));//10
        System.out.println(Math.abs(-10));//10
        // 向上取整
        System.out.println(Math.ceil(3.4));//4.0
        System.out.println(Math.ceil(-3.4));//-3.0
        //向下取整
        System.out.println(Math.floor(3.2));//3.0
        System.out.println(Math.floor(-3.2));//4.0
        //四舍五入
        System.out.println(Math.round(3.4));//3
        System.out.println(Math.round(3.6));//4
        // 求平方
        System.out.println(Math.pow(3, 4));//81.0
    }
}

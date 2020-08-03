package cn.com.mryhl.demo11_bigdecimal;
/*
在Java中小数是不精确的，在运算时有可能出现精度问题。比如1.3加1.6结果是2.9000000000000004

如果想要在运算时解决这个精度问题，那么可以使用BigDecimal
BigDecimal表示精确的小数。

BigDecimal的构造方法
BigDecimal(double val):根据double小数创建一个BigDecimal对象【会产生精度问题，不推荐】
BigDecimal(String val):根据String创建一个BigDecimal对象【推荐】
BigDecimal的加减乘运算的方法：
BigDecimal add(BigDecimal augend):加法运算
BigDecimal subtract(BigDecimal subtrahend):减法运算
BigDecimal multiply(BigDecimal multiplicand):乘法运算




*/

import java.math.BigDecimal;

public class Demo01BigDecimal {
    public static void main(String[] args) {
       /* double a = 1.3;
        double b = 1.6;
        System.out.println(a + b);*/
        BigDecimal a = new BigDecimal("1.6");
        BigDecimal b = new BigDecimal("1.3");
        BigDecimal result = a.add(b);
        System.out.println(result);
        result = a.subtract(b);
        System.out.println(result);
        result = a.multiply(b);
        System.out.println(result);

    }
}

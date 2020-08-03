package cn.com.mryhl.demo11_bigdecimal;
/*
BigDecimal中的除法运算：
BigDecimal divide(BigDecimal divisor):进行除法运算
BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)：除法运算
            参数:divisor：表示要相除的小数
            参数:scale：保留几位小数。
            参数:roundingMode：舍入模式。
             该参数位置我们可以传递BigDecimal中的静态常量，ROUND_HALF_UP表示四舍五入
 */

import java.math.BigDecimal;

public class Demo02BigDecimal {
    public static void main(String[] args) {
        // 创建BigDecimal对象
        BigDecimal a = new BigDecimal("3.6");
        BigDecimal b = new BigDecimal("1.2");
        BigDecimal d = new BigDecimal("4.7");

        BigDecimal c = a.divide(b);
        System.out.println(c);
        // System.out.println(d.divide(b));//除不尽报错

        BigDecimal divide = d.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);

    }
}

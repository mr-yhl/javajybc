package cn.com.mryhl.demo10_bigInteger;
/*
如果是非常大的数字，用Long也是无法表示或者进行计算的。
此时就需要使用BigInteger了.
BigInteger表示数字，这个数字可以无限大。
BigInteger的构造方法：
BigInteger(String val):根据字符串数字创建BigInteger对象


BIgInteger的运算方法:

        BigInteger add(BigInteger val):进行加法运算。
        BigInteger subtract(BigInteger val):进行减法运算
        BigInteger multiply(BigInteger val):进行乘法运算
        BigInteger divide(BigInteger val):进行除法运算
*/
import java.math.BigInteger;

public class Demo01BigInteger {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("332324654328983939328235443239985443456443534");
        BigInteger b = new BigInteger("132324863492094294359530595305465930456443534");
        BigInteger result = a.add(b);
        System.out.println(result);
        result = a.multiply(b);
        System.out.println(result);
        result = a.subtract(b);
        System.out.println(result);
        result = a.divide(b);
        System.out.println(result);
    }
}

package cn.com.mryhl02;

public class Demo03ShortCircOperator {
    public static void main(String[] args) {
        //从左向右运行计算
        /*
         * 先计算表达式（3<2)结果是false,对于&&而言左侧为false,
         * 已经决定了&最终的结果就是false,
         * 所以不再计算&右侧的表达式（++a>3),最终a的值没有变化，还是2
         * */
        int a = 2, b = 2, c = 2, d = 2;
        System.out.println((3 < 2) && (++a > 3));
        System.out.println(a);//2
        /*
         表达式（3<2)&(++b>3)从左向右计算
        先计算表达式（3<2)结果是false,对于&而言不管左侧是false还是true
        都要计算&右侧的表达式，所以计算&右侧的表达式（++b>3),最终b的值变成了3
        */
        System.out.println((3 < 2) & (++b > 3));
        System.out.println(b);//3
        /*
        表达式（3>2)11(++C>2)从左向右计算
        先计算表达式（3>2)结果是true,对于/|而言左侧为true,已经决定了|最终的结果就是true,
        所以不再计算儿右侧的表达式（++C>2),最终c的值没有变化，还是2
        */
        System.out.println((3 > 2) || (++c > 2));
        System.out.println(c);//2
        /*
        表达式（3>2)/(++d>2)从左向右计算
        先计算表达式（3>2)结果是true,虽然已经决定了|的最终结果为true,
        但是对于|而言不管左侧是false还是true,都要计算|右侧的表达式，
        所以计算|右侧的表达式（++d>2),最终d的值变成3
        */
        System.out.println((3 > 2) | (++d > 2));
        System.out.println(d);//3


    }
}

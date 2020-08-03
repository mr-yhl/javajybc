package cn.com.mryhl.typeofdata;
/*
int数据类型的溢出问题
当整数的数据大小超出了可以表示的范围，而程序中又没有做数值范围的检查时，
这个整型变量所输出的值将发生紊乱，且不是预期的运行结果。

 */

public class IntOverflowHandling {
    public static void main(String[] args) {
        // int类型的最大数值
        int maxValue = Integer.MAX_VALUE;
        // int类型的最小数值
        int minValue = Integer.MIN_VALUE;
        //打印这两个数值
        System.out.println("最大的int类型数据为:" + maxValue);//最大的int类型数据为:2147483647
        System.out.println("最小的int类型数据为:" + minValue);//最小的int类型数据为:-2147483648
        int a = maxValue + minValue;
        System.out.println("最大值加上最小值"+a);//-1

        // 如果最大值加一会出现什么结果
        maxValue += 1;
        // 打印这个数值
        System.out.println("最大的int类型数据+1为:" + maxValue);//最大的int类型数据+1为:-2147483648
        // 最小值减一
        minValue-=1;
        System.out.println("最小的int类型数据-1为:" + minValue);//最小的int类型数据-1为:2147483647
        /*
        为了避免 int 类型的溢出，可以在该表达式中的任一常量后加上大写的“L”，或
        是在变量前面加上 long，作为强制类型的转换。
        */
        int x = Integer.MAX_VALUE;
        System.out.println("X = " + x);// X = 2147483647
        System.out.println("X+1 = " + (x+1));// X+1 = -2147483648
        System.out.println("X+1L = " + (x+1L));// X+1L = 2147483648
        System.out.println("X+3L = " + (x+3L));// X+3L = 2147483650






    }
}

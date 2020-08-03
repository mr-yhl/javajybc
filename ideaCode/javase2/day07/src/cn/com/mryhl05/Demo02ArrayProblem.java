package cn.com.mryhl05;
/*数组操作的常见问题一：
 数组空指针异常
1.问题描述：java中使用一个类
java.lang.NullPointerException
描述数组空指针异常这种问题
2.产生原因：
null是引用类型的空常量，可以给任意引用类型变量赋值，一旦赋值给某个引用变量后，
说明该引用变量已经不再执行堆内存的任何空间，也就不能通过该引用变量操作堆内存空间中的内容
数组变量one被赋值为mull后，说明该数组变量one,不再执行堆内存空间的任何数组，
也就不能再通过数组变量one访问堆内存空间中的数组元素，一旦访问，就会报出空指针异常
3.解决方案：
(1)不要使用为null的引用变量，访问堆内存空间的内容
(2)找到引用变量值为muLL的位置，进行修改不让它的是nulL,让变量重新指向堆内存空间
 */
public class Demo02ArrayProblem {
    public static void main(String[] args) {
        int[] one = new int[]{100,200};
        System.out.println(one[0]);
        System.out.println(one[1]);
        System.out.println(one);
        //把null赋值给one
        one=null;
        System.out.println(one);
        System.out.println(one[0]);//错误,空指针异常
        /*Exception in thread "main" java.lang.NullPointerException
        at cn.com.mryhl05.Demo02ArrayProblem.main(Demo02ArrayProblem.java:21)*/
        System.out.println("main------------end");

    }
}

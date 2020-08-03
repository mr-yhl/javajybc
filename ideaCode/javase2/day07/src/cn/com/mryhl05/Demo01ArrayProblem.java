package cn.com.mryhl05;
/*数组操作的常见问题一：
 数组索引越界（超出了范围）异常
1.问题描述：java中使用一个类
java.Lang.ArrayIndexoutofBoundsException
描述数组索引越界异常这种问题
2.产生原因：
访问数组元素时，给出的索引编号超出了数组素引编号的范围（从0开始，到数组长度减1)
3.解决方案：
找到素引越界的代码位置，进行修改，让素引在合理的范围之内
 */
public class Demo01ArrayProblem {
    public static void main(String[] args) {
        int[] one = new int[]{100,200};
        System.out.println(one[0]);
        System.out.println(one[1]);
        System.out.println(one[2]);//报错,停止运行

        System.out.println("main------------end");
        /*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
        at cn.com.mryhl05.Demo01ArrayProblem.main(Demo01ArrayProblem.java:11)*/
    }
}

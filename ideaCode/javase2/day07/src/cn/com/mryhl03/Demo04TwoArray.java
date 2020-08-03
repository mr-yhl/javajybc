package cn.com.mryhl03;
       /*

        2.注意：
(1)数组名称保存数组在堆内存空间的地址值
(2)通过数组名称找到堆内存空间的数组容器，
然后再通过素引编号找到数组容器中的指定的元素进行相关操作
        */
public class Demo04TwoArray {
    public static void main(String[] args) {
        int[] one=new int[2];
        // System.out.println(one);
        // System.out.println(one[0]);
        // System.out.println(one[1]);
        one[0]=100;
        // one[1]=200;
        // System.out.println(one[0]);
        // System.out.println(one[1]);

        int[] two=one;
        // System.out.println(two);
        // System.out.println(two[0]);
        // System.out.println(two[1]);
        two[0]=1000;
        System.out.println(one);
        System.out.println(two);
        // two[1]=2000;
        System.out.println(one[0]);

        System.out.println(two[0]);
        // System.out.println(two[1]);
    }
}

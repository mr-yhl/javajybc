package cn.com.mryhl03;
       /*
       基本类型
        (1)整数数组：元素默认值为
        (2)小数数组：元素默认值为0.0
        (3)字符数组：元素默认值为空白字符
        (4)布尔数组：元素默认值为false
        引用类型:
        元素默认值为null
        2.注意：
(1)数组名称保存数组在堆内存空间的地址值
(2)通过数组名称找到堆内存空间的数组容器，
然后再通过素引编号找到数组容器中的指定的元素进行相关操作
        */
public class Demo02OneArray {
    public static void main(String[] args) {
        int[] one=new int[2];
        System.out.println(one);
        System.out.println(one[0]);
        System.out.println(one[1]);
    }
}

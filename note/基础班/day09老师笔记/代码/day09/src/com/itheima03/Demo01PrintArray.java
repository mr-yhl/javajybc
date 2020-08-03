package com.itheima03;

/*
    需求(先不定义方法):
        完成数组的遍历(打印数组元素)，要求遍历的结果是在一行上的。
        例如：[11, 22, 33, 44, 55]

    举例:
        原数组: {11,22,33,44,55}
        打印格式:[11, 22, 33, 44, 55]

    实现步骤:
        1.定义int数组array,并初始化
        2.打印"[",不换行
        3.使用for循环变量数组
        3.1 打印数组当前元素,不换行
        3.2 如果3.1中打印的元素不是最后一个元素,打印", ",不换行
        4.打印"]",可以换行也可以不换行

    问题:
        没有把按照指定格式打印数组的功能定义成方法,这样有几个数组,就需要重复的写几遍这样的代码,
        导致代码可读性差,冗余度搞
 */
public class Demo01PrintArray {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {11, 22, 33, 44, 55};

        //2.打印"[",不换行
        System.out.print("[");
        //3.使用for循环变量数组
        for (int i = 0; i < array.length; i++) {
            //3.1 打印数组当前元素,不换行
            System.out.print(array[i]);
            //3.2 如果3.1中打印的元素不是最后一个元素
            if (i != array.length - 1) {
                //打印", ",不换行
                System.out.print(", ");
            }
        }
        //4.打印"]",可以换行也可以不换行
        System.out.println("]");
        System.out.println("---------------");

        int[] array2 = {110, 220, 330, 440, 550};
        //2.打印"[",不换行
        System.out.print("[");
        //3.使用for循环变量数组
        for (int i = 0; i < array2.length; i++) {
            //3.1 打印数组当前元素,不换行
            System.out.print(array2[i]);
            //3.2 如果3.1中打印的元素不是最后一个元素
            if (i != array2.length - 1) {
                //打印", ",不换行
                System.out.print(", ");
            }
        }
        //4.打印"]",可以换行也可以不换行
        System.out.println("]");
    }
}

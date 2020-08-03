package com.itheima03;

/*
    需求(定义方法):
        设计一个方法用于int数组遍历(打印数组元素)，
        要求遍历的结果是在一行上的。例如：[11, 22, 33, 44, 55]

    举例:
        原数组: {11,22,33,44,55}
        打印格式:[11, 22, 33, 44, 55]

    设计一个方法用于int数组遍历(打印数组元素)
        三要素:
            1.方法名称:     printArray
            2.参数列表:     int[] array
            3.返回值类型:   void

    printArray方法内部的实现步骤:
        1.打印"[",不换行
        2.使用for循环变量数组
        2.1 打印数组中当前元素,不换行
        2.2 如果2.2中打印的不是最后一个元素,打印", ",不换行
        3.for循环结束,打印"]",可以换行也可以不换行

    main方法的实现步骤:
        1.定义int数组array,并初始化
        2.调用printArray方法,传递数组变量array,完成遍历
 */
public class Demo02PrintArray {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {11, 22, 33, 44, 55};

        //2.调用printArray方法,传递数组变量array,完成遍历
        printArray(array);

        int[] array2 = {110, 220, 330, 440, 550};

        printArray(array2);
    }

    //设计一个方法用于int数组遍历(打印数组元素)
    public static void printArray(int[] array) {
        //1.打印"[",不换行
        System.out.print("[");

        //2.使用for循环变量数组
        for (int i = 0; i < array.length; i++) {
            //2.1 打印数组中当前元素,不换行
            System.out.print(array[i]);
            //2.2 如果2.2中打印的不是最后一个元素
            if (i != array.length-1) {
                //打印", ",不换行
                System.out.print(", ");
            }
        }
        //3.for循环结束,打印"]",可以换行也可以不换行
        System.out.println("]");
        return;
    }

}

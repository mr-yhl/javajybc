package com.itheima03;

/*
    需求:
        设计一个方法用于获取int数组中元素的最大值

    举例:
        原数组: {11,22,33,44,55}
        最大值: 55

    设计一个方法用于获取int数组中元素的最大值
        三要素:
            1.方法名称:     getArrayMax
            2.参数列表:     int[] array
            3.返回值类型:    int

    getArrayMax方法内部的实现步骤:
        1.假设索引为0的元素是最大的,保存到int变量max中
        2.使用for循环依次获取后面的(从索引1开始)每个元素
        2.1 如果当前元素值 大于 max,说明max中的元素已经不是最大的了
        2.2 把当前元素值,赋值给max
        3.for循环结束后,返回max

    main方法的实现步骤:
        1.定义int数组array,并初始化
        2.调用getArrayMax方法,传递数组array,获取结果保存到int变量max中
        3.打印max

 */
public class Demo03PrintMax {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {11, 22, 33, 44, 55};

        //2.调用getArrayMax方法,传递数组array,获取结果保存到int变量max中
        int max = getArrayMax(array);

        //3.打印max
        System.out.println("最大值: " + max);
    }

    //设计一个方法用于获取int数组中元素的最大值
    public static int getArrayMax(int[] array) {
        //1.假设索引为0的元素是最大的,保存到int变量max中
        int max = array[0];

        //2.使用for循环依次获取后面的(从索引1开始)每个元素
        for (int i = 1; i < array.length; i++) {
            //2.1 如果当前元素值 大于 max,说明max中的元素已经不是最大的了
            if (array[i] > max) {
                //2.2 把当前元素值,赋值给max
                max = array[i];
            }
        }
        //3.for循环结束后,返回max
        return max;
    }
}

package com.itheima03;

import java.util.Random;

/*
    需求:
        定义一个静态(被static修饰的)方法,方法内部返回一个长度为6的存储1到100之间[1,100]的6个随机数字的int数组
        在main方法中调用上面的方法,获取数组并遍历

    定义一个方法,方法内部返回一个长度为6的存储1到100之间[1,100]的6个随机数字的int数组
        三要素:
            1.方法名称:     getArray
            2.参数列表:     不需要参数
            3.返回值类型:    int[]

    getArray方法内部的实现步骤:
        1.创建长度为6的int数组array,只能采用动态初始化方式
        2.创建产生随机数字的Random类的对象
        3.产生6个[1,100]之间的随机数字,存储到数组array中
        4.返回数组array

    main方法的实现步骤:
        1.调用getArray方法,获取一个int数组,保存到int类型的数组array中
        2.遍历int数组array
 */
public class Demo04GetArray {
    public static void main(String[] args) {
        //1.调用getArray方法,获取一个int数组,保存到int类型的数组array中
        int[] array = getArray();

        //2.遍历int数组array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //定义一个方法,方法内部返回一个长度为6的存储1到100之间[1,100]的6个随机数字的int数组
    public static int[] getArray() {
        //1.创建长度为6的int数组array,只能采用动态初始化方式
        int[] array = new int[6];

        //2.创建产生随机数字的Random类的对象
        Random r = new Random();

        //3.产生6个[1,100]之间的随机数字,存储到数组array中
        for (int i = 0; i < array.length; i++) {
            //产生1个[1,100]之间的随机数字,赋值给数组索引为i的元素
            //[1,100] --> [0,99] + 1 --> [0,100) + 1
            array[i] = r.nextInt(100) + 1;
        }
        //4.返回数组array
        return array;
    }
}

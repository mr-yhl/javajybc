package cn.com.mryhl.demo02_arraylist;
/*
使用集合保存100,200,300


注意:
    集合只能保存引用类型的数据
    如果像保存基本类型,使用基本类型的包装类

    每个基本类型都有对应的引用类型(包装类)


    基本类型
    byte    short   int     long    float   double
    char        boolean
    基本类型包装类
    Byte    Short   Integer Long    Float   Double
    Character   Boolean
    包装类 的使用与基本类型基本一致

 */

import java.util.ArrayList;

public class Demo03ArrayList {
    public static void main(String[] args) {
        //创建集合对象,保存int整数(不能保存基本类型)
        ArrayList<Integer> list = new ArrayList<>();
        // 向集合添加数据
        list.add(100);
        list.add(200);
        list.add(300);

        //集合的输出
        System.out.println(list);//

    }
}

package com.itheima01;

/*
    需求:
	    使用方法重载的思想，设计比较两个数据是否相等的方法，兼容全整数类型(byte,short,int,long）
        方法重载的思想: 同一个类中,多个功能相同,参数列表不同的方法,可以使用同一个名字

    实现步骤:
        1.使用方法重载的思想,定义获取两个byte数据是否相同的方法compare
        2.使用方法重载的思想,定义获取两个short数据是否相同的方法compare
        3.使用方法重载的思想,定义获取两个int数据是否相同的方法compare
        4.使用方法重载的思想,定义获取两个long数据是否相同的方法compare
        5.在main方法中分别调用以上四个方法,传递对应类型的参数,获取并打印结果

    所以方法重载的思想,定义获取两个byte数据是否相同的方法compare
        三要素:
            1.方法名称:     compare
            2.参数列表:     byte a, byte b
            3.返回值类型:   boolean
 */
public class Demo05OverLoadTest {
    public static void main(String[] args) {
        //5.在main方法中分别调用以上四个方法,传递对应类型的参数,获取并打印结果
        //输出调用: 传递常量
        System.out.println(compare((byte) 10, (byte) 20));
        System.out.println(compare((short) 10, (short) 20));
        System.out.println(compare(10, 20));
        System.out.println(compare(10L, 20L));
        System.out.println("--------------");

        //赋值调用: 传递变量
        byte a = 10, b = 20;
        boolean result = compare(a, b);
        System.out.println(result);

        short c = 10, d = 20;
        result = compare(c, d);
        System.out.println(result);

        int e = 10, f = 20;
        result = compare(e, f);
        System.out.println(result);

        long g = 10, h = 20;
        result = compare(g, h);
        System.out.println(result);
    }

    //使用方法重载的思想,定义获取两个byte数据是否相同的方法compare
    public static boolean compare(byte a, byte b) {
        System.out.println("两个byte...");
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    //2.使用方法重载的思想,定义获取两个short数据是否相同的方法compare
    public static boolean compare(short a, short b) {
        System.out.println("两个short...");
        if (a == b) {
            return true;
        }
        //执行到这里说明a和b是不相同的
        return false;
    }

    //3.使用方法重载的思想,定义获取两个int数据是否相同的方法compare
    public static boolean compare(int a, int b) {
        System.out.println("两个int...");
        //定义boolean变量result,初始值true,假设a和b是相同的
        boolean result = true;

        //如果a和b不相同,修改result的值
        if (a != b) {
            result = false;
        }

        //返回result
        return result;
    }

    //4.使用方法重载的思想,定义获取两个long数据是否相同的方法compare
    public static boolean compare(long a, long b) {
        System.out.println("两个long...");
        return a == b;
    }
}

package com.itheima01;
/*
    方法重载与哪些因素无关?(这些情况是无法构成重载的)
        1.与参数的名称无关
        2.与返回值类型无关
        3.与修饰符无关
 */
public class Demo04OverLoadNotice {
    public static void main(String[] args) {

    }

    //1.该方法有两个int类型参数,参数名称分别为a和b
    public static void method(int a,int b){

    }

    //2.该方法有两个int类型参数,参数名称分别为c和d
    //方法2 和 方法1 参数类型和数量都相同,只有参数名称不同,无法构成重载
    /*public static void method(int c,int d){

    }*/

    //3.该方法有两个int类型参数,参数名称分别为a和b
    //方法1和方法3,只有返回值类型不同,然而方法重载与返回值类型是无关的,所以无法构成重载
    /*public static int method(int a, int b) {
        return a + b;
    }*/



    //4.该方法有两个int类型参数,参数名称分别为a和b
    //方法1和方法4,只有修饰符不同,然而方法重载与修饰符是无关的,所以无法构成重载
    /*private void method(int a,int b){

    }*/

}

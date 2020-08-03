package cn.com.mryhl.ex;

import java.io.IOException;
import java.sql.SQLException;

/*throws注意事项：
    1.如果在方法中抛出了编译时异常，那么必须要使用throws进行异常声明。
    2.如果调用了使用throws声明异常的方法，那么调用者要么使用try...catch解决，要么也要加throws声明。
    3.如果在方法中抛出了运行时异常，那么可以加throws声明，也可以不加
    4.如果方法中有可能推出多个异常，那么需要进行多异常的声明
    5.如果方法中有可能能出多个异常，那么也可以直接声明他们的父类异常
    */
public class Demo01ThrowOrThroes {
    public static void main(String[] args) {
        int[] arr = {1,2,35,5,6};
        System.out.println(method(arr, 2));


    }
    public static int method(int[] arr,int index){
        if (index>=arr.length)
            throw new ArrayIndexOutOfBoundsException();
        return arr[index];

    }
    public static int method2() throws IOException, SQLException {
        int num = 10;
        if (num%2 == 0)
            throw new IOException();
        else
            throw new SQLException();
    }
}

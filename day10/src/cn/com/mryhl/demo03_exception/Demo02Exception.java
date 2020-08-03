package cn.com.mryhl.demo03_exception;
/*
异常产生的过程
异常一旦抛出,程序就停止


当程序执行到getValue方法中的arr[index],因为我们传递索引是10,所以系统发现数组中井
没有索引为10的元素，所以这样不合法，于是就在这个位置创建一个异常对象
new ArraylndexOutOfBoundsException0,因为在getValue方法中没有解决异常，那么这个异
常会向外抛（扔）,将该异常抛给自己的调用者位置。

main方法也没有解决这个异常，所以main方法拿到异常之后，会继续向外抛，抛给自己的调用者，main方法是JVM调用的

jvm拿到异常对象之后会做两件事情
    a.将异常信息输出到控制台。
    b.停止程序。
 */
public class Demo02Exception {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,2,6,7};
        int value = getValue(arr, 10);
        //System.out.println(value);
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
	    at cn.com.mryhl.demo03_exception.Demo02Exception.getValue(Demo02Exception.java:14)
	    at cn.com.mryhl.demo03_exception.Demo02Exception.main(Demo02Exception.java:6)
         */
    }
    /*
        定义方法，该方法获取数组指定素引位置的元素
     */
    public static int getValue(int[] arr,int index){
        int i = arr[index];
        return i;
    }

}

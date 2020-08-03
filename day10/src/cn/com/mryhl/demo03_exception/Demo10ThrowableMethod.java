package cn.com.mryhl.demo03_exception;
/*

在ThrowabLe中，有一些方法，可以获取异常信息。
    void printstackTrace():将非常详细的异常信息输出到控制台。(开发过程中推荐)
    String getMessage():获取简短异常信息的字符申。(上线后)

Throwable是异常的父类，所以Throwable中的这些方法也可以通过异常对象调用。
我们要先捕获异常，使用捕获到的异常对象调用方法。

 */
public class Demo10ThrowableMethod {
    public static void main(String[] args) {
        try{
            int[] arr =new int[2];
            System.out.println(arr[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            // 变量e就是捕获到的异常对象
            //System.out.println(e);
            //e.printStackTrace();
            //java.lang.ArrayIndexOutOfBoundsException: 10
            // at cn.com.mryhl.demo03_exception.Demo10ThrowableMethod.main(Demo10ThrowableMethod.java:16)
            String message = e.getMessage();
            System.out.println(message);
        }
        System.out.println("main   end");
    }
}

package cn.com.mryhl.demo03_exception;
/*
try...catch 语句
作用: 用来真正解决异常.

格式:
    try{
        可能出现异常的代码；
    }catch(类名 变量名){
        出现异常后执行的代码;
    }

    如果catch小括号中的类名和try中引发的异常一样，那么就表示捕获到了异常。如果捕获到了异常，就表示把异常给解决了。

执行流程：
    第一种：如果try中的代码没有异常，那么catch不会执行
    第二种：如果try中的代码有异常，并且catch捕获到了这个异常，那么代码会从try直接执行到catch。
    第三种：如果try中的代码有异常，但是catch没有捕获到这个异常，那么异常会依旧往外抛。


小结：
    异常处理有两种方式
    向外地（危锅）:throw throws
    解决异常：try...catch

 */

public class Demo06TryCatch {
    public static void main(String[] args) {
        try{
            System.out.println("1.try....");
            //Object obj = new Object();
            /*
            1.try....
            2.try...
            4.main...end
            */
            Object obj = null;
            /*
            1.try....
            3.出现异常
            4.main...end
             */
            obj.toString();
            System.out.println("2.try...");
        // }catch (NullPointerException e){
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("3.出现异常");
        }
        System.out.println("4.main...end");
        /*
        1.try....
        Exception in thread "main" java.lang.NullPointerException
	    at cn.com.mryhl.demo03_exception.Demo06TryCatch.main(Demo06TryCatch.java:36)
	    */
    }
}

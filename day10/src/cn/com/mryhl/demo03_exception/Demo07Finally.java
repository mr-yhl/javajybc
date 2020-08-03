package cn.com.mryhl.demo03_exception;

/*
try...catch后面可以追加finally代码块
格式：
    try{
        [A]可能出现异常的代码；
    }catch(类名 变量名）{
        [B]出现异常后执行的代码
    } finally{
        [c]一定会执行的代码
    }
finally代码块的特点：
    finally代码块的内容无论如何一定会执行。

执行流程：
    第一种情况：如果try中的代码没有异常，执行流程为【A】【C】
    第二种情况：如果try中的代码有异常，并且catch辅获到了这个异常，执行流程为【A】【B】【C】
    第三种情况：如果try中的代码有异常，但是catch没有描获到这个异常，流程为【A】【C】，抛出异常

finally代码块的使用场景：
        一定要执行的代码放在finally代码块中，比如后期释放资源的操作(IO流中的关闭流，JDBC关闭连接)都是在finally代码块中执行的
 */
public class Demo07Finally {
    public static void main(String[] args) {
        try {
            System.out.println("1.try....");
            // Object obj = new Object();
            Object obj = null;
            /*
            1.try....
            3.catch
            4.finall
            5.main...end
             */
            obj.toString();
            System.out.println("2.try...");

       // } catch (NullPointerException e) {
       } catch (ArrayIndexOutOfBoundsException e) {
            /*
            1.try....
            4.finall
            Exception in thread "main" java.lang.NullPointerException
                at cn.com.mryhl.demo03_exception.Demo07Finally.main(Demo07Finally.java:34)
             */
            System.out.println("3.catch");
        } finally {
            System.out.println("4.finall");
        }
        System.out.println("5.main...end");
        /*
        1.try....
        2.try...
        4.finall
        5.main...end
         */
    }
}

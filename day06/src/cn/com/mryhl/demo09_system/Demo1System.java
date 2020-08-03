package cn.com.mryhl.demo09_system;
/*
System可以称为系统类，里面有一些方法可以完成系统相关的操作
static void exit ( int status ):终止正在运行的Java虚拟机。参数是状态码，0表示正常终止,非0表示异常终止
static Long currentTimeMiLLis():获取当前时间，以毫秒为单位【从1970年1月1日开始过了多少毫秒】
 */

public class Demo1System {
    public static void main(String[] args) {

        long millis = System.currentTimeMillis();
        System.out.println(millis);
        /*System.out.println("hello");
        System.exit(0);
        System.out.println("world");//不在执行;*/

    }
}

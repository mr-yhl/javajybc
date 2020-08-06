package cn.com.mryhl.demo07_printstream;
/*
System.out.println中的system.out其实就是打印流
System.out叫做标准输出流，该流的目的地是控制台。
我们也可以通过system中的静态方法叫做setOut改变这个标准输出流的目的地。
     static void setOut(PrintStream out)：重新改变System.out这个标准输出流的目的地。
 */


import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo02PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //创建打印流
        PrintStream ps = new PrintStream("day14\\file07.txt");
        //调用System中的静态方法setOut，改变打印流的目的地
        System.setOut(ps);

        System.out.println("hello");
    }
}

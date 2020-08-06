package cn.com.mryhl.demo07_printstream;
/*

PrintStream是打印流
打印流有以下特点：
    1.只有输出，没有输入。
    2.写数据十分方便。

 PrintStream构造方法：
    PrintStream(String fileName)：参数要传递字符串的文件路径。
    PrintStream(File file)：参数要传递File对象。
    PrintStream(OutputStream out)：参数要传递字节输出流。

PrintStream特有的写数据的方法：
    void print(任何类型)： 写任何类型的数据。
    void println(任何类型)： 写任何类型的数据并自动换行。

PrintStream的使用步骤：
    1. 创建打印流对象
    2. 调用方法写数据。
    3. 释放资源
 */


import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //1. 创建打印流对象
        PrintStream ps = new PrintStream("day14\\file06.txt");
        //2. 调用方法写数据。
        //void print(任何类型)： 写任何类型的数据。
        // ps.print("你好");
        // ps.print("我好");
        //void println(任何类型)： 写任何类型的数据并自动换行。
        ps.println("你好");
        ps.println("我好");

        //3. 释放资源
        ps.close();
    }
}

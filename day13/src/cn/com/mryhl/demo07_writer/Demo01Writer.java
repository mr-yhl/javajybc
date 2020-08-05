package cn.com.mryhl.demo07_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
writer是字符输出流，用来写，可以将Java程序中的数据写到文件中。
Writer属于字符流，会以字符为单位写数指
writer是字符输出流的顶层父类，Writer也是抽象类，如果要用，需要使用子类，常用的子类是Filewriter

Filewriter构造方法：
    Filewriter(String fileName):参数要传递一个字符串类型的文件路径，表示向读文件中写数据。
    Filewriter(File file):参数要传递一个File类型的文件，表示向读文件中写数据。

Filewriter其他方法：
    void write(string str):写字符申。
    void flush():刷新
    void close():关闭流
Filewriter使用步骤：
    1.创建字符输出流
    2.写数据
    3.刷新
    4.关闭流

只有字符输出流必须刷新
 */
public class Demo01Writer {
    public static void main(String[] args) throws IOException {
        // 创建字符输出流
        Writer w = new FileWriter("day13\\ff.txt");
        // 写数据
        // void write(String s)
        w.write("你好");
        // 刷新
        w.flush();
        // 关流
        w.close();
    }
}

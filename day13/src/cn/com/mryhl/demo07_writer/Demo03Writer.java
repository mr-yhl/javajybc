package cn.com.mryhl.demo07_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
字符输出流写数据的五个方法
    void write(String str)：向文件中写字符串
    void write(String str, int off, int len) ：向文件中写字符串的一部分。从off位置开始写，写len个。
    void write(int c)：向文件中写一个字符
    void write(char[] cbuf): 向文件中写字符数组
    void write(char[] cbuf, int off, int len)：向文件中写字符数组的一部分。 参数off表示从哪个位置写，参数len表示写几个。
*/
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        // 创建字符输出流
        Writer w = new FileWriter("day13\\fff.txt");
        // 写数据
        // void write(String s)
        //w.write("hello");// hello
        // w.write("hello",1,3);//ell
        //w.write(97);//a
        //w.write('中');//中
        char[] cArr = {'h','e','l','l','o'};
        //w.write(cArr);// hello
        w.write(cArr,1,3);// ell

        // 刷新
        w.flush();
        // 关流
        w.close();
    }
}

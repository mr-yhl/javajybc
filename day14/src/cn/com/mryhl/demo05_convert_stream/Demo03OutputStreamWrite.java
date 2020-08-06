package cn.com.mryhl.demo05_convert_stream;
/*
OutputStreamWriter是转换流，用来写，可以将Java程序中的数据按照【指定编码】写到文件中。
OutputStreamWriter属于字符流，会以字符为单位写数据。

OutputStreamWriter构造方法：
        OutputStreamWriter(OutputStream out)：参数要传递字节输出流，将来会以idea默认编码(utf-8)去写数据。
        OutputStreamWriter(OutputStream out, String charsetName)：第一个参数是字节输出流，第二个参数是指定的编码方式。 该方法会按照指定编码写数据。

OutputStreamWriter其他方法：
    OutputStreamWriter是字符流，所以里面写数据的方法和之前字符流写数据的方法一模一样

OutputStreamWriter使用步骤：
1.创建流对象，指定编码
2.写数据
3.刷新
4.关闭
 */



import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
public class Demo03OutputStreamWrite {
    public static void main(String[] args) throws Exception {
        writer();
        writerutf8();

    }
    /*
    写utf8编码的数据
     */
    public static void writerutf8() throws Exception {
        // 创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("e:\\c1.txt"));
        // 写数据
        osw.write("你好");
        // 刷新
        osw.flush();
        // 关闭
        osw.close();
    }
    /*
    写gbk编码的数据
     */
    public static void writer() throws Exception {
        // 创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("e:\\c.txt"), "gbk");
        // 写数据
        osw.write("你好");
        // 刷新
        osw.flush();
        // 关闭
        osw.close();
    }

}

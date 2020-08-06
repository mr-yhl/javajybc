package cn.com.mryhl.demo05_convert_stream;

import java.io.FileInputStream;

import java.io.InputStreamReader;

/*
InputStreamReader是转换流，用来读，可以按照【指定编码】将文件中的数据读取到Java程序中
InputStreamReader是字符流，会以字符为单位进行读取。

InputStreamReader构造方法：
    InputStreamReader(InputStream in):参数要传递一个字节输入流，使用该构造方法创建的转换对象会使用idea默的编码（utf-8)进行读
    InputStreamReader(InputStream in, String charsetName):第一个参数是字节输入流，第二个参数是编码方式。可以指定编码进行读取。

InputStreamReader其他方法
    InputStreamReader是字符流，所以里面读取的方法和字符流读取的方法一模一样。
InputStreamReader按照指定编码读取步骤：
    1.创建转换流对象用来读取，并指定编码。
    2.调用read方法读取。
    3.施放资源。

 */
public class Demo02InputStreamReader {
    public static void main(String[] args) throws Exception {
        readGBK();
        readUTF8();
    }

    /*
   读取UTF8编码文件
    */
    public static void readUTF8() throws Exception {
        // 创建转换流对象,用来读取
        // InputStreamReader isr = new InputStreamReader(new FileInputStream("e:\\b.txt"), "utf8");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("e:\\b.txt"));
        // 开始读取

        int i;
        while ((i = isr.read())!=-1){
            System.out.print((char) i);
        }
        isr.close();
    }

    /*
    读取gbk编码文件
     */
    public static void readGBK() throws Exception {
        // 创建转换流对象,用来读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream("e:\\a.txt"), "gbk");
        // 开始读取

        int i;
        while ((i = isr.read())!=-1){
            System.out.print((char) i);
        }
        isr.close();
    }
}

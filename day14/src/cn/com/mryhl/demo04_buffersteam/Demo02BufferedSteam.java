package cn.com.mryhl.demo04_buffersteam;

import java.io.*;

/*

缓冲流
字节缓冲流
    字节输入缓冲流：BufferedInputStream
    字节输出缓冲流：BufferedOutputStream
字符缓冲流：
    字符输入缓冲流：BufferedReader
    字符输出缓冲流：BufferedWriter

缓冲流的特点是效率高，缓冲流内部有一个缓冲区，可以提高效率【缓冲区就是使用的数组】
缓冲流本身并不具备读或写的功能，他的作用是给其他流提供加速。

字节缓冲流构造方法:
    BufferedInputStream(InputStream in):参数要传递一个字节输入流
    BufferedOutputStream(OutputStream out):参数要传递一个字节输出流。
字节缓冲流其他方法：
    字节缓冲流中其他的方法和我们昨天学的字节流【一模一样】
字节缓冲流的使用步骤：
    1.创建字节缓冲流对象
    2.读或写。
    3.关流

 */
public class Demo02BufferedSteam {
    public static void main(String[] args) throws IOException {
        // 使用字节缓冲流,一次读写一个字节的方法复制对象

        // 创建字节输入缓冲流对象[构造方法传入字节输入流,对该对象加速]
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day14\\bb.png"));
        // 创建字节输出缓冲流对象[造方法参数要传递一个字节输出流，表示对字节输出流进行加速]
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day14\\dd.png"));
        // 记录时间
        long startTime = System.currentTimeMillis();
        // 开始读写
        int i;
        while ((i = bis.read())!=-1){
            bos.write(i);
        }
        long endTime = System.currentTimeMillis();

        // 释放资源
        bos.close();
        bis.close();
        System.out.println(endTime - startTime);//31
    }
}

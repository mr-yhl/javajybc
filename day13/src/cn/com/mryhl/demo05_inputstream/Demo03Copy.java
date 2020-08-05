package cn.com.mryhl.demo05_inputstream;

import java.io.*;

/*
文件复制
文件复制的本质就是文件的读写，从源文件中读取字节，然后写到目的地文件。
步骤：
1.创建字节输入流，用来读取
2.创建字节输出流，用来写。
3.使用输入流读取数据，每次读取一个字节数组，将读取到的数据写到目的地文件中。
4.释放资源
*/
public class Demo03Copy {
    public static void main(String[] args) throws IOException {
        //1. 创建字节输入流，用来读取。
        InputStream is = new FileInputStream("day13\\s2.png");
        //2. 创建字节输出流，用来写。
        OutputStream os = new FileOutputStream("day13\\bb.png");
        //3. 使用循环读取，将数据读取到字节数组中，然后将读取到的数据写到目的地文件。
        //定义数组，用来保存读取到的数据
        byte[] bArr = new byte[1024];
        //定义变量表示读取到的字节个数
        int len;
        //开始循环
        while ((len = is.read(bArr)) != -1) {
            //如果条件成立，表示读取到了数据，那么就将读取到的数据写到目的地文件。
            os.write(bArr, 0, len);
        }
        //4. 释放资源
        // 后开的先关
        os.close();
        is.close();
    }
}

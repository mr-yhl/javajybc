package cn.com.mryhl.demo08_homework.ti_ioliu;


import java.io.*;

// 请使用字节流复制一个文件，一次读、写一个字节。
public class Demo01Copy {
    public static void main(String[] args) throws IOException {
        //1. 创建字节输入流，用来读取。
        InputStream is = new FileInputStream("day13\\s2.png");
        //2. 创建字节输出流，用来写。
        OutputStream os = new FileOutputStream("day13\\c.png");
        int i;
        while ((i=is.read())!=-1){
            os.write(i);
        }

        //4. 释放资源
        // 后开的先关
        os.close();
        is.close();
    }
}

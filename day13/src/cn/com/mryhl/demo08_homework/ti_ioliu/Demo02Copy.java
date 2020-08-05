package cn.com.mryhl.demo08_homework.ti_ioliu;


import java.io.*;

// 请使用字节流复制一个文件，一次读、写一个字节。
public class Demo02Copy {
    public static void main(String[] args) throws IOException {
        //1. 创建字节输入流，用来读取。
        InputStream is = new FileInputStream("day13\\s2.png");
        //2. 创建字节输出流，用来写。
        OutputStream os = new FileOutputStream("day13\\c1.png");
        byte[] bArr = new byte[1024];
        int len;
        while ((len=is.read(bArr))!=-1){
            os.write(bArr,0,len);
        }

        //4. 释放资源
        // 后开的先关
        os.close();
        is.close();
    }
}

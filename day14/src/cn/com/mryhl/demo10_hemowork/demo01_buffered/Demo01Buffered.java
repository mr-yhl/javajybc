package cn.com.mryhl.demo10_hemowork.demo01_buffered;
/*
请将D:盘下的一个文件复制到E:盘下，例如：d:\\视频.itcast，复制到E:\\视频.itcast。
请使用“字节缓冲流”：BufferedInputStream和BufferedOutputStream实现
 */

import java.io.*;

public class Demo01Buffered {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:\\a.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\a.jpg"));

        int i;
        while ((i = bis.read())!=-1){
            bos.write(i);
        }

        bos.close();
        bis.close();



    }
}

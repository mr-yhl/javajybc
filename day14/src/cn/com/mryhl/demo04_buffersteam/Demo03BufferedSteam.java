package cn.com.mryhl.demo04_buffersteam;

import java.io.*;

/*

使用缓冲流结合数组的方式去复制文件，并统计时间


 */
@SuppressWarnings("all")
public class Demo03BufferedSteam {
    public static void main(String[] args) throws IOException {
        // 创建字节输入缓冲流对象[构造方法传入字节输入流,对该对象加速]
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day14\\bb.png"));
        // 创建字节输出缓冲流对象[造方法参数要传递一个字节输出流，表示对字节输出流进行加速]
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day14\\ff.png"));
        // 记录时间
        long startTime = System.currentTimeMillis();
        // 开始读写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!=-1){
            bos.write(len);
        }
        long endTime = System.currentTimeMillis();

        // 释放资源
        bos.close();
        bis.close();
        System.out.println(endTime - startTime);//2
    }
}

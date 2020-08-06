package cn.com.mryhl.demo04_buffersteam;
/*
使用普通的字节流一次读写一个字节的方法复制文件,并统计时间
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01Copy {
    public static void main(String[] args) throws IOException {
        // 创建输入流
        FileInputStream is = new FileInputStream("day14\\bb.png");
        // 创建输出流
        FileOutputStream os = new FileOutputStream("day14\\cc.png");
        long startTime = System.currentTimeMillis();
        int i;
        while ((i = is.read())!=-1){
            os.write(i);
        }
        long emdTime = System.currentTimeMillis();
        os.close();
        is.close();
        System.out.println(emdTime-startTime);//2533
    }
}

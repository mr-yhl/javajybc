package cn.com.mryhl.demo06_reader;
/*
 使用字符输入流一次读取一个字符数组。
        int read(char[] cbuf)：将数据读取到字符数组中，并返回读取到的字符个数，如果已经读取结束了，返回-1.
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo02Reader {
    public static void main(String[] args) throws IOException{
        // 创建流
        Reader r = new FileReader("day13\\source02.txt");
        // 读数据
        // 创建数组
        char[] cArr = new char[1024];
        int len;
        while ((len = r.read(cArr))!= -1){
            System.out.print(new String(cArr,0,len));
        }
        // 关流
        r.close();
    }
}

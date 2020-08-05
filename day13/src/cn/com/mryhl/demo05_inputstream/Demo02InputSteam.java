package cn.com.mryhl.demo05_inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/*
使用字节输入流一次读取一个字节数组
    int read(byte[]b):将数据读取到字节数组中，返回值是读取到的字节个数，如果文件已经读取结束了，返回的是-1
 */
public class Demo02InputSteam {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输入流对象，绑定数据源文件。[如果指定文件不存在,会保存]
        InputStream is = new FileInputStream("day13\\source2.txt");
        // 2.读数据
        byte[] arr = new byte[2];
        // 将数据读取到arr中,因为数组长度是2,所以一次读取两个，返回值是读取到的字节个数。
        // 用来保存每次读取到的个数
        int len;
        // 循环读取
        /*条件位置做了哪些事情
        1.通过流将数据读取到了字节数组中，
        2.将读取到的字节个数返回，原值给了变量Len。
        3.判断Len如果不是-1,表示读取到了数据，就在循环中进行处理。
        读取到的数据保存到了bArr数组中，返回值Len是读取到的字节个数。*/
        while ((len=is.read(arr))!=-1){
            // 输出,读取几个就转换几个
            System.out.println(new String(arr,0,len));
            System.out.println(len);
        }

        /*
        byte[] arr = new byte[2];
        int len = is.read(arr);
        System.out.println(new String(arr,0,len));// [97, 98]
        System.out.println(len);// 2
        len = is.read(arr);
        System.out.println(new String(arr,0,len));// [99, 100]
        System.out.println(len);// 2
        len = is.read(arr);
        System.out.println(new String(arr,0,len));// [101, 100]
        System.out.println(len);// 1*/

        // 3.关闭
        is.close();
    }
}

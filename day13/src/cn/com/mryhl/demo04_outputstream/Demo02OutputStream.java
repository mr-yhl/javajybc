package cn.com.mryhl.demo04_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    使用字节输出流像文件中写字节数组[多个字节]
    void write(byte[] b)：向文件中写一个字节数组
    void write(byte[] b, int off, int len)：向文件中写字节数组的一部分。参数off表示从哪个位置开始写，参数len表示写几个。


 字节输出流的使用步骤：
    1. 创建字节输出流对象，并绑定一个目的文件
    2. 向文件中写数据
    3. 关闭流


 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输出流对象，并绑定一个目的文件
        FileOutputStream os = new FileOutputStream("day13\\aa.txt");
        // 2. 向文件中写数据
        // void write(byte[] b)：向文件中写一个字节数组
        // byte[] arr = {97,98,99,100,101};
        byte[] arr = "hello,你好".getBytes();
        /*System.out.println(Arrays.toString(arr));
        os.write(arr);*/
        os.write(arr,6,3);

        // 3. 关闭流
        os.close();

    }
}

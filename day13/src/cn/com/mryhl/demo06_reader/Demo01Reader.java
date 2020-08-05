package cn.com.mryhl.demo06_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
Reader是字符输入流，用来读，可以将文件中的数据读取到ava程序中。
Reader是属于字符流，会以字符为单位读取数据，可以读取中文【可以解决字节流读取中文的乱码问题】
Reader是所有字符输入流的顶层父类，是一个抽象类，如果要用，需要使用子类，常用的子类是FileReadeer

FileReader构造方法：
    FileReader(String fileName):参数需要传递字符串类型的文件路径，表示从该文件中读取数据。
    FileReader(File file):参数需要传递File类型的文件，表示从该文件中读取数据。
FileReader读取数据的方法：
    int read():读取一个字符并返回，如果读取结束了，返回-1
    int read(char[]cbuf):将数据读取到字符数组，并返回读取到的字符个数，如果读取结束了，返回-1
FileReader使用步骤：
    1.创建流
    2.读数据
    3.关闭流

 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        // 创建流
        Reader r = new FileReader("day13\\source02.txt");
        // 读数据
        // 定义变量接收读到的字符
        int i;
        while ((i = r.read())!= -1){
            System.out.print((char) i);
        }
        // 关流
        r.close();
    }
}

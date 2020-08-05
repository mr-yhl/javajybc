package cn.com.mryhl.demo05_inputstream;

import java.io.FileInputStream;

import java.io.IOException;

/*
Inputstream是字节输入流，用来读，可以将文件中的数据读取到Java程序中。
InputStream是字节流，会以字节为单位读取数据

InputStream是所有字节输入流的顶层父类，是一个抽象类，如果要用，需要使用子类，最常用的子类是FileInputStream

FileInputStream构造方法：
    FileInputStream(String name)：参数要传递一个字符申类型的文件路径，表示要从该文件中读取数据。
    FileInputStream(File file)：参数要传递一个File类型的文件，表示要从该文件中读取数据。

FileInputStream其他方法：
    int read()：从文件中读取一个字节并返回。如果已经读取结束了，返回-1
    int read(byte[] b)：从文件中读取数据放到字节数组中，返回读取到的字节个数，如果已经读取结束了，返回-1.
    void close():释放资源，关闭流。

字节输入流的使用步骤：
    1. 创建字节输入流对象，绑定数据源文件。
    2. 调用read方法，从文件中读取数据。
    3. 调用close方法，释放资源。

    中文在文件中是占用多个字节的，我们不能使用一次读取一个字节的方式读取中文。
*/
public class Demo01InputSteam {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输入流对象，绑定数据源文件。[如果指定文件不存在,会保存]
        FileInputStream is = new FileInputStream("day13\\source.txt");
        // 2. 调用read方法，从文件中读取数据。
        /*int i = is.read();
        System.out.println(i);// 97
        i = is.read();
        System.out.println(i);// 98
        i = is.read();
        System.out.println(i);// 99
        i = is.read();
        System.out.println(i);// -1*/
        // 定义变量i,用于接收每次读取到是字节
        int i;
        /*
        条件位置做了哪些事情
            1.通过输入流调用了read方法读取了一个字节
            2.将读取到的字节赋值给了变
            3.判断是否不等于-1,如果不是-1,表示读取到了数据，就进行处理。
            读取到的数据会保存到变量i
         */
        while ((i=is.read())!=-1){
            System.out.print((char) i);
        }

        // 3. 调用close方法，释放资源。
        is.close();



    }
}

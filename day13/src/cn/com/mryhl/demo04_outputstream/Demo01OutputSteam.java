package cn.com.mryhl.demo04_outputstream;
/*
OutputStream是字节输出流，用来写，可以将Java程序中的数据写到文件中。
OutputStream可以以字节为单位写数据。

OutputStream是所有字节输出流的顶层父类，是一个抽象类，如果要用，需要使用子类，最常用的子类是FileOutputStream

 FileOutputStream构造方法：
    FileOutputStream(String name)：参数要传递一个字符串类型的文件路径，表示向这个文件中写数据。
    FileOutputStream(File file)：参数要传递一个File类型的文件，表示向这个文件中写数据。

FileOutputStream其他方法
    void write(int b)：向文件中写一个字节
    void write(byte[] b)：向文件中写一个字节数组
    void write(byte[] b, int off, int len)：向文件中写字节数组的一部分。参数off表示从哪个位置开始写，参数len表示写几个。
    void close()：关闭流（释放资源）

 字节输出流的使用步骤：
    1. 创建字节输出流对象，并绑定一个目的文件
    2. 向文件中写数据
    3. 关闭流
ASCII码表上的这些字符，在计算机中都是占一个字节的。
在计算机中，中文是占多个字节的。
    如果采用的是GBK的编码，一个中文是两个字节
    如果采用的是UTF-8的编码，一个中文是三个字节。
因为中午在计算机中占用多个字节,因此不能用write方法写入中文字符
 */



import java.io.FileOutputStream;
import java.io.IOException;
public class Demo01OutputSteam {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输出流对象，并绑定一个目的文件
        /*
            下面代码做了什么事
                1. 创建字符输出流对象
                2. 调用操作系统资源,创建aa.txt.如存在,会覆盖
                3. 将流与文件绑定,以后通过该流,操作的都是该文件
        */
        FileOutputStream os = new FileOutputStream("E:\\test\\aa.txt");
        // 2. 向文件中写数据
        // void write(int b)：向文件中写一个字节
        // os.write(100);// 文件中的内容是d,查询ASCII表,写入对应的字符
        // os.write('a');// a
        os.write('中');// -
        // 如果不关闭流,Java就不结束,该文件一直是占用状态.
        // while(true){}

        // 3. 关闭流
        os.close();


    }
}

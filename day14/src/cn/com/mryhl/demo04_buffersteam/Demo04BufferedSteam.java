package cn.com.mryhl.demo04_buffersteam;

import java.io.*;

/*
字符缓冲流：
    字符输入缓冲流：BufferedReader
    字符输出缓冲流：BufferedWriter
字符缓冲流的构造方法:
    BufferedReader(Reader in):参数要传递字符输入流
    BufferedWriter(Writer in):参数要传递字符输出流
字符缓冲流的其他方法：
    字符缓冲流的其他方法和我们昨天学的字活流里面的方法一模一样。
字符缓冲流的使用步骤：
    1.创建字符缓冲流
    2.读或写
    3.关流。
    注意：如果是字符输出流，需要刷

字符缓冲流特有的方法:
    在BufferedWriter里有个方法叫newLine(),可以实现一个跨平台的换行
        void newLine():写一个换行，这个换行是跨平台的。
    在BufferedReader里面有一个方法，叫做readLine,可以读取一行数据
        String readLine():读取一行数据并返回读取到的数据。如果已经读取结束了，返回null

 */
@SuppressWarnings("all")
public class Demo04BufferedSteam {
    public static void main(String[] args) throws IOException {
        // method();
        method2();
    }
    /*
    String readLine():读取一行数据并返回读取到的数据。如果已经读取结束了，返回null
    不会读取换行符,读取换行符之前的内容
    空常量null 字符串"null"
     */
    public static void method2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day14//file03.txt"));
        String s;
        /*
        条件位置做了哪些内容
            1.通过缓冲流调用了readLine方法读取了一行数据
            2.将读取到的这行数据赋值给了变量Line
            3.判断Line如果不是nuLL,表示读取到了数据，就进行处理。
         读取到的每行数据保存到了Line中

        */
        while ((s = br.readLine())!=null)
            System.out.println(s);

        /*String s = br.readLine();
        System.out.println(s);
        s = br.readLine();
        System.out.println(s);*/

        br.close();
    }


    /*
    void newLine():写一个换行，这个换行是跨平台的。
     */

    public static void method() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("day14\\file03.txt"));
        // 写数据
        bw.write("dsggsg");
        // 使用newLine方法，该方法可以写一个跨平台的换行符
        bw.newLine();
        bw.write("电视动画公司");

        // 刷新
        bw.flush();
        bw.close();
    }
}

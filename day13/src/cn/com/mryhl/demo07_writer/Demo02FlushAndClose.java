package cn.com.mryhl.demo07_writer;
/*
关闭和刷新的区别
    flush:刷新,流在刷新后,流还能使用
    close:关闭
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02FlushAndClose {
    public static void main(String[] args) throws IOException {
        // 创建字符输出流
        Writer w = new FileWriter("day13\\ff.txt");
        // 写数据
        // void write(String s)
        w.write("你好");
        // 刷新
        w.flush();
        w.write("富商大贾");
        // 关流
        w.close();// 包含刷新操作,先刷新,后关闭
    }
}

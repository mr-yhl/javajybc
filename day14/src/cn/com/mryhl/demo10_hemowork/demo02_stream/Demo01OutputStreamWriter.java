package cn.com.mryhl.demo10_hemowork.demo02_stream;


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Demo01OutputStreamWriter {
    public static void main(String[] args) throws Exception {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("test4_1.txt"), "gbk");
        writer.write("我要学好Java，我要月薪过万！！");
        writer.flush();
        writer.close();


    }
}

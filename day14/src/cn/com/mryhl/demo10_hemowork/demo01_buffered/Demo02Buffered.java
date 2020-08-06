package cn.com.mryhl.demo10_hemowork.demo01_buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
请编写main()方法，定义一个存储String的集合：List<String>，并初始化以下数据：
    List<String> list = new ArrayList<>();
    list.add(“迪丽热巴”);
    list.add(“古力娜扎”);
    list.add(“周杰伦”);
    list.add(“蔡徐坤”);
//请定义“字符缓冲输出流”BufferedWriter将集合中的数据写入到文件：test3_2.txt中，每个名字一行。
 */
public class Demo02Buffered {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("周杰伦");
        list.add("蔡徐坤");
        BufferedWriter bw = new BufferedWriter(new FileWriter("test3_2.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}

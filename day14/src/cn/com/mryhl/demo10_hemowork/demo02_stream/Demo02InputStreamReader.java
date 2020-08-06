package cn.com.mryhl.demo10_hemowork.demo02_stream;

import java.io.FileInputStream;

import java.io.InputStreamReader;

public class Demo02InputStreamReader {
    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("test4_1.txt"), "gbk");
        int i;
        while ((i = reader.read())!=-1)
            System.out.print((char) i);
        reader.close();

    }
}

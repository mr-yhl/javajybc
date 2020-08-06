package cn.com.mryhl.demo10_hemowork.demo01_buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Demo03Buffered {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test3_2.txt"));
        List<String> list = new ArrayList<>();
        String s;
        while ((s = br.readLine())!=null)
        list.add(s);
        br.close();
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}

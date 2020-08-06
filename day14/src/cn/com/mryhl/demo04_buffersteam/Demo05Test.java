package cn.com.mryhl.demo04_buffersteam;
/*
将出师表.txt中的内容恢复顺序，并写到另一个文件中。
特点：每行都是由序号，课文内容组成
步骤：
    1.创建集合，用来保存读取到的每行课文。
    2.创建字符输入缓冲流，用来读取。
    3.开始读取，每次读取一行数据。
    4.将读取到的这行数据添加到集合中。
    5.关闭流
    6.根据首字符排序
    7.创建字符输出缓冲流，用来写
    8.遍历集合，拿到元素
    9.将遍历到的元素写到目的地文件。
    10.换行
    11.刷新
    12.关流
 */


import java.io.*;

import java.util.ArrayList;
import java.util.Collections;


public class Demo05Test {
    public static void main(String[] args) throws IOException {
        // 1.创建集合，用来保存读取到的每行课文。
        ArrayList<String> list = new ArrayList<>();

        // 2.创建字符输入缓冲流，用来读取。
        BufferedReader br = new BufferedReader(new FileReader("day14\\出师表.txt"));
        // 3.开始读取，每次读取一行数据。
        String line;
        while ((line = br.readLine())!=null){
            // 4.将读取到的这行数据添加到集合中。
            list.add(line);
        }
        // 5.关闭流
        br.close();
        // 6.根据首字符排序[比较器排序]
        Collections.sort(list, (o1, o2) -> o1.charAt(0) - o2.charAt(0));
        //System.out.println(list);
        // 7.创建字符输出缓冲流，用来写
        BufferedWriter bw = new BufferedWriter(new FileWriter("day14\\csb.txt"));

        // 8.遍历集合，拿到元素
        for (String str : list) {
            // 9.将遍历到的元素写到目的地文件。
            bw.write(str);
            // 10.换行
            // 11.刷新
            bw.newLine();
            bw.flush();
        }


        // 12.关流
        bw.close();
    }
}

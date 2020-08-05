package cn.com.mryhl.demo01_file;

import java.io.File;

/*
相对路径和绝对路径
    相对路径：是一个简单的路径，不是从盘符开始的，在idea中，相对相对路径相对的是当前项目，指的是当前项目下的东西。
    绝对路径：是一个完整的路径,从盘符开始的路径。
如果要区分相对路径和绝对路径,只看是不是从盘符开始.

*/
public class Demo03Path {
    public static void main(String[] args) {
        // 创建File[相对路径,相当于当前项目下的文件aa.txt]
        File file = new File("aa.txt");
    }
}

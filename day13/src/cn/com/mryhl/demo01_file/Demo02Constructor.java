package cn.com.mryhl.demo01_file;
/*
File类的构造方法:
    File(String pathname):根据文件或文件夹的路径创建File对象。
    File(String parent,String child):根据父路径和子路径创建一个File对象
        文件的路径：D:\test\aa.txt
        父路径：D:\test
        子路径：aa.txt
    File(File parent,String child):根据父路径和子路径创建一个File对象

File可以表示计算机中的文件，也可以表示文件夹
File表示的文件或文件夹在计算机中可以是存在的，也可以是不存在的。
 */

import java.io.File;

public class Demo02Constructor {
    public static void main(String[] args) {
        // File(String pathname):根据文件或文件夹的路径创建File对象。
        // 在Java中\是特殊字符，叫做转义字符，表示将后面的字符改变意思
        // 如果想要表示普通的，需要写两个\\
        //File file = new File("e:\\test\\aa.txt");
        File file = new File("e:\\test\\zz.txt");
        // 输出file
        System.out.println(file);

        // File(String parent,String child):根据父路径和子路径创建一个File对象
        // 创建file对象表示e:\test\aa.txt
        File file1 = new File("e:\\test","aa.txt");
        System.out.println(file1);
        // File(File parent,String child):根据父路径和子路径创建一个File对象
        // 创建File对象表示test文件夹
        File parent = new File("e:\\test");
        File file2 = new File(parent,"aa.txt");
        System.out.println(file2);
    }

}

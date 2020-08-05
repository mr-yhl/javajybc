package cn.com.mryhl.demo02_file_method;

import java.io.File;

/*
File中的判断方法
    boolean isDirectory():判断是否是文件夹。
    boolean isFile():是否是一个文件
    boolean exists():判断FiLe对象表示的文件或文件夹是否存在

 */
public class demo02FileMethod {
    public static void main(String[] args) {
        // 创建File对象
        File file = new File("e:\\test\\aa.txt");
        // boolean isDirectory():判断是否是文件夹。
        System.out.println("是否是文件夹"+file.isDirectory());
        // boolean isFile():是否是一个文件
        System.out.println("是否是文件"+file.isFile());
        // boolean exists():判断FiLe对象表示的文件或文件夹是否存在
        System.out.println("是否是存在"+file.exists());
    }
}

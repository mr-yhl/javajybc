package cn.com.mryhl.demo02_file_method;
/*
创建方法
    boolean createNewFile():创建文件，如果文件已经存在，那么创建失败。
    boolean mkdir():创建文件夹，如果文件夹已经存在，那么创建失败。
    boolean mkdirs():创建文件夹，如果文件夹已经存在，那么创建失败【如果上级目录不存在，同时会创建上级目录】
*/

import java.io.File;
import java.io.IOException;

public class Demo03FileMethod {
    public static void main(String[] args) throws IOException {
        method1();
        method2();
        method3();
    }
    /*
    boolean createNewFile():创建文件，如果文件已经存在，那么创建失败。
    课创建文件，上级目录不存在，那么会报错

     */
    public static void method1() throws IOException {
        // 创建File对象
        File file = new File("e:\\test\\zz.txt");
        // 创建文件
        boolean flag = file.createNewFile();
        // 输出
        System.out.println("创建对象: " + flag);
    }
    /*
    boolean mkdir():创建文件夹，如果文件夹已经存在，那么创建失败。
    加果创建文件夹，上级目录不存在，那么会创建失败【不会报错】
    */
    public static void method2(){
        // 创建File对象
        File file = new File("e:\\test\\bb");
        // 创建文件夹
        boolean flag = file.mkdir();
        // 调用mkdir输出
        System.out.println("创建文件夹: " + flag);
    }
    /*
    boolean mkdirs():创建文件夹，如果文件夹已经存在，那么创建失败【如果上级目录不存在，同时会创建上级目录】
    使用mkdirs创建文件夹时,如果文件夹上级目录不存在,一同创建上级目录
    */
    public static void method3(){
        // 创建File对象
        File file = new File("e:\\test2\\bb");
        // 调用mkdirs创建文件夹
        boolean flag = file.mkdirs();
        // 输出
        System.out.println("创建文件夹: " + flag);

    }

}

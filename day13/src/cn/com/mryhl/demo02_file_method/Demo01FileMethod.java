package cn.com.mryhl.demo02_file_method;
/*
获取方法
    String getAbsolutePath():获取FiLe对象表示的文件或文件夹的绝对路径。
    String getPath():获取路径
    String getName():获取文件或文件夹名字
    Long Length():获取文件字节数大小，只能对文件使用，如果用过文件夹使用，得到的是一个不确定的数字。


 */


import java.io.File;

public class Demo01FileMethod {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
    }
    /*
        String getAbsolutePath():获取FiLe对象表示的文件或文件夹的绝对路径。
    */
    public static void method1(){
        // 创建file对象
        // File file = new File("e:\\test\\aa.txt");
        File file = new File("aa.txt");
        // 输出file
        System.out.println(file.getAbsolutePath());

    }
    /*
        String getpath():获取路径
    */
    public static void method2(){
        // 创建file对象
        // File file = new File("e:\\test\\aa.txt");
        File file = new File("aa.txt");
        // 调用getPath获取路径
        System.out.println(file.getPath());
    }
    /*
        String getNe():获取文件或文件夹名字
     */
    public static void method3(){
        // 创建file对象
        File file = new File("e:\\test\\aa.txt");
        //File file = new File("aa.txt");
        // 调用getName获取路径
        System.out.println(file.getName());
    }
    /*
    Long Length():获取文件字节数大小，只能对文件使用，如果用过文件夹使用，得到的是一个不确定的数字。
     */
    public static void method4(){
        // 创建file对象
        File file = new File("e:\\test\\aa.txt");
        System.out.println(file.length());
    }
}

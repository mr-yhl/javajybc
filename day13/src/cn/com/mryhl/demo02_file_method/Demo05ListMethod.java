package cn.com.mryhl.demo02_file_method;
/*
    File中用于遍历目录的方法
        (了解)String[] List():获取指定目录下所有文件和文件夹的名字放入到字符申数组中返回。
        File[] ListFiles():获取指定目录下所有文件和文件夹并放入到File数组中返回。
    注意
        如果FiLe对象表示的是一个文件，那么调用ListFiles得到的是null值。
        如果File对象表示的是一个不存在的文件夹，那么调用ListFiles得到的是null值。
        在使用ListFiles时，一定要注意，必须通过已经存在的文件夹调用该方法。
*/

import java.io.File;


public class Demo05ListMethod {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }

    public static void method3(){
        // 创建File对象
        File file = new File("e:\\test\\aa\\zz");
        // 调用ListFiles方法,获取test下的所以的文件和文件夹
        File[] files = file.listFiles();
        System.out.println(files);//null
        // 遍历会出现空指针异常

    }

    /*
    File[] ListFiles():获取指定目录下所有文件和文件夹并放入到File数组中返回。
    */
    public static void method2(){
        // 创建File对象
        File file = new File("e:\\test");
        // 调用ListFiles方法,获取test下的所以的文件和文件夹
        File[] files = file.listFiles();
        // 遍历数组,输出对象
        for (File s : files) {
            System.out.println(s);
        }
    }
    // e:\test\aa
    // e:\test\bb
    // e:\test\cc
    /*
        String[] List():获取指定目录下所有文件和文件夹的名字放入到字符申数组中返回。
    */
    public static void method1(){
        // 创建File对象
        File file = new File("e:\\test");
        // 调用list方法,获取test下的所以的文件和文件夹
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
    // aa
    // bb
    // cc

}

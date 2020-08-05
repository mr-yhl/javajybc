package cn.com.mryhl.demo08_homework.ti_digui;

import java.io.File;

// 请使用递归遍历一个多级目录，打印所有文件的“绝对路径”。
public class Demo03Dir {
    public static void main(String[] args) {
        // 调用方法,传入对象参数
        printDir(new File("f:\\tcgive"));
    }
    /*
    定义方法,遍历目录
    参数: File file
    返回值:void
    */
    public static void printDir(File file){
        // 调用listFiles方法，获取该文件夹下
        // 所有文件和文件夹放入到File数组中保存
        File[] files = file.listFiles();
        // 遍历数组
        for (File file1 : files) {
            if (file1.isDirectory())// 如果是目录
                printDir(file1);// 递归调用
            else
                System.out.println(file1.getAbsolutePath());// 打印绝对路径

        }
    }
}

package cn.com.mryhl.demo_digui;

import java.io.File;

/*
    输出指定文件夹下所有文件名
    步骤：
        1. 定义一个方法，该方法遍历指定的文件夹
        2. 调用listFiles方法，获取该文件夹下所有文件和文件夹放入到File数组中保存
        3. 遍历File数组，拿到里面的每一个文件和文件夹。
        4. 判断如果遍历到的是文件夹，那么就应该继续遍历该文件夹；
           如果遍历到的是文件，那么直接获取输出
 */
public class Demo03PrintDirtest {
    public static void main(String[] args) {
        // 调用printDir,遍历指定文件夹，输出读文件夹下所有文件的名字
        printDir(new File("e:\\文件整理"));
    }
    /*
    定义一个方法，该方法遍历指定的文件夹
     */
    public static void printDir(File dir){
        // 调用listFiles方法，获取该文件夹下
        // 所有文件和文件夹放入到File数组中保存
        File[] files = dir.listFiles();
        // 遍历File数组，拿到里面的每一个文件和文件夹。
        for (File thisFfile : files) {
            if (thisFfile.isDirectory()){
                System.out.println(thisFfile.getName());
                // 如果是文件夹，那么就应该继续遍历该文件夹；
                // 递归遍历
                printDir(thisFfile);
            }else {
                // 如果遍历到的是文件，那么直接获取输出
                System.out.println(thisFfile.getName());
                // thisFfile.delete();
            }

        }
    }
}

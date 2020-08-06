package cn.com.mryhl.demo09_commons_io;
/*
commons-io是由第三方（Apache）提供的IO流操作的工具包

如果我们要使用第三方的工具包，一般要导入jar包
jar包其实就是java的压缩包，里面保存了很多class文件。
如果导入jar包后，这个jar包中的类就都可以使用了.

导入jar包的步骤：
    1. 新建一个文件夹叫做lib
    2. 将jar包复制到lib文件夹下
    3. 点lib文件夹右键选择 Add as Library


IOUtils中的方法：
    static int copy(InputStream input, OutputStream output)：复制文件。该方法适用于2G以下的文件。
    static long	copyLarge(InputStream input, OutputStream output)复制文件。该方法适用于2G以上的文件。

FileUtils中的方法：
    static void	copyFileToDirectory(File srcFile, File destDir)：将文件(srcFile)复制到一个文件夹(destDir)中
    static void	copyDirectoryToDirectory(File srcDir, File destDir)：将一个文件夹(srcDir)复制到另一个文件夹(destDir)中
    static void	writeStringToFile(File file, String data)：向文件中写字符串数据
    static String readFileToString(File file)：从文件中读取数据，并返回读取到的内容

 */


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

public class Demo01Test {
    public static void main(String[] args) throws Exception {
        //IOUtils中的方法：
        //static int copy(InputStream input, OutputStream output)：复制文件。该方法适用于2G以下的文件。
        //IOUtils.copy(new FileInputStream("d:\\aa.png"), new FileOutputStream("d:\\bb.png"));

        //FileUtils中的方法：
        //static void copyFileToDirectory(File srcFile, File destDir)：将文件(srcFile)复制到一个文件夹(destDir)中
        //FileUtils.copyFileToDirectory(new File("d:\\aa.png"), new File("d:\\iotest"));

        //static void	copyDirectoryToDirectory(File srcDir, File destDir)：将一个文件夹(srcDir)复制到另一个文件夹(destDir)中
        //FileUtils.copyDirectoryToDirectory(new File("d:\\iotest"), new File("d:\\aaa"));

        //static void writeStringToFile(File file, String data)：向文件中写字符串数据
        //FileUtils.writeStringToFile(new File("day14\\file08.txt"), "你好");

        //static String readFileToString(File file)：从文件中读取数据，并返回读取到的内容
    }
}

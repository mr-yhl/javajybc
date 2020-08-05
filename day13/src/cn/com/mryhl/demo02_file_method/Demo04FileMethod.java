package cn.com.mryhl.demo02_file_method;
/*
删除方法
    boolean delete():删除File对象表示的文件或文件夹。

delete删除的文件夹必须是空文件【delete方法删除的内容不走回收站】

*/

import java.io.File;
public class Demo04FileMethod {
    public static void main(String[] args){
        File file = new File("e:\\test");
        // 调用delete删除文件夹
        boolean flag = file.delete();
        // 输出
        System.out.println("删除文件: " + flag);

    }



}

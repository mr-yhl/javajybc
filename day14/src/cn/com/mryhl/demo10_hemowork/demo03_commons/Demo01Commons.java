package cn.com.mryhl.demo10_hemowork.demo03_commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Demo01Commons {
    public static void main(String[] args) throws IOException {
        //FileUtils.copyFileToDirectory(new File("e:\\a.jpg"),new File("d:\\"));
        FileUtils.copyDirectoryToDirectory(new File("e:\\临时文件"),new File("d:\\"));
    }
}

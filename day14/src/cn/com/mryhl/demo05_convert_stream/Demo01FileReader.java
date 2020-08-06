package cn.com.mryhl.demo05_convert_stream;
/*
使用FiLeReader读取GBK文件的内容
FiLeReader会使用idea的歌认编码UTF-8的方式进行渎取,此时文件的编码是GBK,两种编码不一致,
开是就产生了问题
如采要指定编码进行渎取,那么可以使转换流去做
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        // 创建字符输入流对象
        Reader r = new FileReader("e:\\a.txt");
        // 进行读取,一次一字符
        int i;
        while ((i = r.read())!=-1){
            System.out.print((char) i);
        }
        r.close();
    }

}

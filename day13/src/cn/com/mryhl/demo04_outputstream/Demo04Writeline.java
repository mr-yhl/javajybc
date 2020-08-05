package cn.com.mryhl.demo04_outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
    换行写

如果要进行换行操作,需要使用换行符
win:\r\n
mac:\r


 */
public class Demo04Writeline {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流
        OutputStream os = new FileOutputStream("day13\\aa.txt");
        // 像文件写一首诗
        os.write("大风起兮云飞扬\r\n".getBytes());
        os.write("安得猛士兮守四方\n".getBytes());// 老版本系统可能不能识别
        os.write("威加海内兮归故乡".getBytes());
        os.close();
    }
}

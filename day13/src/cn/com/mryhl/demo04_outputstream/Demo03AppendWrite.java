package cn.com.mryhl.demo04_outputstream;
/*

续写,追加写

我们之前使用的构造方法创建流的同时会新建文件，如果文件已经存在会便盖
FileOutputstream(String name):该构造方法会创建文件，如果文件已经存在会厦盖掉原来的文件
如果创建流时不想要盖原来文件，可以使用下面的构造方法
FileOutputstream(String name,booLean append):第二个参数append表示是否续写，如果true,为续写，如果文件已经存在，就不会履盖了
FileOutputstream(File file, boolean apmend):第二个参数append表示是否续写，如果true,为续写，如果文件已经存在，就不会履盖了

 */



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo03AppendWrite {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流
        OutputStream os = new FileOutputStream("day13\\aa.txt",true);
        // 像文件写一首诗
        // os.write("大风起兮云飞扬".getBytes());
        os.write(" 安得猛士兮守四方".getBytes());
        // 关闭流
        os.close();

    }
}

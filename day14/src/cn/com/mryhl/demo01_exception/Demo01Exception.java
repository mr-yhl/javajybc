package cn.com.mryhl.demo01_exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
JDK7之前的IO流异常处理

*/
public class Demo01Exception {
    public static void main(String[] args) {
        Writer w = null;
        try {
            //必须流对象创建成功，那么我们才需要释放资源.
            //如果流对象创建成功了，那么w的值不是null
            // 创建字符输出流
            w = new FileWriter("day14\\file01.txt");
            // 写数据
            w.write("你好");


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //关闭
                // 判断w不是null,表示流成功创建,关闭流
                if (w != null)
                    w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

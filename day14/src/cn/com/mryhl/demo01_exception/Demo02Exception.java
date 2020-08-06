package cn.com.mryhl.demo01_exception;
/*
在JDK7的时候，多了一种try...with...resource语句，可以快捷的处理io流中的异常以及施放资源的问题。
格式：
    try(创建流对象的代码）{

    }catch(类名变量名）{

    }

在try小括号中创建的流对象，只要流对象创建出来了，背定会【自动】调用close方法，关闭流。
小括号中也可以创建多个对象，多个对象之间用分号隔开。
 */


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02Exception {
    public static void main(String[] args){
        // 小括号中创建的对象,在try...catch操作完成后,自动调用close
        try(Writer w = new FileWriter("day14\\file02.txt")){
            // 写数据
            w.write("你好");
        }catch (IOException e){

        }




    }
}

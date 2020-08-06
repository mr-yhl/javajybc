package cn.com.mryhl.demo06_objectstream;
/*
ObjectInputStream是反序列化流，可以将文件中的对象读取到Java程序中。

ObjectInputStream构造方法：
    ObjectInputStream(InputStream in):参数要传递一个字节输入流。

objectInputStream读取对象的方法【特有方法】：
    object readObject():从文件中读取对象。


ObjectInputStream使用步骤：
    1.创建流
    2.读对象
    3.关闭流

注意：如果使用反序列化流读取数据，如果读取的对象所属的类不存在，那么会报错。
 */


import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Demo02ObjectInputStream {
    public static void main(String[] args) throws Exception {
        // 1.创建流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\file04.txt"));
        // 2.读对象

        Object o = ois.readObject();
        System.out.println(o);
        // 3.关闭流
        ois.close();
    }
}

package cn.com.mryhl.demo06_objectstream;
/*
ObjectOutputStream是序列化流，可以将Java程序中的对象写到文件中。

ObjectOutputStream构造方法：
    ObjectOutputStream(OutputStream out):参数要传递字节输出流。

ObjectOutputStream写对象的方法【特有方法】
    void writeObject(object obj):向文件中写对象。

ObjectOutputStream使用步骤：
    1.创建流
    2.写对象
    3.关闭流
要使用序列化流向文件中写的对象，必须要实现Serializable接口，否则就会抛出NotSerializableException异常

 */


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws Exception {
        // 1.创建流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\file04.txt"));
        // 2.写对象
        Person p = new Person("东关定", 23);
        oos.writeObject(p);
        // 3.关闭流
        oos.close();
    }
}

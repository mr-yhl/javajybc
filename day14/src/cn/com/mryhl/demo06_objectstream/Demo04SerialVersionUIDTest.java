package cn.com.mryhl.demo06_objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo04SerialVersionUIDTest {
    public static void main(String[] args) throws Exception {
        //writePerson();
        readPerson();
    }
    /*
    定义方法,读取
     */
    public static void readPerson() throws Exception{
        // 1.创建流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\d5.txt"));
        // 2.读对象

        Object o = ois.readObject();
        System.out.println(o);
        // 3.关闭流
        ois.close();
    }
    /*
    定义方法.写对象
     */
    public  static void writePerson() throws Exception {
        // 创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\d5.txt"));
        // 2.写对象
        Person p = new Person("东关定", 23);
        oos.writeObject(p);
        // 3.关闭流
        oos.close();


    }
}

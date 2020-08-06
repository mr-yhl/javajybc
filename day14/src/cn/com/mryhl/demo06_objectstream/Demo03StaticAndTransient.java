package cn.com.mryhl.demo06_objectstream;
/*
 序列化中的static和transient
    1. static修饰的成员变量无法序列化,static修饰的变量属于类，不属于对象，而序列化向文件中写的是对象。
    2. 如果我们不想某个属性被序列化，同时又不想使用static关键字。那么可以使用transient关键字,transient叫做
        瞬态，被transient修饰的属性无法被序列化。


 */



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo03StaticAndTransient {
    public static void main(String[] args) throws Exception {
        writePerson();
        //readPerson();
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

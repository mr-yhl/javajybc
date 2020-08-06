package cn.com.mryhl.demo06_objectstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*

要求：
    1.将存有多个学生对象的集合序列化操作，保存到List.txt文件中。
    2.反序列化List.txt,并遍历集合，打印对象信息
步骤:
    1.创建集合，用来保存学生
    2.添加三个学生
    3.创建ObjectOutputStream序列化流，用来写对象
    4.调用write方法，将集合写到文件中
    5.释放资源
    6.创建objectInputStream反序列化流，用来读
    7.调用readObject方法读取对象
    8.释放资源
    9.遍历读取到的集合对象，输出里面的信息
向文件中写集合时，集合的泛型类型也必须实现Serializable接口
 */
public class Demo05Test {
    public static void main(String[] args) throws Exception {
        //1. 创建集合
        List<Student> list = new ArrayList<>();
        //2. 向集合中添加学生对象
        list.add(new Student("东关", 18));
        list.add(new Student("何塞荡", 19));
        list.add(new Student("舒代达", 20));
        //3. 创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\list.txt"));
        //4. 将集合对象写到文件中。
        oos.writeObject(list);
        //5. 释放资源。
        oos.close();
        //6. 创建objectInputStream反序列化流，用来读
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\list.txt"));
        //7. 从文件中读取集合对象。
        List<Student> list2 = (List<Student>) ois.readObject();
        //8. 关流
        ois.close();
        //9. 遍历集合，输出集合中的每一个学生对象
        for (Student stu : list2) {
            System.out.println(stu);
        }
    }
}

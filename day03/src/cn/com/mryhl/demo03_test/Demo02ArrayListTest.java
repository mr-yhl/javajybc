package cn.com.mryhl.demo03_test;
/*
使用集合保存Student对象,并遍历
 */
import java.util.ArrayList;

public class Demo02ArrayListTest {
    public static void main(String[] args) {
        // 创建一个集合,保存学生
        ArrayList<Student> list = new ArrayList<>();
        // 创建学生对象
        Student student0 = new Student("张三", 23);
        Student student1 = new Student("张四", 24);
        Student student2 = new Student("张五", 25);
        //将三个学生对象添加到集合,添加的是对象的地址
        list.add(student0);
        list.add(student1);
        list.add(student2);
        //遍历集合,输出对象的姓名年龄
        System.out.println(list);//输出的是地址
        //[cn.com.mryhl.demo03_test.Student@1b6d3586,
        // cn.com.mryhl.demo03_test.Student@4554617c,
        // cn.com.mryhl.demo03_test.Student@74a14482]
        for (int i = 0; i < list.size(); i++) {
            System.out.println("学生的姓名为" + list.get(i).getName() + ",学生的年龄为:" + list.get(i).getAge());
        }

    }
}

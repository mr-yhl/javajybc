package cn.com.mryhl.demo05_test;

import java.util.HashSet;
import java.util.Set;

/*


创建一个HashSet集合，向集合中添加学生对象
如果学生对象的姓名和年龄完全相同，就看成是同一个对象

HashSet判断唯一性的过程
1.先比较两个对象的哈希信
如果哈希值不同，肯定是不同的对象。
如果哈希值相同，不一定是相同的付象。

2.如果哈希值相同，还需要使用equals方法进行比较。
如果equals的结果是true,表示两个对象相同
如果equals的结果是false,表示两个对象不同

结论
如果HashSet存储自定义的数据并保证唯一性（属性相同就看成是同一个对象）,需要同时重写hashCode 和equals


 */
public class Demo01Test {

    public static void main(String[] args) {
        //创建HashSet集合
        Set<Student> set = new HashSet<>();
        set.add(new Student("丁萨关",25));
        set.add(new Student("席冀燎",24));
        set.add(new Student("郑耒",27));

        //添加学生
        set.add(new Student("丁萨关",25));
        // 遍历
        for (Student student : set) {
            System.out.println(student);
        }
     }
}

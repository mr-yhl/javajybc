package cn.com.mryhl.demo07_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
练习：每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，则将学生对象和家庭住
         址存储到map集合中。学生作为键, 家庭住址作为值。
    注意，学生姓名相同并且年龄相同视为同一名学生。因为HashSet内部就是在使用HashMap保存数据。


    HaspMap保证唯一性的过程和HashSet一模一样.

    判断唯一性的方式：
        1. 先比较两个对象的哈希值。
            如果对象的哈希值不同，肯定是不同的对象。
            如果对象的哈希值相同，不一定是同一个对象。
        2. 然后比较两个对象的equals方法
            如果equals方法结果是true，表示两个对象相同。
            如果equals方法结果是false，表示两个对象不同。

    如果HashMap要保证键的唯一性（属性相同就看成是同一个对象），需要同时重写hashCode和equals方法

 */
public class Demo04MapTest {
    public static void main(String[] args) {
        // 创建集合
        Map<Student, String> map = new HashMap<>();
        // 添加元素
        map.put(new Student("东关煞",25),"德国大使馆");
        map.put(new Student("舒定",35),"VS公司");
        map.put(new Student("沙嘏",47),"流沙河2号街");
        // 再添加一个
        map.put(new Student("沙嘏",47),"流沙河3号街");

        //遍历集合

        Set<Student> keySet = map.keySet();
        // 遍历Set集合,拿到键
        for (Student student : keySet) {
            // 根据键获map的值
            String s = map.get(student);
            System.out.println(student + "-----" + s);
        }
        /*
            Person{name='沙嘏', age=47}-----流沙河2号街
            Person{name='舒定', age=35}-----VS公司
            Person{name='东关煞', age=25}-----德国大使馆
            Person{name='沙嘏', age=47}-----流沙河3号街
         */
        // 在Student重写了两个方法后的结果
        /*
        Person{name='东关煞', age=25}-----德国大使馆
        Person{name='舒定', age=35}-----VS公司
        Person{name='沙嘏', age=47}-----流沙河3号街

        */
    }
}

package cn.com.mryhl.demo03_foreach;
/*
使用增强for遍历集合
增强for格式：
for(数据类型变量名：容器）(
)

增强for优缺点:
    优点:里面省去了索引的操作,写法简洁
    缺点:无法在遍历的过程中操作索引，所以如果要在遍历的过程中操作索引的话，还需要使用普通for循环。
 */

import java.util.ArrayList;
import java.util.Collection;

public class Demo02Foreach {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();
        //添加元素
        c.add("hello");
        c.add("word");
        c.add("java");

        for (String str:c)
            System.out.println(str);
        System.out.println("========================");
        // 创建集合,保存Person
        Collection<Person> c2 = new ArrayList<>();
        c2.add(new Person("冯寒抗",32));
        c2.add(new Person("舒凤",32));
        c2.add(new Person("龚定",32));

        for (Person person:c2)
            System.out.println(person);
    }
}

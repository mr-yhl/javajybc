package cn.com.mryhl.demo07_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
使用比较器排序对Person对象根据年龄排序
 */
public class Demo03Collection {
    public static void main(String[] args) {
        //创建集合
        List<Person> list = new ArrayList<>();
        //添加Person对象
        list.add(new Person("公孙嘏", 20));
        list.add(new Person("郑等待", 18));
        list.add(new Person("丁巴寿", 22));
        //使用比较器排序（对集合中的Person对象按照年龄从小到大的顺序排序）
        //单独定义Comparator实现类，然后创建实现类对象。
        Collections.sort(list, new Rule());

        //使用匿名内部类完成比较器排序

        /*Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/


        /*
            (参数类型 参数名) -> {
                方法体;
                return 返回值;
            }
         */
        //使用Lambda表达式完成比较器排序

        Collections.sort(list, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });


        //使用Lambda表达式省略格式完成比较器排序
        //Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());


        //输出结果
        System.out.println(list);
    }
}

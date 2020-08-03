package cn.com.mryhl.demo01_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
自然排序
static void sort(List list):对集合中的内容进行排序【自然排序】
如果想要使用上面的sort方法进行自然排序，那么必须保证该事物本身就具备比较的功能。
如果某个类实现了Comparable接口，那么就表示该事物具备比较的功能，那么才可以使用自然排序的方式进行排序。
注意：【要使用自然排序的集合，里面的泛型必须要实现Comparable接口】
 小结
    自然排序指的是事物本身就具备比较的功能，那么我们可以使用sort方法直接进行排序。
    这个事物必须实现Comparable接口才表示具备了比较的功能，才可以使用自然排序。
    实现Comparable后要重写compareTo方法，公式：升序就是我减他
 */
public class Demo02Collections {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(172);
        integerList.add(145);
        integerList.add(153);
        // 排序
        Collections.sort(integerList);
        System.out.println(integerList);
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("aa");
        list.add("cc");
        list.add("dd");
        list.add("bb");
        // 排序
        Collections.sort(list);
        System.out.println(list);

        List<Person> p = new ArrayList<>();
        p.add(new Person("公孙萨关",29));
        p.add(new Person("匡茶胜",35));
        p.add(new Person("东关飒关",23));
        p.add(new Person("鄂盖协",25));

        Collections.sort(p);
        System.out.println(p);

    }
}

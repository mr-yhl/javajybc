package cn.com.mryhl.demo06_setother;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
TreeSet也是Set接口下的实现类。
TreeSet内部是二叉树，TreeSet可以自动对集合中的内容进行排序。
构造方法：
TreeSet():空参构造方法创建的TreeSet集合会使用自然排序的方式对集合中的元素进行排序。
TreeSet(Comparator comparator):参数需要传递一个比较器，会使用比较器的方式对集合中的内容进行排序

 */
public class Demo02TreeSet {
    public static void main(String[] args) {
        //创建TreeSet集合，使用自然排序的方式进行排序。
        //Set<Integer>set=new TreeSet<>();
        //创建TreeSet集合，传递比较器，使用比较器的方式进行排序[降序]
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            /*
            在compare方法中定义比较规则。
            公式：升序是一减二，降序就是二减一
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        set.add(5);
        set.add(23);
        set.add(673);
        set.add(352);
        set.add(743);
        // TreeSet可以自动对集合中的内容进行排序。
        System.out.println(set);


    }
}

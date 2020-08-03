package cn.com.mryhl.demo01_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
static void sort(List List, Comparator c):对集合中的内容进行排序,第一个参数是集合，第二个参数是比较器[比较器排序]
假如某个类没有实现Comparable接口，就表示该事物不具备比较的功能，那么我们就不能直接对他进行排序了。

如果事物不具备比较的功能，那么我们也可以找一个法官来帮他们比较对象，这个法官就是比较器。
Comparator是一个接口，该接口表示比较器。如果参数是接口，我们需要传递实现类对象，这个实现类需要我们自己创建。

自然排序：如果某个类实现广Comparable接口，那么表示该事物具备了比较的功能，那么可以直接使用sort方法进行排序，
这种排序方式叫做自然排序
比较器排序：我们也可以找一个法官来帮这些对象进行排序，这种排序方式是比较器排序。如果要进行比较器排序，我们
要定义一个类，实现Comparator接口，然后重写compare方法，再调用Collections的sort方法，传递集合和比较器即
 */
public class Demo03Collections {
    public static void main(String[] args) {
        // 创建集合
        List<Student> list = new ArrayList<>();
        // 添加元素
        list.add(new Student("荆飒潮",75));
        list.add(new Student("鄂凤",26));
        list.add(new Student("匡再笛",45));


        //Collections.sort(list,new Rule());
        Collections.sort(list,new Comparator<Student>(){

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);
        /*
        [Person{name='鄂凤', age=26}, Person{name='匡再笛', age=45}, Person{name='荆飒潮', age=75}]
         */
    }
}

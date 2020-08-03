<center>Collections、Set、Map、斗地主排序</center>

## 今日内容

+ Collections
  + shuffle
  + sort自然排序
  + 比较器排序
  + 可变参数[重]
  + addall方法
+ Set接口
  + hashCode
  + 哈希表
  + 其他集合
+ map集合(双列集合)
  + keySet()
  + entrySet()



## 第一章Collections

### 1.shuffle打乱顺序

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Collections是操作集合的工具类。
static void shuffle(List<?>List):打乱集合中元素的顺序。


 */
public class Demo01Collections {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        // 调用shuffle方法
        Collections.shuffle(list);
        // 打印
        System.out.println(list);
        // 运行结果
        //[aa, dd, cc, bb]
    }
}
```

### 2.sort自然排序

```java
// 实现类
public class Person implements Comparable<Person>{
    private String name;
    private int age;
    // 重写了Comparable的抽象方法
    /*

        使用自然排序时，内部会自动调用compareTo方法比较两个对象谁打谁小
        在使用自然排序时，内部会自动调用compareTo方法比较两个对象谁打谁小
        如果方法的返回值是正数，表示调用者对象大于参数对象
        如果方法的返回值是，相等
        如果方法的返回值是负数，表示调用者小于参数对象
        我们要做的是在compareTo定义排序规则。
        公式：升序就是我（调用者）减他（参数）。
        想要根据对象的什么属性进行排序，就让什么属性相减。
    */
    @Override
    public int compareTo(Person o) {
        // 根据age升序

        return this.age-o.age;
    }
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
// 测试类
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
/*
[145, 153, 172]
[aa, bb, cc, dd]
[Person{name='东关飒关', age=23}, Person{name='鄂盖协', age=25}, Person{name='公孙萨关', age=29}, Person{name='匡茶胜', age=35}]
*/
```

### 3.比较器排序

+ 学生类

```java
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

+ 比较器实现类

```java
import java.util.Comparator;
/*
Comparator
Tomparator这个接口表示比较器，当我们使用Rule类实现了这个接口，Rule表示也就是比较器。
*/
public class Rule implements Comparator<Student> {
    /*
    compare会在比较器排序时由系统自动调用,作用是比较两个对象谁大谁小

    如果方法的返回值是正数，表示第一个参数对象大于第二个参数对象（01大于02)
    如果方法的返回值是，表示两者相等
    如果方法的返回值是负数，表示第一个参数对象小于第二个参数对象（01小于02)

    公式：升序就是一减二
想要根据什么属性排序，就让什么属性相减
    */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}
```

+ 测试类

```java
import java.util.ArrayList;
import java.util.Collections;
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


        Collections.sort(list,new Rule());
        System.out.println(list);
    }
}

//结果
/*
[Person{name='鄂凤', age=26}, Person{name='匡再笛', age=45}, Person{name='荆飒潮', age=75}]
*/
```

### 4.可变参数

```java
/*
在JDK5的时候，多了一个新特性，叫做可变参数。
可变参数的方法可以在参数位置传递任意个数据
可变参数的格式：
    修饰符返回值类型方法名（参数类型... 参数名）{
    ...
    }
    1.在调用带有可变参数的方法时，我们可以向可变参数位置传递任意个数据
    2.可变参数的本质是数组,所以我们将可变参数当成数组.
    3.因为可变参数本质是数组，所以在调用可变参数的方法时，也可以传递数组

注意事项:
    1.一个方法中最多只能有一个可变参数
    2.可变参数必须放在最后一个位置
    
*/
public class Demo01Params {
    public static void main(String[] args) {
        /*int[] arr = {1,2,4,54,3,242,4};
        System.out.println(getSum(arr));*/
        int sum = getSum(1, 2,3,4,5);
        System.out.println(sum);
        int[] arr = {1,2,4,54,3,242,4};
        // 传递数组
        System.out.println(getSum(arr));

    }
    /*public static int getSum2(int... nums,int... b){}*/
   /* public static int getSum2(int b, int... nums){}*/
    /*
    定义一个方法,该方法可以求任意个整数和
    */
    public static int getSum(int... nums){
        int sum=0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
    /*
    定义一个方法,该方法可以求任意个整数和
        参数:int[]
        返回值:int
     */
    /*public static int getSum(int[] arr){
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }*/


}
//15
//310
```

### 5.Collections的addall方法

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
在Collections中有一个方法叫做addALL,可以向集合中批量添加数据
static boolean addALL(Collection c,T...elements):批量添加数据
C:表示向哪个集合中添加数据
elements:可变参数，可以传递任意个数据。表示要向集合中添加哪些数据。
*/
public class Demo04Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        Collections.addAll(list,"aa","bb0","cc");
        System.out.println(list);

    }
}
/*
[hello, world, java]
[hello, world, java, aa, bb0, cc]
*/
```

## 第二章 Set接口

### 1.简介

```java
    /*
Set是Collection下面的另一个子接口。
Set接口有以下特点
    1.无序（按照什么顺序存，不一定按照什么顺序取）
    2.无素引（不可以根据索引操作元素）
    3.不可重复（里面不能保存重复元素）
Set是一个接口，如果要用，需要使用实现类，Set接口下面最常用的实现类是Hashset.
Hashset满足Set的所有特点.

 */
public class Demo01Set {
    public static void main(String[] args) {
        // 创建集合
        Set<String> set = new HashSet<>();
        // 添加元素
        set.add("冯萨关");
        set.add("别词");
        set.add("公孙嘏");
        set.add("舒嘏");
        set.add("匡冀燎");
        //无序
        // 输出
        System.out.println(set);//[冯萨关, 别词, 舒嘏, 匡冀燎, 公孙嘏]
        // System.out.println(set.get(1));//无索引
        //set.add("匡冀燎");//不可重复

    }
}
import java.util.HashSet;
import java.util.Set;

/*
set集合是没有索引的，如果要着历Set集合，需要使用送代器或者增强for遵历，强烈推荐增强for

HashSet是Set接口下面最常用的实现类，HashSet内部是在使用哈希表保存数据。
 */
public class Demo02Set {
    public static void main(String[] args) {
        // 创建集合
        Set<String> set = new HashSet<>();
        // 添加元素
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("php");
       // 遍历
        for (String str : set) {
            System.out.println(str);
        }
    }
}
//运行结果
/*
world
java
php
hello
*/
```

### 2.hashCode获取哈希值

```java
public class Person {
    private String name;
    private int age;
    /*
    重写hashCode方法，自己定义哈希值的计算规则
    根号姓名和年龄计算哈希值，如对象的姓名和年龄相同，得到的哈希值也应该相同。

     */
    /*@Override
    public int hashCode() {
        // 获取姓名的哈希值再加上年龄就是对象的哈希值
        return this.name.hashCode()*31+age;
        // ×31是为了减少重复的可能性(31是科学计算的结果)
    }*/
    /*
    D1=new Person("张三",13);
    p2=new Person("李四",12);
    "张三",3      16
    "李四",4      16
     */


    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
/*
哈希值就是一个int数字，我们可以把哈希值看成对象的标识，特征码
在object中，有一个方法叫做hashCode,可以获取对象的哈希值

int hashCode():获取对象的哈希值

Object中的hashCode方法，是根据对象的地址值计算获取的哈希值。

一般情况下，根据地址值计算哈希值，意义不大，更多的我们是希望根据属性值计算哈希值，如果两个对象的属性完全一样，那么他们的哈希值也应该相同.

如果要想自己定义哈希值的计算规则，我们可以对hashCode方法进行重写.

哈希值是对象的一个标识，但并不是唯一的标识，对象的哈希值允许重复。

 */

public class Demo01HashCode {
    public static void main(String[] args) {
        // 创建对象
        Person p = new Person("东方萨关",25);
        System.out.println(p.hashCode());
        Person p2 = new Person("东方萨关",25);
        System.out.println(p2.hashCode());

    }
}
//2095803121
//2095803121
```

### 3.哈希表

在JDK1.8之前，哈希表底层采用数组+链表实现，即使用数组处理冲突，同一hash值的链表都存储在一个数组里。 但是当位于一个桶中的元素较多，即hash值相等的元素较多时，通过key值依次查找的效率较低。而JDK1.8中，哈 希表存储采用数组+链表+红黑树实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。

简单的来说，哈希表是由数组+链表+红黑树（JDK1.8增加了红黑树部分）实现的.JDK1.8引入红黑树大程度优化了HashMap的性能，那么对于我们来讲保证HashSet集合元素的唯一， 其实就是根据对象的hashCode和equals方法来决定的。如果我们往集合中存放自定义的对象，那么保证其唯一，就必须复写hashCode和equals方法建立属于当前对象的比较方式。

### 4.其他集合

#### 4.1LinkedHashSet

```java
import java.util.LinkedHashSet;
import java.util.Set;

/*
LinkedHashSet也是Set接口下的实现类
LinkedList内部除了有一个哈希表之外，还有一个链表。
链表的作用是保证有序。
LinkedList是有序的。
Set接口是无序的，但是他不能保证所有的实现类都无序。

 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建LinkedHashSet集合
        Set<String> set =new LinkedHashSet<>();

        set.add("冯萨关");
        set.add("别词");
        set.add("公孙嘏");
        set.add("舒嘏");
        set.add("匡冀燎");

        // 有序输出
        System.out.println(set);//[冯萨关, 别词, 公孙嘏, 舒嘏, 匡冀燎]
    }
}
```

#### 4.2TreeSet



```java
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
        System.out.println(set);//[743, 673, 352, 23, 5]


    }
}
```



## 第三章 Map集合(双列集合)

### 1.简介

双列集合()
双列集合中的每个元素都是由两部分组成，一部分是键（key),另一部分是值（value)

一个键对应一个值

Collection 中的集合，元素是孤立存在的（理解为单身），向集合中存储元素采用一个个元素的方式存 储。

 Map 中的集合，元素是成对存在的(理解为夫妻)。每个元素由键与值两部分组成，通过键可以找对所对应的 值。 

Collection 中的集合称为单列集合， Map 中的集合称为双列集合。

需要注意的是， Map 中的集合不能包含重复的键，值可以重复；每个键只能对应一个值。

Map集合也叫做双列集合
Map是一个接口，所有的双列集合都实现了这个接
口，所以我们就把Map集合称为双列集合。Map是一
个接口，如果要用，需要使用实现类，Map接口下面
最常用的实现类是HashMap.
双列集合中每一个元素都是由键和值组成的。
一个键对应（映射）一个值
我们可以根据键找到对应的值

键是不允许重复的,值可以重复.

### 2.Map下的常用方法

```java
import java.util.HashMap;
import java.util.Map;

/*
Map是一个接口，所有的双列集合都会实现该接口。
双列集合中每一个元素都有两部分组成，分别是键和值。

Map<K,V>有两个泛型，K表示键的数据类型，V表示值的数据类型。
Map里的方法:
    (常用)V put(K key, V value)：向Map集合中添加元素。key表示键，value表示值。 在调用put方法添加元素时，如果该键已经存在，那么会使用新的值覆盖掉原来的值。
    (常用)V get(Object key)：根据键获取对应的值并返回。
    V remove(Object key)：根据键删除整个的元素(键值对)。返回被删除的元素的值。
    boolean containsKey(Object key)：判断Map集合中是否包含指定的键。

    Map是一个接口，如果要用，需要使用实现类，最常用的实现类是HashMap
 */
public class Demo01Map {
    public static void main(String[] args) {
        // 创建一个双列集合(Map集合),键保存编号,值保存人名
        Map<Integer,String> map = new HashMap<>();
        // 添加键值对,put(K key, V value)
        map.put(100,"东关狐");//返回值是null,存在则返回被替换的值
        map.put(200,"匡溪");
        map.put(300,"上官煞");
        map.put(400,"郑耒");
        //输出map集合
        System.out.println(map);
        // {400=郑耒, 100=东关狐, 200=匡溪, 300=上官煞}
        String put1 = map.put(400, "柯法凤");
        System.out.println(put1);// 郑耒
        System.out.println(map);// {400=柯法凤, 100=东关狐, 200=匡溪, 300=上官煞}
        //System.out.println(map);// 键不能重复,用新的值覆盖原值
        // {400=柯法凤, 100=东关狐, 200=匡溪, 300=上官煞}
        // get(Object key)：根据键获取对应的值并返回
        System.out.println("获取键是100的值" + map.get(100));//获取键是100的值东关狐
        System.out.println("获取键是300的值" + map.get(300));//获取键是300的值上官煞
        System.out.println("获取键是10000的值" + map.get(10000));//获取键是10000的值null
        // remove(Object key)：根据键删除整个的元素(键值对)。
        String remove = map.remove(100);
        System.out.println("删除的元素值是:" + remove + ",删除后的集合" + map);
        // 删除的元素值是:东关狐,删除后的集合{400=柯法凤, 200=匡溪, 300=上官煞}

        // containsKey(Object key)：判断Map集合中是否包含指定的键。
        boolean b = map.containsKey(200);
        System.out.println("map中是否存在200的键" + b);//map中是否存在200的键true


        System.out.println("map中是否存在2000的键" + map.containsKey(2000));//map中是否存在2000的键false

        // containsValue("匡溪")
        System.out.println(map.containsValue("匡溪"));// true


    }
```

### 3.Map的遍历

```java
/*

Map集合不能直接通过送代器或者增强for遍历
如果要遍历Map集合，我们可以先获取到Map集合中所有的键，将所有的键放在set集合中,遍历set集合.
拿到set集合中的键,根据键获取对应的值.

Map中获取所有键的方法:
  Set<K> keySet():可以获取到所有的键，并将所有的键放入到Set集合中返回 .
KeySet遍历步骤:
    1. 调用Map集合的keySet方法获取到所有的键，然后放入到Set集合中。
    2. 遍历Set集合，拿到里面的每一个键。
    3. 调用Map集合的get方法，根据键获取对应的值。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo02KeySet {
    public static void main(String[] args) {
        // 创建集合
        Map<String, String> map = new HashMap<>();
        // 添加元素
        map.put("it001","龚大索");
        map.put("it002","严勃");
        map.put("it003","欧安");
        map.put("it004","讽德郭");
        //  调用Map集合的keySet方法获取到所有的键，然后放入到Set集合中。
        Set<String> keys = map.keySet();
        //遍历set集合,拿到key值
        for (String key : keys) {
            //根据遍历到的继获取对应的值【变量key表示每一个键】
            String s = map.get(key);
            System.out.println(key + "-" + s);
            /*
            it004-讽德郭
            it003-欧安
            it002-严勃
            it001-龚大索
             */
            // System.out.println(key);
            /*
            it004
            it003
            it002
            it001
             */
        }

    }
}
```

### 4.Map键值对的遍历

Map集合中每一个
键和每一个值共同
组成一个Entry对象
Entry对象也称为键值对对象

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Map集合也可以通过Entry对象的方式进行遍历。
Map集合有很多键值对，每一个键值对其实就是一个Entry对象。

我们可以先获取到所有的Entry对象，把所有的Entry放到Set集合，然后遍历Set集合，拿到每一个Entry。
然后根据Entry对象获取键和值。

Map中的获取Entry对象的方法
    Set<Map.Entry<K,V>> entrySet():获取所有的Entry对象，并放入到Set集合中返回。

Entry是Map中的内部接口，所以在使用时，要加上外部接口名也就是Map.Entry
Entry表示键值对对象,里面有获取键和值的方法
    K getkey():获取Entry中的键
    V getValue():获取Entry中的值

Entry对象的遍历步骤:
    1. 调用Map集合的entrySet方法获取到所有的Entry对象并放入到Set集合中返回
    2. 遍历Set集合，拿到里面的每一个Entry对象
    3. 调用Entry对象的getKey和getValue获取到键和值


    Map集合有两种遍历方式
        keySet方式(键找值)【推荐】
        entrySet方式(键值对)
 */
public class Demo03EntrySet {
    public static void main(String[] args) {
        //创建集合
        Map<String, String> map = new HashMap<>();
        //添加元素
        map.put("it001", "龚煞");
        map.put("it002", "少室嘏");
        map.put("it003", "席巴寿");
        //开始遍历
        // 1. 调用Map集合的entrySet方法获取到所有的Entry对象并放入到Set集合中返回
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 2. 遍历Set集合，拿到里面的每一个Entry对象
        for (Map.Entry<String, String> entry : entries) {
            // 3. 调用Entry对象的getKey和getValue获取到键和值
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        /*
        it003-席巴寿
        it002-少室嘏
        it001-龚煞
        */
    }
}
```

### 5.HashMap

```java
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
```

### 6.LinkedHashMap

```java
import java.util.LinkedHashMap;
import java.util.Map;

/*

LinkedHashMap也是一个双列集合
里面采用的哈希表加链表的结构。
链表的作用是保证有序，LinkedHashMap是有序的
 */
public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new LinkedHashMap<>();

        map.put("it001", "张三");
        map.put("it002", "李四");
        map.put("it003", "王叔叔");

        System.out.println(map);// {it001=张三, it002=李四, it003=王叔叔}
    }
}
```

### 7.TreeMap

```java
/*
TreeMap也是一个双列集合，
内部是一个二叉树，可以对键进行排序。

 构造方法：
        TreeMap()：根据键进行自然排序
        TreeMap(Comparator comparator)：根据键进行比较器排序。参数是比较器对象


 */

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Demo06TreeMap {
    public static void main(String[] args) {
        //创建Map集合
        //TreeMap()：根据键进行自然排序
        //Map<Integer, String> map = new TreeMap<>();

        //TreeMap(Comparator comparator)：根据键进行比较器排序。参数是比较器对象
        Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序就是一减二，降序就是二减一
                return o2 - o1;
            }
        });
        map.put(200, "张三");
        map.put(100, "李四");
        map.put(300, "王叔叔");

        System.out.println(map);


    }
}
```

### 8.综合练习

```java
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
练习：键盘录入一个字符串，统计该字符串中每一个字符出现的次数

    举例： 键盘录入了aabbbc   a:2 b:3 c:1

    思路：
        1. 键盘录入一个字符串。
        2. 定义Map集合当做计数器，key是字符，value是该字符出现的次数
        3. 遍历字符串，拿到字符串中的每一个字符。
        4. 判断遍历到的字符在Map集合中是否存在。
           如果Map集合中包含该字符，说明之前统计过，那么获取该字符出现的次数，将次数加1，重新放回到集合中。
           如果Map集合中不包含该字符，说明之前没有统计过，那么就将该字符添加到Map集合中，将次数设置为1.

        5. 遍历Map集合，输出结果
 */
public class Demo07Test {
    public static void main(String[] args) {
        // 1. 键盘录入一个字符串。
        Scanner sc = new Scanner(System.in);
        System.out.println("亲输入一个要统计的字符串");
        String s = sc.nextLine();
        // 2. 定义Map集合当做计数器，key是字符，value是该字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        // 3. 遍历字符串，拿到字符串中的每一个字符。
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 判断遍历到的字符在Map集合中是否存在。
            /*if (map.containsKey(ch)) {
                // 如果Map集合中包含该字符，说明之前统计过，那么获取该字符出现的次数，将次数加1，重新放回到集合中。
                Integer integer = map.get(ch);
                map.put(ch,integer+1);
            }else {
                // 如果Map集合中不包含该字符，说明之前没有统计过，那么就将该字符添加到Map集合中，将次数设置为1.
                map.put(ch,1);

            }*/
            // 三元运算符
            map.put(ch,map.containsKey(ch)?map.get(ch)+1:1);
        }
        // 遍历输出
        // 获取Map集合中所有的键
        Set<Character> keySet = map.keySet();
        for (Character character : keySet) {
            Integer count = map.get(character);
            System.out.println(character + ":" + count);

        }
    }
}
```

## 第四章 集合嵌套

```java
import java.util.ArrayList;
import java.util.List;

/*
假如有两个班的学生姓名，它们分别存储在两个集合中
在把这两个集合放到一个集合中
 */
public class Demo01Test {
    public static void main(String[] args) {
        //第一个班
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("丁萨关");
        list1.add("丁煞");
        list1.add("别煞");
        list1.add("匡煞");
        //第二个班
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("北山定");
        list2.add("北山煞");
        list2.add("龚煞");
        list2.add("平煞");

        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        //遍历list,输出里面每一个班级的学生

        for (List<String> stringList : list) {
            // 遍历stringList
            for (String s : stringList) {
                System.out.println(s);
            }
        }
    }
}
```

## 第五章 斗地主II

```java
import java.util.*;

/*
我们昨天学习的斗地主是在使用ArrayList<String>保存扑克牌，
里面的扑克牌都是♥3,♦2,♠5.这样特殊的字符串是无法进行排序的。
数字是可以直接进行排序的，那么我们就可以使用数字去表示每张扑克牌。
我们可以给每张扑克牌都定义一个数字编号，使用该编号表示对应的扑克牌，
让能力值越小的牌，编号也就越小，将来洗牌，发牌操作，直接对编号进行操作。如果要进行看牌，
我们还是要看到真正的扑克牌的，所以我们可以定义一个Map集合，用来保存每个编号以及牌的对应关系【可以看成字典】，
在看牌时，可以根据编号找到对应的牌，然后进行展示。

步骤：
1.准备牌
    a.定义List集合，保存扑克牌的编号
    b.定义Map集合，用来保存编号和牌的对应关系
    c.向List集合中添加编号，向Map中添加对应关系
2.洗牌
    操作的是编号
    直接打乱编号的顺序
3.发牌
    发牌的逻辑和昨天写的一样
    区别在于，今天真正发给玩家的是扑克牌的编号
4.看牌
    看牌我们真正希望看到的是扑克牌本身而不是满
    所以在看牌时，我们可以根据编号去Map集合中找到对应的扑克牌然后进行输出。
    步骤:
        a.定义方法，用来看牌
        b.先对玩家手中的编号进行排序。
        c.输出玩家姓名
d.遍历玩家手中的编号，拿到每一个编号，去Map集合中找到该编号对应的牌，进行输出
 */
@SuppressWarnings("all")//注解，该注解用来抑制警告
public class Demo01Game {
    public static void main(String[] args) {
        // 1.准备牌
        // a.定义List集合，保存扑克牌的编号
        List<Integer> poker = new ArrayList<>();
        // b.定义Map集合，用来保存编号和牌的对应关系
        Map<Integer, String> map = new HashMap<>();
        // c.向List集合中添加编号，向Map中添加对应关系
        // 定义数组保存花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 定义数组保存点数
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 编号
        int index = 0;
        //向List集合中添加编号，向Map中添加对应关系，使用族套循环遍历两个数组去实现
        for (String num : nums) {
            for (String color : colors) {
                // 添加编号
                poker.add(index);
                // 添加对应关系
                map.put(index,color+num);
                // 编号自增
                index++;
            }
        }
        // 添加大小王
        poker.add(index);
        map.put(index,"小王");
        index++;
        poker.add(index);
        map.put(index,"大王");
        // System.out.println(poker);
        // System.out.println(map);
        // 2.洗牌
        //         操作的是编号
        // 直接打乱编号的顺序
        Collections.shuffle(poker);
        //System.out.println(poker);
        // 3.发牌
        //         发牌的逻辑和昨天写的一样
        // 区别在于，今天真正发给玩家的是扑克牌的编号
        // 定义三个集合，用来保存三个玩家手里的牌【真正保存的是扑克牌的编号】
        List<Integer> play1 = new ArrayList<>();
        List<Integer> play2 = new ArrayList<>();
        List<Integer> play3 = new ArrayList<>();
        // 定义一个集合放底牌
        List<Integer> dp = new ArrayList<>();
        // 遍历保存扑克牌【编号】的集合，拿到每一张牌【编号】，根据牌【编号】在集合中的索引进行发牌。
        for (int i = 0; i <poker.size() ; i++) {
            Integer card = poker.get(i);
            // 根据索引发牌
            if (i>50){
                dp.add(card);
                continue;
            }
            if (i%3==0)
                play1.add(card);
            else if (i%3==1)
                play2.add(card);
            else
                play3.add(card);
        }
        // 看牌
        lookCard("舒嘏",play1,map);
        lookCard("何煞",play2,map);
        lookCard("何萨关",play3,map);
        lookCard("底牌",dp,map);


    }
    /*
    看牌方法
    参数：String name【玩家姓名】，List<Integer>List【玩家手中编号】，Map<Integer,String>map【字典】
    返回值:void
     */
    public static void lookCard(String name,List<Integer> list,Map<Integer,String> map){
        Collections.sort(list);
        System.out.print(name + " ");
        for (Integer id : list) {
            String s = map.get(id);
            System.out.print(s + " ");
        }
        System.out.println();

    }
}
```





## 总结



```java
一. Collections【掌握比较器排序】
	Collections是操作集合的工具类
		static void shuffle(List<?> list)：打乱集合中元素的顺序。
        static void sort(List list)：对集合中的内容进行排序【自然排序】
        static void sort(List list, Comparator c)：对集合中的内容进行排序，第一个参数是集合，第二个参数是比较器【比较器排序】
		static boolean addAll(Collection c, T... elements)：批量添加数据
	自然排序和比较器排序
		自然排序：事物本身就具备比较的功能，我们可以使用Collections的sort方法直接对集合进行排序。如果某个类
		          实现了Comparable接口，就表示该事物具备了比较的功能，就可以使用自然排序。
				  
		比较器排序：我们也可以请一个法官来帮这些对象去比较，这个法官就是比较器。 定义一个类，实现Comparator接口，
		            重写compare方法，并定义比较规则，然后在调用Collections的sort方法时，传递集合以及Comparator实现类对象。
					
二. Set集合
	概念：Set是Collection另一个子接口。
	特点：
		1. 无序【Set接口下的大多数实现类是无序】
		2. 无索引
		3. 不可重复
	
	实现类：
		HashSet：内部是哈希表，无序，无索引，不可重复
		（了解）LinkedHashSet： 内部哈希表+链表，可以保证有序。
		（了解）TreeSet：内部是二叉树，可以对元素进行排序。 
	
	哈希表：
		哈希表就是一个数组，数组中的每一个元素都是一个链表。
		哈希表是先分类，再存储，好处是查找效率高。
		
	HashSet存储数据并保证唯一性
		1. 先比较对象的哈希值
			如果哈希值不同，肯定是不同的对象。
			如果哈希值相同，不一定是同一个对象。
		2. 如果哈希值相同，还需要使用equals进行比较。
		    如果equals结果是true，表示对象相同
			如果equals结果是false，表示对象不同。
		
		如果要保证唯一性【属性相同就看成是同一个对象】，需要同时重写hashCode和equals
	
三. Map集合
	Map表示双列集合，双列集合中的每一个元素都是键值对，一个键对应一个值。键不能重复，值可以重复。
	
	Map中常见的方法：
		（常用）V put(K key, V value)：向Map集合中添加键值对元素，如果键已经存在，会使用新的值覆盖掉原有的值。
        （常用）V get(Object key)：根据键获取到对应的值并返回。
        V remove(Object key)：根据键删除整个的键值对，并将被删除的值返回。
        boolean containsKey(Object key)：判断Map集合中是否包含指定的键。
	
	Map集合遍历
		1. keySet
			a. 先调用Map集合的keySet方法，获取所有的键放入到Set集合
			b. 遍历Set集合，拿到每一个键
			c. 调用Map集合的get方法，根据键获取值
		2. entrySet
			a. 先调用Map集合的entrySet方法，获取所有的entry对象并放入到Set集合。
			b. 遍历Set集合，拿到每一个Entry
			c. 调用Entry对象的getKey和getValue获取键和值
	
	HashMap集合保存数据并保证唯一性：
		HashMap保证唯一性的过程和HashSet一模一样
		
	实现类：
		HashMap：内部是哈希表。
		（了解）LinkedHashMap：内部是哈希表+链表，可以有序
		（了解）TreeMap：内部是二叉树，可以对键进行排序
```












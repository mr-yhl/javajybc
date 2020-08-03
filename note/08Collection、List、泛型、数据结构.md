<center>Collection、List、泛型、数据结构</center>

## 今日内容

+ 集合
+ 迭代器
+ 增强for【重点】
+ 泛型
  + 泛型类
  + 泛型方法
  + 泛型接口
  + 泛型通配符
+ 数据结构简介
+ List接口
  + ArrayList
  + LinkedList
+ 集合小练习

## 导入

集合就是一个容器,可以存放很多数据.

集合和数组的区别:

+ 集合长度可变,数组长度固定
+ 集合存放引用数据,数组可以存放任何数据

ArrayList就是集合,长度可变,可以保存引用类型的数据.其本质是数组.(长度不够就再创建一个1.5倍大小的数组替换.)

## 第一章 Collection集合

### 1.概念

**是所有单列集合的根接口.**因此在Collection中定义了单列集合(List和Set)通用的一些方法，这些方法可用于操作所有的单列集合。

### 2.常用方法

```java
/*
是所有单列集合的根接口.
方法：
booLean add(E e):向集合中添加元素。
int size():获取集合的大小。
void clear():清除集合中所有元素
boolean contains(object o):判断集合是否包含指定元素。
boolean isEmpty():判断集合是否为空。如果集合中没有元素，那么这个集合就是一个空集合，该方法结果就是true。
(object o):直接删除指定元素，删除成功返回true
object[]toArray():将集合转成数组。
注意：Collection中所有的方法都和索引无关，因为不是所有的集合都有索引。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo01_Collection {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();// 多态调用父类的方法
        // 添加元素
        c.add("hello");
        c.add("word");
        c.add("java");
        // 打印集合
        System.out.println(c);// [hello, word, java]

        // 获取集合的大小
        int size = c.size();
        System.out.println(size); // 3
        //清除所有元素
        /*c.clear();
        System.out.println(c);*/
        // 是否存在元素
        System.out.println("是否包含java:"+c.contains("java"));
        System.out.println("是否包含php:"+c.contains("php"));
        /*是否包含java:true
        是否包含php:false*/
        // 判空
        /*System.out.println("是否为空" + c.isEmpty());
        c.clear();
        System.out.println("是否为空" + c.isEmpty());

        是否为空false
        是否为空true*/
        // 删除元素
        System.out.println(c.remove("hello"));
        System.out.println(c);
        /*
         true
        [word, java]
        */
        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));// [word, java]
    }
}
```

## 第二章 Iterator

### 1.迭代器接口

```java
我们之前都是通过for循环结合素引的方式遍历集合，这种方式并不适用于所有的集合。
因为不是所有的集合都有索引。
有一种通用的遍历方式，叫做送代器遗历，可以遍历所有的单列集合。
迭代器其实就是一个遍历集合的工具，内部有一个光标，这个光标最开始指向了集合最开头的位置。
```

### 2.常用方法

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
在Collection中有个叫iterator的方法,可以获取迭代器对象.
    Iterator<E> iterator():获取集合的迭代器

Iterator是一个接口,该接口表示迭代器,迭代器的方法
    booLean hasNext():判断集合中是否还有元素可以获取
    E next():获取当前光标位置的元素，然后把光标向后移动
迭代器遍历步骤:
    1.调用集合的iterator方法,获取集合的迭代器.
    2.通过送代器调用hasNext方法，判断光标位置有没有元素可以获取
    3.如果有元素可以获取，通过送代器调用next方法获取元素，并让光标向后移动。


 */
public class Demo01Iterator {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();
        // 添加元素
        c.add("hello");
        c.add("word");
        c.add("java");
        // 获取迭代器
        Iterator<String> iterator = c.iterator();
        // 通过送代器调用hasNext方法，判断光标位置有没有元素可以获取
        // System.out.println(iterator.hasNext());//true
        // System.out.println(iterator.next());// hello
        while (iterator.hasNext())
        System.out.println(iterator.next());
        /*
        hello
        word
        java*/
    }
}
```

### 3.步骤原理

1. 获取集合的迭代器对象
   集合.iterator();
2. 判断选代器光标位置是否有元素可以获取
   选代器.hasNext();
3. 如果有元素可以获取，获取光标位置的元素，把光标向后移动。
   迭代器.next();



### 4.并发修改异常

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
在使用选代器遍历的过程中，如果使用集合的方法对集合进行增删操作，那么将来有可能引发并发修改异常。
ConcurrentModificationException
 */
public class Demo02Iterator {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();
        // 添加元素
        c.add("aa");
        c.add("bb");
        c.add("cc");
        // 获取迭代器
        Iterator<String> iterator = c.iterator();
        // 通过送代器调用hasNext方法，判断光标位置有没有元素可以获取

        while (iterator.hasNext()){
        System.out.println(iterator.next());
        // c.add("dd");// ConcurrentModificationException并发修改异常
        }

    }
}
```

### 4.for增强【重点】

#### 4.1遍历数组

```java
/*
在JDK5的时候，多了增强for舒环（foreach),可以遍历数组或者集合。
格式
for(数据类型 变量名：容器）(
)
解释
数据类型：要遍历的容器中保存的是什么类型的数据，这个数据类型就写什么。
变量名：表示容器中的每一个元素。
容器：数组或者集合。
通过增强for遍历数组
增强for是一种语法糖，语法糖指的是本质没有变，只不过写法更加优雅，更加简洁了。
增强for遍历数组本质还是之前的普通for循环
 */

import java.util.Arrays;

public class Demo01Foreach {
    public static void main(String[] args) {
        // 创建数组
        int[] intArr = {11,33,44,55};
        for (int a:intArr){
            // 变量a表示数组中的每一个元素
            System.out.println(a);
        }
        System.out.println("遍历double数组=====================");
        //遍历double数组
        double[] doubleArr = {2.4,5.6,78.9,33.4};
        for (double num :doubleArr){
            System.out.println(num);
        }

        int[] arr = {10,20,30,40,50,60};
        for (int num:arr)
            num*=2;
        System.out.println(Arrays.toString(arr));

    }
}
```

#### 4.2遍历集合及优缺点

```java
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
```

## 第三章 泛型

### 1.简介

```java
/*
泛型：泛型是一种未知的，不确定的数据类型。
举例：比如ArrayList<E>，这个E就是泛型。但是E表示的是哪种数据类型呢，不确定，所以泛型是一种未知的，不确定的数据类型.

虽然泛型类型表示的是一种不确定的类型，但是等我们将来使用这个类创建对象时，这个E表示的数据类型就可以被确定下来
比如：
    ArrayList<String>此时这个泛型类型E表示的就是String
    ArrayList<Person>此时这个泛型类型E表示的就是Person

泛型是可以省略的,如果省略泛型,相当于泛型Object

泛型好处：
1.可以省略同下转型的代码。
2.可以将运行时的问题提前到编译时期。
 */

import java.util.ArrayList;

public class Demo01Generic {
    public static void main(String[] args) {
        // 创建集合
        ArrayList list = new ArrayList();
        // 添加元素
        // list.add(100);// 运行报错
        list.add("hello");
        list.add("world");
        list.add("java");
        //遍历集合
        for (Object obj:list){
            // 将obj向下转型
            String s = (String) obj;
            System.out.println(s.length());

        }
        System.out.println("==============");
        ArrayList<String> list2 = new ArrayList();
        // 添加元素
        // list2.add(200);//编译报错
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        //遍历集合
        for (String s1:list2){
            // 将obj向下转型
            System.out.println(s1.length());

        }

    }
}
```

### 2.泛型的擦除

```java
/*
    泛型擦除。
Java中的泛型是伪泛型，泛型只在源代码阶段有效，一旦编译，泛型就会消失。也叫做泛型擦除
 */

import java.util.ArrayList;

public class Demo02Generic {
    public static void main(String[] args) {
        // 创建集合

        ArrayList<String> list2 = new ArrayList();
        // 添加元素
        // list2.add(200);//编译报错
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        //遍历集合[集合.for]
        for (String s1:list2){
           
            System.out.println(s1);

        }

    }
}
```

### 3.泛型的练习

#### 3.1类,方法泛型

```java
public class Phone {
    public void call(){
        System.out.println("打电话");
    }
}
public class Pad {
    public void study(){
        System.out.println("学习");
    }
}
/*
    泛型：是一种未知的，不确定的数据类型。
如果在定义类的时候，在类名后面加上<T>,就表示在类中定义了一个不确定的类型。
T可以是任何字母，一般是一个大写字母

T真正表示一种数据类型，只不过他在刚写出来的时候是未知的。
当我们使用这个类（创建对象）时，会指定这个是什么类型，那么此时这个T表示的类型就可以确定了。
这个T就是一个泛型.


带有泛型的类:
    public class 类名<泛型>{
    .....

    }

如果想要在调用方法时才确定具体的类型，那么我们可以使用泛型方法（在方法上定义泛型）
如果在方法上定义泛型，那么这个泛型类型会在调用方法时才指定

泛型方法格式
  修饰符 <泛型> 返回值类型 方法名(参数类型 参数名){
  ......

  }


小结:
    如果是在类上面定义的泛型,在整个类都可以使用,在整个类中都可以使用，类上面定义的泛型需要等到使用这个类【创建对象】时才会指定这个泛型到底是什么类型。
    如果是在方法上面定义的泛型，在方法中可以使用。方法上面定义的泛型需要等到调用方法时才能知道这个泛型到底是什么类型。

*/
public class Factory<T> {//在类中定义一个未知的不确定的数据类型T,也可以称为泛型类型T

    /*
    定义一个方法:接收什么参数就返回什么结果
     */
    //<E>表示在方法中定义 了一个泛型E
    // 第二个E表示使用了未知的不确定的类型E当作返回值类型
    // 第三个e 表示使用了未知的不确定的类型E当作参数
    public <E> E getSame(E e){
        return e;
    }


    /*定义一个方法,该方法可以修理任意东西*/
    // 使用泛型T当作参数和返回值数据
    public T method(T t){
        // 假装修理
        return t;
    }

    
}
// 测试类
public class Demo01GenericTest {
    public static void main(String[] args) {
        // 创建Factoryduix
        Factory<Phone> f = new Factory<>();
        //调用方法,进行修理
        Phone p = f.method(new Phone());
        p.call();
    }
}
public class Demo02GenericTest {
    public static void main(String[] args) {
        // 创建Factoryduix
        Factory<Pad> f = new Factory<>();
        //调用方法,进行修理
        Pad pad = f.getSame(new Pad());
        Phone phone = f.getSame(new Phone());


    }
}
```

#### 3.2接口泛型

```java
/*
带有泛型的接口。
如果在定义接口时，在接口名后面写上<T>,那么就表示在接口中定义了一个泛型类型【【不确定的类型】


泛型接口的使用
    1.在实现类实现接口时,可以指定泛型类型
    2.实现类在实现接口时,可以不知道泛型,在使用实现类时使用



 */
public interface MyInterface<T> {//在接口中定义一个不确定的类型T
    // 定义方法,使用泛型类型当做参数类型和返回值类型
    T method(T t);
}
/*
实现类在实现接口时指定泛型
实现类在实现接口时，可以直接在接口名后面写上尖括号去指定泛型
 */
public class MyClassA implements MyInterface<Phone> {
    @Override
    public Phone method(Phone phone) {
        return phone;
    }
}
/*
实现类在实现接口时，不指定泛型。
我们在定义类或者接口时，只有在当前类或者接口名字后面写的尖括号是在定义泛型，其他的都是在使用泛型
 */

public class MyClassB<T> implements MyInterface<T> {

    @Override
    public T method(T t) {
        return t;
    }
}

// 测试类
public class Demo03GenericTest {
    public static void main(String[] args) {
        // 创建Factoryduix

        MyClassA ma = new MyClassA();
        Phone p = ma.method(new Phone());
        // 创建MyClassB对象
        MyClassB<Pad> mb = new MyClassB<>();
        Pad method = mb.method(new Pad());

    }
}
```

### 4.泛型通配符

```java
public class Person {
    private String name;
    private  int age;

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
public class Student extends Person {
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }
}
public class Teacher extends Person {
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }
}
//测试类上下限
import java.util.ArrayList;

/*
泛型之间没有继承关系
比如ArrayList<Object>并不是ArrayList<String>的父类


如果想要让方法参数可以匹配任何类型的泛型，那么可以使用泛型通配符。
'?'表示泛型通配符，可以匹配任何类型的泛型。

注意:
    '?'泛型通配符只能放到参数位置被动匹配，不要把它主动使用
 */
public class Demo01Generic {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("hi");
        strList.add("yhl");
        strList.add("bx");
        strList.add("ws");
        //遍历
        printArrayList(strList);
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(6);
        intList.add(7);
        printArrayList(intList);
        /*//创建集合,主动匹配
        ArrayList<?> list = new ArrayList<>();
        list.add();*/

    }

    /*
    定义方法,可以遍历保存字符串已经Integer的集合
    参数:ArrayList<Object>
    返回值:void

     */
    public static void printArrayList(ArrayList<?> list) {//?表示任何类型
        for (Object obj : list)
            System.out.println(obj);
    }
}
//测试类
/*
泛型限定
作用：可以对泛型通配符？的取值范围进行限制。
<? extends A>:泛型要么是A类，要么是A类的子类。[上限]
<? super A>:泛型要么是A类，要么是A类的父类。[下限]

型主要用于代码重构，代码的优化

 */


import java.util.ArrayList;

public class Demo02Generic {
    public static void main(String[] args) {
        ArrayList<Student> stuList =new ArrayList<>();
        stuList.add(new Student("东郭",25));
        stuList.add(new Student("舒黛皋",24));
        stuList.add(new Student("公孙煞",21));
        //调用方法
        printArrayList(stuList);// 参数集合的泛型是Person的子类
        ArrayList<Person> personList =new ArrayList<>();
        printArrayList(personList);////参数集合的Person
        ArrayList<Object> objList =new ArrayList<>();
        // printArrayList(objList);//参数集合是Person的父类
        // method(stuList);//参数集合的泛型是person的子类
        method(personList);//参数集合的泛型是person
        method(objList);//参数集合的泛型是person 的父类
    }
    /*
    定义方法:用来保存遍历Person和Person的子类集合
     */
    public static void printArrayList(ArrayList<? extends Person> list){
        for (Person p:list)
            System.out.println(p);

    }
    /*
    定义方法,使用下限
     */
    public static void method(ArrayList<? super Person> list){
        /*for (Object p:list)
            System.out.println(p);*/

    }

}
```

##  第四章 数据结构

数据结构就是存储数据的方式，如果某个容器存储数据的方式不同，那么他的特点也不同.

常见的数据结构有：栈，队列，数组，链表，树，图，哈希表

### 1.栈(先进后出  FILO)

栈：stack,又称堆栈，它是运算受限的线性表，其限制是仅允许在标的一端进行插入和删除操作，不允许在其 他任何位置进行添加、查找、删除等操作。
简单的说：采用该结构的集合，对元素的存取有如下的特点
后进先出。例如，子弹压进弹夹，先压进去的子弹在下面，后压进去的子弹在上面，当开枪时，先弹出上面 的子弹，然后才能弹出下面的子弹。
栈的入口、出口的都是栈的顶端位置。

这里两个名词需要注意：

+ 压栈：就是存元素。即，把元素存储到栈的顶端位置，栈中已有元素依次向栈底方向移动一个位置。
+ 弹栈：就是取元素。即，把栈的顶端位置元素取出，栈中已有元素依次向栈顶方向移动一个位置。

### 2.队列(先进先出 FIFO)

队列：queue,简称队，它同堆栈一样，也是一种运算受限的线性表，其限制是仅允许在表的一端进行插入， 而在表的另一端进行取出并删除。
简单的说，采用该结构的集合，对元素的存取有如下的特点：
先进先出。例如，小火车过山洞，车头先进去，车尾后进去；车头先出来，车尾后出来。
队列的入口、出口各占一侧。例如，下图中的左侧为入口，右侧为出口。

### 3.数组(查询快,增删慢)

数组:Array,是有序的元素序列，数组是在内存中开辟一段连续的空间，并在此空间存放元素。就像是一排出 租屋，有100个房间，从001到100每个房间都有固定编号，通过编号就可以快速找到租房子的人。
简单的说,采用该结构的集合，对元素的存取有如下的特点：

+ 查找元素快：通过索引，可以快速访问指定位置的元素
+ 增删元素慢

指定索引位置增加元素：需要创建一个新数组，将指定新元素存储在指定索引位置，再把原数组元素根据索 引，复制到新数组对应索引的位置

指定索引位置删除元素：需要创建一个新数组，把原数组元素根据索引，复制到新数组对应索引的位置，原 数组中指定索引位置元素不复制到新数组中。

### 4.链表(查询慢,增删快)

链表:linked list,由一系列结点node（链表中每一个元素称为结点）组成，结点可以在运行时动态生成。每个 结点包括两个部分：一个是存储数据元素的数据域，另一个是存储下一个结点地址的指针域。我们常说的链
表结构有单向链表与双向链表，那么这里给大家介绍的是单向链表。

简单的说，采用该结构的集合，对元素的存取有如下的特点：

+ 多个结点之间，通过地址进行连接。例如，多个人手拉手，每个人使用自己的右手拉住下个人的左手， 依次类推，这样多个人就连在一起了。
+ 查找元素慢：想查找某个元素，需要通过连接的节点，依次向后查找指定元素
+ 增删元素快

### 5.树

树具有的特点： 

1. 每一个节点有零个或者多个子节点 
2.  没有父节点的节点称之为根节点，一个树最多有一个根节点。
3. 每一个非根节点有且只有一个父节点

| 名词     | 含义                                                         |
| -------- | ------------------------------------------------------------ |
| 节点     | 指树中的一个元素                                             |
| 节点的度 | 节点拥有的子树的个数，二叉树的度不大于2                      |
| 叶子节点 | 度为0的节点，也称之为终端结点                                |
| 高度     | 叶子结点的高度为1，叶子结点的父节点高度为2，以此类推，根节点的高度最高 |
| 层       | 根节点在第一层，以此类推                                     |
| 父节点   | 若一个节点含有子节点，则这个节点称之为其子节点的父节点       |
| 子节点   | 子节点是父节点的下一层节点                                   |
| 兄弟节点 | 拥有共同父节点的节点互称为兄弟节点                           |



#### 5.1二叉树

如果树中的每个节点的子节点的个数不超过2，那么该树就是一个二叉树。

#### 5.2二叉查找树

二叉查找树的特点：

1. 左子树上所有的节点的值均小于它的根节点的值
2.  右子树上所有的节点值均大于它的根节点的值

3. 每一个子节点最多有两个子树

遍历获取元素的时候可以按照"左中右"的顺序进行遍历；

 注意：二叉查找树存在的问题：会出现"瘸子"的现象，影响查询效率

#### 5.3平衡二叉树

为了避免出现"瘸子"的现象，减少树的高度，提高我们的搜素效率，又存在一种树的结构："平衡二叉树" 规则：它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树

**旋转** 在构建一棵平衡二叉树的过程中，当有新的节点要插入时，检查是否因插入后而破坏了树的平衡，如果是，则需要 做旋转去改变树的结构。
**左旋：**
左旋就是将节点的右支往左拉，右子节点变成父节点，并把晋升之后多余的左子节点出让给降级节点的右子节点；

**右旋：** 

将节点的左支往右拉，左子节点变成了父节点，并把晋升之后多余的右子节点出让给降级节点的左子节点

#### 5.4红黑树

 概述

红黑树是一种自平衡的二叉查找树，是计算机科学中用到的一种数据结构，它是在1972年由Rudolf Bayer发明的， 当时被称之为平衡二叉B树，后来，在1978年被Leoj.Guibas和Robert Sedgewick修改为如今的"红黑树"。它是一 种特殊的二叉查找树，红黑树的每一个节点上都有存储位表示节点的颜色，可以是红或者黑；
红黑树不是高度平衡的，它的平衡是通过"红黑树的特性"进行实现的； 

红黑树的特性：

1. 每一个节点或是红色的，或者是黑色的。
2. 根节点必须是黑色
3. 每个叶节点(Nil)是黑色的；（如果一个节点没有子节点或者父节点，则该节点相应的指针属性值为Nil，这些 Nil视为叶节点）
4. 如果某一个节点是红色，那么它的子节点必须是黑色(不能出现两个红色节点相连的情况)
5. 对每一个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点；

在进行元素插入的时候，和之前一样； 每一次插入完毕以后，使用黑色规则进行校验，如果不满足红黑规则，就需 要通过变色，左旋和右旋来调整树，使其满足红黑规则；

## 第五章 List接口

### 1.介绍

```java
import java.util.ArrayList;
import java.util.List;

/*
List接口是CoLLection下面的一个子接口。
List接口有下面三个特点：
    1.有序（指的是按照什么顺序存，就按照什么顺序取）
    2.有索引（可以根据索引操作元素）
    3.可重复（可以保存重复元素)

List是一个接口,如果要用,需要使用实现类,最常用的实现类是ArrayList
 */
public class Demo01List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("三饭嘏");
        list.add("欧皑荡");
        list.add("东方煞");
        //输出集
        //1.有序（指的是按照什么顺序存，就按照什么顺序取）
        System.out.println(list);
        // 2.有索引（可以根据索引操作元素）
        System.out.println(list.get(1));
        // 3.可重复（可以保存重复元素)
        list.add("欧皑荡");
        System.out.println(list);
    }
}
```

### 2.常用方法

public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
public E get(int index) :返回集合中指定位置的元素。
public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素。

### 3.实现类

#### 3.1ArrayList

```java
/*
ArrayList是List接口下最常用的实现类，没有之一。
ArrayList是在使用数组保存数据
因为是使用数组保存数据，特点是：查询快，增删慢。
 */
public class Demo02ArrayList {
    public static void main(String[] args) {

    }
}
```

#### 3.2LinkedList[了解]

```java
import java.util.LinkedList;

/*
LinkedList也是List接口下的实现类。
LinkedList内部是双向链表结构。
因为LinkedList内部是健表，所以查询慢，增删快。

LinkedList中特有的方法（丁解）:
    void addFirst(E e):在集合的开头添加元素。
    void addlast(E e):在集合的末尾添加元素。
    E getFirst():获取集合中首个位置的元素
    E getLast():获取集合尾部的元素。
    E removeFirst():删除集合中第一个元素,并将该元素返回
    E removeLast():删除集合最后一个元素。,并将该元素返回
    void push(E e):压入，向集合首个位置添加元素
    E pop():弹出，删除集合中的第一个元素
 */
public class Demo03LinkedList {
    public static void main(String[] args) {
        // 创建集合
        LinkedList<String> linkedList = new LinkedList<>();
        // 添加元素
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("java");
        // 输出
        System.out.println("操作前" + linkedList);
        // void addFirst(E e):在集合的开头添加元素。
        linkedList.addFirst("php");
        System.out.println("在开头加php:" + linkedList);
        // void addlast(E e):在集合的末尾添加元素。
        linkedList.addLast("c#");
        System.out.println("在末尾加c#:" + linkedList);
        // E getFirst():获取集合中首个位置的元素
        String first = linkedList.getFirst();
        System.out.println("获取到的首个位置的元素是" + first);
        // E getLast():获取集合尾部的元素。
        System.out.println("获取到的尾部位置的元素是" + linkedList.getLast());
        // E removeFirst():删除集合中第一个元素
        String remove = linkedList.remove();
        System.out.println("被删除的是:" + remove + "操作后的集合是:" + linkedList);
        // E removeLast():删除集合最后一个元素。
        String removeLast = linkedList.removeLast();
        System.out.println("被删除的是:" + removeLast + "操作后的集合是:" + linkedList);
        // void push(E e):压入，向集合首个位置添加元素
        linkedList.push("ok");
        System.out.println("push操作后的集合:" + linkedList);
        // E pop():弹出，删除集合中的第一个元素
        String pop = linkedList.pop();
        System.out.println("弹出的元素是:" + pop + "操作后的集合:" + linkedList);
        /*
        操作前[hello, world, java]
        在开头加php:[php, hello, world, java]
        在末尾加c#:[php, hello, world, java, c#]
        获取到的首个位置的元素是php
        获取到的尾部位置的元素是c#
        被删除的是:php操作后的集合是:[hello, world, java, c#]
        被删除的是:c#操作后的集合是:[hello, world, java]
        push操作后的集合:[ok, hello, world, java]
        弹出的元素是:ok操作后的集合:[hello, world, java]*/

    }
}
```

## 第六章 斗地主游戏

```java

/*
斗地主小游戏
步骤：
1.准备牌
    a.创建一个集合,保存扑克牌
    b.向集合中添加54张牌
2.洗牌
    洗牌计算打乱集合顺序
    如果要打乱顺序，我们可以使用集合的工具类Collections中的shuffle方法完成。
    static void shuffle(List<?>List):随机打乱集合中元素的顺序。
3.发牌
    a.定义三个集合,保存三个玩家的牌
    b.定义一个集合保存底牌
    c.开始发牌
        i.遍历集合,拿到集合中发每一张pai
        ii.判断索引,根据集合中的索引进行发牌
            将索引为0,3,6...的牌发给第一个玩家【索引对3取余结果是，发给第一个玩家】
            将索引为1,4,7...的牌发给第二个玩家【索引对3取余结果是1,发给第二个玩家
            将素引为2,5,8...的牌发给第三个玩家【索引对3取余结果是2,发给第三个玩家】
4.看牌

 */

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Demo01Game {
    public static void main(String[] args) {
        // 1.准备牌
        // a.创建一个集合,保存扑克牌
        List<String> poker = new ArrayList<>();
        // b.向集合中添加54张牌
        //定义数组保存花色
        String[] colors = {"♠","♥","♣","♦"};
        String[] nums={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //使用循环遍历两个数组
        for (String num:nums) {
            for (String color:colors){
                // 将遍历的花色和点数进行拼接,在添加的集合中
                poker.add(color+num);
            }
        }
        // 添加大小王
        poker.add("🃏D");
        poker.add("🃏X");

        // System.out.println(poker);
        // 2.洗牌
        Collections.shuffle(poker);//随机打乱
        // System.out.println(poker);
        // a.定义三个集合,保存三个玩家的牌
        List<String> playOne = new ArrayList<>();
        List<String> playTwo = new ArrayList<>();
        List<String> playThree = new ArrayList<>();
        // b.定义一个集合保存底牌
        List<String> dipai = new ArrayList<>();
        // c.开始发牌
        // i.遍历集合,拿到集合中发每一张pai
        // ii.判断索引,根据集合中的索引进行发牌
        for (int i = 0; i < poker.size(); i++) {
            String card = poker.get(i);
            //给玩家发牌之前做一个判断，如果是最后三张牌了，就添加到底牌集合
            //最后三张牌的索引是53,52,51,如果索引大于等于51
            if (i>=51){
                dipai.add(card);
                continue;
            }

            if (i%3==0)
                playOne.add(card);
            else if (i%3==1)
                playTwo.add(card);
            else
                playThree.add(card);
        }
        // 看牌
        /*System.out.println(playOne);
        System.out.println(playTwo);
        System.out.println(playThree);*/
        lookCard("冯黛皋",playOne);
        lookCard("龚煞",playTwo);
        lookCard("公孙耒",playThree);
        lookCard("底牌",dipai);
    }
    /*
    * 定义一个方法,用来看牌
    *   参数:String(玩家姓名),List<String>(pai)
    *   返回值:void
    *  */
    public static void lookCard(String name,List<String> list){
        //输出姓名
        System.out.print(name+":");
        for (String s : list) {
            System.out.print(s + " ");

        }
        System.out.println();
    }
}
```

## 总结

```java
一. Collection
	Collection是一个接口，是单列集合的根接口。
	集合继承体系【重要】：
		Collection：接口
			|--List
				|--ArrayList
				|--LinkedList
			|--Set
				|--HashSet
				|--TreeSet
				
	常见方法：
		（常用）boolean add(E e)：向集合中添加元素。
        （常用）int size()：获取集合的大小。
        void clear()：清除集合中所有元素
        boolean contains(Object o)：判断集合是否包含指定元素。
        boolean isEmpty()：判断集合是否为空。如果集合中没有元素，那么这个集合就是一个空集合，该方法结果就是true。
        boolean remove(Object o)：直接删除指定元素，删除成功返回true。
        Object[] toArray()：将集合转成数组。
		
二. 迭代器遍历【看懂】
	步骤：
		1. 调用集合的iterator方法获取集合的迭代器对象
		2. 迭代器调用hasNext方法，判断是否有元素可以获取。
		3. 通过迭代器调用next方法，获取元素，将光标后移。

三. 增强for循环【非常重要】
	格式：
		for(数据类型 变量名 : 容器) {
			....
		}
四. 泛型【理解】
	概念：一种未知的不确定的数据类型。
	好处：
		1. 可以省略向下转型的代码。
		2. 可以将运行时的问题提前到编译时期。
		
	带有泛型的类：
		public class 类名 <泛型> {    
			...
		}
		在类上定义的泛型，需要使用这个类（创建对象）时指定这个泛型类型是什么
		
	
	带有泛型的方法：
		修饰符 <泛型> 返回值类型 方法名（参数列表） {
			...
		}
		在方法上定义的泛型，需要调用方法时才能指定这个泛型到底是什么类型。
	
	带有泛型的接口：
		public interface 接口名<泛型> {
		
		}
		
		在接口上定义的泛型，实现类在实现接口时可以直接指定这个泛型的类型。
		实现类在实现接口时也可以不指定，等到使用这个实现类时再进行指定。
		
	泛型通配符：
		?表示泛型通配符，可以匹配任何类型的泛型。
		
	泛型限定：
		<? extends A>：上限，泛型要么是A，要么是A的子类。
		<? super A>：下限，泛型要么是A，要么是A的父类。
		
五. 数据结构【知道每个数据结构的特点】
	栈：先进后出。
	队列：先进先出。
	数组：查询快，增删慢。
	链表：查询慢，增删快。
	树【了解】：
		二叉树：每个节点的子节点个数不超过2
		二叉查找树：在二叉树的基础上多了排序的功能
		平衡二叉查找树：平衡可以提高查找效率
		红黑树： 一种自平衡二叉查找树，让向红黑树中添加数据时，该树可以自己旋转，维持平衡。
	

六. List接口【知道List接口特点，能够使用List集合】
	List是Collection下面的子接口。
	特点：
		1. 有序
		2. 有索引
		3. 可以重复
	实现类：
		ArrayList：内部是数组结构
		LinkedList：内部是链表结构。
```










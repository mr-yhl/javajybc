<center>ArrayList集合</center>

## 今日内容

- ArrayList集合
- 学生管理系统

## 第一章 ArrayList的介绍

### 1.ArrayList的引入

数组是定长的,不可改变
集合:是一个容器,可以保存很多数据
集合与数组的区别:
    1.数组长度固定
      集合长度可变
    2.数组即可以保存基本类型,也可保存引用类型
      集合只能保存引用类型

ArrayList<E>表示集合
<E>是一个特殊的东西,叫做泛型.看见这个符号就使用引用类型来替换
集合要保存什么类型,就用什么替换.
**ArrayList<String>**  集合保存字符串类型的数据
**ArrayList<Student>**  集合保存Student类型的数据

构造方法
    **ArrayList()**: 空参的构造方法,没有任何元素
其他方法
    **boolean add(E e)**: 将指定的元素追加到此列表的末尾。  返回true

注意:
ArrayList是特殊的引用类型,直接输出名字,直接打印内容
同时 String,StringBuilder,ArrayList也都是特殊的引用类型

```java
/*

 */

import java.util.ArrayList;

public class Demo01ArrayList {
    public static void main(String[] args) {
        //创建集合对象,保存字符串
        // ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();// 后面的类型可以省略

        // 向集合添加数据
        list.add("张三");
        list.add("张四");
        list.add("张五");
        //集合的输出
        System.out.println(list);// [张三, 张四, 张五]

    }
}
```

### 2.ArrayList类概述

`java.util.ArrayList` 是大小可变的数组的实现，存储在内的数据称为元素。此类提供一些方法来操 作内部存储的元素。 `ArrayList `中可**不断添加元素**，其大小也**自动增长**。

 ArrayList集合的特点

- 底层是数组实现的，长度可以变化 泛型的使用
- 用于约束集合中存储元素的数据类型

### 3.ArrayList的一些方法

​    `boolean add(E e)` :将指定的元素追加到此列表的末尾。
   ` void add(int index, E element)` :在此列表中的指定位置插入指定的元素。 index是索引
​    `int size()` :返回此列表中的元素数。获取集合的大小
   ` E get(int index)` :返回此列表中指定位置的元素。 不是删掉
​    `E remove(int index) `:删除该列表中指定位置的元素。 返回被删除的元素
   ` boolean remove(Object o)` :从列表中删除指定元素的第一个出现（如果存在）。  成功返回true
   ` E set(int index, E element)` :用指定的元素替换此列表中指定位置的元素。 返回值是被替换的元素

```java
import java.util.ArrayList;

/*
集合中常用的方法

 */
public class Demo02ArratMethod {
    public static void main(String[] args) {
        // 创建一个集合,保存字符串
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        //输出
        System.out.println("list:" + list);

        // void add(int index, E element) :在此列表中的指定位置插入指定的元素。
        // 1位置添加 php
        list.add(2,"php");
        System.out.println("list" + list);

        // int size() :返回此列表中的元素数。获取集合的大小
        int size = list.size();
        System.out.println("集合的大小为:" + size);
        // E get(int index) :返回此列表中指定位置的元素。 不是删掉
        String s = list.get(1);
        System.out.println("索引为1的元素是:"+s);
        // E remove(int index) :删除该列表中指定位置的元素。 返回被删除的元素
        String s1 = list.remove(2);
        System.out.println("被删除索引为2的元素是"+s1);
        // boolean remove(Object o) :从列表中删除指定元素的第一个出现（如果存在）。  成功返回true
        list.add("hello");
        list.add("world");
        list.add("java");
        boolean b = list.remove("hello");
        System.out.println("hello是否删除" + b);
        System.out.println("list" + list);

        // E set(int index, E element) :用指定的元素替换此列表中指定位置的元素。 返回值是被替换的元素
        String supr = list.set(3, "supr");
        System.out.println("被替换的元素是" + supr);
        System.out.println("list" + list);
    }

}
```

### 4.集合保存基本类型

基本类型							引用类型（包装类）
byte									Byte
short									Short
int										Integer
Long									Long
float									Float
double								Double
boolean								Boolean
char										Character

```java
/*
使用集合保存100,200,300


注意:
    集合只能保存引用类型的数据
    如果像保存基本类型,使用基本类型的包装类

    每个基本类型都有对应的引用类型(包装类)


    基本类型
    byte    short   int     long    float   double
    char        boolean
    基本类型包装类
    Byte    Short   Integer Long    Float   Double
    Character   Boolean
    包装类 的使用与基本类型基本一致

 */

import java.util.ArrayList;

public class Demo03ArrayList {
    public static void main(String[] args) {
        //创建集合对象,保存int整数(不能保存基本类型)
        ArrayList<Integer> list = new ArrayList<>();
        // 向集合添加数据
        list.add(100);
        list.add(200);
        list.add(300);

        //集合的输出
        System.out.println(list);//

    }
}
```

### 5.集合的遍历

```java
/*
保存字符串并遍历
 */

import java.util.ArrayList;

public class Demo01ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhang1");
        list.add("zhang2");
        list.add("zhang3");
        list.add("zhang4");
        list.add("zhang5");
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }
    }
}
```

#### 6.遍历升级

```java
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
```

### 7.Scanner存在的问题

```java
/*
Scanner录入存在的问题
同一个Scanner对象，如果既调用nextLine键盘录入字符串，又调用其他的nextXxx方法，就有可能引发问题。
nextInt,nextDouble...:这些方法都会逐个使用自己的回车。
nextLine:能够检测到其他方法的回车。
解决方案：
给nextInt,nextDouble单独创建一个Scanner对象
给nextLine单独创建一个对象。
 */

import java.util.Scanner;

public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("num"+num);
        String s = scanner1.nextLine();
        System.out.println("s:"+s);
    }
}
```

### 8.集合遍历plus

+ 测试类

```java
import java.util.ArrayList;
import java.util.Scanner;

/*
使用集合保存Student对象,并遍历
键盘输入姓名年龄
思路：
1.创建集合，用来保存学生。
2.为了提高代码的复用性，定义一个方法，用来将学生对象添加到集合。
    a.键盘录入学生的姓名和年龄。
    b.根据键盘录入的姓名和年龄创建学生对象。
    c.将学生对象添加到集合中。
3.遍历集合，输出集合中每一个对象的属性
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建集合,保存学生
        ArrayList<Student> list = new ArrayList<>();
        // 调用方法
        addStudent(list);
        addStudent(list);
        addStudent(list);
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
    /*
    定义方法,将学生对象添加到集合中
        参数:ArrayList<Student>
        返回值:void

     */
    public static void addStudent(ArrayList<Student> list){
        /*
        向list添加数据
         */
        //  a.键盘录入学生的姓名和年龄
        Scanner scanner = new Scanner(System.in);
        // b.根据键盘录入的姓名和年龄创建学生对象。
        System.out.println("输入姓名");
        String s = scanner.nextLine();
        System.out.println("输入年龄");
        String s1 = scanner.nextLine();
        Student student = new Student(s, s1);
        // c.将学生对象添加到集合中。
        list.add(student);
    }
}
```

+ 学生类

```java
  public class Student {
      private String name;
      private String age;
  
      public Student() {
      }
  
      public Student(String name, String age) {
          this.name = name;
          this.age = age;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public String getAge() {
          return age;
      }
  
      public void setAge(String age) {
          this.age = age;
      }
  }
```

## 总结

```java
一. ArrayList集合
	为什么使用ArrayList：数组具有定长性，如果使用数组保存数据不方便。所以有了集合。
	概念：集合就是一个容器，这个容器中可以保存很多数据。
	集合和数组区别：
		1. 数组长度固定
		   集合长度可变
		   
	    2. 数组可以保存任何类型的数据
		   集合只能保存引用类型的数据。
		   
    集合的构造方法：
		ArrayList()：使用空参数的构造方法创建出来的集合里面没有任何元素。
		
	集合的其他方法：
		boolean add(E e)：向集合的末尾添加元素
		void add(int index, E e)： 向指定索引位置添加元素
		int size()：获取集合的大小。
		E get(int index)：获取指定索引位置的元素。
		E remove(int index)：根据索引删除元素，并返回被删除的元素
		boolean remove(Object obj)：根据元素删除，如果删除成功返回true。
		E set(int index, E e)：替换指定索引位置的元素，返回被替换的元素
		
	集合保存基本类型的数据：
		集合只能存放引用类型的数据，如果需要保存基本类型，只能借助对应的包装类。
		基本类型		包装类。
		byte			Byte
		short			Short
		int				Integer
		long			Long
		float			Float
		double			Double
		boolean			Boolean
		char			Character
		
二. 学生管理系统
	练习
```


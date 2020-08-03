<center>day07javase基础</center>

## 今日内容

- 数组的概念和数组变量的定义【重点】

- 数组的初始化及使用【重点的重点】

- 数组的内存图【理解】

- 数组的常见问题【理解】

- 数组的练习【重点的重点】

  ````java
  快捷键：
  生产输出语句：表达式.sout
  数组遍历：
  数组名.fori:正着遍历
  数组名.forr:倒着遍历
  ````

  

  

## 第一章 数组定义和访问

### 1.容器的概念

将多个数据存储到一起，每个数据称为该容器的元素。

**数字**

1. 概念：java中的数组就是一个容器，可以用来存储多个数据，但是多个数据的类型必须一致.

2. 特点::
   1. 可以存储多个数据.
   2. 多个数据的类型必须一致.
   3. 数组的长度一旦确定,永远不可以发生改变.

### 2.数组变量的定义

**数组变量**是一个变量，只能存储一个数据，只不过数组变量内部只能存储的是一个数组容器是一个变量，只能存储一个数据，只不过数组变量内部只能存储的是一个数组容器

1.数组变量定义格式一：推荐使用
`数据类型[] 数组名称；`
2.数组变量定义格式二：不推荐使用的
`数据类型 数组名称[];`

```java
public static void main(String[] args) {
        // 1.定义一个存储int类型数组的变量arrayA
        //只能存储int数据的数组
        int[] arrayA;
        // 2.定义一个存储double类型数组的变量arrayB
        double[] arrayB;
        // 3.定义一个存储char类型数组的变量arrayc
        char[] arrayC;
    }
```

## 第二章 数组初始化及应用

### 1.数组的第一种初始化方式

数组的第一种初始化方式（动态初始化：指定数组长度）
1.格式：
数据类型[] 数组名称=new 数据类型[长度];
2.格式解释：
	(1)左侧数据类型：表示数组容器中可以存储什么类型的数据
	(2)左侧[]:表示数组
	(3)数组名称：就是一个标识符，给数组容器起个名字，方便使用数组
	(4)=:代表赋值操作，就是把右侧的具体的数组容器，存储到左侧的数组变量中（只需要存储地址值）
	(5)new:代表创建数组（为数组容器开辟内存空间）的过程
	(6)右侧[]中的长度：必须是个int类型的数据（常量/变量）,优表数组中可以存储的元素的 个数

```java
// (1)创建一个int类型的数组，可以存储3个int数据，给该数组起个名称叫做arrayA
        int[] arrayA = new int[3];
        // (2)创建一个double类型的数组，可以存储7个double数据，给该数组起个名称叫做arrayB
        double[] arrayB = new double[7];
        // (3)创建一个char类型的数组，可以存储5个char数据，给该数组起个名称叫做arrayc
        char[] arrayC = new char[5];


int[]arrayA=new int[3]
=左侧int[]arrayA:是定义一个可以存储int类型数组容器的变量
=右侧new int[3]:才是一个可以存储3个int数据的数组容器
=:代表赋值操作，把右侧的数组容器的内存地址值存储到=右侧的数组变量中
```

### 2.数组的第二种初始化方式

数组的第二种初始化方式（标准格式静态初始化：指定元素）
1.格式：
数据类型[]数组名称=new数据类型[]{元素1,元素2,元素3..元素n}；
2.注意：
(1)中的多个元素之间用逗号分隔，最后一个元素后面没有逗号	(2)右侧[]中不能写长度，只要写就报错，jvm会根据0中的元素数量推导出长度来

```java
// (1)创建一个int类型的数组，可以存储多个int数据100,200,300,给该数组起个名称叫做arrayA
    int[] arratA= new  int[]{100,200,3000};
    // (2)创建一个double类型的数组，可以存储多个double数据1.1,2.2,3,3,4,5.5,6.6,7.7,给该数组起个名称叫做arraye
    double[] arrayB = new double[]{1.1,2.2,3,3,4,5.5,6.6,7.7};
    //(3)创建一个char类型的数组，可以存储多个char数据'真','的','好','想','你',给该数组起个名称叫做arrayc
    char[] arryC = new char[]{'真','的','好','想','你'};
```

### 3.数组的第三种初始化方式

数据类型[]数组名称={元素1,元素2,元素3..元素n};

```java
 // (1)创建一个int类型的数组，可以存储多个int数据100,200,300,给该数组起个名称叫做arrayA
    int[] arratA= {100,200,3000};
    // (2)创建一个double类型的数组，可以存储多个double数据1.1,2.2,3,3,4,5.5,6.6,7.7,给该数组起个名称叫做arraye
    double[] arrayB = {1.1,2.2,3,3,4,5.5,6.6,7.7};
    //(3)创建一个char类型的数组，可以存储多个char数据'真','的','好','想','你',给该数组起个名称叫做arrayc
    char[] arryC = {'真','的','好','想','你'};
```

注意：
(1)中的多个元素之间用逗号分隔，最后一个元素后面没有追号
(2)右侧不需要写长度，jvm根据（)中元素的数量推导出数组的长度
(3)虽然没有写new,但是底层仍然有new的过程
(4)动态初始化方式和标准格式静态初始化方式都可以分两步完成
(5)java中语法规定，简化格式静态初始化不能分两步完成

### 4.数组使用

1.数组变量名称：保存数组容器在内存空间的地址值，是一个十六进制的整数数字
2.索引编号：
(1)数组中的每个数据，被称为数组元素
(2)数组为内部的每个元素进行标号，称为素引/角标，但是素引编号从0开始，到最大索引（数组长度减1)
(3)素引编号必须是一个int类型的数字
3.数组元素的使用：
数组名称[素引编号]
4.获取数组长度
数组名称.length

```java
int[] array = {10, 20, 30};
        System.out.println(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        array[0]=100;
        array[1]=200;
        array[2]=300;
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
		int count = array.length;
        System.out.println(count);
```

## 第三章 数组原理内存图

### 1.内存概述

内存是计算机中的重要原件，临时存储区域，作用是运行程序。我们编写的程序是存放在硬盘中的，在硬盘中的程序是不会 运行的，必须放进内存中才能运行，运行完毕后会清空内存。
Java虚拟机要运行程序，必须要对内存进行空间的分配和管理。

### 2.Java虚拟机的内存划分

为了提高运算效率，就对空间进行了不同区域的划分，因为每一片区域都有特定的处理数据方式和内存管理方式。

| 区域名称   |                                                            |
| ---------- | ---------------------------------------------------------- |
| 寄存器     | 给CPU使用，和我们开发无关。                                |
| 本地方法栈 | JVM在使用操作系统功能的时候使用，和我们开发无关。          |
| 方法区     | 存储可以运行的class文件。                                  |
| 堆内存     | 存储对象或者数组，new来创建的，都存储在堆内存。            |
| 方法栈     | 方法运行时使用的内存，比如main方法运行，进入方法栈中执行。 |

```java
基本类型
        (1)整数数组：元素默认值为
        (2)小数数组：元素默认值为0.0
        (3)字符数组：元素默认值为空白字符
        (4)布尔数组：元素默认值为false
        引用类型:
        元素默认值为null
        一个数组两个引用的内存图解
1.注意：
(1)数组名称保存数组在堆内存空间的地址值
(2)通过数组名称找到堆内存空间的数组容器，
然后再通过素引编号找到数组容器中的指定的元素进行相关操作
2.一个数组两个引用的理解：
数组变量one中保存数组在内存空间的地址值，把数组变量one赋值给一个新的数组变量two,
导致数组变量one和two保存的是相同的地址值，操作的就是堆内存中的同一个数组
one是打开北京昌平的两居室房子的钥匙，通过钥匙one配了一把新的钥匙two
所以钥匙one和钥匙two打开的都是北京昌平两居室的房子
钥匙one:你自己拿春
钥匙two:你对象拿着
4.获取数组长度（数组中存储元素的个数）
每个数组内部都有一个Length属性，用于获取数组的长度，其实是一个int数据
数组名称.Length:获取数组的长度，是一个int数据
注意：Length后面是没有（)的    
```

## 第四章 数组的应用

### 1.遍历数组

就是将数组中的每个元素分别获取出来，就是遍历。遍历也是数组操作中的基石。

```java
int[] arry={100,200,300};
        System.out.println(arry[0]);
        System.out.println(arry[1]);
        System.out.println(arry[2]);
        System.out.println("-----------");
        //循环遍历
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
```

### 2.求三个int数字的最大值

```java
/*需求：
数组元素最大值
实现步服：
1.定义int数组array,并初始化
2.假设素引为0的元素是最大的，保存到int变量max中
3.使用for循环获取后面的（从索引1开始）每个元素
3.1如果当前元素值大于max说明max中的值已经不是最大的了
3.2把当前元素值赋值给ma
4.for循环结束打印max的值
注意：
1.求和变量，奇数变量，都需要在循环前面定义，循环结束后使用
2.求最大值变量，求最小值变量，求平均值变量，都需要在循环前面定义，循环结束后使用
*/
public class Demo02MaxArray {
    public static void main(String[] args) {
        int max;//保存最大值
        int[] array = {5, 15, 2000, 10000, 100, 4000};
        max = array[0];//将以一个数赋值给max
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max)
                max=array[i];

        }
        System.out.println("数组元素最大值为:"+max);
    }
}
```

## 第五章 数组操作常见问题

### 1.数组索引越界（超出了范围）异常

```java
/*数组操作的常见问题一：
 
1.问题描述：java中使用一个类
java.Lang.ArrayIndexoutofBoundsException
描述数组索引越界异常这种问题
2.产生原因：
访问数组元素时，给出的索引编号超出了数组素引编号的范围（从0开始，到数组长度减1)
3.解决方案：
找到素引越界的代码位置，进行修改，让素引在合理的范围之内
 */
public class Demo01ArrayProblem {
    public static void main(String[] args) {
        int[] one = new int[]{100,200};
        System.out.println(one[0]);
        System.out.println(one[1]);
        System.out.println(one[2]);//报错,停止运行

        System.out.println("main------------end");
        /*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
        at cn.com.mryhl05.Demo01ArrayProblem.main(Demo01ArrayProblem.java:11)*/
    }
}

```

### 2.数组空指针异常

```java
/*数组操作的常见问题一：
 数组空指针异常
1.问题描述：java中使用一个类
java.lang.NullPointerException
描述数组空指针异常这种问题
2.产生原因：
null是引用类型的空常量，可以给任意引用类型变量赋值，一旦赋值给某个引用变量后，
说明该引用变量已经不再执行堆内存的任何空间，也就不能通过该引用变量操作堆内存空间中的内容
数组变量one被赋值为mull后，说明该数组变量one,不再执行堆内存空间的任何数组，
也就不能再通过数组变量one访问堆内存空间中的数组元素，一旦访问，就会报出空指针异常
3.解决方案：
(1)不要使用为null的引用变量，访问堆内存空间的内容
(2)找到引用变量值为muLL的位置，进行修改不让它的是nulL,让变量重新指向堆内存空间
 */
public class Demo02ArrayProblem {
    public static void main(String[] args) {
        int[] one = new int[]{100,200};
        System.out.println(one[0]);
        System.out.println(one[1]);
        System.out.println(one);
        //把null赋值给one
        one=null;
        System.out.println(one);
        System.out.println(one[0]);//错误,空指针异常
        /*Exception in thread "main" java.lang.NullPointerException
        at cn.com.mryhl05.Demo02ArrayProblem.main(Demo02ArrayProblem.java:21)*/
        System.out.println("main------------end");

    }
}
```







## 总结

```java
能够知道数组变量的定义格式
	int[] arrayA;//推荐使用格式
	int  arrayB[];//不推荐使用
能够使用两种方式完成数组元素的初始化
//1.默认初始化：指定数组长度
int[]arrayA=new int[3];
//2.标准格式静态初始化：指定元素
int[]arrayB=new int[]{10,20,30};
//3.简化格式静态初始化：指定元素
int[] arrayc = {10,20,30};
能够知道数组在内存中的初始化过程（了解）
能够完成数组的遍历操作
//1.创建int数组array,并初始化
int[]array={10,20,30};
//2.使用for循环遍历数组
for(int i=0;i<array.length;i++){
sout(array[i]);
for(int i=0;i<=srray.length-1;i++){
sout(array[i]);
能够完成数组的获取最值操作
//1.创建int数组array,并初始化
int[]array={10,20,30};
//2.假设索引0元素是最大的，保存到int变量max中
int max=array[0];    
//3.使用for循环获取后面的每个元素
for(int i=1;i<array.length;i++){
//3.1如果当前元素大于max,说明max中的值已经不是最大的了
if(array[i]>max){
//3.2把当前元素值赋值给max
) I max = array [ i ] ;
}
//4.for循环结束，打印max
sout("max="+max);
```




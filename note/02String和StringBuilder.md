<center>String和StringBuilder</center>

## 今日内容

- String
- StringBuilder
- 能够根据文档查询String和StringBuilder的方法,并进行使用.

## 第一章 String类

### 1.概述

String类代表字符串。  Java程序中的所有字符串文字（例如"abc"）都被实现为此类的实例。

```java
在JDK8以及之前的版本，字符申本质是一个char数组。
在JDK9以及之后的版本，字符申本质是一个byte数组。

字符串创建后不能改变
字符串可以被共享
String s = "abc";
String s1 = "abc";
String所在的包是Java.lang包,此包的内容直接使用不需要导包
```

### 2.常用构造方法

```java
String() :空参 的构造

String(String original)
初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。

String(char[] value)
分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。

String(char[] value, int offset, int count)
分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
value - 作为字符源的数组
offset - 初始偏移量
count - 长度

String(byte[] bytes) (字节数组)
通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
String(byte[] bytes, int offset, int length)
通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。


字符串是一个特殊的引用类型,直接输出字符串
```

```java
public class Demo02StringConstrutor {
    public static void main(String[] args) {
        // String() :空参 的构造
        String str = new String();
        System.out.println("str:" + str);
        // String(String original)
        String str1 = new String("hello");
        System.out.println("str1:" + str1);
        // String(char[] value)
        char[] cc1 = {'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(cc1);
        System.out.println("str2:" + str2);
        // String(char[] value, int offset, int count)
        String str3 = new String(cc1,1,3);
        System.out.println("str3:" + str3);
        // String(byte[] bytes)
        byte[] bb  ={96,97,98,99,100};
        String str4 = new String(bb);
        System.out.println("str4:" + str4);
        // String(byte[] bytes, int offset, int length)
        String str5 = new String(bb,2,3);
        System.out.println("str5:" + str5);
    }
}
```

### 2.字符串new方式创建对象与直接赋值的区别

==比较基本类型和引用类型有些区别
如果==比较基本类型，比较的是值。
如果==比较引用类型，比较的是地址值

字符串是常量，会保存到常量池中。
只有使用双引号直接写出来的字符串才是常量。
扩展：
在JDK6以及之前的版本，常量池在方法区
在JDK7的时候，常量池在堆内存
在JDK8的时候，常量池在元空间【方法区】
字符常量是可以复用的，当我们使用到一个字符串常量时，会先看一下常量池
中有没有这个东西，如果有，就直接使用常量池中的，如果没有，就创建一个
该字符串常量放到常量池中

new的方式创建字符串，会先由栈指向堆，由堆指向常量池。
直接赋值的方式是由栈直接指向常量池

```java
public class Demo03String {
    public static void main(String[] args) {
        String str = "hello";
        String str1 = new String("hello");
        String str2 = "hello";
        System.out.println("str:"+str);
        System.out.println("str1:" + str1);
        System.out.println("str==str1:" + (str == str1));
        System.out.println("str==str2:" + (str == str2));


    }
}
```

### 3.字符串的判断方法

```java
/*
判断方法
boolean equals(Object anObject)
将此字符串与指定对象进行比较。
boolean equalsIgnoreCase(String anotherString)
将此 String与其他 String比较，忽略案例注意事项。 不区分大小写
boolean contains(String s):判断字符串中是否包含指定的内容。
boolean startswith(string prefix):判断字符申是否以指定的内容开头。
boolean endswith(String suffix):判断字符串是否以指定的内容结尾
 */
public class Demo04StringMethod {
    public static void main(String[] args) {
        String str = "hello";
        String str1 = new String("hello");
        String str2 = "Hello";
        // equals比较
        System.out.println("=======equals比较=========");
        System.out.println(str.equals(str1));
        System.out.println(str.equals(str2));
        // equalsIgnoreCase
        System.out.println("=======equalsIgnoreCase比较不区分大小写=========");
        System.out.println(str.equalsIgnoreCase(str2));
        // contains
        System.out.println("=======contains是否存在=========");
        String ss = "helloworld";
        System.out.println(ss.contains(str));
        System.out.println(ss.contains("str"));
        // startswith(string prefix)
        System.out.println("======startswith开头==========");
        System.out.println(ss.startsWith("abc"));
        System.out.println(ss.startsWith("he"));
        // endswith
        System.out.println("========endswith结尾=========");
        System.out.println(ss.endsWith("abc"));
        System.out.println(ss.endsWith("ld"));

    }
}
```

### 4.字符串获取的方法

```java
/*
字符串的获取的方法
length() :返回此字符串的长度。
concat(String str) :将指定的字符串连接到该字符串的末尾。返回新字符串
charAt(int index) :返回 char指定索引处的值。
indexOf(String str) :返回指定子字符串第一次出现的字符串内的索引。没有找到返回-1
lastIndexOf(String str) :返回指定子字符串最后一次出现的字符串中的索引。没有找到返回-1
substring(int beginIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串
substring(int beginIndex, int endIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串,包含头,不包含尾

 */
public class Demo05Stringethod {
    public static void main(String[] args) {
        //length() :返回此字符串的长度。
        String s = "helloworld";
        System.out.println("字符串的长度为:" + s.length());
        System.out.println("================");
        // charAt(int index) :返回 char指定索引处的值。
        System.out.println("字符串索引为1的字符" + s.charAt(1));
        System.out.println("================");
        // indexOf(String str) :返回指定子字符串第一次出现的字符串内的索引。
        System.out.println("查找o在字符串第一次出现的索引" + s.indexOf("o"));
        System.out.println("查找owo在字符串第一次出现的索引" + s.indexOf("owo"));
        System.out.println("查找nihao在字符串第一次出现的索引" + s.indexOf("nihao"));
        System.out.println("================");
        // lastIndexOf(String str) :返回指定子字符串最后一次出现的字符串中的索引。
        System.out.println("查找o在字符串最后次出现的索引" + s.lastIndexOf("o"));
        System.out.println("查找or在字符串最后次出现的索引" + s.lastIndexOf("or"));
        System.out.println("查找abc在字符串最后次出现的索引" + s.lastIndexOf("abc"));
        System.out.println("================");
        // concat(String str) :将指定的字符串连接到该字符串的末尾。返回新字符串
        String s2=s.concat("hihao");
        System.out.println(s2);
        System.out.println("================");
        // substring(int beginIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串
        s.substring(5);
        System.out.println(s);
        System.out.println(s.substring(5));//从索引为5的位置进行截取
        System.out.println("================");
        // substring(int beginIndex, int endIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串

        s.substring(5,7);
        System.out.println(s);
        System.out.println(s.substring(3,6));//从索引为5的位置进行截取

        System.out.println("================");
        

    }
}
```

### 5.转换方法

```java
/*
字符串的转换的方法
char[]toCharArray():将字符申转成字符数组并返回。
byte[]getBytes():将字符申转成字节数组并返回。
String tolowerCase():将字符串全部转成小写并返回转换后新的字符串。
String toUpperCase():将字符串全部转成大写并返回转换后新的字符串。
String replace(String oldStr, String newStr):替换完符串。使用newstr替换掉所有的oldstr,并返回新的字符串
 */
public class Demo05Stringethod {
    public static void main(String[] args) {

        String s = "abcde";
        // toCharArray():将字符申转成字符数组并返回。
        System.out.println("=======toCharArray():将字符申转成字符数组并返回=========");
        char[] cAr = s.toCharArray();
        for (int i = 0; i < cAr.length; i++) {
            System.out.println(cAr[i]);
        }
        // getBytes():将字符申转成字节数组并返回
        System.out.println("=======getBytes():将字符申转成字节数组并返回=========");
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        // tolowerCase():将字符串全部转成小写并返回转换后新的字符串。
        System.out.println("=======tolowerCase():将字符串全部转成小写并返回转换后新的字符串。=========");
        String s1 = "ASDCSF";
        String s2 = s1.toLowerCase();
        System.out.println(s2);
        // toUpperCase():将字符串全部转成大写并返回转换后新的字符串。
        System.out.println("=======toUpperCase():将字符串全部转成大写并返回转换后新的字符串。=========");
        String s3 = s.toUpperCase();
        System.out.println(s3);
        // replace(String oldStr, String newStr):替换完符串。使用newstr替换掉所有的oldstr,并返回新的字符串
        System.out.println("replace(String oldStr, String newStr):替换完符串。使用newstr替换掉所有的oldstr,并返回新的字符串");
        String s4 = s.replace("ab", "AB");
        System.out.println(s4);

    }
}
```

### 6.字符串分割

```java
/*
字符串的分割的方法
String[] split(String regex):根据指定字符串进行切割，切割之后的内容会放到字符申数组中返回。
String trim():去除字符串两边的空格
 */
public class Demo07Stringethod {
    public static void main(String[] args) {

        String s = "aa,bb,cc";
        // String[] split(String regex):根据指定字符串进行切割，切割之后的内容会放到字符申数组中返回。
        String[] s1 = s.split(",");
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        //  String trim():去除字符串两边的空格
        String s2 = "     abc     def   ";
        String s3 = s2.trim();
        System.out.print("原字符串:"+s2);
        System.out.println("==");
        System.out.print("新字符串:"+s3);
        System.out.println("==");

    }
}
```

### 7.遍历字符串

```java
/*
遍历字符串【依次拿到字符申中每一个字符，然后进行操作】
 */
public class Demo08StringTest {
    public static void main(String[] args) {
        // 定义字符串
        String s = "abcd";
        // 使用笨方法获取每个元素
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
```

### 8.字符串遍历输出大小写数字数

```java
/*

    统计字符次数
        键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不统计其他字符)

    思路：
        1. 键盘录入一个字符串。
        2. 定义三个变量表示计数器，分别统计大写字母，小写字母，以及数字字符的个数。
        3. 遍历字符串，拿到字符串中的每一个字符。
        4. 判断这个字符是大写字母还是小写字母还是数字，并且把对应的计数器自增。
        5. 输出计数器的内容。

    ctrl + alt + v： 可以直接生成方法后的结果
 */

import java.util.Scanner;

public class Demo08StringEg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.nextLine();
        int num=0,dz=0,xz=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z')
                xz++;
            if(c>='0'&& c<='9')
                num++;
            if(c>='A' && c<='Z')
                dz++;
        }
        System.out.println("存在数字" + num + "个,小写字母" + xz + "个,大写字母" + dz + "个");
    }
}
```

## 第二章 StringBuilder类

### 1.概念

```java
/*
StringBuilder叫做可变的字符序列,可以看成字符串
StringBuilder也是由一串字符组成的数据,本质是字符数组, 内部都是在使用字符数组保存数据。

    StringBuilder和String的区别
        StringBuilder: 可变的。
        String： 不可变的。
 StringBuilder构造方法
    StringBuilder():使用该构造方法创建的StringBuilder对象没有任何内容
    StringBuilder(String str)： 传递一个字符串。根据字符串的内容创建一个StringBuilder对象。
 StringBuilder是一个特殊的引用类型，如果直接打印该对象名，打印的是内容。和toString方法有关，过两天讲解

 */
public class Demo02StringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        // 根据一个字符串创建StringBuilder对象
        StringBuilder stringBuilder1 = new StringBuilder("你好");
        System.out.println(stringBuilder1);
    }
}
```

### 2.常见方法

```java
/*
StringBuilder常见方法
    StringBuilder append(任何类型)： 拼接（追加）任何类型的数据。返回值为调用者对象本身。
        StringBuilder reverse(): 对StringBuilder的内容反转。返回值为调用者对象本身。
        String toString()： 将StringBuilder转成一个String。

 */
public class Demo03StringBuilder {
    public static void main(String[] args) {
        //创建StringBuilder对象
        StringBuilder sb = new StringBuilder();
        //StringBuilder append(任何类型)： 拼接（追加）任何类型的数据
        //StringBuilder newSb = sb.append("你好");
        //输出结果
        //System.out.println("sb:" + sb);
        //System.out.println("newSb:" + newSb);

        //向sb对象上拼接任何类型的数据
       

        //链式编程
        sb.append("你好").append("我好").append("大家好");
        System.out.println("反转前sb:" + sb);//你好我好10

        //StringBuilder reverse(): 对StringBuilder的内容反转。返回值为调用者对象本身。
        sb.reverse();
        System.out.println("反转后sb:" + sb);//01好我好你

        //String toString()： 将StringBuilder转成一个String。
        String ss = sb.toString();
        System.out.println("字符串ss:" + ss);//01好我好你
    }
}
```

### 3.String和StringBuilder相互转换

```java
/*
    String和StringBuilder相互转换
    StringBuilder  -> String
    调用StringBuilder中的toString方法即可
        String toString()： 将StringBuilder转成一个String。

    String -> StringBuilder
        使用StringBuilder的带参数的构造方法创建一个StringBuilder对象。
        StringBuilder(String str)： 参数要传递一个字符串。 会根据字符串的内容创建一个StringBuilder对象。
 */
public class Demo04StringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你好");
        System.out.println("StringBuilder:" + stringBuilder);
        String s = stringBuilder.toString();
        System.out.println(s);
        System.out.println("======");
        String s1 = "hello";
        StringBuilder stringBuilder1 = new StringBuilder(s1);
        System.out.println(s1);
        System.out.println("StringBuilder1:" + stringBuilder1);

    }
}
```

### 4.字符串拼接

```java
/*
字符串拼接
    定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，
    拼接格式： [11, 22, 33, 44, 55]
 */

public class Demo05StringBuilderTest {
    public static void main(String[] args) {
        int[] arr= {11,22,33,44,55};
        String s = arrayToString(arr);
        System.out.println("拼接后:"+s);

    }
    /*
    定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，
    参数: int[]
    返回值:字符串
     */
    public static String arrayToString(int[] arr){
        /*
        将arr数组中的内容转换成字符串并返回
        步骤:
            创建StringBuilder用来拼接
            拼接左半边的中括号
            遍历数组,拿到数组元素
            将遍历到的元素拼接到StringBuilder上
            判断遍历到的是否是最后一个元素,输出逗号
            拼接右边中括号
            转换成String返回
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            if(i<arr.length-1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        String s = stringBuilder.toString();
        return s;
    }
}
```

## 总结

```java
一. String
	概念：
		字符串一串字符组成的数据，本质就是一个字符数组。
		字符串具有不变性。
		
	构造方法：
		String()
		String(String str)
		String(char[] cArr)：根据字符数组的内容创建字符串。
		String(char[] cArr, int offset, int length)： 根据字符数组的一部分创建字符串，参数offset表示起始索引，length表示长度
		String(byte[] bArr)：根据byte数组的内容创建字符串
		String(byte[] bArr, int offset, int lenght)： 根据byte数组的一部分创建字符串
		直接赋值的方式也是创建字符串： String str = "hello"
		
	判断方法；
		equals：比较两个字符串的内容是否相同。
		equalsIgnoreCase：比较两个字符串的内容是否相同，不区分大小写。
		contains：判断是否包含
		startsWith：判断是否以什么开头
		endsWith：判断是否以什么结尾
		
	获取方法：
		length：获取字符串长度
		charAt：获取指定索引位置的字符。
		indexOf：在大串找小串第一次出现的索引。如果没有找到返回-1
		lastIndexOf：在大串找小串最后一次出现的索引。如果没有找到返回-1
		concat： 拼接字符串。 
		substring：截取字符串
		
	转换方法：
		toCharArray：将字符串转成字符数组
		getBytes：将字符串转成字节数组
		toUpperCase：转大写
		toLowerCase：转小写
		replace：替换
		
	分割方法：
		split：切割字符串
		trim：去除两边空格
		
二. StringBuilder 
	为什么使用StringBuilder：
		String进行拼接，每次拼接都会创建新的字符串，效率低。于是有了StringBuilder，StringBuilder可以改变，如果使用StringBuilder拼接效率高。
		
	StringBuilder的构造方法
		StringBuilder()
		StringBuilder(String str)
		
	StringBuilder的常见方法
		append：拼接
		reverse：反转
		toString：将StringBuilder转成String
		
	StringBuilder和String的相互转换
		String -> StringBuilder
			通过StringBuilder的构造方法根据字符串创建StringBuilder对象即可
			StringBuilder(String str)
		StringBuilder -> String
			使用StringBuilder的toString方法完成
			toString：将StringBuilder转成String
```


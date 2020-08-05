<center>File类、递归、字节流、字符流</center>

## 今日内容

+ file类
+ 递归
+ 字节流
+ 字符流

## 第一章 file类

### 1.介绍

目录(directory):文件夹,文件夹可以保存文件.
文件(file):文件,可以保存数据
路径(path):表示计算机中的一个位置,这个文件可以是文件夹,也可以是文件.

在Java中，有一个类叫做File,这个类表示计算机中的文件或文件夹。
在英语单词中file表示文件的意思，但是在Java中，File不仅能够表示文件，也能够表示文件夹。
我们可以通过File类完成对文件或文件夹的操作。

### 2.构造方法

File(String pathname):根据文件或文件夹的路径创建File对象。
File(String parent,String child):根据父路径和子路径创建一个File对象
        文件的路径：D:\test\aa.txt
        父路径：D:\test
        子路径：aa.txt
File(File parent,String child):根据父路径和子路径创建一个File对象

File可以表示计算机中的文件，也可以表示文件夹
File表示的文件或文件夹在计算机中可以是存在的，也可以是不存在的。

```java
import java.io.File;

public class Demo02Constructor {
    public static void main(String[] args) {
        // File(String pathname):根据文件或文件夹的路径创建File对象。
        // 在Java中\是特殊字符，叫做转义字符，表示将后面的字符改变意思
        // 如果想要表示普通的，需要写两个\\
        //File file = new File("e:\\test\\aa.txt");
        File file = new File("e:\\test\\zz.txt");
        // 输出file
        System.out.println(file);

        // File(String parent,String child):根据父路径和子路径创建一个File对象
        // 创建file对象表示e:\test\aa.txt
        File file1 = new File("e:\\test","aa.txt");
        System.out.println(file1);
        // File(File parent,String child):根据父路径和子路径创建一个File对象
        // 创建File对象表示test文件夹
        File parent = new File("e:\\test");
        File file2 = new File(parent,"aa.txt");
        System.out.println(file2);
    }

}
```

### 3.相对路径与绝对路径

1. 相对路径：是一个简单的路径，不是从盘符开始的，在idea中，相对相对路径相对的是当前项目，指的是当前项目下的东西。
2. 绝对路径：是一个完整的路径,从盘符开始的路径。

```java
public class Demo03Path {
    public static void main(String[] args) {
        // 创建File[相对路径,相当于当前项目下的文件aa.txt]
        File file = new File("aa.txt");
    }
}
```

### 4.获取方法

String getAbsolutePath():获取FiLe对象表示的文件或文件夹的绝对路径。
String getpath():获取路径
String getNe():获取文件或文件夹名字
Long Length():获取文件字节数大小，只能对文件使用，如果用过文件夹使用，得到的是一个不确定的数字。

```java
import java.io.File;

public class Demo01FileMethod {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
    }
    /*
        String getAbsolutePath():获取FiLe对象表示的文件或文件夹的绝对路径。
    */
    public static void method1(){
        // 创建file对象
        // File file = new File("e:\\test\\aa.txt");
        File file = new File("aa.txt");
        // 输出file
        System.out.println(file.getAbsolutePath());

    }
    /*
        String getpath():获取路径
    */
    public static void method2(){
        // 创建file对象
        // File file = new File("e:\\test\\aa.txt");
        File file = new File("aa.txt");
        // 调用getPath获取路径
        System.out.println(file.getPath());
    }
    /*
        String getNe():获取文件或文件夹名字
     */
    public static void method3(){
        // 创建file对象
        File file = new File("e:\\test\\aa.txt");
        //File file = new File("aa.txt");
        // 调用getName获取路径
        System.out.println(file.getName());
    }
    /*
    Long Length():获取文件字节数大小，只能对文件使用，如果用过文件夹使用，得到的是一个不确定的数字。
     */
    public static void method4(){
        // 创建file对象
        File file = new File("e:\\test\\aa.txt");
        System.out.println(file.length());
    }
}
```

### 5.判断功能方法

boolean isDirectory():判断是否是文件夹。
boolean isFile():是否是一个文件
boolean exists():判断FiLe对象表示的文件或文件夹是否存在

```java
import java.io.File;
public class demo02FileMethod {
    public static void main(String[] args) {
        // 创建File对象
        File file = new File("e:\\test\\aa.txt");
        // boolean isDirectory():判断是否是文件夹。
        System.out.println("是否是文件夹"+file.isDirectory());
        // boolean isFile():是否是一个文件
        System.out.println("是否是文件"+file.isFile());
        // boolean exists():判断FiLe对象表示的文件或文件夹是否存在
        System.out.println("是否是存在"+file.exists());
    }
}

```
### 6.创建的功能

boolean createNewFile():创建文件，如果文件已经存在，那么创建失败。
boolean mkdir():创建文件夹，如果文件夹已经存在，那么创建失败。
boolean mkdirs():创建文件夹，如果文件夹已经存在，那么创建失败【如果上级目录不存在，同时会创建上级目录】

```java
import java.io.File;
import java.io.IOException;

public class Demo03FileMethod {
    public static void main(String[] args) throws IOException {
        method1();
        method2();
        method3();
    }
    /*
    boolean createNewFile():创建文件，如果文件已经存在，那么创建失败。
    课创建文件，上级目录不存在，那么会报错

     */
    public static void method1() throws IOException {
        // 创建File对象
        File file = new File("e:\\test\\zz.txt");
        // 创建文件
        boolean flag = file.createNewFile();
        // 输出
        System.out.println("创建对象: " + flag);
    }
    /*
    boolean mkdir():创建文件夹，如果文件夹已经存在，那么创建失败。
    加果创建文件夹，上级目录不存在，那么会创建失败【不会报错】
    */
    public static void method2(){
        // 创建File对象
        File file = new File("e:\\test\\bb");
        // 创建文件夹
        boolean flag = file.mkdir();
        // 调用mkdir输出
        System.out.println("创建文件夹: " + flag);
    }
    /*
    boolean mkdirs():创建文件夹，如果文件夹已经存在，那么创建失败【如果上级目录不存在，同时会创建上级目录】
    使用mkdirs创建文件夹时,如果文件夹上级目录不存在,一同创建上级目录
    */
    public static void method3(){
        // 创建File对象
        File file = new File("e:\\test2\\bb");
        // 调用mkdirs创建文件夹
        boolean flag = file.mkdirs();
        // 输出
        System.out.println("创建文件夹: " + flag);

    }

}
```

### 7.删除方法

boolean delete():删除File对象表示的文件或文件夹。delete删除的文件夹必须是空文件

【delete方法删除的内容不走回收站】

```java
import java.io.File;
public class Demo04FileMethod {
    public static void main(String[] args){
        File file = new File("e:\\test");
        // 调用delete删除文件夹
        boolean flag = file.delete();
        // 输出
        System.out.println("删除文件: " + flag);

    }

}
```



## 第二章 递归





## 第三章 IO流





## 第四章 字节流






<center>File类、递归、字节流、字符流</center>

## 今日内容

+ file类
  + 获取方法
  + 判断方法
  + 创建方法
  + 删除方法
+ 递归
+ 字节流
  + 输入流
  + 输出流
+ 字符流
  + 输入流
  + 输出流

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
String getPath():获取路径
String getName():获取文件或文件夹名字
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

### 8.目录的遍历

(了解)String[] List():获取指定目录下所有文件和文件夹的名字放入到字符申数组中返回。
        File[] ListFiles():获取指定目录下所有文件和文件夹并放入到File数组中返回。
    注意
        如果FiLe对象表示的是一个文件，那么调用ListFiles得到的是null值。
        如果File对象表示的是一个不存在的文件夹，那么调用ListFiles得到的是null值。
        在使用ListFiles时，一定要注意，必须通过已经存在的文件夹调用该方法。

```java
import java.io.File;


public class Demo05ListMethod {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }

    public static void method3(){
        // 创建File对象
        File file = new File("e:\\test\\aa\\zz");
        // 调用ListFiles方法,获取test下的所以的文件和文件夹
        File[] files = file.listFiles();
        System.out.println(files);//null
        // 遍历会出现空指针异常

    }

    /*
    File[] ListFiles():获取指定目录下所有文件和文件夹并放入到File数组中返回。
    */
    public static void method2(){
        // 创建File对象
        File file = new File("e:\\test");
        // 调用ListFiles方法,获取test下的所以的文件和文件夹
        File[] files = file.listFiles();
        // 遍历数组,输出对象
        for (File s : files) {
            System.out.println(s);
        }
    }
    // e:\test\aa
    // e:\test\bb
    // e:\test\cc
    /*
        String[] List():获取指定目录下所有文件和文件夹的名字放入到字符申数组中返回。
    */
    public static void method1(){
        // 创建File对象
        File file = new File("e:\\test");
        // 调用list方法,获取test下的所以的文件和文件夹
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
    // aa
    // bb
    // cc

}
```

## 第二章 递归

### 1.概述

递归：指在当前方法内调用自己的这种现象。

注意:
       1. 递归必须要有出口【结束条件】
    2. 递归次数不能太多【否则也会出现栈内存溢出】

递归的使用场景：
    在不确定层级的场景，可以使用递归【比如遍历文件夹，比如遍历菜单】

```java
public class Demo01DiGui {
    public static void main(String[] args) {
        //method();
        printNumber(1);
    }
    //定义方法
    public static void printNumber(int num){
        // 结束条件
        if (num == 10000)
            return;
        System.out.println(num);//1-11412
        num++;
        printNumber(num);
    }
    // 定义方法
    /*public static void method(){
        System.out.println("方法执行了");
        method();
    }*/
}
```

### 2.演示

使用递归求阶乘
求阶乘公式
    n！=n*（n-1）*....*1
递归思想：
    5！ = 5 * 4！
    4！ = 4 * 3！
    3！ = 3 * 2！
    2！ = 2 * 1！
    1！ = 1
规律：
    如果是求1的阶乘，结果就是固定值1.
    如果是求其他数字的阶乘，结果是这个数 * 这个数减1的阶乘

```java
public class Demo02DiGuiTest {
    public static void main(String[] args) {
        System.out.println(getJieCheng(5));
    }
    /*
    定义方法,该方法用来求一个数的阶乘
    参数:int n
    返回值:int n
     */
    public static int getJieCheng(int n){
        if (n == 1)
            return 1;
        return n * getJieCheng(n-1);
    }
}
```

### 3.输出指定文件夹下所有文件名

```java
import java.io.File;

/*
    输出指定文件夹下所有文件名
    步骤：
        1. 定义一个方法，该方法遍历指定的文件夹
        2. 调用listFiles方法，获取该文件夹下所有文件和文件夹放入到File数组中保存
        3. 遍历File数组，拿到里面的每一个文件和文件夹。
        4. 判断如果遍历到的是文件夹，那么就应该继续遍历该文件夹；
           如果遍历到的是文件，那么直接获取输出
 */
public class Demo03PrintDirtest {
    public static void main(String[] args) {
        // 调用printDir,遍历指定文件夹，输出读文件夹下所有文件的名字
        printDir(new File("e:\\下载文件"));
    }
    /*
    定义一个方法，该方法遍历指定的文件夹
     */
    public static void printDir(File dir){
        // 调用listFiles方法，获取该文件夹下
        // 所有文件和文件夹放入到File数组中保存
        File[] files = dir.listFiles();
        // 遍历File数组，拿到里面的每一个文件和文件夹。
        for (File thisFfile : files) {
            if (thisFfile.isDirectory()){
                // 如果是文件夹，那么就应该继续遍历该文件夹；
                // 递归遍历
                printDir(thisFfile);
            }else {
                // 如果遍历到的是文件，那么直接获取输出
                System.out.println(thisFfile.getName());
            }

        }
    }
}
```



## 第三章 IO流

### 1.概念

我们把这种数据的传输，可以看做是一种数据的流动，按照流动的方向，以内存为基准，分为输入 input 和输出output ，即流向内存是输入流，流出内存的输出流。
Java中I/O操作主要是指使用java.io包下的内容，进行输入、输出操作。输入也叫做读取数据，输出也叫做作写出数据。

输入和输出都是依照内存为参照物的，输出从内存中出去输入就是进入到内存。

### 2.分类

根据数据的流向分为：输入流和输出流。

 	输入流 ：把数据从其他设备上读取到内存中的流。

 	输出流 ：把数据从内存 中写出到其他设备上的流。 

根据数据的类型分为：字节流和字符流。

​	字节流 ：以字节为单位，读写数据的流。

​	字符流 ：以字符为单位，读写数据的流。

### 3.使用场景

用于数据传输，例：上传，下载，拷贝

#### 4.顶层父类

|        | 输入流                 | 输出流                  |
| ------ | ---------------------- | ----------------------- |
| 字节流 | 字节输入流 InputStream | 字节输出流 OutputStream |
| 字符流 | 字符输入流 Reader      | 字符输出流 Writer       |



## 第四章 字节流

### 1.字节

8个比特位就是一个字节。 一切文件数据(文本、图片、视频等)在存储时，都是以二进制数字的形式保存，都是一个一个的字节，那么传输时一样如此。所以，字节流可以传输任意文件数据。在操作流的时候，我们要时刻明确，无论 使用什么样的流对象，底层传输的始终为二进制数据。

### 2.字节输出流【OutputStream】

#### 2.1介绍

OutputStream是字节输出流，用来写，可以将Java程序中的数据写到文件中。

OutputStream可以以字节为单位写数据。

OutputStream是所有字节输出流的顶层父类，是一个抽象类，如果要用，需要使用子类，最常用的子类是FileOutputStream

#### 2.2构造方法

1. FileOutputStream(String name)：参数要传递一个字符串类型的文件路径，表示向这个文件中写数据。

2. FileOutputStream(File file)：参数要传递一个File类型的文件，表示向这个文件中写数据。

#### 2.3其他方法

1. void write(int b)：向文件中写一个字节【重要】

2. void write(byte[] b)：向文件中写一个字节数组

3. void write(byte[] b, int off, int len)：向文件中写字节数组的一部分。参数off表示从哪个位置开始写，参数len表示写几个。

4. void close()：关闭流（释放资源）

#### 2.4字节输出流的使用步骤

1. 创建字节输出流对象，并绑定一个目的文件
2. 向文件中写数据
3. 关闭流

#### 2.5注意事项

ASCII码表上的这些字符，在计算机中都是占一个字节的。
在计算机中，中文是占多个字节的。
    如果采用的是GBK的编码，一个中文是两个字节
    如果采用的是UTF-8的编码，一个中文是三个字节。
因为中午在计算机中占用多个字节,因此不能用write方法写入中文字符

#### 2.6代码展示

```java
import java.io.FileOutputStream;
import java.io.IOException;
public class Demo01OutputSteam {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输出流对象，并绑定一个目的文件
        /*
            下面代码做了什么事
                1. 创建字符输出流对象
                2. 调用操作系统资源,创建aa.txt.如存在,会覆盖
                3. 将流与文件绑定,以后通过该流,操作的都是该文件
        */
        FileOutputStream os = new FileOutputStream("E:\\test\\aa.txt");
        // 2. 向文件中写数据
        // void write(int b)：向文件中写一个字节
        // os.write(100);// 文件中的内容是d,查询ASCII表,写入对应的字符
        // os.write('a');// a
        os.write('中');// -
        // 如果不关闭流,Java就不结束,该文件一直是占用状态.
        // while(true){}

        // 3. 关闭流
        os.close();


    }
}
// 写入多个字节
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输出流对象，并绑定一个目的文件
        FileOutputStream os = new FileOutputStream("day13\\aa.txt");
        // 2. 向文件中写数据
        // void write(byte[] b)：向文件中写一个字节数组
        // byte[] arr = {97,98,99,100,101};
        byte[] arr = "hello,你好".getBytes();
        /*System.out.println(Arrays.toString(arr));
        os.write(arr);*/
        os.write(arr,6,3);

        // 3. 关闭流
        os.close();

    }
}

```

#### 2.7续写

我们之前使用的构造方法创建流的同时会新建文件，如果文件已经存在会便盖
FileOutputstream(String name):该构造方法会创建文件，如果文件已经存在会厦盖掉原来的文件
如果创建流时不想要盖原来文件，可以使用下面的构造方法
FileOutputstream(String name,booLean append):第二个参数append表示是否续写，如果true,为续写，如果文件已经存在，就不会履盖了
FileOutputstream(File file, boolean apmend):第二个参数append表示是否续写，如果true,为续写，如果文件已经存在，就不会履盖了

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo03AppendWrite {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流
        OutputStream os = new FileOutputStream("day13\\aa.txt",true);
        // 像文件写一首诗
        // os.write("大风起兮云飞扬".getBytes());
        os.write(" 安得猛士兮守四方".getBytes());
        // 关闭流
        os.close();

    }
}
```

#### 2.8换行写

如果要进行换行操作,需要使用换行符
win:\r\n
mac:\r

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo04Writeline {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流
        OutputStream os = new FileOutputStream("day13\\aa.txt");
        // 像文件写一首诗
        os.write("大风起兮云飞扬\r\n".getBytes());
        os.write("安得猛士兮守四方\n".getBytes());// 老版本系统可能不能识别
        os.write("威加海内兮归故乡".getBytes());
        os.close();
    }
}
```

### 3.字节输入流【InputStream】

#### 3.1介绍

Inputstream是字节输入流，用来读，可以将文件中的数据读取到Java程序中。
InputStream是字节流，会以字节为单位读取数据

InputStream是所有字节输入流的顶层父类，是一个抽象类，如果要用，需要使用子类，最常用的子类是FileInputStream

#### 3.2构造方法

1. FileInputStream(String name)：参数要传递一个字符申类型的文件路径，表示要从该文件中读取数据。

2. FileInputStream(File file)：参数要传递一个File类型的文件，表示要从该文件中读取数据。

#### 3.3其他方法

1. int read()：从文件中读取一个字节并返回。如果已经读取结束了，返回-1
2. int read(byte[] b)：从文件中读取数据放到字节数组中，返回读取到的字节个数，如果已经读取结束了，返回-1.
3. void close():释放资源，关闭流。 

#### 3.4使用步骤

1. 创建字节输入流对象，绑定数据源文件。
2. 调用read方法，从文件中读取数据。
3. 调用close方法，释放资源。

```java
中文在文件中是占用多个字节的，我们不能使用一次读取一个字节的方式读取中文。
```

#### 3.5代码

```java
import java.io.FileInputStream;
import java.io.IOException;
public class Demo01InputSteam {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输入流对象，绑定数据源文件。[如果指定文件不存在,会保存]
        FileInputStream is = new FileInputStream("day13\\source.txt");
        // 2. 调用read方法，从文件中读取数据。
        /*int i = is.read();
        System.out.println(i);// 97
        i = is.read();
        System.out.println(i);// 98
        i = is.read();
        System.out.println(i);// 99
        i = is.read();
        System.out.println(i);// -1*/
        // 定义变量i,用于接收每次读取到是字节
        int i;
        /*
        条件位置做了哪些事情
            1.通过输入流调用了read方法读取了一个字节
            2.将读取到的字节赋值给了变
            3.判断是否不等于-1,如果不是-1,表示读取到了数据，就进行处理。
            读取到的数据会保存到变量i
         */
        while ((i=is.read())!=-1){
            System.out.print((char) i);
        }

        // 3. 调用close方法，释放资源。
        is.close();
    }
}

// 多字节
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
public class Demo02InputSteam {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输入流对象，绑定数据源文件。[如果指定文件不存在,会保存]
        InputStream is = new FileInputStream("day13\\source2.txt");
        // 2.读数据
        byte[] arr = new byte[2];
        // 将数据读取到arr中,因为数组长度是2,所以一次读取两个，返回值是读取到的字节个数。
        // 用来保存每次读取到的个数
        int len;
        // 循环读取
        /*条件位置做了哪些事情
        1.通过流将数据读取到了字节数组中，
        2.将读取到的字节个数返回，原值给了变量Len。
        3.判断Len如果不是-1,表示读取到了数据，就在循环中进行处理。
        读取到的数据保存到了bArr数组中，返回值Len是读取到的字节个数。*/
        while ((len=is.read(arr))!=-1){
            System.out.println(new String(arr,0,len));
            System.out.println(len);
        }

        /*
        byte[] arr = new byte[2];
        int len = is.read(arr);
        System.out.println(new String(arr,0,len));// [97, 98]
        System.out.println(len);// 2
        len = is.read(arr);
        System.out.println(new String(arr,0,len));// [99, 100]
        System.out.println(len);// 2
        len = is.read(arr);
        System.out.println(new String(arr,0,len));// [101, 100]
        System.out.println(len);// 1*/

        // 3.关闭
        is.close();
    }
}
```

### 4.图片复制案例

文件复制只需要将一个文件中的所有字节原模原样搞到另一个文件中即可。

文件复制的本质就是读和写，从源文件中读取字节，并将字书写到目的地文件即可。

如果要提高复制效率，可以采用数组的方法。

```java
import java.io.*;

/*
文件复制
文件复制的本质就是文件的读写，从源文件中读取字节，然后写到目的地文件。
步骤：
1.创建字节输入流，用来读取
2.创建字节输出流，用来写。
3.使用输入流读取数据，每次读取一个字节数组，将读取到的数据写到目的地文件中。
4.释放资源
*/
public class Demo03Copy {
    public static void main(String[] args) throws IOException {
        //1. 创建字节输入流，用来读取。
        InputStream is = new FileInputStream("day13\\s2.png");
        //2. 创建字节输出流，用来写。
        OutputStream os = new FileOutputStream("day13\\bb.png");
        //3. 使用循环读取，将数据读取到字节数组中，然后将读取到的数据写到目的地文件。
        //定义数组，用来保存读取到的数据
        byte[] bArr = new byte[1024];
        //定义变量表示读取到的字节个数
        int len;
        //开始循环
        while ((len = is.read(bArr)) != -1) {
            //如果条件成立，表示读取到了数据，那么就将读取到的数据写到目的地文件。
            os.write(bArr, 0, len);
        }
        //4. 释放资源
        // 后开的先关
        os.close();
        is.close();
    }
}
```

## 第五章 字符流

当使用字节流读取文本文件时，可能会有一个小问题。就是遇到中文字符时，可能不会显示完整的字 符，那是因为一个中文字符可能占用多个字节存储。所以Java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件。

### 1.字符输入流【Reader】

1. Reader是字符输入流，用来读，可以将文件中的数据读取到ava程序中。
2. Reader是属于字符流，会以字符为单位读取数据，可以读取中文【可以解决字节流读取中文的乱码问题】
3. Reader是所有字符输入流的顶层父类，是一个抽象类，如果要用，需要使用子类，常用的子类是FileReadeer

#### 1.1构造方法

1. FileReader(String fileName):参数需要传递字符串类型的文件路径，表示从该文件中读取数据。
2. FileReader(File file):参数需要传递File类型的文件，表示从该文件中读取数据。

#### 1.2FileReader读取数据的方法：

    1. int read():读取一个字符并返回，如果读取结束了，返回-1
       2. int read(char[]cbuf):将数据读取到字符数组，并返回读取到的字符个数，如果读取结束了，返回-1

#### 1.3FileReader使用步骤：

    1. 创建流
       2. 读数据
       3. 关闭流

```java
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        // 创建流
        Reader r = new FileReader("day13\\source02.txt");
        // 读数据
        // 定义变量接收读到的字符
        int i;
        while ((i = r.read())!= -1){
            System.out.print((char) i);
        }
        // 关流
        r.close();
    }
}
```

#### 1.4读字符数组

```java
/*
 使用字符输入流一次读取一个字符数组。
        int read(char[] cbuf)：将数据读取到字符数组中，并返回读取到的字符个数，如果已经读取结束了，返回-1.
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo02Reader {
    public static void main(String[] args) throws IOException{
        // 创建流
        Reader r = new FileReader("day13\\source02.txt");
        // 读数据
        // 创建数组
        char[] cArr = new char[1024];
        int len;
        while ((len = r.read(cArr))!= -1){
            System.out.print(new String(cArr,0,len));
        }
        // 关流
        r.close();
    }
}
```

### 2.字符输出流【Writer】

writer是字符输出流，用来写，可以将Java程序中的数据写到文件中。
Writer属于字符流，会以字符为单位写数指
writer是字符输出流的顶层父类，Writer也是抽象类，如果要用，需要使用子类，常用的子类是Filewriter

#### 2.1构造方法

1. Filewriter(String fileName):参数要传递一个字符串类型的文件路径，表示向读文件中写数据。
2. Filewriter(File file):参数要传递一个File类型的文件，表示向读文件中写数据。

#### 2.2其他方法

1. void write(string str):写字符申。   
2.  void flush():刷新    
3. void close():关闭流

#### 2.3Filewriter使用步骤：

    1. 创建字符输出流
       2. 写数据
       3. 刷新(只有字符输出流需要刷新)
       4. 关闭流

#### 2.4代码

```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class Demo01Writer {
    public static void main(String[] args) throws IOException {
        // 创建字符输出流
        Writer w = new FileWriter("day13\\ff.txt");
        // 写数据
        // void write(String s)
        w.write("你好");
        // 刷新
        w.flush();
        // 关流
        w.close();
    }
}
```

#### 2.5关闭和刷新的区别

```java
/*
关闭和刷新的区别
    flush:刷新,流在刷新后,流还能使用
    close:关闭
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02FlushAndClose {
    public static void main(String[] args) throws IOException {
        // 创建字符输出流
        Writer w = new FileWriter("day13\\ff.txt");
        // 写数据
        // void write(String s)
        w.write("你好");
        // 刷新
        w.flush();
        w.write("富商大贾");
        // 关流
        w.close();// 包含刷新操作,先刷新,后关闭
    }
}
```

### 3.字符流写数据的5个方法

1. void write(String str)：向文件中写字符串
2. void write(String str, int off, int len) ：向文件中写字符串的一部分。从off位置开始写，写len个。    
3. void write(int c)：向文件中写一个字符    
4. void write(char[] cbuf): 向文件中写字符数组    
5. void write(char[] cbuf, int off, int len)：向文件中写字符数组的一部分。 参数off表示从哪个位置写，参数len表示写几个。

```java
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        // 创建字符输出流
        Writer w = new FileWriter("day13\\fff.txt");
        // 写数据
        // void write(String s)
        //w.write("hello");// hello
        // w.write("hello",1,3);//ell
        //w.write(97);//a
        //w.write('中');//中
        char[] cArr = {'h','e','l','l','o'};
        //w.write(cArr);// hello
        w.write(cArr,1,3);// ell
        
        // 刷新
        w.flush();
        // 关流
        w.close();
    }
}
```

## 总结

````java

一. File
	File表示计算机中文件或文件夹
	
	构造方法：
		File(String pathname)：根据文件或文件夹的路径创建File对象。
        File(String parent, String child)：根据父路径和子路径创建一个File对象
        File(File parent, String child)：根据父路径和子路径创建一个File对象
		
	相对路径和绝对路径
		相对路径：简单的路径，不是从盘符开始，相对路径指定当前项目下的东西， 比如aa.txt
		绝对路径：详细的路径，是从盘符开始。 比如d:\aa.txt
		
	获取方法：
		String getAbsolutePath()：获取File对象表示的文件或文件夹的绝对路径。
        String getPath()：获取路径
        String getName()：获取文件或文件夹名字
        long length()：获取文件字节数大小。只能对文件使用，如果用过文件夹使用，得到的是一个不确定的数字。
	
	判断方法：
		boolean isDirectory()：判断是否是文件夹。
        boolean isFile()：是否是一个文件
        boolean exists()：判断File对象表示的文件或文件夹是否存在。
	
	创建方法：
		boolean createNewFile()：创建文件，如果文件已经存在，那么创建失败。
        boolean mkdir()：创建文件夹，如果文件夹已经存在，那么创建失败。
        boolean mkdirs()：创建文件夹，如果文件夹已经存在，那么创建失败【如果上级目录不存在，同时会创建上级目录】
	
	删除方法：
		boolean delete()：删除File对象表示的文件或文件夹。
	遍历方法：
		（了解）String[] list()：获取指定目录下所有文件和文件夹的名字放入到字符串数组中返回。
        File[] listFiles()：获取指定目录下所有文件和文件夹并放入到File数组中返回。

二. 递归
	是方法调用方法自己
	
	注意：
		1.必须要有终止条件，出口
		2. 次数不能太多
		
三. IO流
	IO流可以传输数据。
	
	字节流
		字节输入流
			1. 创建字节输入流FileInputStream
			2. 调用read方法读取
			3. 关流
		字节输出流
			1. 创建字节输出流FileOutputStream
			2. 调用write方法写
			3. 关流
	
	字符流
		字符输入流
			1. 创建字符输入流FileReader
			2. 调用read方法读数据
			3. 关流
		字符输出流
			1. 创建字符输出流FileWriter
			2. 调用write方法写
			3. 刷新
			4. 关流
````


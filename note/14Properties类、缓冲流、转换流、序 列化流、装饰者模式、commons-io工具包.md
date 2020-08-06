<center>Properties类、缓冲流、转换流、序 列化流、装饰者模式、commons-io工具包</center>

## 今日内容

+ IO资源的处理
+ Properties类
+ ResourceBundle
+ 缓冲流
  + 字节缓冲流
    + 字节输入缓冲流
    + 字节输出缓冲流
  + 字符缓冲流
    + 字符输入缓冲流
    + 字符输出缓冲流
+ 转换流



## 第一章 IO资源的处理

### 1.JDK7之前的处理的IO流异常处理

```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class Demo01Exception {
    public static void main(String[] args) {
        Writer w = null;
        try {

            // 创建字符输出流
            w = new FileWriter("day14\\file01.txt");
            // 写数据
            w.write("你好");


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //关闭
                // 判断w不是null,表示流成功创建,关闭流
                if (w != null)
                    w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
```

### 2.在JDK7的时候

在JDK7的时候，多了一种try...with...resource语句，可以快捷的处理io流中的异常以及施放资源的问题。
格式：
```java
    try(创建流对象的代码）{

    }catch(类名变量名）{
    
    }
```
在try小括号中创建的流对象，只要流对象创建出来了，背定会【自动】调用close方法，关闭流。

小括号中也可以创建多个对象，多个对象之间用分号隔开。

```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02Exception {
    public static void main(String[] args){
        // 小括号中创建的对象,在try...catch操作完成后,自动调用close
        try(Writer w = new FileWriter("day14\\file02.txt")){
            // 写数据
            w.write("你好");
        }catch (IOException e){

        }
    }
}
```

### 3.try...with...resource语句注意事项

try...with...resource语句
在try小括号中创建的对象，必须要使用AutoCLoseable接口

+ 接口实现类

```java
public class Person implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Person close");
    }
}
```

+ 测试类

```java
public class Demo03Test {
    public static void main(String[] args) {
        try (Person p = new Person()){//Person close

        }catch (Exception e){

        }
    }
}
```

## 第二章 Properties(重要)

### 1.介绍

Properties是一个双列集合，也叫做属性集

#### 1.1 概述

java.util.Properties 继承于Hashtable ，来表示一个持久的属性集。它使用键值结构存储数据， 每个键及其对应值都是一个字符串。该类也被许多Java类使用，比如获取系统属性时，System.getProperties 方法就是返回一个Properties对象。

#### 1.2特点

1. Properties实现JMap接口，拥有Map接口中的所有的方法。
2. Properties没有泛型，键和值都是字符申。
3. Properties可以从流【文件中】中读取键值对

### 2.构造方法


Properties():空参数的构造方法

### 3.其他方法

1. Object setProperty(string key, String value):添加键值对
2. String getProperty(String key):根据键获取值。
3. (了解)Set<String> stringPropertyNames():获取所有的健并放入到Set集合中返回。

### 4.代码展示

```java
import java.util.Properties;
import java.util.Set;

public class Demo01Properties {
    public static void main(String[] args) {
        // 创建Properties
        Properties p = new Properties();
        // 添加键值对元素
        p.setProperty("mryhl1","sgds");
        p.setProperty("mryhl2","sgds");
        p.setProperty("mryhl3","sgds");
        // 可以用,不推荐
        p.put("mryhl4","sfgssg");
        // 输出
        //System.out.println(p);//{mryhl3=sgds, mryhl2=sgds, mryhl1=sgds}
        // String getProperty(String key):根据键获取值。
        System.out.println(p.getProperty("mryhl1"));//sgds
        System.out.println("=====");
        Set<String> set = p.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+"-"+p.getProperty(s));
        }
    }
}
```

### 5.核心功能

#### 5.1Properties有关流方法，可以从文件中读取键值对

1. void Load(Inputstream inStream):参数要传递字节输入流
2. void Load(Reader reader):参数要传递字符输入流

上面的Load方法可以传递输入流，该输入流绑定的文件是什么，就可以从该文件中加载（读取）键值对。

#### 5.2文件的要求：

    1. 文件一般以.properties结店【软性规定，properties文件也叫做配置文件】
       2. 文件中的健值对必须按照指定格式存放【硬性规定】
              键=值
              键和值之间用=号隔开，每一个键值对之间换行。

#### 5.3Properties从文件读取键值对的步骤

1. 创建Properties对象
2. 创建输入流，绑定文件。
3. 调用Properties的Load从文件中读取健值对
4. 4.释放资源

#### 5.4代码实现

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo02Properties {
    public static void main(String[] args) throws IOException {
        // 创建properties
        Properties p = new Properties();
        // 创建输入流,绑定文件
        FileInputStream is = new FileInputStream("day14\\file03.properties");
        // 调用Load方法，从文件读取键值对
        // 因为输入流绑定的是fiLe03.properties文件，所以调用Load方法，是将该文件的键值对读取到Properties

        p.load(is);
        // 关闭流
        is.close();
        System.out.println(p);

    }
}
//file03.properties
username=杰克
password=123456
gender=80
```

## 第三章 ResourceBundle工具类

### 1.简介

除了Properties之外，Java中还提供了ResourceBundle用来读取properties配置文件中的内容。
ResourceBundle操作更简便。

ResourceBundle是一个抽象类，如果要用，需要使用子类，他的子类对象不是需要我们自己new的，而是
要通过ResourceBundLe的静态方法获取的

### 2.ResourceBundle方法：

1. static ResourceBundle getBundle(String baseName):获取ResourceBundle子类对象。参数表示要操作的配置文件的路径。
2. String getString(String key):根据键获取值。

注意:ResourceBundle读取的properties必须放到src目录下,在调用getBundle传递文件路径时,不要带拓展名

```java
import java.util.ResourceBundle;

public class Demo01ResourceBundle {
    public static void main(String[] args) {
        // 获取ResourceBundle.参数文件的路径是从src下面开始找,参数不带扩展名
        ResourceBundle bundle = ResourceBundle.getBundle("file04");
        // 调用方法,根据键获取值
        System.out.println("username=" + bundle.getString("username"));
        System.out.println("password=" + bundle.getString("password"));
    }

}
//file04.properties
username=杰克
password=123456
```

## 第四章 缓冲流(效率高)

### 1.普通方法复制

```java
/*
使用普通的字节流一次读写一个字节的方法复制文件,并统计时间
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01Copy {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流
        FileInputStream is = new FileInputStream("day14\\bb.png");
        //创建字节输出流
        FileOutputStream os = new FileOutputStream("day14\\cc.png");
        // 记录时间
        long startTime = System.currentTimeMillis();
        int i;
        // 复制数据
        while ((i = is.read())!=-1){
            os.write(i);
        }
        long emdTime = System.currentTimeMillis();
        // 关闭流
        os.close();
        is.close();
        // 输出时间
        System.out.println(emdTime-startTime);//2533
    }
}
```

### 2.缓冲流的基本使用(字节)

#### 2.1简介

缓冲流
字节缓冲流
    字节输入缓冲流：BufferedInputStream
    字节输出缓冲流：BufferedOutputStream
字符缓冲流：
    字符输入缓冲流：BufferedReader
    字符输出缓冲流：BufferedWriter

缓冲流的特点是效率高，缓冲流内部有一个缓冲区，可以提高效率【缓冲区就是使用的数组】
缓冲流本身并不具备读或写的功能，他的作用是给其他流提供加速。

#### 2.2 构造方法

1. BufferedInputStream(InputStream in):参数要传递一个字节输入流
2. BufferedOutputStream(OutputStream out):参数要传递一个字节输出流。

#### 2.3其他方法

字节缓冲流中其他的方法和我们昨天学的字节流【一模一样】

#### 2.4 字节缓冲流的使用步骤：

       1. 创建字节缓冲流对象
       2. 关流
    3. 读或写。

#### 2.5代码实现

```java
import java.io.*;
public class Demo02BufferedSteam {
    public static void main(String[] args) throws IOException {
        // 使用字节缓冲流,一次读写一个字节的方法复制对象

        // 创建字节输入缓冲流对象[构造方法传入字节输入流,对该对象加速]
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day14\\bb.png"));
        // 创建字节输出缓冲流对象[造方法参数要传递一个字节输出流，表示对字节输出流进行加速]
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day14\\dd.png"));
        // 记录时间
        long startTime = System.currentTimeMillis();
        // 开始读写
        int i;
        while ((i = bis.read())!=-1){
            bos.write(i);
        }
        long endTime = System.currentTimeMillis();

        // 释放资源
        bos.close();
        bis.close();
        System.out.println(endTime - startTime);//31
    }
}
```



### 3.缓冲流结合数组(字节)

```java
import java.io.*;

/*
使用缓冲流结合数组的方式去复制文件，并统计时间


 */
@SuppressWarnings("all")
public class Demo03BufferedSteam {
    public static void main(String[] args) throws IOException {
        // 创建字节输入缓冲流对象[构造方法传入字节输入流,对该对象加速]
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day14\\bb.png"));
        // 创建字节输出缓冲流对象[造方法参数要传递一个字节输出流，表示对字节输出流进行加速]
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day14\\ff.png"));
        // 记录时间
        long startTime = System.currentTimeMillis();
        // 开始读写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!=-1){
            bos.write(len);
        }
        long endTime = System.currentTimeMillis();

        // 释放资源
        bos.close();
        bis.close();
        System.out.println(endTime - startTime);//2
    }
}
```

### 4.字符缓冲流的基本使用

#### 4.1介绍

字符缓冲流：
    字符输入缓冲流：BufferedReader
    字符输出缓冲流：BufferedWriter

#### 4.2字符缓冲流的构造方法:

​    BufferedReader(Reader in):参数要传递字符输入流
​    BufferedWriter(Writer in):参数要传递字符输出流

#### 4.3字符缓冲流的其他方法：

​    字符缓冲流的其他方法和我们昨天学的字活流里面的方法一模一样。

#### 4.4字符缓冲流的使用步骤：

​    1.创建字符缓冲流
​    2.读或写
​    3.关流。
​    注意：如果是字符输出流，需要刷

#### 4.5字符缓冲流特有的方法:

​    在BufferedWriter里有个方法叫newLine(),可以实现一个跨平台的换行
​        void newLine():写一个换行，这个换行是跨平台的。
​    在BufferedReader里面有一个方法，叫做readLine,可以读取一行数据
​        String readLine():读取一行数据并返回读取到的数据。如果已经读取结束了，返回null

#### 4.6 代码展示

```java
public class Demo04BufferedSteam {
    public static void main(String[] args) throws IOException {
        // method();
        method2();
    }
    /*
    String readLine():读取一行数据并返回读取到的数据。如果已经读取结束了，返回null
    不会读取换行符,读取换行符之前的内容
    空常量null 字符串"null"
     */
    public static void method2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day14//file03.txt"));
        String s;
        /*
        条件位置做了哪些内容
            1.通过缓冲流调用了readLine方法读取了一行数据
            2.将读取到的这行数据赋值给了变量Line
            3.判断Line如果不是nuLL,表示读取到了数据，就进行处理。
         读取到的每行数据保存到了Line中

        */
        while ((s = br.readLine())!=null)
            System.out.println(s);

        /*String s = br.readLine();
        System.out.println(s);
        s = br.readLine();
        System.out.println(s);*/

        br.close();
    }


    /*
    void newLine():写一个换行，这个换行是跨平台的。
     */

    public static void method() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("day14\\file03.txt"));
        // 写数据
        bw.write("dsggsg");
        // 使用newLine方法，该方法可以写一个跨平台的换行符
        bw.newLine();
        bw.write("电视动画公司");

        // 刷新
        bw.flush();
        bw.close();
    }
}
```

### 5.出师表排序复制

```java
import java.io.*;

import java.util.ArrayList;
import java.util.Collections;


public class Demo05Test {
    public static void main(String[] args) throws IOException {
        // 1.创建集合，用来保存读取到的每行课文。
        ArrayList<String> list = new ArrayList<>();

        // 2.创建字符输入缓冲流，用来读取。
        BufferedReader br = new BufferedReader(new FileReader("day14\\出师表.txt"));
        // 3.开始读取，每次读取一行数据。
        String line;
        while ((line = br.readLine())!=null){
            // 4.将读取到的这行数据添加到集合中。
            list.add(line);
        }
        // 5.关闭流
        br.close();
        // 6.根据首字符排序[比较器排序]
        Collections.sort(list, (o1, o2) -> o1.charAt(0) - o2.charAt(0));
        System.out.println(list);
        // 7.创建字符输出缓冲流，用来写
        BufferedWriter bw = new BufferedWriter(new FileWriter("day14\\csb.txt"));

        // 8.遍历集合，拿到元素
        for (String str : list) {
            // 9.将遍历到的元素写到目的地文件。
            bw.write(str);
            // 10.换行
            // 11.刷新
            bw.newLine();
            bw.flush();
        }
        // 12.关流
        bw.close();
    }
}
```

## 第五章 转换流

编码和解码:
	编码:字符->字节
	解码:字节->字符
	编码表(字符集):字节和字符的对应关系表。
常见的编码表:
	ASCII码马表:1个字节    128个英文字母数字符号.
	ISO8859-1(Latin):1个字节  256字符(除了支持ASCII码马表上面的内容之外,还多了拉丁文]
	GB2312(1980):1/2字节  支持六千多中文以及符号
	Big5: 1/2字节 支持繁体字
	GBK: 1/2字节 支持两万多中文以及符号.
	unicode:国际标准码表,可以保存全世界任何国家的任何谘,在unicode编码中,任何字符都是阿个字节.武至在unicode8.0版本中,还支村emoji
基于unicode又产生了utf-8(万国码)
万国码:
	UTF-32:每个字符都是4个字节
	UTF-16:每个字符都是2/3/4个字节
	UTE-8:每个字符都是1/2/3/4个字节
记住CK和IUTE-8
	在GBK中,一个中文占2个字节的.
	在UTE-8中,一个中文占3个字节的

在idea中,默认采用的编码是UTF-8.
在windows 默认的编码
最开始是默认的是GBK,后来2019年更新,更新之后windows文件的默认编码变成了UTF-8
后期开发环境编码全局都是统一,统一使用utf-8
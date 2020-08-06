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
在try小括号中创建的对象，必须要实现AutoCLoseable接口

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

1. Properties实现了Map接口，拥有Map接口中的所有的方法。
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

### 1.引入

使用FiLeReader读取GBK文件的内容
FiLeReader会使用idea的歌认编码UTF-8的方式进行渎取,此时文件的编码是GBK,两种编码不一致,
开是就产生了问题
如采要指定编码进行渎取,那么可以使转换流去做

```java
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        // 创建字符输入流对象
        Reader r = new FileReader("e:\\a.txt");
        // 进行读取,一次一字符
        int i;
        while ((i = r.read())!=-1){
            System.out.print((char) i);
        }
        r.close();
    }

}
```

### 2.InputStreamReader是转换流

InputStreamReader是转换流，用来读，可以按照【指定编码】将文件中的数据读取到Java程序中
InputStreamReader是字符流，会以字符为单位进行读取。

#### 2.1InputStreamReader构造方法：

​    InputStreamReader(InputStream in):参数要传递一个字节输入流，使用该构造方法创建的转换对象会使用idea默的编码（utf-8)进行读
​    InputStreamReader(InputStream in, String charsetName):第一个参数是字节输入流，第二个参数是编码方式。可以指定编码进行读取。

#### 2.2InputStreamReader其他方法

​    InputStreamReader是字符流，所以里面读取的方法和字符流读取的方法一模一样。

#### 2.3InputStreamReader按照指定编码读取步骤：

​    1.创建转换流对象用来读取，并指定编码。
​    2.调用read方法读取。
​    3.施放资源。

#### 2.4代码展示

```java
import java.io.FileInputStream;

import java.io.InputStreamReader;

public class Demo02InputStreamReader {
    public static void main(String[] args) throws Exception {
        readGBK();
        readUTF8();
    }

    /*
   读取UTF8编码文件
    */
    public static void readUTF8() throws Exception {
        // 创建转换流对象,用来读取
        // InputStreamReader isr = new InputStreamReader(new FileInputStream("e:\\b.txt"), "utf8");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("e:\\b.txt"));
        // 开始读取

        int i;
        while ((i = isr.read())!=-1){
            System.out.print((char) i);
        }
        isr.close();
    }

    /*
    读取gbk编码文件
     */
    public static void readGBK() throws Exception {
        // 创建转换流对象,用来读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream("e:\\a.txt"), "gbk");
        // 开始读取

        int i;
        while ((i = isr.read())!=-1){
            System.out.print((char) i);
        }
        isr.close();
    }
}
```

### 3.OutputStreamWriter是转换流

OutputStreamWriter是转换流，用来写，可以将Java程序中的数据按照【指定编码】写到文件中。
OutputStreamWriter属于字符流，会以字符为单位写数据。

#### 3.1OutputStreamWriter构造方法：

​        OutputStreamWriter(OutputStream out)：参数要传递字节输出流，将来会以idea默认编码(utf-8)去写数据。
​        OutputStreamWriter(OutputStream out, String charsetName)：第一个参数是字节输出流，第二个参数是指定的编码方式。 该方法会按照指定编码写数据。

#### 3.2OutputStreamWriter其他方法：

​    OutputStreamWriter是字符流，所以里面写数据的方法和之前字符流写数据的方法一模一样

#### 3.3OutputStreamWriter使用步骤：

1.创建流对象，指定编码
2.写数据
3.刷新
4.关闭

#### 3.4代码实现

```java
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
public class Demo03OutputStreamWrite {
    public static void main(String[] args) throws Exception {
        writer();
        writerutf8();

    }
    /*
    写utf8编码的数据
     */
    public static void writerutf8() throws Exception {
        // 创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("e:\\c1.txt"));
        // 写数据
        osw.write("你好");
        // 刷新
        osw.flush();
        // 关闭
        osw.close();
    }
    /*
    写gbk编码的数据
     */
    public static void writer() throws Exception {
        // 创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("e:\\c.txt"), "gbk");
        // 写数据
        osw.write("你好");
        // 刷新
        osw.flush();
        // 关闭
        osw.close();
    }

}
```

## 第六章 序列化流

### 1.ObjectOutputStream是序列化流

ObjectOutputStream是序列化流，可以将Java程序中的对象写到文件中。

#### 1.1ObjectOutputStream构造方法：

​    ObjectOutputStream(OutputStream out):参数要传递字节输出流。

#### 1.2ObjectOutputStream写对象的方法【特有方法】

​    void writeObject(object obj):向文件中写对象。

#### 1.3ObjectOutputStream使用步骤：

​    1.创建流
​    2.写对象
​    3.关闭流
要使用序列化流向文件中写的对象，必须要实现Serializable接口，否则就会抛出NotSerializableException异常

```java
import java.io.Serializable;
/*
Serializable里面没有任何东西,这个接口只是起到标记作用,必须实现接口后
那么类的对象才可以被序列化，才可以写到文件中

 */
public class Person implements Serializable {
    private String name;
    private int age;

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
```

```java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws Exception {
        // 1.创建流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\file04.txt"));
        // 2.写对象
        Person p = new Person("东关定", 23);
        oos.writeObject(p);
        // 3.关闭流
        oos.close();
    }
}
```

### 2.反序列化

ObjectInputStream是反序列化流，可以将文件中的对象读取到Java程序中。

#### 2.1ObjectInputStream构造方法：

​    ObjectInputStream(InputStream in):参数要传递一个字节输入流。

#### 2.2objectInputStream读取对象的方法【特有方法】：

​    object readObject():从文件中读取对象。

#### 2.3ObjectInputStream使用步骤：

​    1.创建流
​    2.读对象
​    3.关闭流



```java
注意：如果使用反序列化流读取数据，如果读取的对象所属的类不存在，那么会报错。
```

#### 2.4代码实现

```java
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Demo02ObjectInputStream {
    public static void main(String[] args) throws Exception {
        // 1.创建流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\file04.txt"));
        // 2.读对象

        Object o = ois.readObject();
        System.out.println(o);
        // 3.关闭流
        ois.close();
    }
}
```

### 3.序列化中的static和transient

1. static修饰的成员变量无法序列化,static修饰的变量属于类，不属于对象，而序列化向文件中写的是对象。
2. 如果我们不想某个属性被序列化，同时又不想使用static关键字。那么可以使用transient关键字,transient叫做瞬态，被transient修饰的属性无法被序列化。

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo03StaticAndTransient {
    public static void main(String[] args) throws Exception {
        //writePerson();
        readPerson();
    }
    /*
    定义方法,读取
     */
    public static void readPerson() throws Exception{
        // 1.创建流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\d5.txt"));
        // 2.读对象

        Object o = ois.readObject();
        System.out.println(o);
        // 3.关闭流
        ois.close();
    }
    /*
    定义方法.写对象
     */
    public  static void writePerson() throws Exception {
        // 创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\d5.txt"));
        // 2.写对象
        Person p = new Person("东关定", 23);
        oos.writeObject(p);
        // 3.关闭流
        oos.close();


    }
}
```

### 4.序列化中的序列号

当读取文件中的对象时，会对比文件中的序列号和当前类中的序列号是否一致，如果不一致，那么就会报错。
解决方案，我们可以给类分配一个固定的序列号，不管这个类如何修改，这个序列号都不变。

我们可以在类中提供一个属性叫做seriaLVersionUID,该属性就表示序列号
    1.属性名必须叫做seriaLVersionUID
    2.必须使用private static final修饰
    3.必须是Long类型

```java
//提供属性，表示类的版本号（序列号）
//该类的办版本号（序列号）永远是,不管怎么修改这个类，版本号（序列号）永远是
private static final long serialVersionUID = 6078236425251693931l;
```

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo04SerialVersionUIDTest {
    public static void main(String[] args) throws Exception {
        //writePerson();
        readPerson();
    }
    /*
    定义方法,读取
     */
    public static void readPerson() throws Exception{
        // 1.创建流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\d5.txt"));
        // 2.读对象

        Object o = ois.readObject();
        System.out.println(o);
        // 3.关闭流
        ois.close();
    }
    /*
    定义方法.写对象
     */
    public  static void writePerson() throws Exception {
        // 创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\d5.txt"));
        // 2.写对象
        Person p = new Person("东关定", 23);
        oos.writeObject(p);
        // 3.关闭流
        oos.close();


    }
}
```

### 5.练习

要求：
    1.将存有多个学生对象的集合序列化操作，保存到List.txt文件中。
    2.反序列化List.txt,并遍历集合，打印对象信息
步骤:
    1.创建集合，用来保存学生
    2.添加三个学生
    3.创建ObjectOutputStream序列化流，用来写对象
    4.调用write方法，将集合写到文件中
    5.释放资源
    6.创建objectInputStream反序列化流，用来读
    7.调用readObject方法读取对象
    8.释放资源
    9.遍历读取到的集合对象，输出里面的信息
向文件中写集合时，集合的泛型类型也必须实现Serializable接口

```java
package cn.com.mryhl.demo06_objectstream;

import java.io.Serializable;

public class Student implements Serializable {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
package cn.com.mryhl.demo06_objectstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*


 */
public class Demo05Test {
    public static void main(String[] args) throws Exception {
        //1. 创建集合
        List<Student> list = new ArrayList<>();
        //2. 向集合中添加学生对象
        list.add(new Student("东关", 18));
        list.add(new Student("何塞荡", 19));
        list.add(new Student("舒代达", 20));
        //3. 创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day14\\list.txt"));
        //4. 将集合对象写到文件中。
        oos.writeObject(list);
        //5. 释放资源。
        oos.close();
        //6. 创建objectInputStream反序列化流，用来读
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day14\\list.txt"));
        //7. 从文件中读取集合对象。
        List<Student> list2 = (List<Student>) ois.readObject();
        //8. 关流
        ois.close();
        //9. 遍历集合，输出集合中的每一个学生对象
        for (Student stu : list2) {
            System.out.println(stu);
        }
    }
}
```

## 7.打印流

PrintStream是打印流

### 1.打印流有以下特点：

​    1.只有输出，没有输入。
​    2.写数据十分方便。

###  2.PrintStream构造方法：

​    PrintStream(String fileName)：参数要传递字符串的文件路径。
​    PrintStream(File file)：参数要传递File对象。
​    PrintStream(OutputStream out)：参数要传递字节输出流。

### 3.PrintStream特有的写数据的方法：

​    void print(任何类型)： 写任何类型的数据。
​    void println(任何类型)： 写任何类型的数据并自动换行。

### 4.PrintStream的使用步骤：

       1. 创建打印流对象
    2. 调用方法写数据。
    3. 释放资源

### 5.代码实现

```java
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //1. 创建打印流对象
        PrintStream ps = new PrintStream("day14\\file06.txt");
        //2. 调用方法写数据。
        //void print(任何类型)： 写任何类型的数据。
        // ps.print("你好");
        // ps.print("我好");
        //void println(任何类型)： 写任何类型的数据并自动换行。
        ps.println("你好");
        ps.println("我好");

        //3. 释放资源
        ps.close();
    }
}
```

### 6.改变标准输出流的方向

```java
/*
System.out.println中的system.out其实就是打印流
System.out叫做标准输出流，该流的目的地是控制台。
我们也可以通过system中的静态方法叫做setOut改变这个标准输出流的目的地。
     static void setOut(PrintStream out)：重新改变System.out这个标准输出流的目的地。
 */


import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo02PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //创建打印流
        PrintStream ps = new PrintStream("day14\\file07.txt");
        //调用System中的静态方法setOut，改变打印流的目的地
        System.setOut(ps);

        System.out.println("hello");
    }
}
```

## 第八章 装饰者模式

装饰者模式
    可以在不改变原有类，不使用继承的前提下，对一个类的功能进行增强。
使用超级刘德华(装饰的类)对原来的刘德华(被装饰的类)进行增强（对刘德华的功能进行扩展）

装饰者模式实现的原则：
    1. 装饰的类和被装饰的类要实现同一个接口。
    2. 在装饰类中接受被装饰类的对象。
    3. 我们在需要增强的方法中直接写增强后的内容。
    4. 如果某个方法不需要增强，直接通过被装饰的类调用该方法。

+ 明星接口

```java
// 明星
public interface Start {
    // 唱歌
    public abstract void sing();
    // 跳舞
    void dance();
}
```

+ 普通实现类

```java
public class LiuDehua implements Start {
    @Override
    public void sing() {
        System.out.println("刘德华唱忘情水");
    }

    @Override
    public void dance() {
        System.out.println("刘德华跳舞");
    }
}
```

+ 增强实现类

```java
// 超级
public class SuperLiuDehua implements Start{
    // 接收一个被装饰(增强)的对象
    private LiuDehua liudehua;
    // 创建构造方法,用来接收外界传来的对象
    public SuperLiuDehua(LiuDehua liudehua) {
        this.liudehua = liudehua;
    }
    // 增强了
    @Override
    public void sing() {
        System.out.println("超级刘德华在鸡窝唱歌,下面好的公鸡叫");
    }
    // 不对跳舞方法增强,直接通过普通的调用
    @Override
    public void dance() {
        liudehua.dance();
    }
}
```

+ 测试类

```java
public class Demo01Test {
    public static void main(String[] args) {
        // 创建对象
        LiuDehua l = new LiuDehua();
        //创建超级刘德华，对普通刘德华增强
        SuperLiuDehua superLiuDeHua = new SuperLiuDehua(l);
        //唱歌
        superLiuDeHua.sing();
        //跳舞
        superLiuDeHua.dance();
    }
}
```

## 第九章 commons-io

```java
/*
commons-io是由第三方（Apache）提供的IO流操作的工具包

如果我们要使用第三方的工具包，一般要导入jar包
jar包其实就是java的压缩包，里面保存了很多class文件。
如果导入jar包后，这个jar包中的类就都可以使用了.

导入jar包的步骤：
    1. 新建一个文件夹叫做lib
    2. 将jar包复制到lib文件夹下
    3. 点lib文件夹右键选择 Add as Library


IOUtils中的方法：
    static int copy(InputStream input, OutputStream output)：复制文件。该方法适用于2G以下的文件。
    static long    copyLarge(InputStream input, OutputStream output)复制文件。该方法适用于2G以上的文件。

FileUtils中的方法：
    static void    copyFileToDirectory(File srcFile, File destDir)：将文件(srcFile)复制到一个文件夹(destDir)中
    static void    copyDirectoryToDirectory(File srcDir, File destDir)：将一个文件夹(srcDir)复制到另一个文件夹(destDir)中
    static void    writeStringToFile(File file, String data)：向文件中写字符串数据
    static String readFileToString(File file)：从文件中读取数据，并返回读取到的内容

 */


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

public class Demo01Test {
    public static void main(String[] args) throws Exception {
        //IOUtils中的方法：
        //static int copy(InputStream input, OutputStream output)：复制文件。该方法适用于2G以下的文件。
        //IOUtils.copy(new FileInputStream("d:\\aa.png"), new FileOutputStream("d:\\bb.png"));

        //FileUtils中的方法：
        //static void copyFileToDirectory(File srcFile, File destDir)：将文件(srcFile)复制到一个文件夹(destDir)中
        //FileUtils.copyFileToDirectory(new File("d:\\aa.png"), new File("d:\\iotest"));

        //static void  copyDirectoryToDirectory(File srcDir, File destDir)：将一个文件夹(srcDir)复制到另一个文件夹(destDir)中
        //FileUtils.copyDirectoryToDirectory(new File("d:\\iotest"), new File("d:\\aaa"));

        //static void writeStringToFile(File file, String data)：向文件中写字符串数据
        //FileUtils.writeStringToFile(new File("day14\\file08.txt"), "你好");

        //static String readFileToString(File file)：从文件中读取数据，并返回读取到的内容
    }
}
```



## 总结

```java
IO流
	作用：用来读写数据，比如上传，下载，复制
	分类：
		从类型角度：字节流，字符流
		从流向角度：输入流，输出流。
	顶层父类：
		字节流	
			字节输入流：InputStream
			字节输出流：OutputStream
		字符流
			字符输入流：Reader
			字符输出流：Writer
			
	字节流会以字节为单位读写
	字符流会以字符为单位读写
	
	所有字节输入流读取的方法：
		int read()：读取一个字节，如果读取结束返回-1
		int read(byte[] bArr)：读取数据到字节数组中，返回读取到的字节个数，如果读取结束返回-1

	所有字节输出流写的方法：
		void write(int i)：写一个字节
		void write(byte[] bArr)：写一个字节数组
		void write(byte[] bArr, int off, int len)：写字节数组一部分
	
	所有字符输入流读取的方法
		int read()：读取一个字符，如果读取结束返回-1
		int read(char[] cArr)：读取数据到字符数组中，返回读取到的字符个数，如果读取结束返回-1
		
	所有字符输出流写的方法
		void write(String str)：写字符串
		void write(String str, int off, int len)：写字符串的一部分
		void write(int i)：写一个字符
		void write(char[] cArr)：写字符数组
		void write(char[] cArr, int off, int len)：写字符数组的一部分

所有流的使用步骤：
	1. 创建流
	2. 读或写
	3. 关闭流
	注意：如果是字符输出流，需要刷新。
	
流的使用步骤一样，只不过每种流的作用有所不同

基本字节流：FileInputStream，FileOutputStream。  操作非文本文件，使用字节流。
基本字符流：FileReader，FileWriter。	操作文本文件，会使用默认编码进行读写。
缓冲流：BufferedInputStream，BufferedOutputStream，BufferedReader，BufferedWriter。    效率高，提高读写效率
        BufferedReader特有方法：readLine，用于读取一行
		BufferedWriter特有方法：newLine，跨平台换行
转换流：InputStreamReader，OutputStreamWriter。  可以指定编码进行读写。
序列化流：ObjectOutputStream，ObjectInputStream。  用来读写对象。
		ObjectOutputStream特有方法：writeObject，用来写对象
		ObjectInputStream特有方法：readObject，用来读取对象
打印流：PrintStream		输出数据十分方便。
		特有方法： print，println

```


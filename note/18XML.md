<center>XMl,正则表达式,方法引用</center>

## 今日内容

+ XML

+ xml约束
  + dtd约束
  + schema约束
  
+ xml解析

+ JDK8的新特性

  + 方法引用
  + Base64

  

## 第一章 XML

### 1.简介

1. XML 指可扩展标记语言（EXtensible Markup Language）
2. XML 是一种标记语言，很类似 HTML，HTML文件也是XML文档
3. XML 的设计宗旨是传输数据，而非显示数据
4. XML 标签没有被预定义。需要自行定义标签。
5. XML 被设计为具有自我描述性(就是易于阅读)。
6. XML 是 W3C 的推荐标准

W3C在1988年2月发布1.0版本，2004年2月又发布1.1版本，但因为1.1版本不能向下兼容1.0版本，所以1.1没有人用。同时，在2004年2月W3C又发布了1.0版本的第三版。我们要学习的还是1.0版本。

### 2.XML 与 HTML 的主要差异

+ XML 不是 HTML 的替代。
+ XML 和 HTML 为不同的目的而设计。
+ XML 被设计为传输和存储数据，其焦点是数据的内容。
+ HTML 被设计用来显示数据，其焦点是数据的外观。
+ HTML 旨在显示信息，而 XML 旨在传输信息。

### 3.文档声明

​    格式:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<aa>
    <bb>hello</bb>
    <cc><dd></dd></cc>
    <cc></cc>
    <cc/>
</aa>
```


​    注意:

           1. 必须以"<?xml "开头,以"?>"结尾
           2. 档声明必须放在第一行第一列
           3. 文档声明可以省略
           4. 档声明有两个属性
                 version表示版本号
                 encoding表示编码格式

### 4.元素(标签)

​    格式:
​        <元素名> </元素名>
​        <开始标签></结束标签>

```java
注意:
    1. 元素一般都是由开始标签,结束标签,元素的内容(元素体)组成
    2. 元素体可以是文本内容,也可以是其它标签
    3. 每个xml文件都要有根元素
    4. 空元素,如果每个元素没有元素体,它就是一个空元素.空元素可以写成自闭合的形式<元素名/>
    5. xml标签的名字区分大小写
    6. 再xml中,元素命名中不要使用下xml,Xml,XML这些名字,也不要带有特殊字符
```
### 5.属性

​    格式:
​        <开始标签 属性名=属性值 属性名=属性值></结束标签>
​    注意事项:
​           1. 属性写在开始标签中
​           2. 属性可以有任意个,多个属性之间有空格隔开,同意元素内属性名不能相同
​           3. 属性值必须有单,双引号包裹,推荐双引号.
​           4. 属性名在命名时不要有特殊字符,属性名不能以数字开头

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--
    persons是根元素,一个xml中只能有一个根元素
    person是persons的子元素
    每一个person标签都有两个属性,分别是name和age
-->
<persons>
    <person name="郑大索" age="18"></person>
    <person name="东关萨" age="16"></person>
    <person name="席八燮" age="20"></person>
</persons>
```

### 6.注释

​    格式:

```xml
   <!-- 注释内容 -->
```


​    注意:
​        在xml中,注释不会被解析

### 7.转义字符

​    如果要在xml中表示特殊符号,需要转义字符.

```xml
   <: &lt;
   >: &gt;
   ": &quot;
   ': &apos;
   &: &amp
```



```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--        如果要在xml中表示特殊符号,需要转义字符.
    <: &lt;
    >: &gt;
    ": &quot;
    ': &apos;
    &: &amp-->
<root>
    hello
    1 &lt; 2

</root>
```

8.CDATA区
    如果xml中出现大量的转义字符，会大大的影响程序的阅读性
    我们可以使用CDATA区解决这个问题
    作用：
        在CDATA区中写的任何东西，都会原样显示，不需要转义。
    格式:

```xml
   <![CDATA[        
            ...
        ]]>

<?xml version="1.0" encoding="UTF-8" ?>
<root>
<![CDATA[
     public static void main(String[] args) {
            System.out.println(1 < 2);
            System.out.println(1 > 2);
            System.out.println(1 & 2);
        }
]]>
</root>
```

## 第二章 xml约束

### 1.约束简介

```xml
xmL的写法是非常灵活的，但是很多情况下太灵活也不是一件好事。所以我们要给xmL定义一个规范，规范一下xml中应该写什么内容.
这个规范就是约束

约束可以限制元素的名字,属性,元素体,元素的顺序等等写法.
xml约束有两种:dtd, schema
学习目标:要根据xml约束编写xml文档.
```

### 2.dtd约束

#### 2.1简介

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--
    如果要使用约束,需要先把约束给引入过来,这个引入也成为导入
    如何引入:
        打开约束文件,从约束文件的注释中找到以<!DOCTYPE开头的,复制到xml中
        <!DOCTYPE 书架 SYSTEM "bookshelf.dtd">里面的书架表示xmL的根元素
    数量词：
        *：任意次
        +：至少一次
        ?：0次或1次
        ,：顺序。
        |：多个选一个

-->
<!DOCTYPE 书架 SYSTEM "bookshelf.dtd">
<书架>
    <书>
        <书名>西游记</书名>
        <作者>吴承恩</作者>
        <售价>89.7</售价>
    </书>
   
</书架>
```

```dtd
// 文件名bookshelf.dtd
<?xml version="1.0" encoding="UTF-8"?>
    <!--
    传智播客DTD教学实例文档，将注释中的以下内容复制到要编写的xmL的声明下面
    复制内容如下：
    <!DOCTYPE 书架 SYSTEM "bookshelf.dtd">
    -->
<!ELEMENT 书架 (书+)>
<!ELEMENT 书 (书名,作者,售价)><!--约束元素书的子元素必须为书名、作者、售价-->
<!ELEMENT 书名 (#PCDATA)>
<!ELEMENT 作者 (#PCDATA)>
<!ELEMENT 售价 (#PCDATA)>
```

#### 2.2.dtd约束有三种引入方式

```xml
第一种:内部DTD,将dtd嵌入到xml文件中,只对当前的xml文件youxiao
        <!DOCTYPE 根元素 [
            dtd语法
        ]>
第二种:外部DTD-本地DTD
    <!DOCTYPE 书架 SYSTEM "bookshelf.dtd">
    DOCTYPE:引入关键字
    书架:根元素
    SYSTEM:表示 外部DTD-本地DTD 这种引入方式,这种引入方式是将dtd语法写到自己电脑的dtd文件中，然后再进行引入
    "bookshelf.dtd":要引入文件的位置,相对路径是当前文件夹

第三种:外部DTD-公共DTD
    将DTD文件放在网络上
    <!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
    DOCTYPE:引入关键字
    web-app:根元素
    PUBLIC::表示 外部DTD-公共DTD 这种引入方式
```
### 3.schema约束

#### 3.1概念

Schema 语言也可作为 XSD（XML Schema Definition）。
Schema 比DTD强大，是DTD代替者。
Schema 本身也是XML文档，单Schema文档扩展名为xsd，而不是xml。
Schema 功能更强大，数据类型约束更完善。

#### 3.2引入

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--
    引入schema约束的方式和引入dtd约束的方式一样,
    都是从约束文件的注释中找到相对应的代码复制到xml文件中.

    复制过来的schema注释中的代码是一个开始标签,需要我们手动补齐结束标签
    引入过来的标签其实是根标签
-->
<书架 xmlns="http://www.itcast.cn"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.itcast.cn bookshelf.xsd"
>
    <书>
        <书名>西游记</书名>
        <作者>吴承恩</作者>
        <售价>89.7</售价>
    </书>
</书架>
```

```xml
// bookshelf.xsd
<?xml version="1.0" encoding="UTF-8" ?>
<!--
传智播客schema教学实例文档.将注释中的以下内容复制到要编写的xml的声明下面
复制内容如下:
<书架 xmlns="http://www.itcast.cn"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.itcast.cn bookshelf.xsd"
>
-->
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://www.itcast.cn"
           elementFormDefault="qualified">
    <xs:element name='书架' >
        <xs:complexType>
            <xs:sequence maxOccurs='unbounded' >
                <xs:element name='书' >
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name='书名'
                                        type='xs:string' />
                            <xs:element name='作者'
                                        type='xs:string' />
                            <xs:element name='售价'
                                        type='xs:double' />
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
```

#### 3.3名称空间(namespace)

![](https://img03.sogoucdn.com/app/a/100520146/AF7D47E7F96F575F0C164C3A139A3DAB)

### 4.隐式名称空间和显示名称空间

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--
    <书架 xmlns="http://www.itcast.cn"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.itcast.cn bookshelf.xsd"
    >
    xmlns="http://www.itcast.cn"
    表示引入过来的schema文件的名称空间

    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    引入的w3c官方的内容,固定写法

    xsi:schemaLocation="http://www.itcast.cn bookshelf.xsd"
    引入的schema文件的位置
    格式: 名称空间 位置
    名称空间
        隐式名称空间(我们之前用的都是隐式名称空间)
        显式名称空间(我们给名称空间起一个别名,通过别名去使用元素)
            xmlns:别名 = "名称空间"
        使用方式:
            <别名:元素名>
-->
<别名:书架 xmlns:别名="http://www.itcast.cn"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.itcast.cn bookshelf.xsd"
>
    <别名:书>
        <别名:书名>西游记</别名:书名>
        <别名:作者>吴承恩</别名:作者>
        <别名:售价>89.7</别名:售价>
    </别名:书>
</别名:书架>
```

## 第三章 xml解析

### 1.xml的解析方式：

1. DOM解析（会把整个的xml文件都加载到内存中，然后进行解析）
    优点：会保留xml文件的结构。可以对里面元素进行增删操作。
    缺点：有可能内存溢出。

2. SAX解析（会逐行解析xml，每解析一行，就释放一行）
    优点：效率高，不会内存溢出。
    缺点： 不会保留xml文件的结构，只能读

3. PULL解析（安卓内置的，类似sax）

解析工具包
DOM4J（是由第三方提供的，使用的时候需要导入jar包）

![](https://img01.sogoucdn.com/app/a/100520146/4ACF6F547B4719AD4CF6E5B2131D4BC3)

### 2.使用DOM4J解析XML

准备：
1. 导入jar包（dom4j-1.6.1.jar）
2. 准备读取相关的xml
3. 相关API
    SAXReader核心类
        read方法可以读取xml文件，生成dom树并创建Document对象
    Document表示整个的xml文档
        getRootElement获取根元素
    Element表示元素
        List elements() 获得指定名称的所有子元素。可以不指定名称
        Element element(String ele) 获得指定名称第一个子元素。可以不指定名称
        String getName() 获得当前元素的元素名
        String attributeValue(String attrName) 获得指定属性名的属性值
        String elementText(Sting ele) 获得指定名称子元素的文本值
        String getText() 获得当前元素的文本内容

```java
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo02Parse {
    public static void main(String[] args) throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //调用read方法，读取xml文件，创建Document对象
        Document document = reader.read("day18\\book.xml");
        //调用getRootElement获取根元素
        Element rootElement = document.getRootElement();
        //调用elements获取子元素
        List<Element> bookList = rootElement.elements();
        //遍历集合，拿到集合中的每一个book元素
        for (Element bookElement : bookList) {
            //获取book元素上的id属性值
            String id = bookElement.attributeValue("id");
            System.out.println("id = " + id);
            //获取book元素中的所有的子元素
            List<Element> bookChildList = bookElement.elements();
            //遍历集合，拿到里面的每一个子元素
            for (Element bookChildElement : bookChildList) {
                //调用getName获取元素的名字
                String name = bookChildElement.getName();
                //调用getText获取元素中的文本内容
                String value = bookChildElement.getText();
                System.out.println(name + ":" + value);
            }
        }


    }
}
```

### 3.XPath表达式

xpath可以根据一个表达式获取指定的元素。

步骤：
    1.导包（dom4j-1.6.1.jar和jaxen-1.1-beta-6.jar）
    2. 通过SAXReader读取xml获取document对象。
    3. 调用方法，根据xpath表达式获取元素。

document中根据xpath获取元素的方法主要有两个：
    List selectNodes("xpath表达式")：获取多个满足要求的元素
    Node selectSingleNode("xpath表达式")：获取一个满足要求的元素(第一个)

表达式的规则：
       1. 绝对路径表达式方式 例如: /元素/子元素/子子元素...  [绝对路径从根开始找]
    2. 相对路径表达式方式 例如: 子元素/子子元素.. 或者 ./子元素/子子元素..  [相对路径从当前元素]
    3. 全文搜索路径表达式方式 例如: //子元素//子子元素
    4. 谓语（条件筛选）方式 例如: //元素[@属性名=属性值]

```java
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo03XPath {
    public static void main(String[] args) throws DocumentException {
        // 创建SAXPReader
        SAXReader reader = new SAXReader();
        // 调用read方法获取
        Document document = reader.read("day18\\book.xml");
        // 4. 谓语（条件筛选）方式 例如: //元素[@属性名=属性值]
        Node node3 = document.selectSingleNode("//book[@id=0002]//author");
        // 属性名为字符串时,需加引号
        System.out.println(node3.getText());

        System.out.println("====");
        // 3. 全文搜索路径表达式方式 例如: //子元素//子子元素
        Node node2 = document.selectSingleNode("//author");
        System.out.println(node2.getText());

        System.out.println("====");
        // 2. 相对路径表达式方式 例如: 子元素/子子元素.. 或者 ./子元素/子子元素..  [相对路径从当前元素]
        Element rootElement = document.getRootElement();
        Node node1 = rootElement.selectSingleNode("book/name");
        System.out.println(node1.getText());

        System.out.println("====");
        //  1. 绝对路径表达式方式 例如: /元素/子元素/子子元素...  [绝对路径从根开始找]
        // 获取一个元素
        // Node node = document.selectSingleNode("/books/book/sale");
        // 获取元素的文本输出
        // System.out.println(node.getText());
        // 获取所有author
        List<Node> list = document.selectNodes("/books/book/author");
        for (Node node : list) {
            System.out.println(node.getText());
        }
    }
}
```

## 第四章 JDK8的新特性

### 1.方法的引用

方法引用是Lambda表达式的简化写法,也是函数式编程的内容.
当Lambda表达式拿到参数之后直接对参数进行处理，那么可以换成方法引用
比如：
s-> System. out. println(s)
该Lambda表达式，拿到s之后，直接对s进行了输出处理，那么可以换成方法引用。
::是方法引用的符号

```java
import java.util.ArrayList;
import java.util.List;
public class Demo01MethodRef {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        // 使用Stream流的方式对集合中的每一个元素遍历输出
        // list.stream().forEach(s-> System.out.println(s));
        // 方法引用初体验
        list.stream().forEach(System.out::println);

    }
}
```

常见的四种方法引用

        1. 对象引用成员方法
           2. 类名引用静态方法
           3. 类的构造器引用。   
           4. 数组的构造器引用。

#### 1.1对象引用成员方法

```java
import java.util.ArrayList;
import java.util.List;

public class Demo01MethodRef {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        // 遍历集合,将集合的每一个元素转大写输出
        //list.stream().forEach(s-> System.out.println(s.toUpperCase()));
        MyClass myClass = new MyClass();
        // list.stream().forEach(s -> myClass.printUpperCase(s));
        // list.stream().forEach(myClass::printUpperCase);
        list.forEach(myClass::printUpperCase);
    }
}
public class MyClass {
    public void printUpperCase(String str){
        System.out.println(str.toUpperCase());
    }
}

```

#### 1.2类名引用静态方法

```java
/*
类名引用静态方法
    类名::静态方法名
创建集合，添加数字，将每个数字转成绝对值并输出
 */

import java.util.ArrayList;
import java.util.List;

public class Demo01ClassRef {
    public static void main(String[] args) {
        // 创建集合
        List<Integer> list = new ArrayList<>();
        // 添加元素
        list.add(-10);
        list.add(20);
        list.add(-30);
        list.add(-40);
        // 将集合中的每一个元素转成绝对值并输出
        // list.stream().map(num -> Math.abs(num) ).forEach(System.out::println);
        list.stream().map(Math::abs).forEach(System.out::println);
    }
}
```

#### 1.3类的构造器引用

```java
/*
  类的构造器引用

    类的构造器引用是在创建对象的时候使用的。
    格式：
        类名::new
 */

public class Demo01MethodRef {
    // 使用函数式接口作为参数
    public static void method(PersonBuilder personBuilder) {
        Person person = personBuilder.createPerson("张三", 15);
        System.out.println(person);
    }

    public static void main(String[] args) {
        //调用method方法，传递Lambda表达式
        method((name, age) -> new Person(name, age));

        //方法引用
        method(Person::new);
    }
}
public interface PersonBuilder {
    //给我姓名和年龄，我就可以创建一个Person对象返回。
    Person createPerson(String name, int age);
}
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
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

#### 1.4数组的构造器引用

```java
/*
数组的构造器引用

    数组的构造器引用在创建数组的时候使用。
    格式：
        数据类型[]::new
 */

import java.util.Arrays;

public class Demo01ArrayRef {
    public static void method(ArrayBuilder a) {
        int[] arr = a.createArray(10);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        //调用method方法，传递Lambda表达式
        method(len -> new int[len]);
        //使用方法引用
        method(int[]::new);
    }
}
public interface ArrayBuilder {
    //给我长度，我可以创建数组并返回。
    int[] createArray(int len);
}
```



### 2.Base64

Base64可以进行编码和解码

Base64.Encoder：用来编码
Base64.Decoder：用来解码

static Base64.Encoder getEncoder()：获取一个标准的Base64的编码器
static Base64.Decoder getDecoder()：获取一个标准的Base64的解码器
static Base64.Decoder getUrlEncoder()：获取一个标准的url的Base64的编码器
static Base64.Decoder getUrlDecoder()：获取一个标准的url的Base64的解码器
static Base64.Decoder getMimeEncoder()：获取一个标准的MIME的Base64的编码器
static Base64.Decoder getMimeDecoder()：获取一个标准的MIME的Base64的解码器

Base64.Encoder的方法:
    String encodeToString(byte[] src):将byte数组编码成字符串
Base64.Decoder的方法:
    String decode(String src):解码,将字符串变成byte数组

```java
import java.util.Base64;

public class Demo01Base64 {
    public static void main(String[] args) {
        // 定义字符串
        String str = "嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈";
        // 使用标准Base64进行编码
        String base64Code = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(base64Code);
        // 使用标准Base64进行解密
        byte[] decode = Base64.getDecoder().decode(base64Code);
        System.out.println(new String(decode));
        // 使用url进行编码解码
        String urlCode = Base64.getUrlEncoder().encodeToString(str.getBytes());
        System.out.println(urlCode);
        byte[] decode1 = Base64.getUrlDecoder().decode(urlCode);
        System.out.println(new String(decode));
        // 使用MIME编码解码
        String mimeCode = Base64.getMimeEncoder().encodeToString(str.getBytes());
        System.out.println(mimeCode);
        byte[] decode2 = Base64.getMimeDecoder().decode(mimeCode);
        System.out.println(new String(decode2));

    }
}
```

## 总结

```java
一. xml
	作用：
		保存数据(当做配置文件使用)
		传输数据 
		
	文档声明
		格式：
			<?xml version="1.0" encoding="UTF-8"?>
		注意：
			1. 必须以<?xml开头，以?>结尾
			2. 文档声明必须放到xml的第一行第一列。
			3. 文档声明可以省略。
			4. 文档声明有两个属性
				version：表示版本号
				encoding：表示编码

	元素
		格式：
			<元素名></元素名>
			<开始标签></结束标签>
			
		注意：
			1. 元素一般都是由开始标签，结束标签，元素的内容（元素体）组成的
			2. 元素体可以是文本内容，也可以是其他的标签。
			3. 每一个xml都要有一个根标签
			4. 空元素，如果某个元素没有元素体，他就是一个空元素。空元素可以写成自闭合的形式，格式：<元素名/>
			5. xml标签名字区分大小写。
			6. 在xml中，元素命名不要使用xml,Xml,XML这些名字，也不要带有特殊字符。

	属性
		格式：
			<开始标签 属性名=属性值 属性名=属性值></结束标签>

		注意事项：
			1. 属性要写在开始标签中。
			2. 属性在元素中可以写任意个，多个属性之间用空格隔开，一个元素中的多个属性，属性名不能相同。
			3. 属性值必须用双引号或单引号包裹，推荐双引号
			4. 属性名在命名时不要有特殊字符，属性名不能用以数字开头

	注释
		格式：
			<!-- 注释内容 -->
		注意：
			在xml中，注释也是不会被解析的。

	转义字符【了解】
		如果要在xml中表示特殊字符，需要使用转义字符。
			<：&lt;
			>：&gt;
			"：&quot;
			'：&apos;
			&：&amp;

	CDATA区【了解】
		如果xml中出现大量的转义字符，会大大的影响程序的阅读性
		我们可以使用CDATA区解决这个问题

		作用：
			在CDATA区中写的任何东西，都会原样显示，不需要转义。

		格式：
			<![CDATA[
				...
			]]>
	约束
		约束可以限制xml的写法
		两种约束dtd,schema
		要求能够根据约束编写xml。
		在使用约束时，从约束文件的注释中找到引入的代码，复制到自己的xml文件中，然后开始编写代码。		
二. XML解析
	解析方式：
		DOM：将整个xml文件加载到内存中，再进行解析
			优点：会保留整个xml文件的结构
			缺点：可能会内存溢出
		SAX：逐行解析，每解析一行就释放一行。
		PULL：	
	解析工具包
		DOM4J		
	DOM4J使用
		1. 导入jar包
		2. 准备xml
		3. 使用代码进行解析
			a. 创建SAXReader对象
			b. 调用read方法读取，生成Document对象
			c. 调用getRootElement获取根元素
			d. 进行解析	
	xpath
		可以根据表达式获取xml文件中的指定元素。
		
三. 方法引用(了解)
	是Lambda表达式的简化写法。
	方法引用是Lambda表达式的简化写法，也是函数式编程的内容。
    当Lambda表达式拿到参数之后直接对参数进行处理，那么可以换成方法引用
    比如：
        s -> System.out.println(s)
        该Lambda表达式，拿到s之后，直接对s进行了输出处理，那么可以换成方法引用。
		System.out::println
    ::是方法引用的符号。
	
四. Base64(了解)
    Base64.Encoder：用来编码，是编码器
    Base64.Decoder：用来解码，是解码器

    Base64里面的静态方法
        static Base64.Encoder getEncoder()：获取一个标准的Base64的编码器
        static Base64.Decoder getDecoder()：获取一个标准的Base64的解码器
        static Base64.Encoder getUrlEncoder() ：获取一个标准的url的编码器
        static Base64.Decoder getUrlDecoder() ：获取一个标准的url的解码器
        static Base64.Encoder getMimeEncoder()：获取一个标准的MIME的编码器
        static Base64.Decoder getMimeDecoder() ：获取一个标准的MIME的解码器

    Base64.Encoder方法：
        String encodeToString(byte[] src)：将byte数组编码成字符串

    Base64.Decoder方法：
        byte[] decode(String src)：解码，将字符串变成byte数组
今天必须要掌握的xml文件的编写。
```


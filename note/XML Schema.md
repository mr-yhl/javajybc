<center>XML Schema</center>

## 一. 简介

XML Schema 是基于 XML 的 DTD 替代者。

XML Schema 可描述 XML 文档的结构。

XML Schema 语言也可作为 XSD（XML Schema Definition）来引用。

XML Schema 的作用是定义 XML 文档的合法构建模块，类似 DTD。

XML Schema 在 2001 年 5 月 2 日成为 W3C 标准。

```xml
定义可出现在文档中的元素
定义可出现在文档中的属性
定义哪个元素是子元素
定义子元素的次序
定义子元素的数目
定义元素是否为空，或者是否可包含文本
定义元素和属性的数据类型
定义元素和属性的默认值以及固定值
```

## 二. 数据类型

XML Schema 最重要的能力之一就是对数据类型的支持。

### 通过对数据类型的支持：

- 可更容易地描述允许的文档内容
- 可更容易地验证数据的正确性
- 可更容易地与来自数据库的数据一并工作
- 可更容易地定义数据约束（data facets）
- 可更容易地定义数据模型（或称数据格式）
- 可更容易地在不同的数据类型间转换数据

编者注：数据约束，或称 facets，是 XML Schema 原型中的一个术语，中文可译为"面"，用来约束数据类型的容许值。

## 三.使用方法

+ 定义

```xml
<?xml version="1.0"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
targetNamespace="http://www.w3schools.com"
xmlns="http://www.w3schools.com"
elementFormDefault="qualified">

<xs:element name="note">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="to" type="xs:string"/>
      <xs:element name="from" type="xs:string"/>
      <xs:element name="heading" type="xs:string"/>
      <xs:element name="body" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>

</xs:schema>
```

+ 引用

```xml
<?xml version="1.0"?>

<note
xmlns="http://www.w3schools.com"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.w3schools.com note.xsd">
  <to>Tove</to>
  <from>Jani</from>
  <heading>Reminder</heading>
  <body>Don't forget me this weekend!</body>
</note>
```

下面的代码片断：

```xml
xmlns="http://www.runoob.com"
```

规定了默认命名空间的声明。此声明会告知 schema 验证器，在此 XML 文档中使用的所有元素都被声明于 "http://www.runoob.com" 这个命名空间。

一旦您拥有了可用的 XML Schema 实例命名空间：

```xml
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
```

您就可以使用 schemaLocation 属性了。此属性有两个值。第一个值是需要使用的命名空间。第二个值是供命名空间使用的 XML schema 的位置：

```xml
xsi:schemaLocation="http://www.runoob.com note.xsd"
```

## 四.元素

### 1.根元素

`<schema> `元素是每一个 XML Schema 的根元素：

```xml
<xs:schema>
...
...
</xs:schema>
```

`<schema> `元素可包含属性。一个 schema 声明往往看上去类似这样：

```xml
<?xml version="1.0"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
targetNamespace="http://www.runoob.com"
xmlns="http://www.runoob.com"
elementFormDefault="qualified">
...
...
</xs:schema>
```

以下代码片段:

````xml
xmlns:xs="http://www.w3.org/2001/XMLSchema"
````

显示 schema 中用到的元素和数据类型来自命名空间 "http://www.w3.org/2001/XMLSchema"。同时它还规定了来自命名空间 "http://www.w3.org/2001/XMLSchema" 的元素和数据类型应该使用前缀 xs：

这个片断：

````xml
targetNamespace="http://www.runoob.com"
````

显示被此 schema 定义的元素 (note, to, from, heading, body) 来自命名空间： "http://www.runoob.com"。

这个片断：

````xml
xmlns="http://www.runoob.com"
````

指出默认的命名空间是 "http://www.runoob.com"。

这个片断：

```xml
elementFormDefault="qualified"
```

指出任何 XML 实例文档所使用的且在此 schema 中声明过的元素必须被命名空间限定。

### 2.简易元素

XML Schema 可定义 XML 文件的元素。

简易元素指那些只包含文本的元素。它不会包含任何其他的元素或属性。

定义简易元素的语法：

```xml
<xs:element name="xxx" type="yyy"/>
```

此处 xxx 指元素的名称，yyy 指元素的数据类型。XML Schema 拥有很多内建的数据类型。

#### 2.1最常用的类型是：

- xs:string
- xs:decimal
- xs:integer
- xs:boolean
- xs:date
- xs:time

#### 2.2默认值和固定值

简易元素可拥有指定的默认值或固定值。

当没有其他的值被规定时，默认值就会自动分配给元素。

在下面的例子中，默认值是 "red"：

```xml
<xs:element name="color" type="xs:string" default="red"/>
```

固定值同样会自动分配给元素，并且您无法规定另外一个值。

在下面的例子中，固定值是 "red"：

```xml
<xs:element name="color" type="xs:string" fixed="red"/>
```

#### 2.3可选的和必需的属性

在默认的情况下，属性是可选的。如需规定属性为必选，请使用 "use" 属性：

```xml
<xs:attribute name="lang" type="xs:string" use="required"/>
```

### 3.限定

#### 3.1.对值的限定

下面的例子定义了带有一个限定且名为 "age" 的元素。age 的值不能低于 0 或者高于 120：

```xml
<xs:element name="age">
 <xs:simpleType>
  <xs:restriction base="xs:integer">
   <xs:minInclusive value="0"/>
   <xs:maxInclusive value="120"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

#### 3.2.对一组值的限定

如需把 XML 元素的内容限制为一组可接受的值，我们要使用枚举约束（enumeration constraint）。

下面的例子定义了带有一个限定的名为 "car" 的元素。可接受的值只有：Audi, Golf, BMW：

```xml
<xs:element name="car">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:enumeration value="Audi"/>
   <xs:enumeration value="Golf"/>
   <xs:enumeration value="BMW"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

上面的例子也可以被写为：

```xml
<xs:element name="car" type="carType"/>

<xs:simpleType name="carType">
 <xs:restriction base="xs:string">
  <xs:enumeration value="Audi"/>
  <xs:enumeration value="Golf"/>
  <xs:enumeration value="BMW"/>
 </xs:restriction>
</xs:simpleType>
```

**注意：** 在这种情况下，类型 "carType" 可被其他元素使用，因为它不是 "car" 元素的组成部分。

#### 3.3对一系列值的限定

如需把 XML 元素的内容限制定义为一系列可使用的数字或字母，我们要使用模式约束（pattern constraint）。

下面的例子定义了带有一个限定的名为 "letter" 的元素。可接受的值只有小写字母 a - z 其中的一个：

```xml
<xs:element name="letter">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="[a-z]"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```



下一个例子定义了带有一个限定的名为 "initials" 的元素。可接受的值是大写字母 A - Z 其中的三个：

````xml
<xs:element name="initials">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="[A-Z][A-Z][A-Z]"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
````

下一个例子也定义了带有一个限定的名为 "initials" 的元素。可接受的值是大写或小写字母 a - z 其中的三个：

```xml
<xs:element name="initials">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="[a-zA-Z][a-zA-Z][a-zA-Z]"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```



下一个例子定义了带有一个限定的名为 "choice 的元素。可接受的值是字母 x, y 或 z 中的一个：

```xml
<xs:element name="choice">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="[xyz]"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```



下一个例子定义了带有一个限定的名为 "prodid" 的元素。可接受的值是五个阿拉伯数字的一个序列，且每个数字的范围是 0-9：

```xml
<xs:element name="prodid">
 <xs:simpleType>
  <xs:restriction base="xs:integer">
   <xs:pattern value="[0-9][0-9][0-9][0-9][0-9]"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

#### 3.4对一系列值的其他限定

下面的例子定义了带有一个限定的名为 "letter" 的元素。可接受的值是 a - z 中零个或多个字母：

```xml
<xs:element name="letter">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="([a-z])*"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

下面的例子定义了带有一个限定的名为 "letter" 的元素。可接受的值是一对或多对字母，每对字母由一个小写字母后跟一个大写字母组成。举个例子，"sToP"将会通过这种模式的验证，但是 "Stop"、"STOP" 或者 "stop" 无法通过验证：

```xml
<xs:element name="letter">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="([a-z][A-Z])+"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

下面的例子定义了带有一个限定的名为 "gender" 的元素。可接受的值是 male 或者 female：

```xml
<xs:element name="gender">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="male|female"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

下面的例子定义了带有一个限定的名为 "password" 的元素。可接受的值是由 8 个字符组成的一行字符，这些字符必须是大写或小写字母 a - z 亦或数字 0 - 9：

```xml
<xs:element name="password">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:pattern value="[a-zA-Z0-9]{8}"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

#### 3.5对空白字符的限定

如需规定对空白字符（whitespace characters）的处理方式，我们需要使用 whiteSpace 限定。

下面的例子定义了带有一个限定的名为 "address" 的元素。这个 whiteSpace 限定被设置为 "preserve"，这意味着 XML 处理器不会移除任何空白字符：

```xml
<xs:element name="address">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:whiteSpace value="preserve"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

这个例子也定义了带有一个限定的名为 "address" 的元素。这个 whiteSpace 限定被设置为 "replace"，这意味着 XML 处理器将移除所有空白字符（换行、回车、空格以及制表符）：

```xml
<xs:element name="address">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:whiteSpace value="replace"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

这个例子也定义了带有一个限定的名为 "address" 的元素。这个 whiteSpace 限定被设置为 "collapse"，这意味着 XML 处理器将移除所有空白字符（换行、回车、空格以及制表符会被替换为空格，开头和结尾的空格会被移除，而多个连续的空格会被缩减为一个单一的空格）：

````xml
<xs:element name="address">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:whiteSpace value="collapse"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
````

#### 3.6对长度的限定

如需限制元素中值的长度，我们需要使用 length、maxLength 以及 minLength 限定。

本例定义了带有一个限定且名为 "password" 的元素。其值必须精确到 8 个字符：

```xml
<xs:element name="password">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:length value="8"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```

这个例子也定义了带有一个限定的名为 "password" 的元素。其值最小为 5 个字符，最大为 8 个字符：

```xml
<xs:element name="password">
 <xs:simpleType>
  <xs:restriction base="xs:string">
   <xs:minLength value="5"/>
   <xs:maxLength value="8"/>
  </xs:restriction>
 </xs:simpleType>
</xs:element>
```


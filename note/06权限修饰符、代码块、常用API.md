<center>权限修饰符、代码块、常用API</center>

## 今日内容

- 权限修饰符
- 代码块
  - 构造代码块
  - 静态代码块
- Object类
  - toString
  - Equals
  - Objects
  - native本地方法
- Date类
  - getTime
  - setTime
  - DateFormat
- Calendar类
  - get
  - set
  - add
- Math
- System
- BigInteger
- BigDecimal
- Arrays
- 包装类
  - 自动装箱拆箱
  - 字符串转换







## 第一章  权限修饰符

```java
Java中的权限修饰符.
Java中有四种权限:
public：公共的
protected：受保护的
(空的)：默认的
private：私有的
public:公共的。被pubLic修饰的成员可以在任何位置使用
protected:受保护的。被protected修饰的成员只能在本包中，以及其他包下的子类中使用。不能在其他包下的无关类中使用
默认：如果权限修饰符留空不写，那么就是默认权限。默认权限的成员只能在本包中使用。
private:私有。被private修饰的成员只能在本类中使用。
四种权限修饰符从大到小：public>protected>默认>private
重点掌握：pubLic private
   public class MyClass {
    public static void main(String[] args) {
        publicMethod();
        protectedMethod();
        morendMethod();
        privateMethod();
    }
    public static void publicMethod(){
        System.out.println("public修饰的方法");
    }
    protected static void protectedMethod(){
        System.out.println("protected修饰的方法");
    }
    static void morendMethod(){
        System.out.println("moren修饰的方法");
    }

    private static void privateMethod(){
        System.out.println("private修饰的方法");
    }
}
```

## 第二章 代码块

```java
构造代码块
格式:
    {
        代码块;


    }
位置：
    构造代码块要写在类的成员位置。
作用：
    构造代码块中的内容会在每次创建对象的时候执行。
    构造代码块会优先于构造方法执行


静态代码块（重要）

格式：
    static{
        静态代码块内容
    }

位置：
    静态代码块要定义在类的成员位置
作用：
    静态代码块中的内容会在类加载的时候执行，只会执行一次
    当我们使用一个类时，这个类必须先加载到方法区才能使用，这个过程就是类加载。当我们第一次使用某个类时，
    这个类会加载到方法区，类只会加载一次。

使用场景:
    一些项目的准备工作可以方法静态代码块中.
    比如jdbc阶段注册驱动的动作需要放在静态代码块中.
    public class Hero {
    static {
        System.out.println("静态代码块加载地图");
    }

    {
        System.out.println("构造代码块给英雄创建武器");
    }
    private String name;
    private int age;

    public Hero() {
       // System.out.println("给英雄创建武器");
       System.out.println("构造方法执行了");
    }

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
        //System.out.println("给英雄创建武器");
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
}

public class Demo01Test {
    public static void main(String[] args) {
        // 创建对象
        // Hero 东方定 = new Hero("东方定", 25);
        // new Hero();
        // new Hero();
        new Hero();
        System.out.println("==========");
        new Hero();
        System.out.println("==========");
        new Hero();
        System.out.println("==========");
        new Hero();
    }


}
/*结果
静态代码块加载地图
构造代码块给英雄创建武器
构造方法执行了
==========
构造代码块给英雄创建武器
构造方法执行了
==========
构造代码块给英雄创建武器
构造方法执行了
==========
构造代码块给英雄创建武器
构造方法执行了
*/
```

## 第三章 常用API

### 1.Object

#### 1.1简介

```java
所有类都直接或间接继承Object类,是所有的父类
如果一个类我们没有使用extends关健字继示其他类，那么这个类是继承自object的
```

#### 1.2toString方法

```java
/*
在object中，有一个方法叫做tostring,可以将对象转成字符串
String toString():返回对象的字符申表示形式。
当我们通过一个对象调用tostring方法时，会先看一下自己有没有这个方法，如果自己没有，就向上找父类，如果到了object,
Object中的toString方法，是将对象转成地址值。
直接输出一个对象名，看到的也是地址值，原因是因为在输出对象名时，内部会调用这个对象的tostring方法，也就是这个对象的
tostring结果是什么，直接输出对象名看到的就是什么结果。
一般来说调用toString看到地址值没有意义，更多的我们是希望调用tostring看到对象的内容。如果想要看到对象的内容，我们
需要对tostring方法进行重写。
*/
public class Demo02ObjectToString {
    public static void main(String[] args) {
        Person p = new Person("张三丰", 102);
        //调用toString类,输出地址值
        System.out.println(p.toString());
        // 输出的地址值
        System.out.println(p);

    }
}
// 人类
public class Person {
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

    /*@Override
    public String toString() {

        return "姓名:" + getName() + ",年龄:" + getAge();
    }*/
    // Alt+Ins快速生成

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

#### 1.3Equals

```java
在0bject中还有一个方法叫做equaLs,可以比较两个对象是否相同。
boolean equals(object obj):比较两个对象是否相同。
    
    /*
在0bject中还有一个方法叫做equaLs,可以比较两个对象是否相同。
boolean equals(object obj):比较两个对象是否相同。

当通过一个对象调用equaLs方法时，会先看一下自己有没有，如果没有，就会向上找父类。如果到bbject,
Object中的equaLs,是在使用==比较对象的地址值是否一样。

一般情况下，比较地址值是没有意，的，更多的我们是希望通过对象的属性比较两个对象是否相同。如果
两个对象的属性完全一样，那么我们可以看成是相同的对象。


如果想要调用equals根据属性比较两个对象是否相同，我们需要对equals方法进行重写。

 */
public class Demo03ObjectEquals {
    public static void main(String[] args) {
        Person p1 = new Person("冯瑟夫", 56);
        Person p2 = new Person("东方塞房", 66);
        Person p3 = new Person("东方塞房", 66);
        // 使用==比较
        System.out.println(p1 == p2);
        System.out.println(p2 == p3);
        System.out.println("============");
        //使用equals比较
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));

    }
}
// 人类
public class Person {
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

    /*@Override
    public String toString() {

        return "姓名:" + getName() + ",年龄:" + getAge();
    }*/
    // Alt+Ins快速生成

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    // 重写equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

```

#### 1.4OBjects

```java
import java.util.Objects;

/*
在JDK7的时候，多了一个工具类叫做objects,这个工具类里面有很多方法，可以对对象进行操作。
static boolean equals(Object a, Object H):比较a和b两个对象是否相同。



 */
public class Demo04Objects {
    public static void main(String[] args) {
        Teacher s1 = new Teacher("小老鼠", 25);
        Teacher s2 = new Teacher("小老鼠", 25);
        // 重写equals后结果为true
        System.out.println(s1.equals(s2));// false
        System.out.println(Objects.equals(s1,s2));// false

        Teacher t3 = null;
        Teacher t4 = null;
        //使用object的equals比较两个对象是否相同
        //通过null访问任何非静态的方法和属性都会引发空指针异常
        //System.out.println(t3.equals(t4));
        System.out.println(Objects.equals(t3,t4));// false
    }
}
public class Teacher {
    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (age != teacher.age) return false;
        return name != null ? name.equals(teacher.name) : teacher.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
```

#### 1.5native本地方法

本地方法,Java是c和c++编写,本地方法表示不是Java的语言写的.

在Object类的源码中定义了 native 修饰的方法， native 修饰的方法称为本地方法。 本地方法的作用： 就是Java调用非Java代码的接口。方法的实现由非Java语言实现，比如C或C++。 当我们需要访问C或C++的代码时，或者访问操作系统的底层类库时，可以使用本地方法实现。
也就意味着Java可以和其它的编程语言进行交互。

### 2.Date类

#### 2.1介绍

```java
Date(java.util.Date)类可以叫做时间日期类。
虽然叫做时间日期类，但是表示的是特定的时间瞬间，精确到毫秒。
```

#### 2.2构造方法

```javascript
/*
构造方法:
    Date(): 使用空参数的构造方法会根据当前计算机的时间创建Date对象。
    Date(Lang aate):参教要传递Long类型的毫秒值，表示从1970年1月1日时0分0秒开始，过了多少毫秒。
中国是东八区时间,标准时间是格林尼治时间,比标准时间块八个时间.初始时间是1970年1月1日8时0分0秒
 */
public class Demo01Date {
    public static void main(String[] args) {
        //使用空参数构造方法创建的Date对象表示当前计算机的时间。
        Date date = new Date();
        System.out.println(date);
        // 创建Date对象,传long类型毫秒值
        Date date1 = new Date(15323632203l);
        System.out.println(date1);
    }
}
```

#### 2.3getTime()

```java
/*
Date中的方法:
    long getTime():获取Date对象对应的毫秒值【从1970年1月1日开始，到Date对象对应的时间过了多少毫秒】
 */
public class Demo02DateGetTime {
    public static void main(String[] args) {
        //使用空参数构造方法创建的Date对象表示当前计算机的时间。
        Date date = new Date();
        //从1970年1月1日开始，到Date对象对应的时间过了多少毫秒
        System.out.println(date.getTime());

    }
}
```

#### 2.4setTime()

```java
/*
Date中的其他方法:
   void setTime():重新设置Date对象所表示的时间。参数是毫秒值，表示从1970年1月1日开始过了多少毫秒，
 */
public class Demo32DateSetTime {
    public static void main(String[] args) {
        //使用空参数构造方法创建的Date对象表示当前计算机的时间。
        Date date = new Date();
        System.out.println("date:"+date);
        date.setTime(899343l);
        System.out.println("date:"+date);


    }
}
```

#### 15.DateFormat

```java
import java.util.Date;

/*
如果我们希望将Date对象转成我们喜欢的格式然后进行输出，那么我们可以使用DateFormat进行格式化操作
格式化操作指的是将Date对象转成指定格式的字符申。

DateFormat是一个抽象类，如果要用，需要使用子类。最常用的子类是SimpleDateFormat
SimpleDateFormet(String pattern):参数要传递一个模式，会根据指定的模式创建SimpleDateFormat对象。
模式其实就是要转换的格式：
    最终要转换的格式：   2000年10月24日 14时12分23秒
模式：
                     yyyy年MM月dd日 HH时mm分ss秒
模式其实就是要使用英文字母替换掉格式中的数字
年：y
月：M
日：d
时：H(24)   h(12)
秒：s

SimpleDateFormet的其他方法:
String format(Date date):将参数Date对象根据指定的模式转成字符申并返回。


 将Date转String步骤:
    1.创建Date对象
    2.创建SimpLeDateFormat对象【转换器】
    3.调用SimpleDateFormat中的format方法，将Date转成字符串。


 */
public class Demo01DateFormat {
    public static void main(String[] args) {
        // 创建Date对象
        Date date = new Date();
        // 创建SimpLeDateFormat对象【转换器】
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        // 调用SimpleDateFormat中的format方法，将Date转成字符串。
        System.out.println(simpleDateFormat.format(date));//2020年07月26日 11时31分40秒
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat1.format(date));//20-07-26 11:33:13
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("y-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date));//2020-07-26 11:33:13
    }

}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
如果想要将时间字符申转成一个Date对象，我们也可以使用simpleDateFormat去完成，如果字器申转Date,一般叫做解析。

SimpleDateFormat中解析的方法：
    Date parse(String source):将字符申转成Date并返回。

解析的步骤：
    1.定义一个字符申表示时间。
    2.创建SimpleDateFormat对象【转换器】
    3.调用parse方法，将字符串转成Date
注意:
    1. SimpLeDateFormat构造方法中的模式，必须要和字符串的格式一致
    2.调用完parse方法会出现红线，原因是因为parse方法需要处理异常【后期讲解】现在做法是把光标放到红线上，然后按alt+回车，选择第一个
 
 小结：
    Date->String:格式化，SimpLeDateFormat中的format方法完成。
    String->Date:解析，SimpLeDateFormat中的parse方法完成。
 
 */
public class Demo02DateFormat {
    public static void main(String[] args) throws ParseException {
        // 定义一个字符申表示时间。
        String s = "2020-07-26 11:35:20";
        // 创建SimpleDateFormat对象【转换器】
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 调用parse方法，将字符串转成Date
        Date parse = simpleDateFormat.parse(s);

        System.out.println(parse);
    }

}
```

### 3.Calender类

#### 3.1简介

```java
import java.util.Calendar;

/*
Calendar叫做日历类。
虽然他叫做日历类，但是他和Date一样，也可以表示精确的时间瞬间，精确到毫秒。
Calendar是一个抽象类，如果要用需要使用子类。
由于时间地区的敏感性,Calendar的子类对象(日历)不需要我们自己new,可以通过Calendar的静态方法获取
 Calendar中获取日历的方法
static Calendar getInstance():根据时区的设置获取一个日历对象。

 */
public class Demo01Calendar {
    public static void main(String[] args) {
        // 调用Calendar中的静态方法获取日历
        // Ctrl + Alt + v
        Calendar instance = Calendar.getInstance();
        //将日历对象输出
        System.out.println(instance);
    }
}
```

#### 3.2方法介绍get

```java
import java.util.Calendar;

/*

在CaLendar中有一个方法叫做get,可以获取指定字段值
int get(int field):获取日历中指定字段的值并返回。
举例：
    get(年）:获取年的数据
    get(月）:获取月的数据
    get(日）:获取日的数据
get方法的参数是int类型，所以要传递int数字。我们可以使用int数字表示日历中的指定字段。
但是如果每次调用get方法，都传递数字，阅读性就会非常非常
在CaLendar中给我们提供了很多静态常量，这些经常常量是一些数字，并且根据常量名可以起到见名知意
的作用。在调用get方法时，最好传递这些常量
Calendar.YEAR:年
Calendar.MONTH:月
Calendar.DATE:日
注意：Calendar中的月份是从0开始的，范围是0到11。比我们生活中的月份要少1.
 */
public class Demo02Calendar {
    public static void main(String[] args) {
        // 调用Calendar中的静态方法获取日历
        // Ctrl + Alt + v
        Calendar c = Calendar.getInstance();
        // 获取指定字段的数据
        int i = c.get(Calendar.YEAR)-1949;
        //将日历对象输出
        System.out.println("现在是共和国"+i+"年");
        int i1 = c.get(Calendar.MARCH);
        System.out.println("现在是第 "+(i1 + 1)+"月");
        int i2 = c.get(Calendar.DATE);
        System.out.println("day:" + i2);
    }
}
```
#### 3.3set方法

```java


/*
在Calendar中有一个方法叫做set,可以设置指定字段的值。
    void set(int field, int value):给指定字段设置值。
        参数field:给哪个字段设置值。
        参数vaLue:设置成什么值
 */


import java.util.Calendar;

public class Demo03Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
        // 重新设置值
        c.set(Calendar.YEAR,1912);
        c.set(Calendar.MARCH,0);
        c.set(Calendar.DATE,1);
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
    }
}

```

#### 3.4 add方法

```java
/*
在Calendar中有一个方法叫做add,可以对指定字段的值进行计算。
void add(int field, int amount):对指定字段的值进行计算。
参数field:对哪个字段进行计算。
参数amount:如何计
如果该数是一个正数，表示加上该值。2
如果该数是一个负数，表示减去该值。-2
 */


import java.util.Calendar;

public class Demo04CalendarAdd {
    public static void main(String[] args) {
        // 获取日历对象
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
        // 对年字段进行计算
        c.add(Calendar.YEAR,2696);
        c.add(Calendar.MARCH,10);
        c.add(Calendar.DATE,12);
        System.out.println("黄帝历:"+c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
    }
}
```

### 4.Math类

```java
/*
Math是数学工具类，里面有很多方法可以进行数学运算
static int abs(int a):求出绝对值并返回
static double ceil(double a):向上取整
static double floor(double a):向下取整
static Long round(double a):四舍五入
static double pow(double a,double b):求a的b次幂(房)
 */

public class Demo01Math {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(10));//10
        System.out.println(Math.abs(-10));//10
        // 向上取整
        System.out.println(Math.ceil(3.4));//4.0
        System.out.println(Math.ceil(-3.4));//-3.0
        //向下取整
        System.out.println(Math.floor(3.2));//3.0
        System.out.println(Math.floor(-3.2));//4.0
        //四舍五入
        System.out.println(Math.round(3.4));//3
        System.out.println(Math.round(3.6));//4
        // 求平方
        System.out.println(Math.pow(3, 4));//81.0
    }
}
```

### 5.System类

```java
/*
System可以称为系统类，里面有一些方法可以完成系统相关的操作
static void exit ( int status ):终止正在运行的Java虚拟机。参数是状态码，0表示正常终止,非0表示异常终止
static Long currentTimeMiLLis():获取当前时间，以毫秒为单位【从1970年1月1日开始过了多少毫秒】
 */

public class Demo1System {
    public static void main(String[] args) {

        long millis = System.currentTimeMillis();
        System.out.println(millis);
        /*System.out.println("hello");
        System.exit(0);
        System.out.println("world");//不在执行;*/

    }
}
/*
要求：统计输出1000次HeLLoWorLd花费多长时间。
步骤：
1.在输出HeLLoWorld之前记录当前时间【喜秒值】
2.输出Helloworld
3.在输出Helloworld之后记录当前时间【喜秒值】
4.相减
 */
public class Demo02System {
    public static void main(String[] args) {
        // 1.在输出HeLLoWorld之前记录当前时间【喜秒值】

        long startl = System.currentTimeMillis();

        // 2.输出Helloworld
        for (int i = 1000; i > 0; i--) {
            System.out.println("helloworld");
        }

        // 3.在输出Helloworld之后记录当前时间【喜秒值】
        long entl = System.currentTimeMillis();

        // 4.相减
        System.out.println(entl - startl);
    }
}

```

### 6.BigInteger类

```java
/*
如果是非常大的数字，用Long也是无法表示或者进行计算的。
此时就需要使用BigInteger了.
BigInteger表示数字，这个数字可以无限大。
BigInteger的构造方法：
BigInteger(String val):根据字符串数字创建BigInteger对象


BIgInteger的运算方法:

        BigInteger add(BigInteger val):进行加法运算。
        BigInteger subtract(BigInteger val):进行减法运算
        BigInteger multiply(BigInteger val):进行乘法运算
        BigInteger divide(BigInteger val):进行除法运算
*/
import java.math.BigInteger;

public class Demo01BigInteger {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("332324654328983939328235443239985443456443534");
        BigInteger b = new BigInteger("132324863492094294359530595305465930456443534");
        BigInteger result = a.add(b);
        System.out.println(result);
        result = a.multiply(b);
        System.out.println(result);
        result = a.subtract(b);
        System.out.println(result);
        result = a.divide(b);
        System.out.println(result);
    }
}
```

### 7.BigDecimal类

#### 7.1加减乘发

```java
/*
在Java中小数是不精确的，在运算时有可能出现精度问题。比如1.3加1.6结果是2.9000000000000004

如果想要在运算时解决这个精度问题，那么可以使用BigDecimal
BigDecimal表示精确的小数。

BigDecimal的构造方法
BigDecimal(double val):根据double小数创建一个BigDecimal对象【会产生精度问题，不推荐】
BigDecimal(String val):根据String创建一个BigDecimal对象【推荐】
BigDecimal的加减乘运算的方法：
BigDecimal add(BigDecimal augend):加法运算
BigDecimal subtract(BigDecimal subtrahend):减法运算
BigDecimal multiply(BigDecimal multiplicand):乘法运算

*/

import java.math.BigDecimal;

public class Demo01BigDecimal {
    public static void main(String[] args) {
       /* double a = 1.3;
        double b = 1.6;
        System.out.println(a + b);*/
        BigDecimal a = new BigDecimal("1.6");
        BigDecimal b = new BigDecimal("1.3");
        BigDecimal result = a.add(b);
        System.out.println(result);
        result = a.subtract(b);
        System.out.println(result);
        result = a.multiply(b);
        System.out.println(result);

    }
}
```

#### 7.2除法

```java
public class Demo02BigDecimal {
    public static void main(String[] args) {
        // 创建BigDecimal对象
        BigDecimal a = new BigDecimal("3.6");
        BigDecimal b = new BigDecimal("1.2");
        BigDecimal d = new BigDecimal("4.7");

        BigDecimal c = a.divide(b);
        System.out.println(c);
        // System.out.println(d.divide(b));//除不尽报错

        BigDecimal divide = d.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);

    }
}
```

### 8.Arrays类

```java
/*
Arrays是操作数组的工具类
    static String toString(数组）:将数组内容转成指定格式的字符申并返回
    static void sort(数组）:对数组中的内容进行排序。



 */

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {

        // 创建数组
        int[] arr = {66,22,77,44,55};
        // 将数组的内容转成字符串
        String s = Arrays.toString(arr);
        System.out.println(s);
        // 通过Arrays的sort方法,对内容排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

### 9.包装类

#### 9.1 概述

```java
每一种基本类型都有其对应的引用类型，这个对应的引用类型叫做包装类。

    基本类型        引用类型（包装类）
    byte            Byte
    short           Short
    int             Integer（特殊）
    long            Long
    float           Float
    double          Double
    boolean         Boolean
    char            Character（特殊）
    基本类型和对应的包装类使用方式基本一致。
    基本类型只是一些简单的数据，只能直接使用或者进行运算，无法调用方法，优点效率高
    包装类是引用类型，可以创建对象，并且可以调用方法,功能比较强大
```

#### 9.2自动拆箱装箱

```java
/*
在JDK5的时候，多了一个新的特性，叫做自动拆装箱。
        拆箱： 包装类类型转成对应的基本类型。
        装箱： 基本类型转成对应的包装类类型。

    有了自动拆装箱后，基本类型以及包装类类型可以自动转换。

 */

public class Demo01Wrap {
    public static void main(String[] args) {
        // 自动装箱:10默认是int类型，把int类型的10赋值给Integer类型，那么基本类型会自动变成对应的包装类类型
        Integer a = 10;
        // 自动装箱:20默认是int类型，把int类型的20赋值给Integer类型，那么基本类型会自动变成对应的包装类类型

        Integer b = 20;
        // 自动拆箱:Integer类型的a和会先把自己转成int类型，然后再去进行运算。此时包装类型转成基本类型就是拆箱。
        // 自动装箱：a和相加的结果是int类型，把int类型的结果以赋值的方式交给Integer,基本类型int就转成了包装类类型

        Integer sum = a+b;
        System.out.println(sum);


    }
}
```

#### 9.3手动装箱拆箱

```java
/*
 在JDK5之前，如果基本类型和对应的包装类进行转换，需要使用手动拆装箱。

    手动装箱（int -> Integer）
        使用包装类的静态方法valueOf即可。
        static Integer valueOf(int i)：接受一个int类型的数据，返回Integer类型的结果。
    手动拆箱（Integer -> int）
        使用包装类的方法intValue实现
        int intValue()：将Integer对象转成int数字并返回
 */

public class Demo02Wrap {
    public static void main(String[] args) {
       int a = 10;
        Integer integer = Integer.valueOf(a);
        System.out.println(integer);
        int i = integer.intValue();
        System.out.println(i);
    }
}
```

#### 9.4Integer的常见方法

```java
/*
Integer中的常见方法
Integer(int value):根据int数字创建Integer对象
Integer(String s):根据字符申创建Integer对象。
static Integer valueof(int i):将int转成Integer并返回
static Integer valueof(String s):将String转成Integer并返回

 */

public class Demo03Integer {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        System.out.println(a);
        Integer b = new Integer("100");
        System.out.println(b);
        Integer c = Integer.valueOf(100);
        System.out.println(c);
        Integer d = Integer.valueOf("100");
        System.out.println(d);


    }
}
```

#### 9.5基本类型与字符串想回转换

```java
/*
基本类型和字符申的相互转换
基本类型->字符串
    1.直接在基本类型数据后面加上“”    1+"abc"->  "1abc"
    2.调用String的静态方法valueOf
        static string valueof(任何类型）:将数据转成字符串并返回。
 字符串 -> 基本类型
        我们可以使用基本类型对应包装类的静态方法parseXXX完成。

        除了Character每个包装类中都有一个静态方法ParseXxx,可以把字符串转成对应的基本类型。
        如果要将字符串转成int类型，那么就是Integer中的静态方法parseInt完成。
        如果要将字符串转成double类型，那么就使用Double中的静态方法parseDouble完成。
        如果要讲字符串转成long类型，那么就使用Long中的静态方法parseLong完成。

        要把String转成int类型，使用Integer中的parseInt方法进行转换。
        要把string转成Long类型，使用Long中的parseLong方法进行转换。
        要把String转成double类型，使用DoubLe中的parseDouble方法进行转换
 */

public class Demo04Parse {
    public static void main(String[] args) {
        int num = 10;
        String str = num + "";
        System.out.println(str);
        String str1 = String.valueOf(num);
        System.out.println(str1);

        String ss = "231445";
        int basicNum = Integer.parseInt(ss);
        System.out.println(basicNum);
    }
}
```

## 总结

```java
一. 权限修饰符
	public：公共的。被public修饰的成员可以在任何位置使用。
	protected：受保护的。 只能在本包中，以及其他包下的子类中使用。不能在其他包下的无关类中使用。
	默认：如果权限修饰符省略不写，这个就是默认权限。默认权限只能在本包中使用。
	private：私有的。私有的成员只能在本类中使用。
	
二. 代码块
	构造代码块（了解）
		格式： 
			{
				内容
			}
		作用：
			构造代码块在每次创建对象的时候执行，优先于构造方法执行。
			
	静态代码块
		格式：
			static {
				内容
			}
			
		作用：
			静态代码块在累加载的时候，终身只会执行一次。
			
三. Object【重点】
	概念：是所有类的父类。
	方法：
		String toString()：将对象转成字符串。默认Object中的toString是转成了地址值。如果想要得到自己想要的内容，需要在子类中重写。
		boolean equals(Object obj)：比较两个对象是否相同。默认Object中的equals根据地址值比较。如果想要自己定义比较规则，需要在子类中重写。

四. Date
	概念：表示特定的时间瞬间，精确到毫秒
	构造方法：
		Date()：使用空参数构造方法创建的Date对象表示的是当前系统时间。
		Date(long date)：参数是毫秒值，表示从1970年1月1日开始过了多少毫秒。
		
	其他方法：
		long getTime()：获取Date对象表示的毫秒值
		void setTime(long millis)：给Date对象设置毫秒值
		
五. DateFormat
	概念：用于Date和String相互转换。DateFormat是一个抽象类，如果要用需要使用子类SimpleDateFormat
	
	构造方法：
		SimpleDateFormat(String pattern)：参数要传递一个模式，模式就是转换的格式。 比如yyyy-MM-dd HH:mm:ss
	
	其他方法：
		String format(Date date)：将Date对象转成一个指定格式的字符串并返回
		Date parse(String str)：将字符串解析成一个Date对象并返回。
		
六. Calendar
	概念：日历类，也可以表示特定的时间瞬间。
	其他方法：
		static Calendar getInstance()：获取日历对象
		int get(int field)：获取日历中指定字段的值
		void set(int field, int value)：给日历中的指定字段设置值。
		void add(int field, int amount)：对日历中的指定字段进行计算。
		
七. System
	概念：系统类，里面有很多静态方法和系统有关
		static void exit(int status)：终止Java虚拟机，参数是0表示正常终止
		static long currentTimeMillis()：获取当前系统时间（毫秒值）
		
八. BigInteger
	概念：表示大的整数【无穷大】
	构造方法：
		BigInteger(String val)：根据字符串数字创建BigInteger对象
	其他方法：
		BigInteger add(BigInteger val)：进行加法运算。
        BigInteger subtract(BigInteger val): 进行减法运算
        BigInteger multiply(BigInteger val)： 进行乘法运算
        BigInteger divide(BigInteger val)：进行除法运算

九. BigDecimal
	概念：表示精确的小数。
	构造方法：
		BigDecimal(double val)：根据double小数创建一个BigDecimal对象【会产生精度问题，不推荐】
        BigDecimal(String val)：根据String创建一个BigDecimal对象【推荐】
	其他方法：
		BigDecimal add(BigDecimal augend):加法运算
        BigDecimal subtract(BigDecimal subtrahend)：减法运算
        BigDecimal multiply(BigDecimal multiplicand)：乘法运算
		BigDecimal divide(BigDecimal divisor)：进行除法运算。如果除不尽，会报错
        BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)： 进行除法运算，可以保留指定位的小数部分。
            参数divisor： divisor表示除以几。
            参数scale：表示保留几位小数
            参数roundingMode： 舍入模式。 这个参数我们要使用BigDecimal中的常量 ROUND_HALF_UP 表示四舍五入的模式
	
十. Arrays
	概念：表示数组的工具类，里面的方法可以操作数组
	方法：
		static String toString(数组)：将数组内容转成指定格式的字符串并返回
        static void sort(数组)：对数组中的内容进行排序。
		
十一. 包装类
	概念：每种基本类型都有对应的包装类，这个包装类是引用类型。他们的用法基本一致，包装类功能更加强大，比如可以调用方法。
			基本类型			包装类
			byte				Byte
			short				Short
			int					Integer
			long				Long
			float				Float
			double				Double
			boolean				Boolean
			char				Character
	
	自动拆装箱：
		在JDK5的时候，有了自动拆装箱特性。
		自动装箱：基本类型可以自动转成对应的包装类类型。
		自动拆箱：包装类类型可以自动转成对应的基本类型。
		
	基本类型和字符串的相互转换
		基本类型 -> 字符串
			直接在基本类型后面加上""
			
		字符串 -> 基本类型
			使用对应包装类的静态方法parseXxx即可。
			要把String转成int类型，使用Integer中的parseInt方法进行转换。
            要把String转成long类型，使用Long中的parseLong方法进行转换。
            要把String转成double类型，使用Double中的parseDouble方法进行转换
            ...
			

重点:
	1. 权限修饰符重点掌握public和private，protected和默认权限能理解。
	2. 掌握静态代码块。
	3. 掌握Object【最重点】
	4. 掌握Date 
	5. 掌握包装类。
	6. 掌握Arrays
	
	
	其他用的使用能查即可
		比如：BigInteger,BigDecimal,Math,System,Calendar
```


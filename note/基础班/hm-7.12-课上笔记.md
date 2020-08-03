<center>构造方法、继承、抽象类</center>

## 今日内容

- 构造方法

- 继承

- 抽象类

  ​	模板设计模式【面试必备】

## 第一章 构造方法

### 1构造方法介绍

#### 构造方法是什么

```java
就是我们创建某个类的对象时调用的方法
比如：创建Dog类对象
Dog d = new Dog ( ) ;
```

#### 构造方法的格式

```java
1.构造方法的方法名必须和类名一模一样
2.构造方法是没有返回值的，连void也没有
    public class Dog {
    private String name;
    private int age;
    //默认构造方法
    public Dog(){
        System.out.println("默认构造方法");
    }
    }
```

#### 构造方法的功能

```java
上成的对象的成员变量赋默认值！
    public Dog(){
        system.out.println("Dog的默认构造方法...");
        //默认构造方法给成员变量赋默认值I
        //this.name=nu11;
        //this.age=0;
    }
```

#### 代码演示

```java
public class Dog {
    private String name;
    private int age;
    //默认构造方法
    public Dog(){
        System.out.println("默认构造方法");
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
//测试类
public class TestDog {
    public static void main(String[] args) {
        Dog dd = new Dog();
    }
}
```



### 2构造方法的注意事项

#### 4点注意事项

```java
a.如果一个类我们没有写构造方法，那么系统会自动生成一个无参构造，构造中会给成员变量赋默认值！!
b.构造方法也是方法，所以可以重载，但是如果我们重载任意一个构造，那么无参构造系统将不会自动生成了
c.无论我们如何使用构造，无参构造建议我们直接写出来
d.无参构造和有参构造区别在于：一个给成员变量赋默认值一个给成员变量赋指定的值
```

#### 代码演示

```java
public class Dog {
    private String name;
    private int age;
    //默认构造方法
    public Dog(){
        System.out.println("默认构造方法");
    }
    //构造方法重载
    public Dog(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Dog(String name){
        this.name=name;
        // this.age=age;
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
//测试类
public class TestDog {
    public static void main(String[] args) {
        //创建Dog对象
        Dog dd = new Dog();
        System.out.println(dd.getName());
        System.out.println(dd.getAge());
        //使用重载后的有参构造
        Dog dd1=new Dog("wangcai",18);
        System.out.println(dd1.getName());
        System.out.println(dd1.getAge());
        Dog dd2=new Dog("wangcai");
        System.out.println(dd2.getName());
        System.out.println(dd2.getAge());
    }
}

```

### 3标准类制作

#### 标准类lavaBean

```java
a.所有的成员变量都需要封装（private+get/set)
.我们应该给标准类提供至少两个构造：无参构造+满参构造
```

#### 代码演示

```java
/*
 * a.封装
 * b.2个构造
 **/
public class Student {
    private String name;
    private int age;
    private double score;
    //无参
    public Student() {

    }
    //满参
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}


```

## 第二章继承

### 1继承的概念

```java
Java中的继承：
有一个类A继承另外一个类B,这个过程称为继承
其中类A称为子类/派生类/subclass
其中类B称为父类/基类/超类/superclass
```
### 2继承的格式
```java
public class 父类{
}
public class 子类 extends 父类{
    
}
```
### 3继承的案例
```java
/*
* 父类人类
* */
public class Human {
    String name;
    int age;
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }

}
/*
* 子类学生
* */
public class Student extends Human {
    public void study(){
        System.out.println("学习");
    }
}
/*
* 之类老师类
* */
public class Teacher extends Human{
    double salary;
    public void teach(){
        System.out.println("dsjkghasddkjhgj");
    }
}
public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.name="丹丹";
        s.age=23;
        s.sleep();
        s.study();
        s.eat();
        Teacher teacher = new Teacher();
        teacher.name="laoshi";
        teacher.age=34;
        teacher.salary=4567.77;
        teacher.sleep();
        teacher.teach();
        teacher.eat();

    }
}
//继承的好处
在于提高代码的复用性，提高开发效率
```
### 4子类不能继承的内容
```java
a.父类中的构造方法子类是无法继承的!!
b.父类中的私有成员，子类可以继承，但是继承也没法直接使用!!(可以间接使用)
```
### 5继承后的特点——成员变量
```java
a.如果子父类成员变量不同时，那么访问时取决于打印是哪个成员变量名
b.如果子父类成员变量同名了，那么子类中优先访问子类的成员变量!
c.如果子父类成员变量同名了，那么我们想要在子类中访问父类的那个成员变量，需要使用super.成员变量名访问!!   
   
public class Fu {
// int numFu=10;
int num=10;
}
public class zi extends Fu {
// int numzi=20;
int num=20;
//打印成员变量
public void show(){
//
system.out.println(numFu);
//
system.out.println(numzi);
//
system.out.print1n(num);//就近原则，访问的是子类的20
system.out.println(super.num);//用于区别子父类成员变同名的关键字
}
public class TestDemo {
public static void main(string[] args){
//1创建对象
zizz=newzi();
zz.show();}}
```
### 6继承后的特点——成员方法
```java
a.如果子父类成员方法不同时，那么调用时取决于调用的是哪个方法名
b.如果子父类成员方法同名了，那么使用子类对象去调用方法时，优先访问子类的成员方法!
c.我们可以在子类的方法中，使用super方法名（指定调用父类的某个方法    
    public class Fu {
// public void showFu(){
//
system.out.print1n("Fu类的show....");
// }
public void show(){
system.out.print1n("Fu类的show....");
}}
public class Zi extends Fu {
public void show(){
system.out.println("zi类的show....");
super.show();}}
public class TestDemo {
public static void main(string[] args){
//1.创建对象
zizz=newziO;
zz.showzi();
//
zz.showFu()
//2.调用同名方法
zz.show();}}
```
### 7重写的概念和应用
```java
在实际开发中，不会出现子父类的成员变量同名这种现象，因为没有意义!
在实际开发中，经常会出现子父类的成员方法同名的现象，这是非常有意义!
方法重载：
在同一个类中，方法名一样，参数列表不一样，这些方法称为方法重载!!
方法重写：
在子父类中，子类出现了一个和父类除了方法体其他一模一样的方法，那么子类中这个方法称为方法重写   
方法重写的应用场景：
当子类继承父类的方法后，如果方法该方法功能不足或者功能不适合，那么我们可以在子类从重写这个方法！
```
### 8@Override注解
```java
@override //方法重写注解
    //作用：如果我们在方法上写了aoverride,那么就代表该方法是重写的，编译器就会帮助我们检查重写语法是否正确!
```
### 9方法重写的注意事项
```java
a.方法重写的前提是继承关系（实现关系）
b.方法重写后，要求子类中的方法权限>=父类中方法权限（了解）
c.方法重写时，返回值类型、函数名和参数列表都要一模一样。
```
### 10继承后的特点——构造方法

#### 构造方法特点介绍

```java
a.子类能否继承？?
	子类是无法继承父类的构造方法!!
b.子类的任何构造方法中第一行会有一句隐藏的代码，super(),调用父类的无参构造!!!
```
#### 构造方法案例演示

```java

```

#### 构造方法总结

```java

```

### 11 super(...)和this(…）

```java

```
### 12 Java中继承的特点
```java


```
## 第三章抽象类

### 1抽象类的概念和引入
```java

```
### 2 abstract使用格式
```java

```
### 3抽象类的特征和注意事项
```java

```
### 4抽象类存在的意义
```java

```
### 5第一个设计模式：模板模式（司机开车）
```java

```
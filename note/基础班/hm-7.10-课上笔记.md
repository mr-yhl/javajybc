<center>面向对象</center>

## 今日内容

- 面向对象思想
- 类与对象的使用

## 第一章 面向对象

### 1面向对象思想概述

```java
面向过程编程思想
强调的是过程,必须清楚每一个步骤,然后按照步骤一步一步去实现
面向对象编程思想
强调的是对象, 通过调用对象的行为来实现功能，而不是自己一步一步的去操作实现。
```

### 2类和对象以及他们的关系

```java
要想有对象,必须先有类!!
什么叫类：
一群具有相同属性和行为的事物的统称
什么叫对象：
类中的某一个具体的存在（实例，instance)
    类和对象的关系：
类是模板，是抽象类
对象是以模板创建出来的实体，是具体的
```

## 第二章类与对象的使用[重点]

### 1类的定义

```java
格式:
public class 类名{
    //属性(成员变量)
    数据类型 变量名;
    ....
    //行为（成员方法）,和我们基础班方法相比，少了一个关键字static
    public返回值类型方法名（形式参数）{
    方法体;
    return返回值;
    }
}
public class Dog {
    String name;
    int age;
    public void bark(){
        System.out.println("汪汪...");
    }
    public void eat(){
        System.out.println("吃骨头...");
    }

}
```

### 2对象的创建和使用

```java
创建对象格式:
		类名  对象名 = new 类名();
使用对象:
		对象名.成员变量
		对象名.成员方法名()
     public class TestDog {
        public static void main(String[] args) {
            //根据dog类创建对象
            Dog dd = new Dog();
            dd.age=18;
            dd.name="丹丹";
            System.out.println(dd.name);
            System.out.println(dd.age);
            dd.bark();
            dd.eat();

        }
	}

```

### 3学生对象-练习

需求：首先定义一个学生类，然后定义一个学生测试类，在学生测试类中通过对象完成成员变量和成员方法的使用

```java
public class Student {
    String id;
    String name;
    int age;
    public void eat(){
        System.out.println("学生吃盒饭...");
    }
    public void study(String subject){
        System.out.println("学生在学" + subject);
    }

}


public class TestStudent {
    public static void main(String[] args) {
        Student s = new Student();
        s.id="10000";
        s.name="电信";
        s.age=15;
        System.out.println(s.id);
        System.out.println(s.name);
        System.out.println(s.age);
        s.eat();
        s.study("java");
    }
}

```



### 4成员变量的默认值

````java
成员变量是默认值的！!默认值和数据类型有关的
整数类型默认值:0
小数类型默认值:0.0
字符类型默认值:' '
布尔类型默认值:false
引用类型默认值:nu11
````

## 第三章类与对象的内存图[理解]

### 回顾Java内存的五大区

```java
栈区：运行方法以及保存方法中定义的变量
堆区：保存new出来的东西（对象）
方法区：保存字节码文件
本地方法区：和操作系统相关
寄存器区：和CPU相关
```

## 第四章成员变量和局部变量区别[重点]

### 1什么是成员变量和局部变量

```java
什么是成员变量：
	定义在类中方法外
什么是局部变量：
	定义在类中方法内
```



### 2成员变量和局部变量的五大区别

```java
a.定义位置不同
    成员变量：定义在类中方法外
    局部变量：定义在类中方法内
b.默认值不同
    成员变量有默认值
    局部变量没有默认值
c.有效范围不同（作用域不同）
    成员变量在整个类都是有效的
    局部变量只在当前方法中有效的
d.内存位置不同
    成员变量跟随对象保存在堆中
    局部变量跟随方法的运行保存在栈中
e.生命周期不同（从出生到销毁）
    成员变量跟随对象的创建而出现，跟随对象的销毁而销毁
    局部变量跟随方法的执行而出现，跟随方法执行完毕而销毁
```



## 第五章封装[重点]

### 1封装怎么理解

```java
我们可以理解为是一种对数据的保护屏障
    电脑: (主板,内存,显卡,CPU,风扇) 封装各种元件,最终给用户的就是一个开机按钮
```



### 2为什么要封装

```java
/**
 * 女孩类
 */
public class Girl {
    String name;
    int age;
    //...

    public void ps(){
        System.out.println("美美美哒...");
    }

    public void buyBuyBuy(){
        System.out.println("清空购物车...");
    }
}

/**
 * 测试类
 */
public class TestDemo {
    public static void main(String[] args) {
        //1.创建一个女孩
        Girl g = new Girl();
        System.out.println(g.age);
        System.out.println(g.name);

        //2.赋值
        g.age = -18;
        g.name = "美美";
        System.out.println(g.age);
        System.out.println(g.name);
        //由于age我们没有封装,所以别人可以随意给age赋值,数据就不能保证安全了!!!
    }
}
```

### 3封装的原则和步骤

```java
原则：
a.隐藏需要封装的数据
b.对外暴露可以访问的方式
步骤：
a.使用private修饰要封装的数据
b.对封装的数据提供get/set方法
```



### 4封装的操作

#### private关键字

 ```java
  private关键字,称为私有关键字
  作用: 当前类中的成员变量/成员方法 如果用private修饰了,那么该变量或者方法只能在类的内部使用!!    
 ```

#### 封装代码演示

```java
/**
 * 女孩类
 */
public class Girl {
    String name;
    //1.封装数据
    private int age;

    //2.提供age的get和set方法
    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        if (a < 0 || a > 200) {
            System.out.println("您的年龄非法");
        } else {
            age = a;
        }
    }
}
/**
 * 测试类
 */
public class TestDemo {
    public static void main(String[] args) {
        //1.创建一个女孩
        Girl g = new Girl();
//        System.out.println(g.age); //封装之前
        System.out.println(g.getAge()); //封装之后
        System.out.println(g.name);

        //2.赋值
//        g.age = -18;//封装之前
        g.setAge(10);//封装之后
        g.name = "美美";
        System.out.println(g.getAge()); //封装之后
        System.out.println(g.name);
        //由于age我们没有封装,所以别人可以随意给age赋值,数据就不能保证安全了!!!
    }
}
以后我们所有类，必须所有成员变量使用private,提供get/set方法，这是Java标准类的规范(JavaBean)
```

### 5 this关键字

#### this的作用

用于区别成员变量和局部变量同名的情况
如果成员变量和局部变量同名，JVM会采用就近原则，访问局部变量

#### this原理

this代表一个对象，当前对象！
成员方法是由哪个对象调用的，那么该方法中this就代表哪个对象名

### 6封装总结

1.封装概述是面向对象三大特征之一（封装，继承，多态）
2.封装原则a.将成员变量隐藏b.对外提供可以访问该成员变量的方式
private
getxxx和setxxx方法
3.封装好处a.提高代码的安全性b.提高了代码的复用性
在开会我们idea会自动生成封装代码，使用快捷键alt+insert
选择getterandsetter即可（初学者必须熟练后再使用快捷键）
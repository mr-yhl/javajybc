<center>继承、抽象类、模板设计模 式、final关键字</center>

## 今日内容

- 继承 
- 抽象类
- 模板设计模式
- final 关键字

## 第一章 匿名对象

### 1.概念

```java
匿名对象 ,就是没有名字的对象,创建出来但是没有用变量去接收,那么就是匿名对象
    new 数据类型();
好处:
    稍微简化我们的操作
        
        // 原调用
        Student student = new Student();
        student.eat();
        // 匿名对象调用eat方法
        new Student().eat();
```

### 2.使用场景

```java
使用场景:
    1.某个对象只需要调用一次,可以使用匿名对象[匿名对象没有变量接收,只能使用一次]
    2.匿名对象当作参数传递
        
    public class Demo01NoName {
    public static void main(String[] args) {
        // 原调用
        Student student = new Student();
        student.eat();
        // 匿名对象调用eat方法
        new Student().eat();
        // 只能使用一次(打印3次地址不同)
        System.out.println(new Student());// cn.com.mryhl.noname.Student@1b6d3586
        System.out.println(new Student());//  cn.com.mryhl.noname.Student@4554617c
        System.out.println(new Student());// cn.com.mryhl.noname.Student@74a14482
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("战术",23));
        list.add(new Student("李斯术",25));
        list.add(new Student("一百二十三",25));
        for (int i = 0; i < list.size(); i++) {
            Student student1 = list.get(i);
            System.out.println(student1.getName() + student1.getAge());
        }
    }
}
```

## 第二章 继承

###  1.概念

继承描述的是事物之间的所属关系，这种关系是： is-a 的关系。

继承：就是子类继承父类的属性和行为，使得子类对象可以直接具有与父类相同的属性、相同的行为。子类可以直 接访问父类中的非私有的属性和行为。

继承时多态的前提,没有继承就没有多态。Java中的继承是描述事物之间是所属关系。

子类继承父类，会自动继承父类所有的成员。（父类私有的成员也能继承，但不能直接访问）

好处：

​		**提高代码的复用性**。

将子类的共性抽取到父类中。

父类拥有之类的所有共性。

子类除了拥有共性外，还有子类特有的内容。

### 2.格式

```java
继承的格式:
    public calss A{}
    public calss B exctends A{}
    A是父类,B是子类
```

### 3.实操[重点]

```java
// 父类
public class Employee {
    String name;
    int age;
}
// 子类
public class Teacher extends Employee{

    public void teach(){
        System.out.println("讲课");
    }
}
// 测试
public class Demo01Test {
    public static void main(String[] args) {
        // 创建教师类
        Teacher teacher = new Teacher();
        teacher.name="战神";
        teacher.age=19;
        System.out.println("姓名" + teacher.name + ",年龄" + teacher.age);
        teacher.teach();
    }
}
```

### 4.访问特点[重点]

```java
/*
继承关系中成员变量访问特点:
    通过子类访问成员，如果子类没有，会向上找父类。
    通过父类访问成员，如果父类没有，不会向下找子类。

同名变量访问：
    直接访问（通过子类对象）
        访问的是之类的变量
    间接访问：
        调用的哪个类的方法,就是访问的哪个类的属性    
        */
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();
        Fu fu = new Fu();
        System.out.println(zi.numZi);
        System.out.println(zi.numFu);
        // 同名变量访问
        System.out.println(zi.num);

        zi.showZi();
        zi.showFu();

    }
}
public class Fu {
    int numFu= 20;
    int num =30;
    // 定义方法,输出num
    public void showFu(){
        System.out.println(num);
    }

}
public class Zi extends Fu{
    int numZi = 10;
    int num =40;
    public void showZi(){
        System.out.println(num);
    }
}
```

```java
/*
继承关系中成员方法访问特点
    如果子类的成员方法和父类的成员方法同名，那么通过子类对象访问的是子类的成员方法。
在子类中出现了和父类一样的方法,叫做重写Override
    重载(Overload):方法名相同,参数列表不同
    重新(Overri):子类和父类方法一样

 */
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();

        zi.methodZu();
        zi.methodFu();

        zi.method();
    }
}
// 父类
public class Fu {
    public void methodFu(){
        System.out.println("父类执行");
    }
    public void method(){
        System.out.println("父类2执行");
    }
}
// 子类
public class Zi extends Fu {
    public void methodZu(){
        System.out.println("子类执行");
    }
    public void method(){
        System.out.println("子类2执行");
    }
}
```

### 5.重写注解

```java
/*
@Override叫做注解,用来验证是否重写了父类的方法
如果我们在某个方法上面加上@Override报错，那么就说明该方法不是重写的父类的方法。
如果我们在某个方法上面加上@Override不报错，那么就说明该方法时重写父类的方法。
 */
@Override
public void method(){
    System.out.println("method子类");
}
```

### 6.注意事项

```java
方法重写注意事项:
    1.方法重写时，参数列表必须相同
    2.子类方法的权限必须要大于等于父类方法的权限。
        权限修饰符从大到小：public>protected>默认>private
    3.私有方法不能重写
    
    方法重写时,方法名,参数列表,修饰符,返回值一般都一样
        
        
        Ctrl  + o //生成重写方法
```

### 7.应用场景

重写的应用场景：父类的方法不能满足子类的需求，那么就可以在子类中对父类的方法进行重写。

```java
public class Demo01Test {
    public static void main(String[] args) {
        // 创建对象
        NewPhone newPhone = new NewPhone();
        // v调用方法
        newPhone.call();
        newPhone.sendMessage();

        newPhone.show();
    }
}
// 父类
public class Phone {
    public void call(){
        System.out.println("打电话");
    }
    public void sendMessage(){
        System.out.println("发短信");
    }
    public void show(){
        System.out.println("号码来电显示");
    }
}
// 子类
public class NewPhone extends Phone{
    // 来电显示功能更新
	// Ctrl + o 快捷键生成
    @Override
    public void show() {
        System.out.println("号码+姓名+归属地");
        super.show();//调用父类的show方法
    }
```

### 8.super关键字[重点]

子类可以通过super调用父类的方法

子父类中出现了同名的成员变量时，在子类中需要访问父类中非私有成员变量时，可以使用 super 关键字，类似 于之前学过的 this 。
需要注意的是：super代表的是父类对象的引用，this代表的是当前对象的引用。

```java
super的三种用途
    1.可以访问父类的成员变量
    super.变量名
    2.可以访问父类的成员方法
    super.方法名();
    3.可以调用父类的构造方法
    super(参数);
this的三种用途
    1.可以访问本类的成员变量
    this.变量名
    2.可以访问本类的成员方法
    this.方法名()
    3.可以访问本类的构造方法
    this(参数);//必须放在第一行

注意：this如果调用构造方法，只能放到第一行
如果某个构造方法的第一行写了this,系统也不会帮我们提供默认的super
```

### 9.继承关系中构造方法的特点[重点]

1.构造方法不能继承
2.创建子类对象时,先执行父类的构造方法,然后执行子类的构造方法.原因是因为在子类的构造方法第一行，有一个隐藏的super(),这个super()是在调用父类的构造方法
3.我们也可使super手动调用父类的构造方法
    super(参数);
4.如果使用super调用构造方法,一定要放在第一行

### 10.继承的特点[重点]

1. 类与类之间只能单继承。一个类只能有一个父类

   ```java
   public class A{}
   public class B{}
   public class C extends A,B{}//错误
   ```

   

2. Java中,类与类可以多级(层)继承,父类也可以有父类.所有类都继承Object(祖类)

   ````java
   public class A{}
   public class B extends A{}
   public class C extends B{}
   ````

3. 一个类可以有很多子类.

   ```java
   public class A{}
   public class B extends A{}
   public class C extends A{}
   ```

   

## 第三章 抽象类

### 1.概述

我们把没有方法体的方法称为抽象方法。Java语法规定，包含抽象 方法的类就是抽象类。
抽象方法 ： 没有方法体的方法。
抽象类：包含抽象方法的类。

abstract是抽象的意思，用于修饰方法方法和类，修饰的方法是抽象方法，修饰的类是抽象类。

### 2.格式

```java
抽象方法:
    使用abstract修饰,没有方法体
格式:
    public abstract 返回值 方法名(参数列表);
抽象类:
    抽象方法所在的类,必须是抽象类
抽象类的格式
    public abstract class 类名{}
```

### 3.抽象类的使用

```java
抽象类的使用:
   1.抽象类不能创建对象
   2.抽象类为了给子类使用,定义一个子类去继承抽象类
   3.在子类中需要重写抽象类中的所有的抽象方法。
   4.创建子类对象，通过子类对象调用方法。
```

### 4.抽象类注意事项

```java
抽象类注意事项:
    1.抽象类不能创建对象
    2.抽象类也可以有构造方法,抽象类的构造方法是给子类去用的
    3.抽象类中可以有抽象方法,也可以有非抽象方法
      抽象方法所在的类,必须是抽象类
    4.一个普通分类继承抽象类时,必须重写抽象方法
      一个抽象类在继承抽象类时,可以不重写抽象方法
    5.抽象类的目的是给子类继承,规范子类的行为.抽象类可以体现模板思想.
```

### 5.模板模式

```java
模板方法模式:
    将固定 的流程定义在父类中,不同的地方使用抽象类,让子类去重写
```



## 第四章 final关键字

```java
final关键字
final可以看成最终的，可以修饰类，修饰方法，修饰变量。
如果final修饰类，这个类不能被继承，但是可以继承其他类
如果final修饰方法，这个方法不能被重写,但可以被子类继承使用
如果final修饰变量，这个变量的值不可改变，从效果上看，它其实就是一个常量。 
    如果final修饰局部变量,变量的值只能赋值一次,一旦赋值,不可改变
    final修饰成员变量,变量的值只能赋值一次,一旦赋值不能改变.
    final修饰的成员变量，必须在创建对象之前完成赋值（可以直接赋值，也可以构造方法中赋值）
    
final修饰变量后,改变量就是常量了,常量命名规范  全部大写,单词用_隔开
```



## 总结

```java
一. 匿名对象
	概念：如果我们创建对象时没有用变量接受对象的地址，那么它就是一个匿名对象。
	格式：
		new 数据类型();
	好处：
		稍微简化我们的写法
		
	使用场景：
		1. 如果某个对象只用一次，可以使用匿名对象。
		2. 可以使用匿名对象当做方法参数传递。
		
	
二. 继承
	概念：Java中继承描述的是事物之间的所属关系。比如人属于动物，可以让人继承动物。老师属于员工，就可以让老师继承员工。
	好处：提高代码的复用性。 子类继承父类会自动拥有父类所有的成员。
	特点：类与类之间只能单继承， Java支持多级继承，一个父类可以多个子类。
	方法的重写：
		如果子类中出现了和父类一样的方法，那么这个就是方法的重写。
		使用场景：如果父类的方法不能满足子类的需求，可以在子类中进行重写。
	
	继承中构造方法的特点：
		1. 构造方法不能继承。
		2. 创建子类对象时，会先执行父类的构造方法，因为在子类构造方法的第一行有一个隐藏的super‘
		3. 我们也可以使用super手动调用父类的构造方法。
		4. 如果super调用父类的构造方法，只能写在第一行。
		
	super关键字：
		可以访问父类的成员方法	
			super.方法名()
			
		可以访问父类的成员变量
			super.变量名
		
		可以访问父类的构造方法
			super()
			
	this关键字：
		可以访问本类的成员方法	
			this.方法名()
			
		可以访问本类的成员变量
			this.变量名
		
		可以访问本类的构造方法
			this()

抽象类
	当某个方法的方法体我们说不清，不知道怎么写时，可以把这个方法定义成抽象方法，抽象方法所在的类必须是抽象类。
	
	抽象类格式：
		public abstract class 类名 {}
		
	抽象方法格式：
		public abstract 返回值类型 方法名(参数列表);
		
	抽象类的使用：
		1. 抽象类是给子类用的，我们要定义一个类，去继承抽象类。
		2. 重写抽象类中的所有的抽象方法。
		3. 创建这个子类对象，调用方法。
		
	抽象类的注意事项：
		1. 抽象类不能创建对象
		2. 抽象类中也可以有构造方法，构造方法是给子类使用的。
		3. 抽象类中可以有抽象方法，也可以有非抽象的内容。
		   抽象方法所在的类必须是一个抽象类。
		4. 一个普通类在继承抽象类时，需要重写里面所有的抽象方法。
           一个抽象类在继承抽象类时，可以不重写里面的抽象方法。
		5. 抽象类都是作为父类存在，抽象类体现的是模板思想【司机开车案例】

final关键字
	final表示最终的不可改变的。
	
	如果final修饰类，这个类不能被继承，但是可以继承其他类。
	如果fianl修饰方法，这个方法不能被重写，但是可以被子类继承使用。
	如果final修饰变量，该变量就变成了常量。只能被赋值一次，一旦赋值就不能更改了。
	
代码方面
	1. 要能够使用匿名对象。
	2. 要能够定义一个父类，使用一个子类去继承这个父类  
	3. 要能够定义抽象类，以及抽象方法。能够使用子类继承抽象类，以及重写抽象方法。
	4. 知道final的概念
```


<center>static、接口、多态、内部类</center>

## 今日内容

- static 
- 接口 
- 多态 
- 内部类

## 第一章 static关键字

### 1.概念

static是静态修饰符，一般修饰成员。被static修饰的成员属于类，不属于单个这个类的某个对象。static修饰的成 员被多个对象共享。static修饰的成员属于类，但是会影响每一个对象。被static修饰的成员又叫类成员，不叫对象
的成员。

### 2.修饰变量

```java
/*
所有的学生的学校属性都相同，都是传智学院，那么此时其实就没有必要给每一个学生对象都分配一个学校属性了，这样就比较浪费了。
如果某个成员变量使用static关键字修饰，那么这个成员变量就不再属于对象了，属于类，会被该类所有的对象所共享，
核static修饰的成员，可以通过对象调用，也可以通过类名直接调用【推荐类名直接调用】
格式:
    类名.成员变量
小结:
    如果某个成员变量不使用static修饰，那么这个成员变量是属于对象的，要有对象才能调用。
如果某个成员变量使用static修饰，那么这个成员变量是属于类的，可以通过类名直接调用。
 */

public class Student {
    String name;
    int age;
    // 学校[静态属于类,所有对象共享,静态的东西程序中只有一个]
    static String school;

}
```

### 3.静态方法使用

```java
/*
static修饰方法
如果一个方法使用static修饰,就不属于对象,属于该类,可以通过类名调用
静态方法和非静态方法使用：
静态方法：可以通过类名，也可以通过对象名调用。建议通过类名调用。
非静态方法：必须有对象才能调用。
如果调用本类中的静态方法，可以省略类名。
静态中的注意事项：
1.静态类中不能直接访问非静态的内容。
静态方法属于类，非静态方法属于对象，刚开始有类的时候还没有对象呢，所以不能在静态中使用非静态的内容。
2.静态方法中不能使用this 和 super关键字。

*/

public class Demo02Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.normalMethod();
        myClass.staticMethod();

        // 通过类型调用
        // MyClass.normalMethod();
        MyClass.staticMethod();
        //调用本类的静态方法
        method();
    }
    public static void method(){
        System.out.println("ddd");
    }
}
// 
public class MyClass {
    int normalNum = 10;
    static int staticNum = 20;

    public void normalMethod(){
        System.out.println("非静态方法");
        System.out.println(normalNum);
        System.out.println(staticNum);


    }
    public static void staticMethod(){
        System.out.println("静态方法");
        //System.out.println(normalNum);
        System.out.println(staticNum);
    }
}
```

### 4.使用场景

使用在工具类中

## 第二章 接口

### 1.概念

接口主要起到规范作用.

```java
接口是一个规范(给类的规范,类和接口发生关系后，类需要重写接口中所有的抽象才)
接口是一种引用数据类型


接口的定义格式:
public interface 接口名{

}
接口编译完也是.calss

接口中可以有以下内容:
在JDK7以及之前的版本
1.抽象方法
2.常量
在JDK8以及之后
3.默认方法
4.静态方法
最核心的就是抽象方法
```

### 2.接口的定义(抽象方法)

```java
/*
接口最核心的就是抽象方法
任何版本的java中,接口中都可以有抽象方法

抽象方法的定义格式：
public abstract返回值类型方法名（参数列表）;
注意：
    1.接口中的抽象方法可以省略public abstract关键字
    2.如果省略public abstract,那么抽象方法也是使用public abstract修饰


接口中抽象方法的使用:
    1. 接口不能创建对象
    2. 我们要定义一个类,让这类实现这个接口
    3.在类中重写接口中所有抽象方法
    4.创建对象,通过类的对象调用方法

类实现接口的格式:
    public class A implements I{

    }
    表示A类实现了I接口,A也叫I接口的实现类
    
注意:一个普通类实现接口,需重写所有抽象方法
    一个抽象类实现接口,可以不重写抽象方法
 */
public interface MyInterface {

    // 定义抽象方法
    public abstract void method();

    abstract void method2();

    public void method3();

    void method4();
}
//实现类
/*
让该类实现接口
 */
public class MyClass implements MyInterface {
    @Override
    public void method() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {

    }
}
```

### 3.默认方法的使用

```java
/*
jdk8中,接口中也可以有默认方法

默认方法定义
    public default 返回值类型 方法名(参数列表){
        方法体;
        return 返回值;

    }
注意:
    1.默认方法有方法体
    2.默认方法中的public关键字可以省略，如果省略public,这个方法也是用public修饰的

默认方法的使用：
1.实现类不需要强制重写接口中的默认方法，我们可以通过实现类对象直接去调用这些默认方法
2.实现类也可以重写接口中的默认方法，实现类重写默认方法时要去掉default

 */
public interface MyInterface {
    void hello();
    // 提供默认方法
    default void printWorld(){
        System.out.println("world");
    }
}
// 实现类
public class MyclassA implements MyInterface
{
    @Override
    public void hello() {
        System.out.println("nihao0");
    }
}
public class MyclassB implements MyInterface {
    @Override
    public void hello() {
        System.out.println("nihaobbbbbbbb0");
    }

    @Override
    public void printWorld() {
        System.out.println("world!!!!!!!!!!");
    }
}
//测试类
public class Test {
    public static void main(String[] args) {
        MyclassA myclassA = new MyclassA();
        myclassA.hello();
        myclassA.printWorld();
        System.out.println("===============");
        MyclassB myclassB = new MyclassB();
        myclassB.printWorld();
    }
}
```

### 4.静态方法的使用

```java
/*
在JDK8的时候，接口中也可以有静态方法啦。
静态方法的格式：
    public static返回值类型方法名（参数列表）{
        方法体；
        return返回值；
    }
注意：
    1.静态方法中的public可以省略。
    2.如果省略pubLic,那么这个方法也是用public修饰的。
接口中静态方法的使用：
    1.接口中的静态方法可以通过接口名直接调用。
    2.不能通过实现类调用


 */
public interface MyInterface {
public static void staticMethod(){
    System.out.println("接口中的静态方法");
}

}
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        // 直接接口名调用
        MyInterface.staticMethod();
    }
}

```

### 5.接口中的常量

```java
/*
接口中可以有成员变量，从效果上看，这个成员变量就是常量。
在任何版本的Java中，接口中都可以有常量。
常量的定义格式：
    public static final 数据类型 常量名 = 值;
因为使用final修饰了，所以不可以改变，我们就称为常量。

注意：
    1.接口中的常量public static final可以省略。
    2.如果省略public static final,那么常量也是用public static final修饰的。
    3.因为常量使用static修饰了，所以我们要通过接口名字直接去使用常量。
    4.接口中的常量值不能改变
    5.接口中的常量必须有默认值
    6.常量的命名规范,大写,下划线隔开

 */
public interface MyInterface {
    public static final int NUM = 10;

}
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        System.out.println(MyInterface.NUM);
    }
}
```

### 6.接口多继承

```java
类与类之间的关系是继承，一个类只能继承一个类。
类与接口之间的关系是实现，一个类可以实现多个接口。
接口与接口之间的关系是继承，一个接口可以继承多个接口
继承：extends
实现：implements
接口多继承的格式：
public interface A extends B, C {
上面代码表示A接口同时继承了B和C这两个接口。
    
// 接口ab
public interface MyInterfA {
    void abstractMethod();
    void abstractMethodA();
}
public interface MyInterfB {
    void abstractMethod();
    void abstractMethodB();
}
// 继承接口
public interface MyInterfaceChild extends MyInterfA,MyInterfB{
}
// 实现类
//实现MyInterfaceChild接口
public class MyClass implements MyInterfaceChild {
    @Override
    public void abstractMethod() {
        System.out.println("共有的方法");
    }

    @Override
    public void abstractMethodA() {
        System.out.println("重写了A");
    }

    @Override
    public void abstractMethodB() {
        System.out.println("重写lB");
    }
}
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.abstractMethodA();
        myClass.abstractMethodB();
        myClass.abstractMethod();
    }
}

```

### 7.继承后实现多接口

```java
一个类在继承父类的同时实现多个接口。
格式：
public class A extends B implements I1, I2 {
上面代码表示A类继承日类的同时，实现了11和工2这两个接口，
```

```java
// 接口
public interface MyInterfA {
    /*void abstractMethod();
    void abstractMethodA();
    default void defaultMethod(){
        System.out.println("aaa默认");
    }
*/
    void abstractMethodA();
    void abstractMethod();
    default void defaultMethod(){
        System.out.println("a中的默认方法");
    }
}
public interface MyInterfB {
    /*void abstractMethod();
    void abstractMethodB();
    default void defaultMethod(){
        System.out.println("bbb默认");
    }
*/
    void abstractMethodB();
    void abstractMethod();
    default void defaultMethod(){
        System.out.println("b中的默认方法");
    }
}
```

```java
// 父类
public class MySuperClass {
    public void superMethod(){
        System.out.println("父类方法");
    }
    public void defaultMethod(){
        System.out.println("父类的默认方法");
    }
}
```

```java
//实现MyInterfaceChild接口
public class MyClass extends MySuperClass implements MyInterfA,MyInterfB {

    @Override
    public void abstractMethodA() {
        System.out.println("MyClass重写的MyInterfacea");

    }

    @Override
    public void abstractMethod() {
        System.out.println("这他妈是重名的那个");
    }

    /*@Override
    public void defaultMethod() {
        System.out.println("这他妈是重名的默认方法");
    }*/

    @Override
    public void abstractMethodB() {
        System.out.println("MyClass重写的MyInterfaceb");
    }
}
```

```java
/*
一个类在继承父类的同时实现多个接口。
格式：
public class A extends B implements I1, I2 {
上面代码表示A类继承日类的同时，实现了11和工2这两个接口，

注意:
    如果父类中的方法与接口中的默认方法同名是可以的,执行的是父类的方法
 */
public class Demo01Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.abstractMethodA();
        myClass.abstractMethodB();
        myClass.superMethod();
        myClass.abstractMethod();
    }
}
```

### 8.缉毒犬练习

```java
/*
通过实例进行分析和代码演示抽象类和接口的用法
举例： 犬：
        行为： 吼叫； 吃饭；
      缉毒犬：
        行为： 吼叫； 吃饭；缉毒；

由于犬分为很多种类，他们吼叫和吃饭的方式不一样，在描述的时候不能具体化，也就是吼叫和吃饭的行为不能明 确。当描述行为时，行为的具体动作不能明确，这时可以将这个行为写为抽象行为，那么这个类也就是抽象类。
可是有的犬还有其他额外功能，而这个功能并不在这个事物的体系中 , 例如 : 缉毒犬。缉毒的这个功能有好多种动 物都有 , 例如 : 缉毒猪 , 缉毒鼠。我们可以将这个额外功能定义接口中 ,让缉毒犬继承犬且实现缉毒接口 , 这样缉毒
犬既具备犬科自身特点也有缉毒功能。

结论:
抽象类中定义的是事物的共性,接口中定义的额外的内容

接口和抽象类的区别

1.抽象类中定义的是共性的内容
接口中定义的是额外的内容
2.抽象类是类，一个类只能继承一个父类。
一个类可以实现多个接口
 */
public class Demo01Test {
    public static void main(String[] args) {
        JiDuDog jiDuDog = new JiDuDog();
        jiDuDog.say();
        jiDuDog.eat();
        jiDuDog.jiduMethod();
    }
}
```

```java
// 犬类
public abstract class Dog {
    public abstract void say();
    public abstract void eat();

}
```

```java
// 缉毒接口
public interface JiDuInterface {
    void jiduMethod();
}
```

```java
public class JiDuDog extends Dog implements JiDuInterface{
    @Override
    public void say() {
        System.out.println("汪汪叫");
    }

    @Override
    public void eat() {
        System.out.println("排队吃");
    }

    @Override
    public void jiduMethod() {
        System.out.println("缉毒功能");
    }
}
```

## 第三章 多态

### 1.概念

```java
多态：一种事物具备多种形态。
比如小明是一个学生，同时肯定也是一个人，所以小明同时具备学生和人的形态，这个就是多态。
多态在代码中的体现（父类变量（引用）指向子类对象）:
父类类型变量名=new子类类型();
为什么父类变量可以指向子类对象：狗肯定是动物，所以可以把狗当成动物去看待，所以把狗赋值给动物类型

注意：如果我们通过多态的方式创建对象，调用方法时，运行的是子类的方法。[创建的是谁的对象,调用的就是谁的方法]
根据多态性,可以把子类类型当成父类类型去看待
    
// 继承的多态
// 父类
    public abstract class Animal {
    // 叫的方法
    abstract void say();
}
// 子类
	public class Dog extends Animal {
    @Override
    void say() {
        System.out.println("汪汪汪");
    }
}
// 测试类
public class Demo01Duotai {
    public static void main(String[] args) {
        // 多态的方法创建对象
        Animal a = new Dog();
        // 调用方法
        a.say();

    }
}
// 接口的多态
// 定义接口
public interface Flyable {
    // 飞的功能
    abstract void fly();
}
// 实现类
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("鸟扇动翅膀飞");
    }
}
// 测试类
/*
接口多态(特殊的父类)
接口多态格式(接口类型指向实现类对象)
    接口类型 变量名 = new 实现类类型();
 */
public class Demo02Test {
    public static void main(String[] args) {
        Flyable f = new Bird();
        //调用方法
        f.fly();
    }
}

```



### 2.多态的好处

```java
多态的好处：
多态的参数如果是父类类型，那么可以传递任何子类对象。程序会更加灵活
        原因：
        根据多态性，子类类型可以当成父类类型去看待。比如狗肯定是动物，所以可以当成动物去看待。
        参数需要的是动物（父类）类型，那么我们可以传递狗（子类）对象。因为狗肯定是动物。
    // 父类
    public abstract class Animal {
    // 叫的方法
    abstract void say();
}
//子类
public class Dog extends Animal {
    @Override
    void say() {
        System.out.println("汪汪汪");
    }
}
public class Cat extends Animal {
    @Override
    void say() {
        System.out.println("m喵喵");
    }
}
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        // 调用showSay()方法
        showSay(new Cat());// 匿名对象
        showSay(new Dog());// 匿名对象
    }
    /*
    定义方法,该方法让猫叫
     */
    /*public static void showSay(Dog dog){
        dog.say();
    }*/
    /*
    定义方法,该方法让猫叫
     */
    /*public static void showSay(Cat cat){
        cat.say();
    }*/
  /*  定义方法,让任何动物叫*/
    public static void showSay(Animal animal){
        animal.say();
    }
}

```

### 3.多态的特点

```java
多态访问成员的特点
多态访问成员变量的特点【了解，不用】
编译看左边父类:如果父类中没有这个变量，编译时期，语法报错
运行也看左边父类:运行时，真正执行的是父类的变量。

多态访问成员方法的特点【重要】
编译看左边父类：如果父类中没有这个方法，编译报错。
运行看右边子类：如果程序运行，运行的是子类的方法。


多态的优缺点：
优点：让程序更加灵活。参数是父类类型，可以传递子类对象。
缺点：只能访问父类中有的东西，不能访问子类特有的内容。【多态方式使用成员，编译会看左边父类】
    
public class Fu {
    // 定义变量
    int num = 15;
    public void method(){
        System.out.println("父类的方法");
    }
}
public class Zi extends Fu{
    int num = 10;
    public void method(){
        System.out.println("子类的方法");
    }
    public void methods(){
        System.out.println("子类特的方法");
    }
}

public class Demo01Test {
    public static void main(String[] args) {
        Fu fu = new Zi();
        // 访问里面的成员变量
        System.out.println(fu.num);
        //  调用方法
        fu.method();
        //fu.methods();
    }
}
```

### 4.转型

```java
向上转型：子类可以转换成父类类型
格式：
    父类类型 变量名 = new 子类类型（）；
向下转型::父类类型转成子类类型
格式:
    子类类型 变量名 = (子类类型)父类变量;
 向下转型前必须要有向上转型

父类类型表示的对象不是目标类型，再转换的时候会报错。（如果父类类型表示的是猫，但是我们却把它向下转型成狗,就会报错)
多态的弊端就是不能调用子类特有的方法.想要调用子类特有的内容,需要进行向下转型
public abstract class Animal {
    public abstract void eat();

}
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
    // 特有行为
    public void lookDoor(){
        System.out.println("看门");
    }
}
public class Demo01Test {
    public static void main(String[] args) {
        // 多态  向上转型
        Animal a = new Dog();
        System.out.println(a);
        //Animal a = new Cat();
        /*Exception in thread "main" java.lang.ClassCastException: cn.com.mryhl.demo12_parse.Cat cannot be cast to cn.com.mryhl.demo12_parse.Dog
        at cn.com.mryhl.demo12_parse.Demo01Test.main(Demo01Test.java:24)*/
        // 调用方法
        a.eat();

        // a.lookDoor();//子类特有不能调用
        // 把Animal类型的a转成Dog
        Dog d = (Dog) a;
        System.out.println(d);
        d.eat();
        // 调用 看门方法
        d.lookDoor();
    }
}
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃宇宙魔方");
    }
    //
    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}
public class Demo02Test {
    public static void main(String[] args) {
        //Animal a = new Dog();
        Animal a = new Cat();

        a.eat();
        //判断判断a是不是Dog类型对象
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.lookDoor();
        }
        // 如果a是cat对象
        if (a instanceof Cat){
            Cat c = (Cat) a;
            c.catchMouse();
        }

        //转型
    }
}
```



## 第四章 内部类

### 1.概念

```java
如果把一个类定义在另一个类的里面,就是内部类
里面的类叫内部类,外面的类叫外部类
如果把一个类定义在另一个类的成员位置，那么这个类就是成员内部类
格式
public class 外部类{
    public class内部类{
    }
}
注意:
    1.其中内部类编译之后也会生成.class文件.名字为   外部类$内部类.class
    2.内部类可以访问外部类的成员
    3.外部类不能访问内部类的成员
```
### 2.成员内部类
```java
public class Person {
    int age = 18;
    //心脏类
    public class Heart{
        // 心房
        int heartRoom = 2;
        // 心跳
        public void jump(){
            System.out.println("心脏已正常跳到" + age + "年");
            System.out.println("心脏跳动");
        }
    }
}
public class Demo01NoName {
    public static void main(String[] args) {
        // 创建内部类对象
        Person.Heart heart = new Person().new Heart();
        System.out.println(heart.heartRoom);
        heart.jump();
    }
}
```

### 3.匿名内部类

```java
匿名内部类
匿名内部类,也是内部类,只不过这种内部类没有名字

作用:临时定义某个类的子类,在创建该子类的对象


格式:
    new 父类或接口(){
        重写方法
    };
举例:
    new Person(){
        重写方法
    };
    创建的是Person的子类对象,子类没有命名,称匿名内部类
public abstract class Animal {
    abstract void eat();
}
public class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("狗吃肉");
    }
}
public class Demo01Test {
    public static void main(String[] args) {
       /* Dog d =new Dog();
        d.eat();*/
        // 通过匿名内部类创建子类对象
        Animal a=new Animal(){


            @Override
            void eat() {
                System.out.println("吃骨头");
            }
        };
        a.eat();
        // 匿名内部类+匿名对象
        new Animal(){

            @Override
            void eat() {
                System.out.println("吃炒饼");
            }
        }.eat();
    }
}
```

### 4.接口匿名内部类

```java
// 飞的接口
public interface Flayable {
    abstract void fly();

}
/*
接口实现内部类
格式:
     new 父类或接口(){
        重写方法
    };
 */
public class Demo02Test {
    public static void main(String[] args) {
        new Flayable(){

            @Override
            public void fly() {
                System.out.println("小鸟飞");
            }
        }.fly();
    }
}
```

### 5.使用匿名内部类当参数传递

```java
public class Demo03Test {
    public static void main(String[] args) {
        // 调用showEat()
        showEat(new Dog());
        showEat(new Animal(){

            @Override
            void eat() {
                System.out.println("吃饭饭");
            }
        });

    }
    public static void showEat(Animal a){
        a.eat();
    }
}
```

### 6.内部类的潜在名称

```java
匿名内部类真正也是有名字的
名字:外部类$num//num是序号
```

## 总结

```java
一. static
	概念：
		被static修饰的东西属于类，不属于对象，可以被该类的所有对象共享。
		被static修饰的东西可以通过类名直接调用，可以通过对象调用，推荐通过类名调用。
		
		没有被static修饰的东西属于对象的，必须有对象才能调用。
		
	注意：
		1. 静态不能直接使用非静态的内容。
		2. 静态方法中不能出现this和super
		
二. 接口
	概念：接口是用来定义规范的。
	
	定义格式：
		public interface 接口名 {
			抽象方法【抽象方法】
			常量
			默认方法
			静态方法
		}
	
	抽象方法：
		格式：	
			public abstract 返回值类型 方法名(参数列表);
			
		使用：
			实现类在实现接口时，需要重写这个接口中的所有的抽象方法。除非实现类是一个抽象类。
			
	
	默认方法：
		格式：
			public default 返回值类型 方法名(参数列表) {
				方法体;
				return 返回值;
			}
		使用：	
			实现类在实现接口时，可以不重写默认方法。
			
	静态方法：
		格式：
			public static 返回值类型 方法名(参数列表) {
				方法体;
				return 返回值;
			}
		使用：
			接口中的静态方法要通过接口名字直接调用。
			
	常量：
		格式：
			public static final 数据类型 常量名 = 值;
			
		使用：
			接口中的常量要通过接口名直接调用。
			
	接口和类的关系：
		类和类之间是继承，一个类只能继承一个父类。
		类和接口是实现，一个类可以实现多个接口。
		接口和接口是继承，一个接口可以继承多个接口。
		
		继承：extends关键字
		实现：implements关键字
		
多态：
	概念：一种事物具备多种形态，比如小明是学生，肯定也是一个人。
	在代码中的体现（父类类型指向子类对象）：
		父类类型 变量名 = new 子类类型();
		在多态中，子类类型可以当成父类类型去看待。
		
	好处：
		提高代码的灵活性，方法的参数是父类类型，那么可以传递任何子类对象。
		
	多态访问方法的特点：
		编译看左边父类：如果父类没有该方法会报错。
		运行看右边子类：运行执行的是子类的方法。
		
	多态的优缺点：
		优点：让代码更灵活
		缺点：不能访问子类特有的内容。
		
	引用类型的转换
		向上转型（子类类型转成父类类型）
			父类类型 变量名 = new 子类类型();
			
		向下转型（父类类型转成子类类型）
			子类类型 变量名 = (子类类型) 父类变量;
			
			目的：为了访问子类特有的内容。
			
	instanceof关键字
		格式：	
			变量名 interfaceof 数据类型
		作用：
			判断该变量表示的对象是否是指定类型的。
		举例：
			a interfaceof Dog
			判断a表示的对象是否是Dog类型。
			
内部类
	成员内部类【了解】
	匿名内部类
		作用：临时定义某个类的子类，创建该子类的对象。
		格式：
			new 父类或接口() {
				重写的方法;
			}
			
		举例：
			new Person() {
				重写的方法
			}
			
			这个代码真正创建的是Person子类对象，只不过这个子类叫什么，我们不知道，因为他没有名字。
```


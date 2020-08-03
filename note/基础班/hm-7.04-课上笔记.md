<center>day08Javaee</center>

## 今日内容

- 方法的概念【重要】
- 无参数无返回值方法的定义和调用【重要】
- 有参数无返回值方法的定义和调用【重要】
- 有参数有返回值方法的定义和调用【重要重要重要重要重要】

## 第一章 方法

```java
/*     main是一个主方法，由JVM调用，是程序的入口
        1.public static:修饰符，目前固定写法
        2.void:返回值类型，表示方法内部的代码执行完毕，没有最终的结果，返回给调用者
        3.main:方法名称：固定写法
        4.String[]args:方法的参数
      注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        */
public class Demo01NoMethod {
    public static void main(String[] args) {
        System.out.println("游戏开始...");
        System.out.println("看到了一个怪物...血牙野猪...");
        fire();
        System.out.println("...血牙野猪被打倒...");
        System.out.println("...走啊走啊走啊走...");
        System.out.println("看到了一个怪物...黄金虎鲨...");
        fire();
        System.out.println("...黄金虎盆被打倒...");
        System.out.println("...走啊走啊走啊走...");
        System.out.println("看到了一个怪物...吞天巨狼...");
        fire();
        System.out.println("...吞天巨狼被打倒...");
        System.out.println("...走啊走啊走啊走...");
        System.out.println("游戏结束...");

    }
    //方法
    public static void fire(){
        System.out.println("开始发射5发炮弹");
        for (int i = 0; i < 5; i++) {
            System.out.println("发射第"+i+"枚炮弹");
        }
        System.out.println("5发炮弹发射完毕");
        return ;//结束方法,返回调用处

    }
}
```

### 1.概念

就是将具有独立功能的代码块组织成为一个整体，使其具有特殊功能的代码集

### 2.格式

```java
修饰符 返回值类型 方法名 （参数列表）｛ 
    
    代码... 
    return [结果数据/返回值];
｝
```

### 3.格式解释

- 修饰符： 目前固定写法 public static 。 

- 返回值类型： 

  方法的功能代码执行完毕后，产生的需要返还给方法的调用者的结果数据的具体类型
  目前方法的功能代码执行完毕后，没有结果数据返还给调用这，方法内部没有返回值，返回值类型固定写为void
  没有返回值的方法，返回值类型必须固定写为void(不能不写，也不能写成其它的）

- 方法名：为我们定义的方法起名，满足标识符的规范，用来调用方法。

-  参数列表： 目前无参数， 带有参数的方法在后面的课程讲解。

- 方法体:完成特殊功能的一条或多条语句.

- return：方法结束。因为返回值类型是void，方法大括号内的return可以不写。

### 4.练习

```java
/*无返回值无参数方法的定义和调用
        1.无返回值
        方法的功能代码执行完毕后，没有具体的结果数据返还给方法的调用者/处，
        此时方法内部只能写return;而且返回值类型必须固定写为void
        2.无参数
        方法没有参数，不需要写参数列表，但是必须保留()
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        定义方法method,方法内部输出一句话”我是一个方法”*/
public class Demo01PrintMethod {
    public static void main(String[] args) {					System.out.println("main...........start....");
        method();
        System.out.println("main..............end....");
    }
    public static void method(){
        System.out.println("我是一个方法");
    }
}
//定义一个方法，打印该方法内部的两个数据（方法内部定义的变量）的最大值
       
public class Demo02PrintMax {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        printMax();
        System.out.println("main..............end....");
    }
    public static void printMax(){
        int a=10,b=20;
        int max = a>b?a:b;
        System.out.println("最大值是:"+max);
        return;
    }
}
 //定义一个方法，打印输出该方法内部的数据（方法内部定义的变量）是否是偶数
   
public class Demo03PrintOu {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        printOu();
        System.out.println("main..............end....");
    }
    public static void printOu(){
        int num = 25;
        boolean result =num%2==0?true:false;
        System.out.println("这个数是偶数是:"+result);
        return;
    }
}
```

## 第二章 方法详解

### 1.格式注意

(1)如果方法没有参数，不需要写参数列表，但是必须保留()
(2)方法内部没有结果数据返回，返回值类型必须写为void
(3)返回值类型为void的方法内部只能写return;建议省略

### 2.返回值类型：

你调用我的方法时，方法内部功能代码执行完毕后，会给你（调用者）一个什么样子的数据

方法的功能代码执行完毕后，产生的需要返还给方法的调用者的结果数据的具体类型
举例：告诉调用这方法结束后，返回的结果数据是什么类型的？
比如方法内部写return100;返回值类型写为int
比如方法内部写return6.6;返回值类型写为double
比如方法内部写 return true;返回值类型写为boolean

### 3.参数列表

本质：就是定义一个/多个变量
方法参数列表举例：
()
调用方法（)
(int a)
调用方法（100)
(int a,int b)
调用方法（100,200)
(int a,double b,boolean c)调用方法（100,6.6,true)

### 4.三要素

(1)方法名称
(2)参数列表
(3)返回值类型

```java
public class Demo01PrintMax {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        printMax(20,60);
        System.out.println("main..............end....");
    }
    /*你调用我的方法printou时，必须给我传递两个int数据，
    就方法内部功能代码执行完毕后，没有结果数据返回给你，内部会直接打印结果数据*/
    public static void printMax(int a,int b){

        int max = a>b?a:b;
        System.out.println("最大值是:"+max);
        return;
    }
}



/*无返回值有参数方法的定义和调用
        1.无返回值
        经验分享：
        如果在题目需求中能够明确看到打印/输出/遍历二字，说明方法不需要返回结果数据，直接打印结果即可
        方法内部不需要返回值，返回值类型必须写为void
        2.有参数
        经验分享：如果题目需求中有不确定的东西，就需要定义参数列表
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        定义一个方法，该方法接收一个int参数，方法内部打印输出该数据是否是偶数
        */
public class Demo02PrintOu {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        printOu(56);
        System.out.println("main..............end....");
    }
    public static void printOu(int num){

        boolean result =num%2==0?true:false;
        System.out.println("这个数是偶数是:"+result);
        return;
    }
}


/*有返回信有数的方法练习-获取最大值
        1.返回值
        经验分享：
        如果在题目需求中能够明确看到获取/返回/判断二字，说明方法内部需要返回结果数据，就必须定义返回值类型
        2.有参数
        经验分享：如果题目需求中有不确定的东西，就需要定义参数列表
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        设计一个方法可以获取两个int数的较大值，数据来自于参数*/
public class Demo01GetMax {
    public static void main(String[] args) {
        int m = 100, n = 200;
        System.out.println(getMax(20,63));
        System.out.println(getMax(m,n));
    }
    /*
    你调用我的方法getMax时，必须给我传递两个int数据，
我方法内部功能代码执行完毕后，会返还给你一个int类型的结果数据
你：代表方法的调用者
我：方法本身
    */
    public static int getMax(int a,int b){
        int max = a>b?a:b;
        return  max;
    }
}

/*有返回值有参数方法的定义和调用
        1.返回值
        经验分享：
        如果在题目需求中能够明确看到打印/输出/遍历二字，说明方法不需要返回结果数据，直接打印结果即可
        方法内部不需要返回值，返回值类型必须写为void
        2.有参数
        经验分享：如果题目需求中有不确定的东西，就需要定义参数列表
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        定义一个方法，该方法接收一个int参数，判断该数据是否是偶数，并返回真假值
        */
public class Demo02GettOu {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        boolean result=printOu(56);
        System.out.println("这个数是偶数是:"+result);
        System.out.println("main..............end....");
    }
    //一个方法，该方法接收一个int参数，判断该数据是否是偶数，并返回真假值
    /*
    你调用我的方法getou时，必须给我传递一个int数据，
我方法内部功能代码执行完毕后，会返还给你一个boolean类型的结果数据
你：I代表方法的调用者
我：方法本身
    */
    public static boolean printOu(int num){

        boolean result =num%2==0?true:false;

        return result;
    }
}

```

### 5.方法的注意事项

```java
/*方法的注意事项一
        1.方法不能联套定义（在定义方法的内部又定义了其它方法）,可以调用其它方法
        2.方法可以联套调用
        3.定义方法时参数列表根据需求确定（可以有0个/1个/2个/3个...)
        4.定义方法时返回值类型根据需求确定
        如果没有返回值，返回值类型固定写为void
        4.如果方法需要参数列表，参数列表中定义的变量的类型根据需求确定
        可以是基本类型/引用类型
        5.定义方法时返回值类型根据需求确定
        如果没有返回值，返回值类型固定写为void
        6.如果分析后发现方法需要返回值类型，那么返回值类型也可以是基本类型/引用类型
        7.不管方法的返回值类型基本类型还是引用类型，返回的结果数据只能有一个，不能有多个
            如果需要返回多个数据，那么必须把多个数据放入数组/集合（就业班讲）中，返回一个数组/集合
        */
public class Demo01MethodNotice {
    public static void main(String[] args) {
        a();
        //调用方法获取int数字，保存到int变量num中
        int num = getNum();
        //调用方法传递int数字
        printNum(num);
        //2.方法可以长套调用
        printNum(getNum());
    }


    // 1.方法不能联套定义（在定义方法的内部又定义了其它方法）,可以调用其它方法
    public static void a() {
        /*错误：不能在方法内部，再定义其它方法
        public static void b(){

        }*/
        System.out.println("a...");
        c();
    }

    public static void c() {
        System.out.println("c..");
    }

    // 2.方法可以联套调用
    public static int getNum() {
        return 100;
    }

    private static void printNum(int num) {
        System.out.println(num);
    }

    //3.定义方法时参数列表根据需求确定（可以有0个/1个/2个/3个...)
    // 4.如果方法需要参数列表，参数列表中定义的变量的类型根据需求确定
    // 可以是基本类型/引用类型
    public static void d(int a, double b, int[] array, Scanner scanner) {
    }

    // 5.定义方法时返回值类型根据需求确定
    // 如果没有返回值，返回值类型固定写为void
    public static int e() {//方法值类型是基本类型
        return 100;
    }

    public static Scanner f() {//返回值类型是引用类型
        return new Scanner(System.in);
    }
    // 6.如果分析后发现方法需要返回值类型，那么返回值类型也可以是基本类型/引用类型

    // 7.不管方法的返回值类型基本类型还是引用类型，返回的结果数据只能有一个，不能有多个
    // 如果需要返回多个数据，那么必须把多个数据放入数组/集合（就业班讲）中，返回一个数组/集合
    public static int[] g() {//返回值类型是基本类型
        return new int[]{100, 200, 300};
    }
}
```

```java
/*方法的注意事项二
1.返回值类型，必须要和return语句返回的数据的类型要匹配，否则编译失败。
2.不能在return后面写代码，return意味着方法结束，所有后面的代码永远不会执行，属于无效代码。
3.void表示无返回值，可以省略return,也可以单独的书写return,后面不加数据return;

        */
public class Demo02MethodNotice {
    public static void main(String[] args) {

    }

// 1.返回值类型，必须要和return语句返回的数据的类型要匹配，否则编译失败。
    public static int a(){
        return 1000;//返回值类型:int
        // return 6.6;//返回值类型：double
    }
// 2.不能在return后面写代码，return意味着方法结束，所有后面的代码永远不会执行，属于无效代码。
public static int getMax(int a,int b){
   if(a>b)
       return a;
   else 
       return b;
    //System.out.println("getMax....end");
}
// 3.void表示无返回值，可以省略return ;,也可以单独的书写return ;,后面不加数据return;


}
```

### 6.有返回值的方法调用方式

```java
/*有返回值的方法调用方式
1.赋值调用：把调用有返回信的方法的返回结果保存到变量中
    数据类型变量名称=方法名称（参数列表...);
2.打印/输出调用：把调用有返回值的方法的返回结果直接交给输出语句，进行打印输出
    stem.out.println(方法名称（参数列表...);
3.直接/单独/独立调用   码是没有错误的，但是丢失了结果数据
    方法名称（参数列表...);
*/
public class Demo03Methodinvoke {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //调用方法，传递常量
        int result = getSum(10,20);

        System.out.println("和："+result);
        // 打印/输出调用
        System.out.println("和："+getSum(10,20));

        //3.单独调用(直接调用)
        getSum(10,20);
        System.out.println("main...end...");
    }
    //定义方法，获取两个int数据之和
    public static int getSum(int a, int b){
        int sum=a+b;
        return sum;}
}
```
### 7.有返回值的方法调用方式

```java
/*无返回值的方法调用方式

1.直接/单独/独立调用
没有返回值方法，只能采用直接调用，另外两种调用方式都是错误的
    方法名称（参数列表...);

2.赋值调用：把调用有返回信的方法的返回结果保存到变量中【错误】
    数据类型变量名称=方法名称（参数列表...);
3.打印/输出调用：把调用有返回值的方法的返回结果直接交给输出语句，进行打印输出【错误】
    stem.out.println(方法名称（参数列表...);
*/
public class Demo04Methodinvoke {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //调用方法，传递常量
        // int result = printSum(10,20);
        //
        // System.out.println("和："+result);
        // // 打印/输出调用
        // System.out.println("和："+printSum(10,20));

        //1.单独调用(直接调用)
        printSum(10, 20);
        System.out.println("main...end...");
    }

    //定义方法，获取两个int数据之和
    public static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
        return;
    }
```

### 8.形式参数和实际参数的区别

```java
/*
形式参数和实际参数的区别
注意:
实参与形参名字可以相同也可以不同
*/
public class Demo04MethodParam {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //调用方法,传递参数
        /*
        实际参数
        1.概念：在调用方法时，()中指定的常量/变量，称为实际参数
        2.特点
            (1)是在调用方法时，()中指定的常量/变量
            (2)必须是有具体的数据值的
        */
        int m = 10, n = 0;
        int result = getNum(m, n);
        System.out.println(result);

        System.out.println("main...end...");
    }

    //定义方法，获取两个int数据之和
   /* 形式参数
        1.概念：在定义方法时，()中定义的参数（变量）,叫做形式参数
        2.特点：
            (1)是在定义方法时，()中指定的
            (2)此时是没有值的，调用方法时，由方法的调用者传递具体的数据给对应的形式参数


        */
    public static int getNum(int a, int b) {//此处（)中的a和，叫做形式参数
        int sum = a + b;

        return sum;
    }
}
```

## 总结

```java
能够知道方法定义的通用格式
修饰符返回值类型方法名称（参数列表...){
方法功能代码；
return结果数据/返回值；}
能够知道形参和实参的区别
    形式参数
        1.概念：在定义方法时，()中定义的参数（变量）,叫做形式参数
        2.特点：
            (1)是在定义方法时，()中指定的
            (2)此时是没有值的，调用方法时，由方法的调用者传递具体的数据给对应的形式参数
    实际参数
        1.概念：在调用方法时，()中指定的常量/变量，称为实际参数
        2.特点
            (1)是在调用方法时，()中指定的常量/变量
            (2)必须是有具体的数据值的
    能够使用方法完成两个较大数的获取并调用方法
```


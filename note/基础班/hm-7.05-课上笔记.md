<center>day09javase基础</center>

## 今日内容

- 方法的重载【重点】
- 方法的参数传递【难点】
- 方法练习【重点】
- Debug调试【理解】

## 第一章 方法的重载【重点】

### 1.引入

```java
需求：
1.定义一个获取两个int数字之和的方法
2.定义一个获取三个int数字之和的方法
3.定义一个获取两个double数字之和的方法
4.定义一个获取三个double数字之和的方法
    /*
1.定义一个获取两个int数字之和的方法
2.定义一个获取三个int数字之和的方法
3.定义一个获取两个double数字之和的方法
4.定义一个获取三个double数字之和的方法
定义一个获取两个int数字之和的方法
三要素：
1.方法名称：getTwoIntNumSum
2.参数列表：int a,int b
3.返回值类型：int

发现问题：
以下四个方法都是完成求和功能，只是参数列表不同，然而我们却给每个方法都起了一个很长的而且非常复杂的名字，
导致程序员的学习和使用成本增加（太复杂，记不住）

*/
public class Demo01Method {
    public static void main(String[] args) {
        System.out.println(getTwoIntNum(5,6));
        System.out.println(getThreeIntNum(4,5,6));
        System.out.println(getTwoDoubleNum(3.4,5.6));
        System.out.println(getThreeDoubleNum(2.3,4.5,6.7));

    }

    public static int getTwoIntNum(int a,int b) {
        return a+b;
    }
    public static int getThreeIntNum(int a,int b,int c) {
        return a+b+c;
    }
    public static double getTwoDoubleNum(double a,double b) {
        return a+b;
    }
    public static double getThreeDoubleNum(double a,double b,double c) {
        return a+b+c;
    }
}
```





### 2.概念

在同一个类中，多个功能相同，但是参数列表不同的方法，可以使用相同的名称，这种多个同名不同参的方法，可以存在于同一个类中的现象

```java
package cn.com.mryhl01;
/*
1.定义一个获取两个int数字之和的方法
2.定义一个获取三个int数字之和的方法
3.定义一个获取两个double数字之和的方法
4.定义一个获取三个double数字之和的方法
定义一个获取两个int数字之和的方法
三要素：
1.方法名称：getTwoIntNumSum
2.参数列表：int a,int b
3.返回值类型：int

发现问题：
以下四个方法都是完成求和功能，只是参数列表不同，然而我们却给每个方法都起了一个很长的而且非常复杂的名字，
导致程序员的学习和使用成本增加（太复杂，记不住）
方法重载：
1.概念：
在同一个类中，多个功能相同，但是参数列表不同的方法，可以使用相同的名称，
这种多个同名不同参的方法，可以存在于同一个类中的现象，就叫做方法重载
举例：
比如说每个类中有个叫做method的方法，我们可以再载入（书写）,多个名称为method的方法，
但是要求这多个方法之间的参数列表互不相同
2.作用
(1)减少程序员的学习和使用成本
(2)减少了方法名称的数量
3.调用
(1)根据方法名称找到对应的方法
(2)根据参数的数量再次确定方法
(3)最后根据参数的类型确定方法（优先做类型的完全匹配 然后做自动类型提升匹配)
*/

public class Demo02MethodOverload {
    public static void main(String[] args) {
        System.out.println(getSum(5, 6));
        System.out.println(getSum(4, 5, 6));
        System.out.println(getSum(3.4, 5.6));
        System.out.println(getSum(2.3, 4.5, 6.7));

    }

    public static int getSum(int a, int b) {
        System.out.println("2int");
        return a + b;
    }

    public static int getSum(int a, int b, int c) {
        System.out.println("3int");
        return a + b + c;
    }

    public static double getSum(double a, double b) {
        System.out.println("2double");
        return a + b;
    }

    public static double getSum(double a, double b, double c) {
        System.out.println("3double");
        return a + b + c;
    }
}

```
### 3.方法重载参数列表不同有哪些情况？

```java
/*方法重载参数列表不同有哪些情况？
1.参数数量不同
2.参数类型不同
3.多个类型，顺序不同
记住：
方法重载，名称相同后，看参数列表的本质区别（不含参数名称）,和其它的任何东西无关
*/
public class Demo03OverLoadNotice {
    public static void main(String[] args) {

    }
    //该方法没有参数
    public static void method(){

    }
    //该方法有一个int参数
    public static void method(int a){

    }
    //该方法有两个int参数
    public static void method(int a,int b){

    }
    //该方法有一个double参数
    public static void method(double a){

    }
    //该方法有一个double参数一个int参数
    public static void method(double a,int b){

    }
    //该方法有一个int参数一个double参数
    public static void method(int a,double b){

    }
}

```

### 4.方法重载与哪些因素无关

```java
/*方法重载与哪些因素无关？(这些情况是无法构成重载的）
1.与参数的名称无关
2.与返回值无关
3.与修饰符无关

记住：
方法重载，名称相同后，看参数列表的本面区别（不含参数名称）,和其它的任何东西无关
*/
public class Demo04OverLoadNotice {
    public static void main(String[] args) {

    }
    //该方法有两个int参数
    public static void method(int a,int b){

    }
    /*数类型和数量都相同，只有参数名称不同，无法构成重载
    public static void method(int c,int d){

    }*/
    /*
    有返回值类型不同，然而方法重载与返回值类型是无关的，所以无法构成重载
    public static int method(int a,int b){
        return a+b;
    }*/
    /*只有修饰符不同，然而方法重载与修饰符是无关的，所以无法构成重载
    public  void method(int a,int b){

    }*/
}

```

### 5.练习

```java

/*需求：
使用方法重载的思想，设计比较两个数据是否相等的方法，兼容全整数类型（byte,short,int,long)
方法重载的思想：同一个类中，多个功能相同，参数列表不同的方法，可以使用同一个名字
实现步骤：
1.所以方法重载的思想，定义获取两个byte数据是否相同的方法compare
2.所以方法重载的思想，定义获取两个short数据是否相同的方法compare
3.所以方法重载的思想，定义获取两个int数据是否相同的方法compare
4.所以方法重载的思想，定义获取两个Long数据是否相同的方法compare
5.在main方法中分别调用以上四个方法，传递对应类型的参数，获取并打印结果
*/
public class Demo05OverLoadTest {
    public static void main(String[] args) {
    //    调用
    //     输出调用
        System.out.println(compare((byte)10,(byte)20));
        System.out.println(compare((short)10,(short)20));
        System.out.println(compare(10,20));
        System.out.println(compare(10L,20L));
        System.out.println("----------------------------");
        byte a=1,b=2;
        short c=3,d=4;
        int e=5,f=6;
        long g=7l,h=8l;
        System.out.println(compare(a,b));
        System.out.println(compare(c,d));
        System.out.println(compare(e,f));
        System.out.println(compare(g,h));
    }

    public static boolean compare(byte a, byte b) {
        System.out.println("2byte");
        if (a == b)
            return true;
        else
            return false;

    }

    public static boolean compare(short a, short b) {
        System.out.println("2shory");
        if (a == b)
            return true;
        else
            return false;

    }

    public static boolean compare(int a, int b) {
        System.out.println("2int");
        if (a == b)
            return true;
        else
            return false;

    }

    public static boolean compare(long a, long b) {
        System.out.println("2long");
        if (a == b)
            return true;
        else
            return false;

    }
}

```



## 第二章 方法的参数传递【难点】

### 1.概念

参数传递：
	可以理解当我们要调用一个方法时，我们会把指定的数值，传递给方法中的参数（定义方法时（)中定义的变量）,这样方法中的参数就拥有了这个指定的值，可以使用该值，在方法中运算了。这种传递方式，我们称为参数传递。
	形式参数：定义方法时，()中定义的参数（1个/多个变量）,叫做形式参数定义时是没有值的
	实际参数：调用方法时，()中指定的数据（常量/变量）,叫做实际参数使用时必须是有值的

```java
package cn.com.mryhl02;
/*
1.基本类型变量a的值，赋值给基本类型变量b,其实是把变量a的值复制一份给变量b,
之后不管如何修改变量b中的值，对变量a中的值是不会产生任何影响的
2.方法内部或者方法定义时（)中定义的变量，称之为局部变量，只在方法内部有效，出了所在的方法就不能使用到了
*/
public class Demo01LocalVar {
    public static void main(String[] args) {
        int a = 10;
        int b;//定义未赋值
        b = a;
        System.out.println("a="+a);
        System.out.println("b="+b);
        b*=10;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
    public static void method(){
        /*a和b是在main方法中定义的，只能在main方法中使用
        System.out.println("a="+a);
        System.out.println("b="+b);
        */
    }
}

```

### 2.基本类型作为方法参数传递的特点

```java
/*
基本类型作为方法参数传递的特点
1.基本类型变量保存的具体的数据值，进行赋值时，传递的也是具体的数据值
2.基本类型作为方法参数时，形式参数的改变，不会影响实际参数
注意：
1.方法的执行都有自己独立的栈内存空间
2.方法内部定义的变量也有独立的内存空间
3.不同的方法中可以定义同名的变量，因为所在的方法的楼内存空间不同，同名变量的内存空间也不同，
他们之间是互不干扰，互不影响
*/
public class Demo02BaseVar {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a="+a);//10
        System.out.println("b="+b);//20
        change(a,b);
        System.out.println("ea="+a);//10
        System.out.println("eb="+b);//20
    }
    public static void change(int a,int b){
        System.out.println("ch.a="+a);//10
        System.out.println("ch.b="+b);
        a*=10;
        b*=10;
        System.out.println("ech.a="+a);//10
        System.out.println("ech.b="+b);
    }
}
/*
引用类型作为方法参数传递的特点【形参的改变，不会影响实参】
注意：
1.引用类型变量，保存对象在堆内存空间的地址值
2.引用类型变量，作为方法参数传递时，传递的是地址值
3.通过形式参数找到对应的堆内存空间的内容，进行修改后，再通过实际参数，看到的是堆内存空间修改后的内容
数组：
1.数组变量也是引用类型变量，保存数组对象在堆内存空间的地址值
2.数组变量，作为方法参数传递时，传递的是地址值
3.通过形式参数数组变量找到对应的堆内存空间的数组，修改数组元素后
再通过实际参数数组变量，看到的一定是是堆内存空间的修改后的数组元素
总结：
所有引用变量，保存的都是地址值，作为方法参数/方法返回值，传递/返回的都是地址值
*/
public class Demo03RefVar {
    public static void main(String[] args) {
        int[] a =new int[]{10,20};

        System.out.println("a[0]="+a[0]);//10
        System.out.println("b="+a[1]);//20
        change(a);
        System.out.println("ea[0]="+a[0]);//10
        System.out.println("ea[1]="+a[1]);//20
    }
    public static void change(int[] a){
        System.out.println("ch.a="+a[0]);//10
        System.out.println("ch.a[1]="+a[1]);
        a[0]*=10;
        a[1]*=10;
        System.out.println("ech.a[0]="+a[0]);//10
        System.out.println("ech.a[1]="+a[1]);
    }
}

```



## 第三章 方法练习【重点】

### 1.打印练习

```java
/*需求（先不定义方法）:
完成数组的遍历（打印数组元素）,要求遍历的结果是在一行上的。
例如：[11,22,33,44,55]
举例：
原数组：(11,22,33,44,55)
打印格式：[11,22,33,44,55]
实现步骤：
1.定义int数组array,并初始化
2.打印“[”，不换行
3.使用for循环变量数组
3.1打印数组当前元素，不换行
4.打印“]”，可以换行也可以不换行
*/
public class Demo01PrintArray {
    public static void main(String[] args) {
        int[] array = {11,22,33,44,55};
        printArray(array);
    }
    public static void printArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]);
            if(i==array.length-1)
                break;
            System.out.print(",");
        }
        System.out.println("]");
    }
} 
```

### 2.数组最大值

```java
/*需求：
设计一个方法用于获取int数组中元素的最大值
举例：
原数组：(11,22,33,44,55)
最大值：55
设计一个方法用于获取int数组中元素的最大值
getArrayMax方法内部的实现步骤：
1.假设索引为0的元素是最大的，保存到int变量max中
2.使用for循环依次获取后面的（从素引1开始）每个元素
2.1如果当前元素值大于max,说明max中的元素已经不是最大的了
2.2把当前元素值，赋值给max
3.for循环结束后，返回max
*/
public class Demo03PrintMax {
    public static void main(String[] args) {
        int[] array = {11,22,33,44,55};
        System.out.println("最大值是"+getArrayMax(array));
    }
    public static int getArrayMax(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max)
                max = array[i];
        }
        return max;
    }
}
```



## 第四章 Debug调试【理解】

### 1. Debug查看求和

```java
使用步骤:
1.在代码的第一行左侧空白(行号后面)处单击鼠标左键,添加断点
2.右键选择"debug...",进入断点调试界面

public class Demo01DeBugSum {
    public static void main(String[] args) {

        System.out.println("main...start....");
        int a = 10;
        int b = 20;

        int sum = a + b;

        System.out.println("sum="+sum);

        System.out.println("main...end....");
    }
}

```



### 2 .Debug查看求和方法

```java
public class Demo02DeBug {
    public static void main(String[] args) {

        System.out.println("main...start...");

        method();

        System.out.println("main...end...");
    }

    public static void method() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        return ;
    }
}

```

## 总结

```java
能够知道方法重载的特点
	1.概念: 在同一个类中,多个名称相同参数列表不同的方法,可以共同存在
	2.特点:
		(1)方法参数不同有哪些情况?
            a.数量不同
            b.类型不同
            c.多个类型顺序不同
        (2)与哪些因素无关?
            a.与方法名称无关
            b.与返回值类型无关
            c.与修饰符无关
能够使用方法重载完成比较两个整数是否相同并调用方

	public static boolean compare(byte a,byte b) {
		return a == b;
	}
	public static boolean compare(short a,short b) {
		return a == b;
	}
	public static boolean compare(int a,int b) {
		return a == b;
	}
	public static boolean compare(long a,long b) {
		return a == b;
	}
能够使用方法完成数组遍历并调用方法

	public static void  printArray(int[] array) {
		//...
	}
能够使用方法完成获取int数组最大值并调用方法
	public static int getArrayMax(int[] array) {
		//...
	}
能够使用断点调试查看循环求和流程
能够知道方法的参数是基本类型和引用类型的区别
	1.基本类型作为方法参数传递特点: 形参的改变不会影响实际参数
	2.引用类型作为方法参数传递特点: 形参的改变会影响实际参数
```


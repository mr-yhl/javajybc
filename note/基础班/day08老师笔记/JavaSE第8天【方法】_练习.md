## JavaSE第8天【方法】

### 8.1 【目标】掌握方法定义的参数和返回值含义

#### 题目一

下面关于方法参数的说法中，错误的是：（）

A：方法可以没有参数

B：方法可以有多个参数

C：方法产生的数据结果被称为参数

D：方法的参数可以是任意数据类型

#### 题目二

下面关于方法返回值的说法中，错误的是：（）

A：方法可以没有返回值

B：方法可以有多个返回值

C：如果方法的返回值类型不是void，则必须写return语句

D：方法的返回值可以是任意数据类型

### 8.2 【目标】掌握方法的调用过程

#### 题目一

在调用一个有参数且有返回值的方法时，过程中步骤的正确排序是：（）

A：执行方法体 、传递参数、将返回值还给调用处

B：传递参数、将返回值还给调用处、执行方法体

C：执行方法体、将返回值还给调用处、传递参数

D：传递参数、执行方法体、将返回值还给调用处

#### 题目二

有以下代码：

```java
public class Demo {
  public static void main(String[] args) {
    System.out.println(10);
    System.out.println(methodA(20));
    System.out.println(15);
  }

  public static int methodA(int num) {
    num++;
    return num;
  }

}
```

程序的执行结果为：（）

A：10、20、15

B：10、15、20

C：10、21、15

D：21、10、15

### 8.3 【目标】掌握方法的三种调用格式

#### 题目一

常用的三种方法调用格式中，不包含：（）

A：单独调用，例如：`method(10);`

B：打印调用，例如：`System.out.println(method(20));`

C：赋值调用，例如：`int result = method(30);`

D：名称调用，例如：`method;`

#### 题目二

对于一个没有返回值、没有参数的方法method来说，下面方法调用的代码中正确的是：（）

A：`method();`

B：`System.out.println(method());`

C：`int result = method();`

D：`void result = method();`

### 8.4 【目标】能够判断出方法的重载

#### 题目一

下面正确构成方法重载的代码是：（）

A：

```java
public static void method1() {}
public static void method2() {}
```

B：

```java
public static void method(int num) {}
public static void method(double num) {}
```

C：

```java
public static int method() {}
public static double method() {}
```

D：

```java
public static int method(int a, int b) {}
public static int method(int x, int y) {}
```

#### 题目二

在构成方法重载的相关因素中，不包含：（）

A：方法的名称

B：参数的个数

C：方法的返回值类型

D：参数的类型
<center>day06javase基础</center>

## 今日内容

- 跳出语句break,continue【重点】
- 循环嵌套
- 随机数字【重点】
- 猜数字案例【重点】

## 第一章 循环跳转

### 1. break语句

**作用**：

1.可以使用在switch语句中，用来结束switch语句
2.可以使用在循环中，用来结束循环
	(1)本次循环的循环体不再执行
	(2)剩余的所有次数的循环也不再执行
	(3)相当于从执行break的位置，跳转到循环后面的其它代码执行

3.只能用在循环及switch语句中

**代码**

```java
public static void main(String[] args) {
        for (int i = 1; i <= 4 ; i++) {
            /*当的值是2时，if后面（)中是true,执行if后面（}中的代码
        首先：执行输出语句打印一句话
        其次：执行break,一旦执行break,本次循环的循环体中break后面的代码将不再执行，而且剩余次数的循环也不再执行，
        也就是说会直接结束for循环，执行for循环后面的其它代码
        相当于执行break时，代码从break的位置跳转到了for循环后面的其它代码继续执行*/
            if (i==2){
                System.out.println("第二个包子上有个蟑螂");
                break;
            }
            System.out.println("正在吃包子"+i);
        }
        System.out.println("赔偿了");
    }
```

### 2.continue语句

**作用**

1.只能使用在循环当中
2.不能使用在除循环以外的其它任何位置
3.提前结束本次循环，继续进行下一次循环
	(1)本次循环continue后面的代码不再执行
	(2)继续执行下次循环的步进表达式
4.注意：
	(1)break影响的是整个循环，结束整个循环
	(2)continue只影响本次循环，剩余次数的循环不受影响

**代码**

```java
public static void main(String[] args) {
        for (int i = 1; i <= 4 ; i++) {
            /*当的值是2时，if后面（)中是true,执行if后面（}中的代码
        首先：执行输出语句打印一句话
        其次：执行continue,一旦执行continue,本次循环的循环体中continue后面的代码将不再执行，继续进行下次循环的步进表达式，

        相当于执行continue时，代码从continue的位置跳转到了for循环下次循环继续执行*/
            if (i==2){
                System.out.println("第二个包子上掉地上了,不能吃了");
                continue;
            }
            System.out.println("正在吃包子"+i);
        }
        System.out.println("结账");
    }
```

## 第二章 循环拓展

### 1. 循环嵌套

```java
1.概念：使用一个循环作为另外一个循环的循环体，内部的循环称为内层循环，外部的循环称为外层循环
2.格式（for嵌套）:
for(外初始化表达式1;外布尔表达式2;外步进表达式7){
	for(内初始化表达式3;内布尔表达式4;内步进表达式6){
	内循环体5;
	}
}
其它语句8

```

### 2. 练习

```java
//使用嵌套循环，打印2021年至2023年月份，格式：xxxx年x月
public class Demo02PrintMonth {
    public static void main(String[] args) {
        for (int i = 2021; i <= 2023; i++) {
            for (int j = 1; j <= 12 ; j++) {
                System.out.println(i+"年"+j+"月");
            }

        }
    }
}
---------------------------------------------
/*模拟钟表的时针和分针
        时针（外层循环）走一个格，分钟（内层循环）走一圈
        对应：
        外层循环执行一次，内层循环执行完整的一遍*/
public class Demo03PrintClock {
    public static void main(String[] args) {
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                System.out.println(i+"时"+j+"分");
            }

        }
    }
}    
```

## 第三章 随机数

### 1 Random产生随机数（掌握）

```java
	1.概念：java.util.Random类，就是jdk中已经定义好的用来产生随机数字的
    2.随机数Random类的使用步骤：
java中的引用类型的使用有3个固定的步骤，而Random类也属于引用类型，所以也有3个固定的步骤：
	(1)导包（找到我们要使用的类）
		格式：import包名.类名；
		注意：
        	a.如果当前类和要使用的类在同一个包中，不需要导包
			b.java.lang包中的内容不用导包
			C.导包的快捷键：alt+回车
      	键盘录入Scanner类的导包：import java.util.Scariner;
		随机数字Random类的导包：import java.util.Random;
	(2)创建对象
		格式：类名对象名=new类名（参数...);
		类名：class关键字后面的名字
		对象名：就是一个标识符，只要符合表示符的命名规范就可以
	创建键盘录入Scanner类的对象：
	Scanner sc = new Scanner ( System . in ) ;
注意：()中的System.in目前是固定写法，后面会讲
	创建随机数Random类的对象：
	Random r=new Random();
注意：()中什么都不用写，目前是固定格式，后面会讲
   
	(3)使用：
		r.nextInt():产生一个整数范围（正负21亿）内的随机整数数字
		r.nextInt(整数数字/int类型变量n):产生一个0到n之间的随机整数数字，但是包含0,不包含n
    举例：
r.nextInt(10):产生一个0到10之间的随机整数数字，但是包含0,不包含10[0,10)==>[0,9]
r.nextInt(100):产生一个0到100之间的随机整数数字，但是包含0,不包含100[0,100)==>[0,99]
```

**练习**

```java
import java.util.Random;
/*
Random类的练习
        (1)产生10个int范围内的整数数字
        (2)产生10个0到100之间（包含0,但是不包含100)的整数数字
*/
public class Demo01Random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("产生10个int范围内的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt();
            System.out.println(num);
        }
        System.out.println("产生10个0到100之间（包含0,但是不包含100)的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(100);
            System.out.println(num);
        }
        //证明0的存在
        while (true){
            int num = r.nextInt(100);
            System.out.println(num);
            if(num==0)break;
        }
    }
}
-------------------------------------------
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("产生10个1到5之间（包含1,包含5)的整数数字");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(5)+1;
            System.out.println(num);
        }
        
    }
```

##  总结

```java
能够知道循环嵌套的执行流程
	外层循环第1次: 
		i: 1 i<=2 --> 1<=2 --> true 执行外层循环的循环体(内层循环)
            内层循环:
				j: 1,2,3,4 j<=4 --> true 执行内层循环的循环体,输出"Hello"
                j: 5 j<=4 --> false 结束内层for循环,执行外层循环步进表达式i++,i的值变成2
    外层循环第2次:
		i: 2 i<=2 --> 2<=2 --> true 执行外层循环的循环体(内层循环)
            内层循环:
				j: 1,2,3,4 j<=4 --> true 执行内层循环的循环体,输出"Hello"
                j: 5 j<=4 --> false 结束内层for循环,执行外层循环步进表达式i++,i的值变成3
    
    外层循环第3次:
		i: 3 i<=2 --> 3<=2 --> false 不再执行外层循环的循环体(内层循环),直接结束外层循环,执行
        外层for循环后面的其它语句 
	for(int i = 1;i<=2;i++) {
		for(int j = 1;j<=4;j++) {
			sout("Hello");
		}
	}
	其它语句;

能够知道break和continue的作用
	1.break的作用:
		(1)用在switch语句中,用来结束switch语句
		(2)用在循环中,用来结束整个循环,相当于从break的位置跳转到循环后面的其它代码执行
	2.continue的作用:
		(1)只能用在循环中
		(2)提前结束本次循环,继续进行下一次循环(步进表达式)
            一旦执行continue,本次循环的循环体中continue后面的代码将不再执行,
			直接执行下次循环的步进表达式
			
能够完成猜数字小游戏程序	
    
```




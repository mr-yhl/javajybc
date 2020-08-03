<center>线程安全、volatile关键字、原子性、并发包</center>

## 今日内容

+ 高并发
+ 线程安全
  + 可见性
  + 有序性
  + 原子性
+ volatile关键字
  + 解决可见性
  + 解决有序性
+ 原子类
  + CAS[乐观锁]
+ synchronized
  + 同步代码块[悲观锁]
  + 同步方法
+ 并发包
  + CopyOnWriteArrayList
  + CopyOnWriteArraySet
  + Hashtable
  + CountDownLatch
  + CyclicBarrier
  + Semaphore
  + Exchanger



## 第一章  高并发线程安全

### 1.概念

`高并发`是指在某个时间点上，有大量的用户(线程)同时访问同一资源。例如：天猫的双11购物节、12306的 在线购票在某个时间点上，都会面临大量用户同时抢购同一件商品/车票的情况。

`线程安全`：在某个时间点上，当大量用户(线程)访问同一资源时，由于多线程运行机制的原因，可能会导致被 访问的资源出现"数据污染"的问题。

### 2.多线程的运行机制

当一个线程启动后，**JVM**会为其分配一个独立的"线程栈区"，这个线程会在这个独立的栈区中运行。

找内存是线程私有的，每一个线程都有一个自己的找空间，用来运行自己的方法。

方法是通过哪个线程调用的，那么该方法就在哪个线程的栈空间中运行。

+ 线程类

```java
public class MyTheard extends Thread  {
    @Override
    public void run() {
        // 百次输出
        for (int i = 0; i < 100; i++) {
            System.out.println("helloworld" + i);
        }
    }
}
```

+ 测试类

```java
public class Demo01Test {
    public static void main(String[] args) {
        // 创建MyThread对象
        MyTheard myTheard = new MyTheard();
        myTheard.start();
        // 百次输出
        for (int i = 0; i < 100; i++) {
            System.out.println("helloJava" + i);
        }
    }
}
```

![](https://p.pstatp.com/origin/1383d00002891a40618b1)

### 3.多线程的安全性问题

**Java内存模型**
Java内存模型是线程对于共享数据的一个访问规则。
`主内存`：线程共享的数据会保存到主内存中
`线程的工作内存`：保存的是数据的副本，当线程要操作共享数据时，会先把主内存中的数据读取到自己的工作内存中，然后再进行操作。
线程无法直接操作主内存中的数据，如果线程要操作主内存中的数据，会先把主内存中的数据复制一份放到自己的工作内存中，然后在自己的工作内存中进行操作，操作完之后会再把工作内存中的数据放回到主内存中。
各个线程的工作内存，是相互不可见的。

#### 3.1可见性

+ 线程类

```java
public class MyTheard extends Thread{
    // 成员位置定义变量
    boolean flag = false;
    @Override
    public void run() {
        try {
            // 让程序休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 将flag改成true
        flag = true;
        System.out.println("flag已经改为" + flag);
    }
}
// 结果
// flag已经改为true
```

+ 测试类

```java
/*
演示线程可见性
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建线程对象
        MyTheard myTheard = new MyTheard();
        // 启动线程
        myTheard.start();
        // 在main线程中用死循环进行判断，如果线程对象中的flag变成了true,就输出一句
        while (true)
             // 解决办法加条输出语句可以输出本段语句
            if (myTheard.flag)
            System.out.println("线程执行了");
    }
}
```

![](https://p.pstatp.com/origin/fe47000284358f133120)



#### 3.2有序性

有些时候“编译器”在编译代码时，会对代码进行“重排”，例如： 

int a = 10; //1 

int b = 20; //2 

int c = a + b; //3
第一行和第二行可能会被“重排”：可能先编译第二行，再编译第一行，总之在执行第三行之前，会将1,2编译完毕。1和2先编译谁，不影响第三行的结果。

但在“多线程”情况下，代码重排，可能会对另一个线程访问的结果产生影响：多线程环境下，我们通常不希望对一些代码进行重排的！！

![](https://p.pstatp.com/origin/ff730000ef06cf05bc0b)

#### 3.3原子性

+ runnable的实现类

```java
public class Task implements Runnable {
    int conut = 0;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            conut++;
            System.out.println("count = " + conut);
        }
    }
}
```

+ 测试类

```java
/*
    原子性问题
 */
public class Demo01Tesk {
    public static void main(String[] args) {
        // 创建task对象
        Task task = new Task();
        // 让上三个线程执行线程对象
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
```

count++
count++不具备原子性，
count++里面有很多操作，这些操作有可能被插队执行的。
如果某个线程要对共享数据count执行++操作，步骤如下
	1.该线程会将主内存中的数据复制到自己的工作内存中。
	2.然后将该数据在自己的工作内存中修改（加1)
	3.将修改后的数据保存到主内存中
++不具备原子性，上面的3个操作不是一个整体，有可能会被其他线程插队执行。

![](https://p.pstatp.com/origin/ff060002f678c13b66c1)



## 第二章 volatile关键字

### 1.概念

1. **volatile**是一个"变量修饰符"，它只能修饰"成员变量"，它能强制线程每次从主内存获取值，并能保证此变量不 会被编译器优化。 

2. **volatile**能解决变量的可见性、有序性；
3. **volatile**不能解决变量的原子性

### 2.解决可见性问题

**volatile**可以保证多线程中的可见性的问题
**volatile**修饰的成员变量，该变量每次修改后，对于其他变量是可见的。
**volatile**修饰的成员变量，每次线程在操作时，都会从主内存中读取数据。

```java
public class MyTheard extends Thread{
    // 成员位置定义变量
    volatile boolean flag = false;
    @Override
    public void run() {
        try {
            // 让程序休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 将flag改成true
        flag = true;
        System.out.println("flag已经改为" + flag);
    }
}
```

```java
/*
演示线程可见性
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建线程对象
        MyTheard myTheard = new MyTheard();
        // 启动线程
        myTheard.start();
        // 在main线程中用死循环进行判断，如果线程对象中的flag变成了true,就输出一句
         while (true){
             // flag已经使用volatile修饰了，所以每次使用该数据时，会从主内存中获取最新的数据
            if (myTheard.flag){
            System.out.println("线程执行了");
            return;
            }
         }
    }
}
/*
线程执行了
flag已经改为true
*/
```

### 3.解决有序性问题

![](https://p.pstatp.com/origin/1373d0001163ac823c3c1)

### 4.volatile关键字只能解决"变量"的可见性、有序性问题，并不能解决原子性问题



## 第三章 原子类

### 1.概述

在java.util.concurrent.atomic包下定义了一些对“变量”操作的“原子类”: 

1. java.util.concurrent.atomic.AtomicInteger：对int变量操作的“原子类”;
2. java.util.concurrent.atomic.AtomicLong：对long变量操作的“原子类”; 
3. java.util.concurrent.atomic.AtomicBoolean：对boolean变量操作的“原子类”;

它们可以保证对“变量”操作的：原子性、有序性、可见性。

### 2.原子类AtomicInteger

`AtomicInteger`是整数原子类，里面支持原子性操作

举例：AtomicInteger进行自增操作，里面的自增操作是一个整体，这个整体不会被插队执行。

AtomicInteger构造方法：
   ` AtomicInteger()`:使用空参数构造方法创建的对象表示整数
    `AtomicInteger(int initialvalue)`:根据指定的整数创速AtomicInteger对象。
AtomicInteger其他方法：
   ` int getAndIncrement()`:先获取当前值，然后自增。返回的是自增前的值。 相当于 int a = i++;
    `int incrementAndGet()`:先自增，然后获取自增后的值。返回的是自增后的值。相当于 int a = ++i;
    `int get()`: 获取 AtomicInteger对象的int数字

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Demo01_Atomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        // System.out.println(atomicInteger);// 10
        /*
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println("andIncrement"+andIncrement);// andIncrement10
        System.out.println("atomicInteger"+atomicInteger);// atomicInteger11
        */
        int incrementAndGet = atomicInteger.incrementAndGet();
        System.out.println("incrementAndGet"+incrementAndGet);// incrementAndGet11
        System.out.println("atomicInteger"+atomicInteger);// atomicInteger11

        int i = atomicInteger.get();
        System.out.println(i);// 11
    }
}
```

### 3.使用AtomicInteger解决原子性问题

+ 实现类

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
    AtomicInteger num=new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int count = num.incrementAndGet();

            System.out.println("count = " + count);
        }
    }
}
```

+ 测试类

```java
public class Demo02_Atomic {
    public static void main(String[] args) {
        // 创建task对象
        Task task = new Task();
        // 让上三个线程执行线程对象
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
```

**CAS(compare and swap):比较并交换。**
**CAS是通过记录旧的预期值的方式来保证原子性的。**
**旧的预期值：原来的值（修改前的值）**

过程：

1. 线程一先将主内存中的数据读取到自己的工作内存中，并记录旧的预期值。
2. 如果CPU的执行权被其他线程抢走了，线程二执行了，线程二将主内存中的数据读取到自己的工作内存中，并在自己的工作内存中进行修改，修改后再保存到主内存中
3. 线程一要将工作内存中的数据进行修改（自增）
4. 线程一会将工作内存中的数据保存到主内存，在保存到主内存之前，会先对比一下自己记录的日的预期值和主内存中的数据是否一致，如果旧的预期值和主内存中的一样，表示主内存中的数据没有被修改过，那么可以直接将工作内存中的数据保存到主内存，如果工作内存中的数据和主内存中的数据不一样，如果不一样，就表示主内存中的数据已经被修改过了，那么线程一会重新读取主内存中的新的数据，并记录旧的预期值，然后再自己的工作内存中修改，修改完之后再次对比旧的预明值和主内存中的数据并进行操作。

## 第四章 synchronized关键字[重点]

### 1.多行代码的原子性问题

之前的AtomicInteger类只能保证"变量"的原子性操作，而对多行代码进行"原子性"操作，使用AtomicInteger 类就不能达到效果了。

+ 实现类引入问题

```java
public class Ticket implements Runnable {
    // 定义变量，表示票数
    int count = 100;
    // 使用多线程卖票,定义卖票任务
    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
            // 判断是否有票,有就卖
            if (count > 0) {
                // 套身份证用5毫秒,线程休眠模拟
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + count + "张票.");
                count--;
            }

        }

    }
}
```

+ 测试类

```java
/*
电影院要卖票，我们模拟电影院的卖票过程。假设要播放的电影是 “葫芦娃大战奥特曼”，本次电影的座位共 100个(本场电影只能卖100张票)。
我们来模拟电影院的售票窗口，实现多个窗口同时卖 “葫芦娃大战奥特曼”这场电影票(多个窗口一起卖这100
张票)需要窗口，采用线程对象来模拟；需要票，Runnable接口子类来模拟。

使用3给线程卖100张票
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建Runnable实现类对象
        Ticket ticket = new Ticket();
        // 三个线程卖票
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();

    }
}
```

+ 运行结果（部分）

Thread-1正在卖第7张票.
Thread-2正在卖第7张票.
Thread-0正在卖第7张票.
Thread-2正在卖第4张票.
Thread-1正在卖第3张票.
Thread-0正在卖第2张票.
Thread-0正在卖第1张票.
Thread-1正在卖第0张票.
Thread-2正在卖第-1张票.

发现程序出现了两个问题： 

1. 相同的票数,比如7这张票被卖了两回。

2. 不存在的票，比如0票与-1票，是不存在的。

这种问题，几个窗口(线程)票数不同步了，这种问题称为线程不安全。线程安全问题都是由全局变量及静态变量引起的。而每个线程操作这个变量都需要很多步骤：获取变量的 值、打印变量的值、更改变量的值，而一个线程在执行某一步骤时都可能被暂停，而另一个线程会执行，这
同样会导致多个线程访问同一个变量，最终导致这个变量的值不准确。

### 2.synchronized关键字概述

1. `synchronized`关键字：表示“同步”的。它可以对“多行代码”进行“同步”——将多行代码当成是一个完整的整 体，一个线程如果进入到这个代码块中，会全部执行完毕，执行结束后，其它线程才会执行。这样可以保证 这多行的代码作为完整的整体，被一个线程完整的执行完毕。
2. `synchronized`被称为“重量级的锁”方式，也是“悲观锁”——效率比较低。
3. `synchronized`有几种使用方式： a).同步代码块 b).同步方法【常用】

当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安全问题。要解决上述多线程并发访问一个资源的安全性问题:也就是解决重复票与不存在票问题，Java中提供了同步机制(synchronized)来解决。

### 3.同步代码块

使用synchronized解决线程安全问题【多行代码原子性的问题】
synchronized表示同步，可以修饰方法，也可以修饰代码块
如果synchronized修饰代码块，就叫做同步代码块。

同步代码块格式：

```java
synchronized(锁对象){
    ...
    }
```



锁对象就是一个普通的Java对象，镜对象可以是任何类型的，可以是student,ArrayList,object..
锁对象仅仅起到一个标记作用，除此之外,没有任何含义
同步代码块的作用：
    只有持有锁的线程才能够进入到同步代码块中。
 【多行代码如果加了同步代码块，那么只有一个线程能执行了，不允许被其他线程插队执行，就保证了多行代码的原子性】

 线程同步会保证安全，但是会牺牲效率

```java
// 如果多线程同时操作共享数据，就有可能会引发线程安全问题。
public class Ticket2 implements Runnable {
    // 定义变量，表示票数
    int count = 100;
    // 创建对象,表示锁,可以是任何类型.
    // 多线程使用统一代码块,必须使用同一个锁
    Object lock = new Object();

    // 使用多线程卖票,定义卖票任务
    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
            // 判断是否有票,有就卖
            // 当线程执行到同步代码块时，会看一下同步代码块上面还有没有锁
            // 如果同步代码块上面还有锁，此时线程会获取到锁，然后进入到同步代码块中
            // 如果同步代码块上面没有锁，那么此时线程会一直在这里等着获取锁。
            synchronized (lock) {
                if (count > 0) {
                    // 套身份证用5毫秒
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + count + "张票.");
                    count--;
                }
            }
			// 如果线程离开同步代码块，线程会释放自己的锁【把锁还回去】
        }

    }
}
```

+ 测试类

```java
public class Demo02Test {
    public static void main(String[] args) {
        // 创建Runnable实现类对象
        Ticket2 ticket2 = new Ticket2();
        // 三个线程卖票
        new Thread(ticket2).start();
        new Thread(ticket2).start();
        new Thread(ticket2).start();
    }
}
```

### 4.同步方法

如果synchronized修饰方法，那么这个方法叫做同步方法，也可以解决线程安全问题
格式：
    修饰符 synchronized 返回值类型 方法名（参数列表）{
    ...
    }

同步方法其实相当于把整个方法体都加了同步代码块

同步方法也是有锁的
    如果同步方法是非静态的,同步方法的锁对象是this,this就是创建的对象
    如果同步方法是静态的,锁对象是类名.class[当前类的字节码文件对象]

```java
@SuppressWarnings("all")
public class Ticket3 implements Runnable {
    // 定义变量，表示票数
    int count = 100;
    // 创建对象,表示锁,可以是任何类型.
    // 多线程使用统一代码块,必须使用同一个锁
    Object lock = new Object();

    // 使用多线程卖票,定义卖票任务
    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
           sell2();

        }

    }
    /*
     定义一个方法,用于卖票
    如果某个方法的所有方法体都加了同步代码块，我们也可以使用不同方法。
    */
    public  void sell(){
        synchronized (lock) {
            if (count > 0) {
                // 套身份证用5毫秒
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + count + "张票.");
                count--;
            }
        }
    }
    /*
        定义方法，使用同步方法。
        同步方法相当于把整个方法体都加了同步代码块[锁对象是this]
     */
    public synchronized void sell2(){
        if (count > 0) {
            // 套身份证用5毫秒
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + count + "张票.");
            count--;
        }
    }
}
```

```java
/*
测试类

*/
public class Demo03Test {
    public static void main(String[] args) {
        Ticket3 ticket3 = new Ticket3();

        new Thread(ticket3).start();
        new Thread(ticket3).start();
        new Thread(ticket3).start();
    }
}
```

### 5.同步代码块同步方法的区别

```java
两种同步方式
    1.同步代码块
    2.同步方法
同步代码块：
    优点，使用起来比较灵活
    缺点：语法不如同步方法简洁
同步方法：
    优点:语法简洁
    缺点：使用起来不如同步代码块灵活。
```

### 6.Lock锁

在JDK5的时候，提供了Lock接口，里面有手动锁和释放锁的方法

​	 void lock():获取锁
​    void unlock():释放锁

lock是一个接口，接口不能直接去使用，如果要用，需要使用实现类，常用的是ReentrantLock

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
如果多线程同时操作共享数据，就有可能会引发线程安全问题。

 */
@SuppressWarnings("all")
public class Ticket4 implements Runnable {

    int count = 100;
    // 创建lock对象
    Lock l=new ReentrantLock();

    @Override
    public void run() {
        //因为售票窗口一直开放
        while (true) {
           l.lock();

            if (count > 0) {
                // 套身份证用5毫秒
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + count + "张票.");
                count--;
            }
           l.unlock();
        }

    }
}
public class Demo04Test {
    public static void main(String[] args) {
        Ticket4 ticket4 = new Ticket4();

        new Thread(ticket4).start();
        new Thread(ticket4).start();
        new Thread(ticket4).start();
    }
}

```

## 第五章 并发包(juc)

`java.util.concurrent`也叫并发包

### 1.CopyOnWriteArrayList

```java
ArrayList是线程不安全的，多个线程一起对ArrayList进行操作有可能会有安全问题
CopyOnWriteArrayList是线程安全的，可以使用它来解决这个问题
```

```java
public class Task implements Runnable {

    //List<Integer> list=new ArrayList<>();
    List<Integer> list=new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
        }
        System.out.println("添加完毕");

    }
}
public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        Thread.sleep(3000);
        // 输出集合大小
        System.out.println(task.list.size());
    }
}
```



### 2.CopyOnWriteArraySet

```java
HashSet线程不安全，如果多线程同时对HashSet集合进行操作，有可能会产生安全性的问题
CopyOnWriteArraySet是线程安全的，我们可以使用这个集合进行多线程操作
```

```java
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Task implements Runnable {
    //
    // Set<Integer> set = new HashSet<>();
    Set<Integer> set = new CopyOnWriteArraySet<>();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            set.add(i);
        }
        System.out.println("添加完毕");

    }
}
public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        // 创建线程,启动
        new Thread(task).start();
        // 在main线程中向集合添加2000-3000的数字
        for (int i = 2000; i < 3000; i++) {
            Thread.sleep(5);
            task.set.add(i);
        }
        Thread.sleep(5000);
        System.out.println(task.set.size());
    }
}
```

### 3.Hashtable

```java
HashMap是线程不安全的，如果多个线程同时操作HashMap,那么很有可能出现安全性的问题。
Hashtable是线程安全的，多线程同时操作Hashtable不会有线程安全问题，但是这个集合效事非常低，已经淘汰了。
ConcurrentHashMap是线程安全的,效率比Hashtable要高.ConcurrentHashMap内部使用的是分段锁+CAS
```

```java
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task implements Runnable {

    // Map<String,String> map = new HashMap<>();
    //Map<String,String> map = new Hashtable<>();
    Map<String,String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 键不要重复
           map.put(Thread.currentThread().getName()+i,Thread.currentThread().getName()+i);
        }
        System.out.println("添加完毕");

    }
}

public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        // 创建线程,启动
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        Thread.sleep(5000);
        System.out.println(task.map.size());

    }
}
// 结果
/*
添加完毕
添加完毕
添加完毕
30000
*/
```

### 4.CountDownLatch 

```java
CountDownLatch允许一个或多个线程等待其他线程完成操作。
例如：线程1要执行打印：A和C，线程2要执行打印：B，但线程1在打印A后，
要线程2打印B之后才能打印C，所以：线程1在打印A后，必须等待线程2打印完B之后才能继续执行。

CountDownLatch构造方法:
    public CountDownLatch(int count):参数counr表示计数器

CountDownLatch重要方法:
    public void await(): 让当前线程等待 ,如果计算器变成0那么计数器向下执行
    public void countDown(): 计数器进行减1
```

```java
import java.util.concurrent.CountDownLatch;

public class MyThreadA extends Thread {
    // 定义CountDownLatch
    CountDownLatch c;
    // 提供一个构造方法,接收外界的CountDownLatch
    public MyThreadA(){

    }
    public MyThreadA(CountDownLatch c){
        this.c=c;
    }
    @Override
    public void run() {
        try {
            System.out.println("A");
            c.await();
            System.out.println("C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
import java.util.concurrent.CountDownLatch;

public class MyThreadB extends Thread {
    CountDownLatch c;
    // 提供一个构造方法,接收外界的CountDownLatch
    public MyThreadB(){

    }
    public MyThreadB(CountDownLatch c){
        this.c=c;
    }
    @Override
    public void run() {
        System.out.println("B");
        //System.out.println("D");

        c.countDown();

    }
}
// 测试类
import java.util.concurrent.CountDownLatch;

public class Demo01Test {
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(1);
        new MyThreadA(c).start();

        new MyThreadB(c).start();
    }
}
// 结果
// A
// B
// C
```

### 5.CyclicBarrier

CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障 （也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。

例如：公司召集5名员工开会，等5名员工都到了，会议开始。

```java
创建5给员工线程,一个会议的线程任务,使用CyclicBarrier保证5名员工都到了,再开始开会.
CyclicBarrier构造方法：
    public CyclicBarrier(int count, Runnable barrierAction):当count个线程到达同步点时,会执行barrierAction任务
CyclicBarrier其他方法：
    public int await():让线程等待,会通知CyclicBarrier到达了同步点[屏障]
```

```java
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class PersonThread extends Thread {
    // 定义CyclicBarrier
    CyclicBarrier c;

    // 定义构造方法
    public PersonThread() {
    }

    public PersonThread(CyclicBarrier c) {
        this.c = c;
    }
    // 线程执行任务,让员工休眠随机毫秒值,然后到办公室
    @Override
    public void run() {
        try {
            // 产生随机数
            int randomTime = new Random().nextInt(3000);
            // 线程休眠
            Thread.sleep(randomTime);
            // 模拟到办公室
            System.out.println(Thread.currentThread().getName() + "来到办公室");
            // 让线程等待,直到所有人到达才能开会
            c.await();//线程等待,并通知到达同步点


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class Meeting implements Runnable {
    @Override
    public void run() {
        System.out.println("人都到了.开始开会");
    }
}
public class Demo01Test {
    public static void main(String[] args) {
        // 创建会议对象
        Meeting meeting = new Meeting();
        // 创建CyclicBarrier对象,并指定5给线程到达同步点
        CyclicBarrier c = new CyclicBarrier(5, meeting);
        // 创建CyclicBarrier对象

        new PersonThread(c).start();
        new PersonThread(c).start();
        new PersonThread(c).start();
        new PersonThread(c).start();
        new PersonThread(c).start();
        /*
        Thread-1来到办公室
        Thread-3来到办公室
        Thread-2来到办公室
        Thread-4来到办公室
        Thread-0来到办公室
        人都到了.开始开会
         */

    }
}
```

使用场景 使用场景：CyclicBarrier可以用于多线程计算数据，最后合并计算结果的场景。
需求：使用两个线程读取2个文件中的数据，当两个文件中的数据都读取完毕以后，进行数据的汇总操作。

### 6.Semaphore

```java
Semaphore 可以控制某段代码有几个线程执行。
构造方法：
    Semaphore(int permits);参数表示允许几个线程执行代码。
Semaphore其他方法：
    public void acquire(): 表示获取许可 【获取锁】
    public void release(): 释放凭证【释放锁】
```

```java
import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
    // 定义Semaphore
    Semaphore s;
    // 构造方法,接收外界的Semaphore对象
    public MyThread(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            System.out.println(Thread.currentThread().getName() + "进来了");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "出去了");
            s.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Demo01Test {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        new MyThread(s).start();
        /*
        Thread-1进来了
        Thread-1出去了
        Thread-2进来了
        Thread-2出去了
        Thread-4进来了
        Thread-4出去了
        Thread-3进来了
        Thread-3出去了
        Thread-0进来了
        Thread-0出去了
        Thread-5进来了
        Thread-5出去了
        */
    }
}

```

### 7.Exchanger

Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。 这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执 行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。

```java
Exchanger是交换者，可以让线程之间交换数据
构造方法：
    Exchanger():空参数构造方法
其他方法：
    V exchange(V x):参数表示交给其他类型的数据，返回值是其他线程发送过来的数据,调用该方法后线程就一直等待其他线程数据.
```

```java
import java.util.concurrent.Exchanger;

public class MyThreadA extends Thread {
    // 定义Exchanger
    Exchanger<String> e;

    public MyThreadA(Exchanger<String> e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程A等待来自线程B的礼物");
            System.out.println("线程A送出了自己的礼物,并受到线程B的礼物:"+e.exchange("礼物A"));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
import java.util.concurrent.Exchanger;

public class MyThreadB extends Thread {
    // 定义Exchanger
    Exchanger<String> e;

    public MyThreadB(Exchanger<String> e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程B等待来自线程A的礼物");
            System.out.println("线程B送出了自己的礼物,并受到线程A的礼物:"+e.exchange("礼物B"));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
// 测试类
public class Demo01Test {
    public static void main(String[] args) {
        Exchanger<String> e = new Exchanger<>();
        new MyThreadA(e).start();
        new MyThreadB(e).start();
        /*
        线程A等待来自线程B的礼物
        线程B等待来自线程A的礼物
        线程A送出了自己的礼物,并受到线程B的礼物:礼物B
        线程B送出了自己的礼物,并受到线程A的礼物:礼物A
        */
    }
}

```

## 总结

```java
一. 线程引发的安全性问题
	1. 可见性
	2. 有序性
	3. 原子性
	
二. volatile
	volatile可以解决可见性
		被volatile修饰的变量，每次都会从主内存中读取数据。
	volatile可以解决有序性
		volatile可以禁止重排序。
	volatile不能解决原子性

三. 原子类
	AtomicInteger
		构造方法：
			AtomicInteger()：使用空参数构造方法创建的对象表示整数0
			AtomicInteger(int initialValue)：根据指定的整数创建AtomicInteger对象。
		其他方法：
			int getAndIncrement()：先获取当前值，然后自增。 返回的是自增前的值。
			int incrementAndGet()：先自增，然后获取自增后的值。 返回的是自增后的值。
			int get()：获取AtomicInteger对象的int数字
		解决原子性的原理：
			CAS
四. synchornized
	synchornized表示同步
	
	同步代码块
		synchronized(锁对象) {
			...
		}
		只有持有锁的线程才能够进入到同步代码块中【保证只有一个线程能够执行这段代码】
		
	同步方法：
		修饰符 synchronized 返回值类型 方法名(参数列表) {
			...
		}
		同步方法相当于把整个方法体都加了同步代码块。
		如果同步方法是非静态的，锁是this。
		如果同步方法时静态的，锁是 类名.class

	Lock接口：
		void lock()：可以手动获取锁
		void unlock：可以手动释放锁
		
五. 并发包(juc)
	java.util.concurrent 也叫作并发包
	
	CopyOnWriteArrayList：线程安全的List集合
	CopyOnWriteArraySet：线程安全的Set集合
	ConcurrentHashMap：线程安全的Map集合
	CountDownLatch：允许线程等待其他线程完成操作之后再执行。
	CyclicBarrier：让多个线程到达同步点时，再执行另一个线程任务【五个人都到了，再开会】
	Semaphore：允许n个线程一起执行某段代码【增强版的同步代码块】
	Exchanger：交换者，可以让线程之间交换数据。
	
	
能够写出synchronized同步代码块和同步方法的代码。
其他的能够理解就可以。
```






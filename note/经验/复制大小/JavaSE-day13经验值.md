### 1.已知的文件复制代码

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_文件复制 {
    public static void main(String[] args) throws IOException {
        //创建输入流
        FileInputStream fis = new FileInputStream("day10\\123.jpg");
        //创建输出流
        FileOutputStream fos = new FileOutputStream("day10\\复制.jpg");

        //一次读取多个字节
        byte[] bytes = new byte[1024];
        int len;
        while((len=fis.read(bytes)) != -1){
            //一次写出多个字节
            fos.write(len);
        }

        //关流
        fos.close();
        fis.close();
    }
}
```

### 2.出现的问题

源文件“123.jpg”的大小：

​	                             ![](img\1.jpg)

目标文件“复制.jpg”的大小：

![](img\2.jpg)

### 3.问题的分析

​	read()方法每次读取1024个字节存放在数组中，返回的是实际读取到的字节个数len(一个整数)。

​	在write()输出方法中，写的是len，也就是说每次输出的是一个整数。

​	源文件共13465字节，需要循环读取14次，所以如上代码写出到文件中的是14个字节。并没有输出实际读取

到的数组内容，所以文件复制错误。



### 4.问题的解决办法

​	在输出数据时应该写的是:

```java
fos.write(bytes,0,len);
```

​	bytes中存放的是读取到的字节内容， 0 代表从数组的0索引开始输出，len代表本次输出的字节个数。

​	总结：

​	数组是文件复制时字节的容器，读取时把字节读取到数组中，并记录读取到的字节个数，输出时把数组中指定个数的字节输出，最终完成文件的复制。
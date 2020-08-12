package cn.com.mryhl.demo01_parse;
/*
xml的解析方式：
1. DOM解析（会把整个的xml文件都加载到内存中，然后进行解析）
    优点：会保留xml文件的结构。可以对里面元素进行增删操作。
    缺点：有可能内存溢出。

2. SAX解析（会逐行解析xml，每解析一行，就释放一行）
    优点：效率高，不会内存溢出。
    缺点： 不会保留xml文件的结构，只能读

3. PULL解析（安卓内置的，类似sax）

解析工具包
DOM4J（是由第三方提供的，使用的时候需要导入jar包）
 */

public class Demo01Parse {
    public static void main(String[] args) {

    }
}

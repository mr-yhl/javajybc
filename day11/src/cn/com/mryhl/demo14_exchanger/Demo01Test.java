package cn.com.mryhl.demo14_exchanger;

import java.util.concurrent.Exchanger;

/*
Exchanger是交换者，可以让线程之间交换数据
构造方法：
    Exchanger():空参数构造方法
其他方法：
    V exchange(V x):参数表示交给其他类型的数据，返回值是其他线程发送过来的数据,调用该方法后线程就一直等待其他线程数据.
*/
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

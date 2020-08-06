package cn.com.mryhl.demo08_wrap;
/*
装饰者模式
    可以在不改变原有类，不使用继承的前提下，对一个类的功能进行增强。
使用超级刘德华(装饰的类)对原来的刘德华(被装饰的类)进行增强（对刘德华的功能进行扩展）

装饰者模式实现的原则：
    1. 装饰的类和被装饰的类要实现同一个接口。
    2. 在装饰类中接受被装饰类的对象。
    3. 我们在需要增强的方法中直接写增强后的内容。
    4. 如果某个方法不需要增强，直接通过被装饰的类调用该方法。
 */


public class Demo01Test {
    public static void main(String[] args) {
        // 创建对象
        LiuDehua l = new LiuDehua();
        //创建超级刘德华，对普通刘德华增强
        SuperLiuDehua superLiuDeHua = new SuperLiuDehua(l);
        //唱歌
        superLiuDeHua.sing();
        //跳舞
        superLiuDeHua.dance();
    }
}

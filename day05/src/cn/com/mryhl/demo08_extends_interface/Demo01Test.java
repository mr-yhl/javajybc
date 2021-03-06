package cn.com.mryhl.demo08_extends_interface;
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

package cn.com.mryhl.demo04_factory;

/*
    工厂设计模式可以让我们通过工厂的方式去获取对象
        1. 定义Car作为父类，里面提供run方法。
        2. 定义子类FaLaLi，继承Car
        3. 定义Factory工厂类，里面提供一个获取Car小汽车的方法。
        4. 在测试类中通过工厂获取小汽车对象

    工厂设计模式的好处：可以降低耦合性（关联性）

 */

public class Demo01Test {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("法拉利");
        car.run();
    }
}
package cn.com.mryhl01;

public class TestDog {
    public static void main(String[] args) {
        //根据dog类创建对象
        Dog dd = new Dog();
        dd.age=18;
        dd.name="丹丹";
        System.out.println(dd.name);
        System.out.println(dd.age);
        dd.bark();
        dd.eat();

    }
}

package cn.com.mryhl.demo16_homework.c03;

public class Demo {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        Cat cat = (Cat) animal;
        cat.catchMouse();
    }
}

package cn.com.mryhl.demo12_parse;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
    // 特有行为
    public void lookDoor(){
        System.out.println("看门");
    }
}

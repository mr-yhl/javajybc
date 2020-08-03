package cn.com.mryhl.demo15_homework;

public class Coach extends Human {
    public Coach() {
    }

    public Coach(String id, String name, int age, String sex) {
        super(id, name, age, sex);
    }

    @Override
    public void eat() {
        System.out.println("吃工作餐");
    }
}

package cn.com.mryhl01;

public class TestDog {
    public static void main(String[] args) {
        //创建Dog对象
        Dog dd = new Dog();
        System.out.println(dd.getName());
        System.out.println(dd.getAge());
        //使用重载后的有参构造
        Dog dd1=new Dog("wangcai",18);
        System.out.println(dd1.getName());
        System.out.println(dd1.getAge());
        Dog dd2=new Dog("wangcai");
        System.out.println(dd2.getName());
        System.out.println(dd2.getAge());
    }
}


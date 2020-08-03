package cn.com.mryhl.demo05_genderic;

public class Demo01GenericTest {
    public static void main(String[] args) {
        // 创建Factoryduix
        Factory<Phone> f = new Factory<>();
        //调用方法,进行修理
        Phone p = f.method(new Phone());
        p.call();
    }
}

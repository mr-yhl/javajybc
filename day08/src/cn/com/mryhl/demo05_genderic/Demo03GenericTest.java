package cn.com.mryhl.demo05_genderic;

public class Demo03GenericTest {
    public static void main(String[] args) {
        // 创建Factoryduix

        MyClassA ma = new MyClassA();
        Phone p = ma.method(new Phone());
        // 创建MyClassB对象
        MyClassB<Pad> mb = new MyClassB<>();
        Pad method = mb.method(new Pad());

    }
}

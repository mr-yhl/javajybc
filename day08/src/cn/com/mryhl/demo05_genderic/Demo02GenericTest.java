package cn.com.mryhl.demo05_genderic;

public class Demo02GenericTest {
    public static void main(String[] args) {
        // 创建Factoryduix
        Factory<Pad> f = new Factory<>();
        //调用方法,进行修理
        Pad pad = f.getSame(new Pad());
        Phone phone = f.getSame(new Phone());


    }
}

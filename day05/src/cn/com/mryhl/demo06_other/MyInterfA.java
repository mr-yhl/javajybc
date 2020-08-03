package cn.com.mryhl.demo06_other;

public interface MyInterfA {
    void abstractMethod();
    void abstractMethodA();
    default void defaultMethod(){
        System.out.println("aaa默认");
    }
}

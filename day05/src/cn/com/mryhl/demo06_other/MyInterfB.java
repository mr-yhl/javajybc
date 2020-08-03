package cn.com.mryhl.demo06_other;

public interface MyInterfB {
    void abstractMethod();
    void abstractMethodB();
    default void defaultMethod(){
        System.out.println("bbb默认");
    }
}

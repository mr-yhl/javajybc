package cn.com.mryhl.demo06_other;

public interface MyInterfaceChild extends MyInterfA,MyInterfB{


    @Override
    default void defaultMethod() {
        System.out.println("child");
    }
}

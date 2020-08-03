package cn.com.mryhl.demo07_other.demo06_other;

public interface MyInterfB {
    /*void abstractMethod();
    void abstractMethodB();
    default void defaultMethod(){
        System.out.println("bbb默认");
    }
*/
    void abstractMethodB();
    void abstractMethod();
    default void defaultMethod(){
        System.out.println("b中的默认方法");
    }
}
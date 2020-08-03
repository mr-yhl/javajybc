package cn.com.mryhl.demo07_other.demo06_other;

public interface MyInterfA {
    /*void abstractMethod();
    void abstractMethodA();
    default void defaultMethod(){
        System.out.println("aaa默认");
    }
*/
    void abstractMethodA();
    void abstractMethod();
    default void defaultMethod(){
        System.out.println("a中的默认方法");
    }
}

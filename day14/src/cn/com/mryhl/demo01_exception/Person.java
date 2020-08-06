package cn.com.mryhl.demo01_exception;

public class Person implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Person close");
    }
}

package cn.com.mryhl.demo02_quanxian;

public class MyClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.publicMethod();
        myClass.protectedMethod();
        myClass.defaultMethod();
        myClass.privateMethod();
    }
    //提供public修饰的方法
    public void publicMethod() {
        System.out.println("public修饰的方法");
    }


    //提供protected修饰的方法
    protected void protectedMethod() {
        System.out.println("protected修饰的方法");
    }

    //提供默认权限的方法
    void defaultMethod() {
        System.out.println("默认权限的方法");
    }

    //提供私有的方法
    private void privateMethod() {
        System.out.println("私有的方法");
    }
}

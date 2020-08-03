package cn.com.mryhl.demo08_super;

public class Fu {
    int num = 10;

    public Fu() {
    }

    public Fu(String str){
        System.out.println("父类中的构造方法执行了" + str);
    }

    public void method(){
        System.out.println("父类的method方法执行");
    }
}

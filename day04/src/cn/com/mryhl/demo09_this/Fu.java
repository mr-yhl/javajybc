package cn.com.mryhl.demo09_this;

public class Fu {
    int num = 20;

    public Fu() {
        System.out.println("父类执行gz");
    }

    public void method(){
        System.out.println("父类执行");
    }
    public void method(String s){
        System.out.println(s+"父类执行");
    }
}

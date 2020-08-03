package cn.com.mryhl.demo09_this;

public class Zi extends Fu {
    int num =10;
    public void show(){
        int num = 5;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println("ssssss");
        this.method();
    }
    /*public void method(){
        System.out.println("zi类执行");
    }*/

    public Zi() {
        this("ddddd");
        System.out.println("空参构造");

    }
    public Zi(String s) {
        this(222);
        System.out.println(s+"字符串参数构造");
    }
    public Zi(int num) {
        System.out.println(num+"整数参数构造");
    }
}

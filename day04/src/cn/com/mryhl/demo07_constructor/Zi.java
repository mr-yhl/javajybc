package cn.com.mryhl.demo07_constructor;

public class Zi extends Fu {
    public Zi() {
        super("略咧咧");//调用父类的空参构造,默认存在且隐藏
        System.out.println("子类空参数的构造方法执行了");
    }
}

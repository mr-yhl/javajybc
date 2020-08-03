package cn.com.mryhl.demo05_override;

public class Zi extends Fu {
    /*
    @Override叫做注解,用来验证是否重写了父类的方法
    如果我们在某个方法上面加上@Override报错，那么就说明该方法不是重写的父类的方法。
    如果我们在某个方法上面加上@Override不报错，那么就说明该方法时重写父类的方法。
     */
    @Override
    public void method(){
        System.out.println("method子类");
    }
}

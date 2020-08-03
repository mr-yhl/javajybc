package cn.com.mryhl.demo10_this_super;

public class Zi extends Fu {
    int num =10;
@Override
    public void method(){
        System.out.println("zi类执行");
    }

    public void show(){
        System.out.println(this.num);
        System.out.println(super.num);

    }
}

package cn.com.mryhl.demo14_noname;
/*
接口实现内部类
格式:
     new 父类或接口(){
        重写方法
    };
 */
public class Demo02Test {
    public static void main(String[] args) {
        new Flayable(){

            @Override
            public void fly() {
                System.out.println("小鸟飞");
            }
        }.fly();
    }
}

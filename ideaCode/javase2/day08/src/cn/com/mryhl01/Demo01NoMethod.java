package cn.com.mryhl01;
/*     main是一个主方法，由JVM调用，是程序的入口
        1.public static:修饰符，目前固定写法
        2.void:返回值类型，表示方法内部的代码执行完毕，没有最终的结果，返回给调用者
        3.main:方法名称：固定写法
        4.String[]args:方法的参数
      注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        */
public class Demo01NoMethod {
    public static void main(String[] args) {
        System.out.println("游戏开始...");
        System.out.println("看到了一个怪物...血牙野猪...");
        fire();
        System.out.println("...血牙野猪被打倒...");
        System.out.println("...走啊走啊走啊走...");
        System.out.println("看到了一个怪物...黄金虎鲨...");
        fire();
        System.out.println("...黄金虎盆被打倒...");
        System.out.println("...走啊走啊走啊走...");
        System.out.println("看到了一个怪物...吞天巨狼...");
        fire();
        System.out.println("...吞天巨狼被打倒...");
        System.out.println("...走啊走啊走啊走...");
        System.out.println("游戏结束...");

    }
    public static void fire(){
        System.out.println("开始发射5发炮弹");
        for (int i = 0; i < 5; i++) {
            System.out.println("发射第"+i+"枚炮弹");
        }
        System.out.println("5发炮弹发射完毕");
        return ;//结束方法,返回调用处

    }
}

package cn.com.mryhl.demo02_kejian;
/*
演示线程可见性
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建线程对象
        MyTheard myTheard = new MyTheard();
        // 启动线程
        myTheard.start();
        // 在main线程中用死循环进行判断，如果线程对象中的flag变成了true,就输出一句
         while (true){
             // 解决办法加条输出语句可以输出本段语句
            if (myTheard.flag)
            System.out.println("线程执行了");
         }
    }
}

package cn.com.mryhl.demo04_volatile;

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
             // flag已经使用volatile修饰了，所以每次使用该数据时，会从主内存中获取最新的数据
            if (myTheard.flag){
            System.out.println("线程执行了");
            return;
            }
         }
    }
}

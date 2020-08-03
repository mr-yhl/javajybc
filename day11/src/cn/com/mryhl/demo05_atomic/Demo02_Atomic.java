package cn.com.mryhl.demo05_atomic;

/*

 */
public class Demo02_Atomic {
    public static void main(String[] args) {
        // 创建task对象
        Task task = new Task();
        // 让上三个线程执行线程对象
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}

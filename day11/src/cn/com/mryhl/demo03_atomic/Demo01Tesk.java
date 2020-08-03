package cn.com.mryhl.demo03_atomic;
/*
    原子性问题
 */
public class Demo01Tesk {
    public static void main(String[] args) {
        // 创建task对象
        Task task = new Task();
        // 让上三个线程执行线程对象
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}

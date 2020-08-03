package cn.com.mryhl.demo09_set;

public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        // 创建线程,启动
        new Thread(task).start();
        // 在main线程中向集合添加2000-3000的数字
        for (int i = 2000; i < 3000; i++) {
            Thread.sleep(5);
            task.set.add(i);
        }
        Thread.sleep(5000);
        System.out.println(task.set.size());
    }
}

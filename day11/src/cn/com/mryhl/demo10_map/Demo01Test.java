package cn.com.mryhl.demo10_map;



public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        // 创建线程,启动
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        Thread.sleep(5000);
        System.out.println(task.map.size());

    }
}

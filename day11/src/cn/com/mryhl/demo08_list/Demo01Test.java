package cn.com.mryhl.demo08_list;

public class Demo01Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        Thread.sleep(3000);
        // 输出集合大小
        System.out.println(task.list.size());
    }
}

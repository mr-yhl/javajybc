package cn.com.mryhl.demo03_atomic;

public class Task implements Runnable {
    int conut = 0;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            conut++;
            System.out.println("count = " + conut);
        }
    }
}

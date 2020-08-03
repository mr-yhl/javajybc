package cn.com.mryhl.demo12_cyclicbarrier;

public class Meeting implements Runnable {
    @Override
    public void run() {
        System.out.println("人都到了.开始开会");
    }
}

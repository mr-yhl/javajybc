package cn.com.mryhl.demo03_dead_lock;

public class MyThreadB extends Thread{
    @Override
    public void run() {
        synchronized (Locks.lockb){
            System.out.println("B进程------b");
            synchronized (Locks.locka){
            System.out.println("B进程-----a");}
        }
    }
}

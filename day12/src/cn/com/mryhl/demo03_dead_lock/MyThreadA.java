package cn.com.mryhl.demo03_dead_lock;

public class MyThreadA extends Thread{
    @Override
    public void run() {
        synchronized (Locks.locka){
            System.out.println("A进程------a");
            synchronized (Locks.lockb){
            System.out.println("A进程-----b");}
        }
    }
}

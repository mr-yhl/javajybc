package cn.com.mryhl.homework.t02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
   int ticket=100;
    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            l.lock();
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖第" + ticket + "张票");
                ticket--;
            }
            l.unlock();
        }
    }

}

package cn.com.mryhl.homework.t01;

public class Ticket implements Runnable{
   int ticket = 100;
    @Override
    public void run() {

    }
    public  synchronized void sellTicket(){
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖第" + ticket + "张票");
                ticket--;
            }
        }

    }
}

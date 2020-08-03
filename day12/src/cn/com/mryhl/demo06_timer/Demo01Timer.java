package cn.com.mryhl.demo06_timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*

Timer类，表示定时器，可以只执行一次，也可以周期性的执行
Timer的构造方：
    Timer():空参数的构造方法

其他方法:
    void schedule(TimerTask task, Long delay):指定毫秒值【deLay】后，执行任务【task】，只执行一次
    void schedule(TimerTask task, Long delay,long period):指定毫秒值【deLay】后，执行任务【task】,该方法会周期性执行任务,每隔【period】执行一次.
    void schedule(TimerTask task, Date time): 安排定时器在指定时间【time】执行任务【task】
    void schedule(TimerTask task, Date time,long period): 安排定时器在指定时间【time】执行任务【task】,该方法会周期性执行任务,每隔【period】执行一次.

 */
public class Demo01Timer {
    public static void main(String[] args) {
        // 创建定时器对象
        Timer t = new Timer();
        // 设置定时器,1秒后启动,输出内容
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("叮咚");
            }
        },1000);
        System.out.println("XXXX");
        // 设置定时器,2秒后启动,输出内容,每秒执行一次
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("biubiubiu");
            }
        },2000,1000);
        // 设置定时器,指定时间执行一次.
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,11);
        c.set(Calendar.MINUTE,42);
        c.set(Calendar.SECOND,30);
        // 转成时间对象
        Date date = c.getTime();
        // 设置定时,在指定时间执行
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("指定时间到了");
            }
        },date);
    }
}

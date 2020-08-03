package cn.com.mryhl.homework.t06;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*l 定义第一个线程：计算1--10000的所有数的累加和。

l 定义第二个线程：计算1--10000的所有偶数的累加和。

l 定义第三个线程：计算1--10000的所有奇数的累加和。

l 定义第四个线程：打印：”计算完毕”。

要求在“第一个线程”、“第二个线程”、“第三个线程”全部执行完毕，再执行“第四个线程”。
*/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("计算完毕");
            }
        });
        new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10000; i++) {

                    sum += i;
                }
                System.out.println("计算结果为:" + sum);
                try {Thread.sleep(20000);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10000; i++) {
                    if (i%2!=0)
                    sum += i;
                }
                System.out.println("奇数和计算结果为:" + sum);
                try {Thread.sleep(20000);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10000; i++) {
                    if (i%2==0)
                        sum += i;
                }
                System.out.println("偶数和计算结果为:" + sum);
                try {
                    Thread.sleep(20000);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}

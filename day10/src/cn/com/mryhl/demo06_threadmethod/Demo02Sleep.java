package cn.com.mryhl.demo06_threadmethod;
/*
线程体眠的方法
(记住）static void sleep(Long millis):线程休眠，参数是要休眠的毫秒值。
 */
public class Demo02Sleep {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("开始");
        // 线程休眠5000毫秒
        Thread.sleep(5000);
        System.out.println("结束");
    }
}

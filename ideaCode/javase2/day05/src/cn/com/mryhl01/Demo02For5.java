package cn.com.mryhl01;

public class Demo02For5 {
    //在控制台输出1-5和5-1
    public static void main(String[] args) {
        int i;
        System.out.println("输出1-5");
        for (i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("输出5-1");
        for ( int j=5; j >0 ; j--) {
            System.out.println(j);
        }
        System.out.println("main.............end......");
    }
}

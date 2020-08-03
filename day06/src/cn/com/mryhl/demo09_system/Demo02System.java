package cn.com.mryhl.demo09_system;
/*
要求：统计输出1000次HeLLoWorLd花费多长时间。
步骤：
1.在输出HeLLoWorld之前记录当前时间【喜秒值】
2.输出Helloworld
3.在输出Helloworld之后记录当前时间【喜秒值】
4.相减
 */
public class Demo02System {
    public static void main(String[] args) {
        // 1.在输出HeLLoWorld之前记录当前时间【喜秒值】

        long startl = System.currentTimeMillis();

        // 2.输出Helloworld
        for (int i = 1000; i > 0; i--) {
            System.out.println("helloworld");
        }

        // 3.在输出Helloworld之后记录当前时间【喜秒值】
        long entl = System.currentTimeMillis();

        // 4.相减
        System.out.println(entl - startl);
    }
}

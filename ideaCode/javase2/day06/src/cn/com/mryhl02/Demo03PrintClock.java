package cn.com.mryhl02;
/*模拟钟表的时针和分针
        时针（外层循环）走一个格，分钟（内层循环）走一圈
        对应：
        外层循环执行一次，内层循环执行完整的一遍*/
public class Demo03PrintClock {
    public static void main(String[] args) {
        int count=0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                count++;
                System.out.println(i+"时"+j+"分");
            }

        }
        System.out.println(count);
    }
}

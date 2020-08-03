package cn.com.mryhl01;

public class Demo03ForSum {
    //计算1-5的和,并输出结果
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("1-5的数据和为:" + sum);
    }
}

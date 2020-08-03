package cn.com.mryhl01;

//求1-100之间的偶数和，并把求和结果在控制台输出
public class Demo04ForOuShuSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i+=2) {
            //if (i % 2 == 0)
                sum += i;
        }
        System.out.println("1-100之间的偶数和:" + sum);
    }
}

package cn.com.mryhl.demo08_homework.ti_digui;
// 请使用递归计算5的阶乘
public class Demo01JieCheng {
    public static void main(String[] args) {
        // 调用方法,接收返回值
        int sum = sumNJieCheng(5);
        // 打印结果
        System.out.println("计算结果为:" + sum);
    }
    // 定义方法,计算阶乘
    // 参数:int n(计算n的阶乘)
    // 返回值:int sum
    public static int sumNJieCheng(int n){
        if (n == 1)
            return 1;
        return n * sumNJieCheng(n-1);
    }
}

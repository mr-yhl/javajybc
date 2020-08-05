package cn.com.mryhl.demo08_homework.ti_digui;
// 递归计算1-100的和
public class Demo02Bhe {
    public static void main(String[] args) {
        // 调用方法,接收返回值
        int bai = sumBai(100);
        // 打印结果
        System.out.println("计算结果为:" + bai);
    }
    /*
    * 定义方法,递归计算1-100的和
    * 参数: int n
    * 返回值: int sum
    * */
    public static int sumBai(int n){
        // 如果是1直接返回
        if (n == 1)
            return 1;
        // 递归调用
        return n + sumBai(n - 1);
    }
}

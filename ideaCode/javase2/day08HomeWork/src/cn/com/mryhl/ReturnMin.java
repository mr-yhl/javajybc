package cn.com.mryhl;
// 定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。
public class ReturnMin {
    public static void main(String[] args) {
        System.out.println("两个数中,较小的是"+returnMinNum(5.6,5.3));
    }
    public static double returnMinNum(double a, double b){
        return a<b?a:b;
    }

}

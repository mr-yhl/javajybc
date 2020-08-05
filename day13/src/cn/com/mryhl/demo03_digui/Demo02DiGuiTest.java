package cn.com.mryhl.demo03_digui;
/*
使用递归求阶乘
求阶乘公式
    n！=n*（n-1）*....*1
递归思想：
    5！ = 5 * 4！
    4！ = 4 * 3！
    3！ = 3 * 2！
    2！ = 2 * 1！
    1！ = 1
规律：
    如果是求1的阶乘，结果就是固定值1.
    如果是求其他数字的阶乘，结果是这个数 * 这个数减1的阶乘
*/
public class Demo02DiGuiTest {
    public static void main(String[] args) {
        System.out.println(getJieCheng(5));
    }
    /*
    定义方法,该方法用来求一个数的阶乘
    参数:int n
    返回值:int n
     */

    public static int getJieCheng(int n){
        if (n == 1)
            return 1;
        return n * getJieCheng(n-1);
    }
}

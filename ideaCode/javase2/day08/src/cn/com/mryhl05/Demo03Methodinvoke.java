package cn.com.mryhl05;
/*有返回值的方法调用方式
1.赋值调用：把调用有返回信的方法的返回结果保存到变量中
    数据类型变量名称=方法名称（参数列表...);
2.打印/输出调用：把调用有返回值的方法的返回结果直接交给输出语句，进行打印输出
    stem.out.println(方法名称（参数列表...);
3.直接/单独/独立调用   码是没有错误的，但是丢失了结果数据
    方法名称（参数列表...);
*/
public class Demo03Methodinvoke {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //调用方法，传递常量
        int result = getSum(10,20);

        System.out.println("和："+result);
        // 打印/输出调用
        System.out.println("和："+getSum(10,20));

        //3.单独调用(直接调用)
        getSum(10,20);
        System.out.println("main...end...");
    }
    //定义方法，获取两个int数据之和
    public static int getSum(int a, int b){
        int sum=a+b;
        return sum;}
}

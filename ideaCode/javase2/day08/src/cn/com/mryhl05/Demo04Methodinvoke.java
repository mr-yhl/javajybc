package cn.com.mryhl05;

/*无返回值的方法调用方式

1.直接/单独/独立调用
没有返回值方法，只能采用直接调用，另外两种调用方式都是错误的
    方法名称（参数列表...);

2.赋值调用：把调用有返回信的方法的返回结果保存到变量中【错误】
    数据类型变量名称=方法名称（参数列表...);
3.打印/输出调用：把调用有返回值的方法的返回结果直接交给输出语句，进行打印输出【错误】
    stem.out.println(方法名称（参数列表...);
*/
public class Demo04Methodinvoke {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //调用方法，传递常量
        // int result = printSum(10,20);
        //
        // System.out.println("和："+result);
        // // 打印/输出调用
        // System.out.println("和："+printSum(10,20));

        //1.单独调用(直接调用)
        printSum(10, 20);
        System.out.println("main...end...");
    }

    //定义方法，获取两个int数据之和
    public static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
        return;
    }
}

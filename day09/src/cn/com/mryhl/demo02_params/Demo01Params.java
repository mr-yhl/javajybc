package cn.com.mryhl.demo02_params;
/*
在JDK5的时候，多了一个新特性，叫做可变参数。
可变参数的方法可以在参数位置传递任意个数据
可变参数的格式：
    修饰符返回值类型方法名（参数类型... 参数名）{
    ...
    }
    1.在调用带有可变参数的方法时，我们可以向可变参数位置传递任意个数据
    2.可变参数的本质是数组,所以我们将可变参数当成数组.
    3.因为可变参数本质是数组，所以在调用可变参数的方法时，也可以传递数组

注意事项:
    1.一个方法中最多只能有一个可变参数
    2.可变参数必须放在最后一个位置

*/
public class Demo01Params {
    public static void main(String[] args) {
        /*int[] arr = {1,2,4,54,3,242,4};
        System.out.println(getSum(arr));*/
        int sum = getSum(1, 2,3,4,5);
        System.out.println(sum);
        int[] arr = {1,2,4,54,3,242,4};
        // 传递数组
        System.out.println(getSum(arr));

    }
    /*public static int getSum2(int... nums,int... b){}*/
   /* public static int getSum2(int b, int... nums){}*/
    /*
    定义一个方法,该方法可以求任意个整数和
    */
    public static int getSum(int... nums){
        int sum=0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
    /*
    定义一个方法,该方法可以求任意个整数和
        参数:int[]
        返回值:int
     */
    /*public static int getSum(int[] arr){
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }*/


}

package cn.com.mryhl04;
/*有返回信有数的方法练习-获取最大值
        1.无返回值
        经验分享：
        如果在题目需求中能够明确看到获取/返回/判断二字，说明方法内部需要返回结果数据，就必须定义返回值类型
        2.有参数
        经验分享：如果题目需求中有不确定的东西，就需要定义参数列表
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        设计一个方法可以获取两个int数的较大值，数据来自于参数*/
public class Demo01GetMax {
    public static void main(String[] args) {
        int m = 100, n = 200;
        System.out.println(getMax(20,63));
        System.out.println(getMax(m,n));
    }
    public static int getMax(int a,int b){
        int max = a>b?a:b;
        return  max;
    }
}

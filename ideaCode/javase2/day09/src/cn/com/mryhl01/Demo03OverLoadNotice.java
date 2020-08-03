package cn.com.mryhl01;
/*方法重载参数列表不同有哪些情况？
1.参数数量不同
2.参数类型不同
3.多个类型，顺序不同
记住：
方法重载，名称相同后，看参数列表的本质区别（不含参数名称）,和其它的任何东西无关
*/
public class Demo03OverLoadNotice {
    public static void main(String[] args) {

    }
    //该方法没有参数
    public static void method(){

    }
    //该方法有一个int参数
    public static void method(int a){

    }
    //该方法有两个int参数
    public static void method(int a,int b){

    }
    //该方法有一个double参数
    public static void method(double a){

    }
    //该方法有一个double参数一个int参数
    public static void method(double a,int b){

    }
    //该方法有一个int参数一个double参数
    public static void method(int a,double b){

    }
}

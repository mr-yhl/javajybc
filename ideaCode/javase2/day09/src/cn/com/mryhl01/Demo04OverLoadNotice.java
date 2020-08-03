package cn.com.mryhl01;
/*方法重载与哪些因素无关？(这些情况是无法构成重载的）
1.与参数的名称无关
2.与返回值无关
3.与修饰符无关

记住：
方法重载，名称相同后，看参数列表的本面区别（不含参数名称）,和其它的任何东西无关
*/
public class Demo04OverLoadNotice {
    public static void main(String[] args) {

    }
    //该方法有两个int参数
    public static void method(int a,int b){

    }
    /*数类型和数量都相同，只有参数名称不同，无法构成重载
    public static void method(int c,int d){

    }*/
    /*
    有返回值类型不同，然而方法重载与返回值类型是无关的，所以无法构成重载
    public static int method(int a,int b){
        return a+b;
    }*/
    /*只有修饰符不同，然而方法重载与修饰符是无关的，所以无法构成重载
    public  void method(int a,int b){

    }*/
}

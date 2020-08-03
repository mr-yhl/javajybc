package cn.com.mryhl05;

import java.util.Scanner;

/*方法的注意事项二
1.返回值类型，必须要和return语句返回的数据的类型要匹配，否则编译失败。
2.不能在return后面写代码，return意味着方法结束，所有后面的代码永远不会执行，属于无效代码。
3.void表示无返回值，可以省略return,也可以单独的书写return,后面不加数据return;

        */
public class Demo02MethodNotice {
    public static void main(String[] args) {

    }

// 1.返回值类型，必须要和return语句返回的数据的类型要匹配，否则编译失败。
    public static int a(){
        return 1000;//返回值类型:int
        // return 6.6;//返回值类型：double
    }
// 2.不能在return后面写代码，return意味着方法结束，所有后面的代码永远不会执行，属于无效代码。
public static int getMax(int a,int b){
   if(a>b)
       return a;
   else
       return b;
    //System.out.println("getMax....end");
}
// 3.void表示无返回值，可以省略return ;,也可以单独的书写return ;,后面不加数据return;


}

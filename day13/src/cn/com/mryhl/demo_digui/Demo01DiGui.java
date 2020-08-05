package cn.com.mryhl.demo_digui;
/*
递归
    指在当前方法内调用自己的这种现象。

注意:
    1. 递归必须要有出口【结束条件】
    2.递归次数不能太多【否则也会出现栈内存溢出】

递归的使用场景：
    在不确定层级的场景，可以使用递归【比如遍历文件夹，比如遍历菜单】

*/
public class Demo01DiGui {
    public static void main(String[] args) {
        //method();
        printNumber(1);
    }
    //定义方法
    public static void printNumber(int num){
        // 结束条件
        if (num == 10000)
            return;
        System.out.println(num);//1-11412
        num++;
        printNumber(num);
    }
    // 定义方法
    /*public static void method(){
        System.out.println("方法执行了");
        method();
    }*/
}

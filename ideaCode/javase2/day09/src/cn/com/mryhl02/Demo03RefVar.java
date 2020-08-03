package cn.com.mryhl02;
/*
引用类型作为方法参数传递的特点【形参的改变，不会影响实参】
注意：
1.引用类型变量，保存对象在堆内存空间的地址值
2.引用类型变量，作为方法参数传递时，传递的是地址值
3.通过形式参数找到对应的堆内存空间的内容，进行修改后，再通过实际参数，看到的是堆内存空间修改后的内容
数组：
1.数组变量也是引用类型变量，保存数组对象在堆内存空间的地址值
2.数组变量，作为方法参数传递时，传递的是地址值
3.通过形式参数数组变量找到对应的堆内存空间的数组，修改数组元素后
再通过实际参数数组变量，看到的一定是是堆内存空间的修改后的数组元素
总结：
所有引用变量，保存的都是地址值，作为方法参数/方法返回值，传递/返回的都是地址值
*/
public class Demo03RefVar {
    public static void main(String[] args) {
        int[] a =new int[]{10,20};

        System.out.println("a[0]="+a[0]);//10
        System.out.println("b="+a[1]);//20
        change(a);
        System.out.println("ea[0]="+a[0]);//10
        System.out.println("ea[1]="+a[1]);//20
    }
    public static void change(int[] a){
        System.out.println("ch.a="+a[0]);//10
        System.out.println("ch.a[1]="+a[1]);
        a[0]*=10;
        a[1]*=10;
        System.out.println("ech.a[0]="+a[0]);//10
        System.out.println("ech.a[1]="+a[1]);
    }
}

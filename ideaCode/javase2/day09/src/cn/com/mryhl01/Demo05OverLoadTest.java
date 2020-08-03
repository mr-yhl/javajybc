package cn.com.mryhl01;

/*需求：
使用方法重载的思想，设计比较两个数据是否相等的方法，兼容全整数类型（byte,short,int,long)
方法重载的思想：同一个类中，多个功能相同，参数列表不同的方法，可以使用同一个名字
实现步骤：
1.所以方法重载的思想，定义获取两个byte数据是否相同的方法compare
2.所以方法重载的思想，定义获取两个short数据是否相同的方法compare
3.所以方法重载的思想，定义获取两个int数据是否相同的方法compare
4.所以方法重载的思想，定义获取两个Long数据是否相同的方法compare
5.在main方法中分别调用以上四个方法，传递对应类型的参数，获取并打印结果
*/
public class Demo05OverLoadTest {
    public static void main(String[] args) {
    //    调用
    //     输出调用
        System.out.println(compare((byte)10,(byte)20));
        System.out.println(compare((short)10,(short)20));
        System.out.println(compare(10,20));
        System.out.println(compare(10L,20L));
        System.out.println("----------------------------");
        byte a=1,b=2;
        short c=3,d=4;
        int e=5,f=6;
        long g=7l,h=8l;
        System.out.println(compare(a,b));
        System.out.println(compare(c,d));
        System.out.println(compare(e,f));
        System.out.println(compare(g,h));
    }

    public static boolean compare(byte a, byte b) {
        System.out.println("2byte");
        if (a == b)
            return true;
        else
            return false;

    }

    public static boolean compare(short a, short b) {
        System.out.println("2shory");
        if (a == b)
            return true;
        else
            return false;

    }

    public static boolean compare(int a, int b) {
        System.out.println("2int");
        if (a == b)
            return true;
        else
            return false;

    }

    public static boolean compare(long a, long b) {
        System.out.println("2long");
        if (a == b)
            return true;
        else
            return false;

    }
}

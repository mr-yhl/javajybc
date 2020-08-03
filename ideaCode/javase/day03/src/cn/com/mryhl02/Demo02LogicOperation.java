package cn.com.mryhl02;

public class Demo02LogicOperation {
    public static void main(String[] args) {
        int a=10,b=20,c=30;
        System.out.println("与运算");
        System.out.println((a>b)&(a>c));//false
        System.out.println((a<b)&(a<c));//true
        System.out.println((a>b)&(a<c));//false
        System.out.println((a<b)&(a>c));//false
        System.out.println("或运算");
        System.out.println((a>b)|(a>c));//false
        System.out.println((a<b)|(a<c));//true
        System.out.println((a>b)|(a<c));//true
        System.out.println((a<b)|(a>c));//true
        System.out.println("异或运算");
        System.out.println((a>b)^(a>c));//false
        System.out.println((a<b)^(a<c));//false
        System.out.println((a>b)^(a<c));//true
        System.out.println((a<b)^(a>c));//true
        System.out.println("非运算");
        System.out.println(!true);
        System.out.println(!false);
        System.out.println(!(3<2));
    }
}

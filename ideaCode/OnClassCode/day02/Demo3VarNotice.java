/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 10:22:45
 * @Topic request: 定义的注意事项
 */ 
/*
变量定义的注意事项：
1.变量名称：在同一个大括号范围内，变量的名字不可以相同。
2.变量赋值：定义的变量，不赋值不能使用。
*/
public class Demo3VarNotice {
    public static void main(String[] args) {
        int a=10;
        System.out.println(a); 
        //int a =20;
        //System.out.println(a);
        int b;
        //system.out.println(b)水/错误的：变量b中没有值不能使用
        b=30;
	System.out.println(b);}
}

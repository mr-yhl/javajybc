/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 14:38:41
 * @Topic request: 自增自减运算符
 */ 
public class Demo16Operator {
    public static void main(String[] args) {
        int a=2;
        a++;
        System.out.println(a);//3
        ++a;
        System.out.println(a);//4
        int c=2;
        int d = ++c;
        System.out.println(c);//3
        System.out.println(d);//3
        int e=2;
        int f=e++;
        System.out.println(e);//3
        System.out.println(f);//2
    }

}

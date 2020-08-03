/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 10:29:22
 * @Topic request: 题目描述
 */ 
/*
变量定义的注意事：
1.定义long类型的变量时，需要在整数的后面加L(大小写均可，建议大写）。
因为整数默认是int类型，整数太大可能超出int范小写均可，建议大写）
2.定义float类型的变量时，需要在小数的后面加F
因为浮点数的默认类型是double,double的取值范围是大于float的，类型不兼容。
*/
public class Demo4VarNotice {
    public static void main(String[] args) {
        //错误
        //整数600000000默认是int类型，而int类型的取值范围正负21亿
        //首前6000000000已经超出了int的取值范围正负21亿
        //long a=6000000000;
        //6000000000L表示1ong类型的数据，long的取值范围大概19位数字，没有超出范围
        long a = 6000000000L;
        System.out.println(a);
        //错误：
        // 6.6默认是double类型，占8个字节，左侧的变量float类型，占4个字节
        ///大萝卜不能直接放小坑中
        //float c = 6.6;
        //System.out.println(c);
        float c = 6.6F;
        System.out.println(c);
    }
}

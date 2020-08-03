/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 11:18:48
 * @Topic request: 自动类型转换二
 */ 
public class Demo7Covert {
    public static void main(String[] args) {
        int i =1;
        double d=2.5;
        //d是double类型占8字节，i是int类型，占4字节，int自动转成double类型
        //结果为double占8字节，不能直接赋值给占4字节的int
        // int x = d+i;
        double x = d+i;
        System.out.println(x);
    }
}
/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 11:09:15
 * @Topic request: 自动类型转换练习
 */ 
public class Demo6Convert {
    public static void main(String[] args) {
        int i=6;
        byte b=2;
        /*
        b是byte类型，占1字节，i是int类型占4字节，类型不一致，会发生自动类型转换。
        把byte类型b转换成int类型。b+i是int类型，不能直接赋值给byte类型变量。
        解决方案：
        1.把左侧的坑变大（目前采用这种方式）
        2.把右侧的萝卜变量（后面讲的强制类型转换）
        */
        // byte x =b+i;
        int x =b+i;
        System.out.println(x);
    }
}
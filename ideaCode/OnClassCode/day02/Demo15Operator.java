/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 14:38:41
 * @Topic request: 赋值运算的特点
 */ 
public class Demo15Operator {
    public static void main(String[] args) {
        /*
        右侧1默认是int类型，占4个字节，左侧变量s是short类型，占2个字节
        按照道理来讲，大萝卜是不能直接放入小坑中
        这里为什么没有报错
        数字1虽然是int类型，但是是常量，而且没有超出short的取值范围，
        此时编译器内部帮助我们做强制类型转换
        */
        short s=1;
        System.out.println(s);
    }
}

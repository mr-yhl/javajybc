package cn.com.mryhl.demo04_variable;
/*局部变量和成员变量的区别:
定义位置不同:
    成员:在类中方法外定义
    局部:在方法内定义
 使用范围不同:
    局部:只能在自己的作用域
    成员:可以在整个类中使用
 内存位置不同:
    局部:跟随方法在栈内存中开辟
    成员:跟随对象保存至堆内存
 初始值:
    局部:没有默认值,使用之前必须赋值
    成员:有默认值。整数是0,小数是0.0,字符是'',布尔是faLse,引用类型是null
 生命周期:
    局部:在方法执行到定义变量这行代码的时候产生,一旦离开自己的作用域,局部变量就会消失
    成员:跟随对象的产生而产生,随着对象的消失而消失

*/
public class Demo01Variable {
}

package cn.com.mryhl.demo04_myexception;
/*
自定义异常
如何自定义异常：认赔作父，定义一个类，继承一个异常类即可。

如果一个类继示的是编译时异常，那么该类也就是编译时异常
如果一个类继示的是运行时异常，那么该类也就是运行时异常

我们可以在自定义异常中提供一个构造方法，用来传递异常信息【在该构造方法中要将异常信息交给父类的构造方法】
 */
public class AgeException extends RuntimeException {
    public AgeException() {
    }

    // 提供一个参数为字符串的构造方法,用来给异常信息赋值
    public AgeException(String message){
        super(message);
    }

}

package cn.com.mryhl.demo03_exception;

import java.util.Objects;

/*
在objects中，有一个方法可以对对象进行非空判断

static <T> T requireNonNuLL(T obj):判断obj是否是nulL。如果obj是nulL,会引发空指针异常。
 */
public class Demo04Objects {
    public static void main(String[] args) {
        // 定义Object
        Object obj = null;


        //使用objects中的requireNonNuLL验证是否为mull
        Objects.requireNonNull(obj);
        /*if (obj == null){
            throw new NullPointerException();
        }*/
        //通过nuLL调用任何非静态的属性和方法都会引发空指针异常。
        obj.toString();
    }
}

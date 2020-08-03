package cn.com.mryhl.demo05_genderic;
/*
实现类在实现接口时，不指定泛型。
我们在定义类或者接口时，只有在当前类或者接口名字后面写的尖括号是在定义泛型，其他的都是在使用泛型
 */

public class MyClassB<T> implements MyInterface<T> {

    @Override
    public T method(T t) {
        return t;
    }
}

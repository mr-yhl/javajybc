package cn.com.mryhl.demo05_genderic;
/*
实现类在实现接口时指定泛型
实现类在实现接口时，可以直接在接口名后面写上尖括号去指定泛型
 */
public class MyClassA implements MyInterface<Phone> {
    @Override
    public Phone method(Phone phone) {
        return phone;
    }
}

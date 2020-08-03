package cn.com.mryhl.demo05_genderic;
//工厂
/*
    泛型：是一种未知的，不确定的数据类型。
如果在定义类的时候，在类名后面加上<T>,就表示在类中定义了一个不确定的类型。
T可以是任何字母，一般是一个大写字母

T真正表示一种数据类型，只不过他在刚写出来的时候是未知的。
当我们使用这个类（创建对象）时，会指定这个是什么类型，那么此时这个T表示的类型就可以确定了。
这个T就是一个泛型.


带有泛型的类:
    public class 类名<泛型>{
    .....

    }

如果想要在调用方法时才确定具体的类型，那么我们可以使用泛型方法（在方法上定义泛型）
如果在方法上定义泛型，那么这个泛型类型会在调用方法时才指定

泛型方法格式
  修饰符 <泛型> 返回值类型 方法名(参数类型 参数名){
  ......

  }


小结:
    如果是在类上面定义的泛型,在整个类都可以使用,在整个类中都可以使用，类上面定义的泛型需要等到使用这个类【创建对象】时才会指定这个泛型到底是什么类型。
    如果是在方法上面定义的泛型，在方法中可以使用。方法上面定义的泛型需要等到调用方法时才能知道这个泛型到底是什么类型。

*/
public class Factory<T> {//在类中定义一个未知的不确定的数据类型T,也可以称为泛型类型T

    /*
    定义一个方法:接收什么参数就返回什么结果
     */
    //<E>表示在方法中定义 了一个泛型E
    // 第二个E表示使用了未知的不确定的类型E当作返回值类型
    // 第三个e 表示使用了未知的不确定的类型E当作参数
    public <E> E getSame(E e){
        return e;
    }


    /*定义一个方法,该方法可以修理任意东西*/
    // 使用泛型T当作参数和返回值数据
    public T method(T t){
        // 假装修理
        return t;
    }


}
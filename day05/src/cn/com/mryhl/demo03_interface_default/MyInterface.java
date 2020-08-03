package cn.com.mryhl.demo03_interface_default;
/*
jdk8中,接口中也可以有默认方法

默认方法定义
    public default 返回值类型 方法名(参数列表){
        方法体;
        return 返回值;

    }
注意:
    1.默认方法有方法体
    2.默认方法中的public关键字可以省略，如果省略public,这个方法也是用public修饰的

默认方法的使用：
1.实现类不需要强制重写接口中的默认方法，我们可以通过实现类对象直接去调用这些默认方法
2.实现类也可以重写接口中的默认方法，实现类重写默认方法时要去掉default

 */
public interface MyInterface {
    void hello();
    // 提供默认方法
    default void printWorld(){
        System.out.println("world");
    }
}

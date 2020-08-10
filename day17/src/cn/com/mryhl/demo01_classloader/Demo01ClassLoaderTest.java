package cn.com.mryhl.demo01_classloader;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 8:46
 */
/*
如果想要获取加载读类的类加载器，可以使用下面代码
    Person.class.getClassLoader()

启动类加载器是扩展类加载器的 父加载器
扩展类加载器是应用类加载器的 父加载器
 */

public class Demo01ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(Person.class.getClassLoader().getParent());
    }
}

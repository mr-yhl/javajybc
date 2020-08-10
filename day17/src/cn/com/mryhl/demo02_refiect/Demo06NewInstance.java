package cn.com.mryhl.demo02_refiect;
/*
在CLass中有一个方法叫做newInstance,可以十分方便的创建对象
T newInstance():使用空参数的构造方法创建对象。
如果要通过空参数的构造方法创建对象，那么不需要像之前那样先获取构造方法，然后再通过构造方法创建对象了。
我们可以通过class直接调用newInstance方法，利用空参数的构造方法对象。
 */

public class Demo06NewInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 获取Person类的Class
        Class clazz = Class.forName("cn.com.mryhl.demo02_refiect.Person");
        //直接调用newInstance创建对象
        Object obj = clazz.newInstance( ) ;
        //输出结果
        System.out.println(obj);
    }
}

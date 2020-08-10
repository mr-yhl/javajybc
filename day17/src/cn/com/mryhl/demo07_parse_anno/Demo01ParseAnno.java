package cn.com.mryhl.demo07_parse_anno;
/*
注解解析
注解解析指的是获取注解中的内容(属性)然后进行使用。

解析相关API：
    Annotation：是所有注解的根接口，所有注解都会默认实现这个接口。
    AnnotatedElement：这个接口中定义了有关操作注解的方法
        Annotation[] getAnnotations()：获取到所有的注解。
        T getAnnotation(Class annotationClass)：获取到指定的注解。 参数是注解的Class对象。
        boolean isAnnotationPresent(Class annotationClass)：判断是否有该注解。参数是注解的Class对象。

反射有关的类【Class，Method，Constructor，Field】都实现了AnnotatedElement这个接口。
注解解析要结合反射技术实现。
    如果要操作类上的注解，通过CLass对象调用上面的方法进行操作。
    如果要操作构造方法上的注解，通过Constructor对象调用上面的方法进行操作
    如果要操作成员方法上的注解，通过Method对象调用上面的方法进行操作。
要求：获取BookStore这个类上的注解，并输出注解的属性
分析：如果要获取BookStore上的注解，我们可以先获取BookStore的Class对象，通过Class对象对注解进行操作.
*/


import java.lang.annotation.Annotation;

public class Demo01ParseAnno {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取Class对象
        Class clazz = Class.forName("cn.com.mryhl.demo07_parse_anno.BookStore");
        //判断有没有注解
        boolean flag = clazz.isAnnotationPresent(Book.class);
        // System.out.println(flag);
        if (flag){
            // 如果条件成立,表示bookstore上有注解
            Annotation a = clazz.getAnnotation(Book.class);
            // 向下转型
            Book book = (Book) a;
            System.out.println("书名:"+book.name());
            System.out.println("价格:"+book.price());
            System.out.println("作者:"+book.author());
        }


    }

}

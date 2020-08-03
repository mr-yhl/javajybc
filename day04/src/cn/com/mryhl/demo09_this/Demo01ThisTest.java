package cn.com.mryhl.demo09_this;
/*
this的三种用途
1.可以访问本类的成员变量
this.变量名
2.可以访问本类的成员方法
this.方法名()
3.可以访问本类的构造方法
this(参数);

注意：this如果调用构造方法，只能放到第一行
如果某个构造方法的第一行写了this,系统也不会帮我们提供默认的super
 */
public class Demo01ThisTest {
    public static void main(String[] args) {
        Zi zi = new Zi();
        //zi.show();
    }
}

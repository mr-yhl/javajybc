package cn.com.mryhl.demo08_super;
/*
super的三种用途
    1.可以访问父类的成员变量
    super.变量名
    2.可以访问父类的成员方法
    super.方法名();
    3.可以调用父类的构造方法
    super(参数);
 */
public class Demo01Super {
    public static void main(String[] args) {
        Zi zi = new Zi();

        zi.show();
    }
}

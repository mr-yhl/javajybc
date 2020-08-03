package cn.com.mryhl.demo12_abstract.demo11_abstract;
/*
抽象类注意事项:
    1.抽象类不能创建对象
    2.抽象类也可以有构造方法,抽象类的构造方法是给子类去用的
    3.抽象类中可以有抽象方法,也可以有非抽象方法
      抽象方法所在的类,必须是抽象类
    4.一个普通分类继承抽象类时,必须重写抽象方法
      一个抽象类在继承抽象类时,可以不重写抽象方法
    5.抽象类的目的是给子类继承,规范子类的行为.抽象类可以体现模板思想.
 */
public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();

    }
}

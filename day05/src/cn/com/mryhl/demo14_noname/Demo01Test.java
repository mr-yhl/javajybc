package cn.com.mryhl.demo14_noname;
/*
匿名内部类
匿名内部类,也是内部类,只不过这种内部类没有名字

作用:临时定义某个类的子类,在创建该子类的对象


格式:
    new 父类或接口(){
        重写方法
    };
举例:
    new Person(){
        重写方法
    };
    创建的是Person的子类对象,子类没有命名,称匿名内部类
 */
public class Demo01Test {
    public static void main(String[] args) {
       /* Dog d =new Dog();
        d.eat();*/
        // 通过匿名内部类创建子类对象
        Animal a=new Animal(){


            @Override
            void eat() {
                System.out.println("吃骨头");
            }
        };
        a.eat();
        // 匿名内部类+匿名对象
        new Animal(){

            @Override
            void eat() {
                System.out.println("吃炒饼");
            }
        }.eat();
    }
}

package cn.com.mryhl.demo01_test;
/*
定义Person类，并提供吃的方法
在测试类中定义一个方法，该方法接收一个Person对象作为参数，并在方法中让Person去吃。
再定义一个方法，该方法用来获取一个Person对象。【在方法中创建Person对象并返回】

 类作为方法参数,我们需要传递这个类的对象

 */

public class Demo01Test {
    public static void main(String[] args) {
        // 调用showEat,让person对象去吃
        //showEat(new Person());
        //调用createPerson,得到对象
        Person p = createPerson();
        //通过person对象调用方法
        showEat(p);
    }
    /*
        定义方法，用来获取Person对象
            参数：没有
            返回值类型：Person
     */
    public static Person createPerson(){
        // 创建Person对象
        Person p = new Person();
        return p;
    }



    /*
    定义方法，在方法中让Person去吃
        参数：Person
        返回值类型：void
     */
    public static void showEat(Person p){
        p.eat();
    }
}

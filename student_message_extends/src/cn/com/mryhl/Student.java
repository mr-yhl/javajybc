package cn.com.mryhl;

/*
学生类


对于学生来说，编号最好应该让系统自动维护。第一个创建的学生对象，编号是1,第二个创建的学生对象，编号是2...
我们可以定义一个计数器，该计数器用来记录学生对象的数量，每创建一个学生对象，就让这个计数器加1。
这个计数器需要让所有的学生对象共用一个，可以使用static去完成。被static修饰的东西属于类，不属于对象，可以被
该类的所有对象所共享，static修饰的东西只有一份
 */
public class Student extends Person {
    private static int count = 0;

    public Student() {
        // 创建对象时,让count自增

        super.setId(++count);
    }

    public Student(String name, String ssex, String birthday) {
        super(++count, name, ssex, birthday);
    }

    @Override
    public String work() {
        return "学习";
    }


}

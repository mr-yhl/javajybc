package cn.com.mryhl.demo02_class;
/*
* 学生类
*   属性:姓名,年龄
*   行为:学习,说话
* 在类中,属性称为成员变量,行为称为成员方法
* 成员变量,定义在方法外
* 成员方法:不带static关键字[描述现实事物的类的方法中,去掉static]
* */
public class Student {
    //定义成员变量,姓名
    String name;
    //定义成员变量,年龄
    int age;
    //定义一个学习的方法
    public void study(){
        System.out.println("好好学习,天天向上,为祖国实现伟大复兴做出贡献");
    }
    //定义说话的方法
    public void say(){
        System.out.println("好好说话");
    }

}

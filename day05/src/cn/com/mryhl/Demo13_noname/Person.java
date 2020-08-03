package cn.com.mryhl.Demo13_noname;
/*
如果把一个类定义在另一个类的里面,就是内部类
里面的类叫内部类,外面的类叫外部类
如果把一个类定义在另一个类的成员位置，那么这个类就是成员内部类
格式
public class 外部类{
    public class内部类{
    }
}
注意:
    1.其中内部类编译之后也会生成.class文件.名字为   外部类$内部类.class
    2.内部类可以访问外部类的成员
    3.外部类不能访问内部类的成员

 */
public class Person {
    int age = 18;
    //心脏类
    public class Heart{
        // 心房
        int heartRoom = 2;
        // 心跳
        public void jump(){
            System.out.println("心脏已正常跳到" + age + "年");
            System.out.println("心脏跳动");
        }
    }
}

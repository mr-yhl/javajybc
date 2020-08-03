package cn.com.mryhl.Demo13_noname;
/*
成员内部类的使用

在创建成员内部类对象时,需要创建外部类对象
格式:
    外部类.内部类 对象名 = new 外部类().new 内部类();
 */
public class Demo01NoName {
    public static void main(String[] args) {
        // 创建内部类对象
        Person.Heart heart = new Person().new Heart();
        System.out.println(heart.heartRoom);
        heart.jump();
    }
}

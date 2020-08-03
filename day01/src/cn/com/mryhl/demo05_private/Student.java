package cn.com.mryhl.demo05_private;

/*
学生类
    属性:姓名 年龄
    行为:show方法

private关键字:
1.private是一个权限修饰符,表示私有
2.可以修饰成员变量、方法
3.被private修饰成员只能在本类使用

如果某个属性使用private修饰了，那么这个属性就不能在外面使用了。这个属性如果完全不能在外面使用，一般来说也是不行的。
我们可以提供一些访问方式让外界去使用到这个私有的属性。
*/
public class Student {
    String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //判断年龄数据的合法行
        if (age >= 0 && age <= 200)
            this.age = age;
        else
            System.out.println("对不起,输入数据不合法");
    }

    public void show() {
        System.out.println("姓名:" + name + ",年龄:" + age);
    }
}

package cn.com.mryhl.demo04_Hash;
/*
哈希值就是一个int数字，我们可以把哈希值看成对象的标识，特征码
在object中，有一个方法叫做hashCode,可以获取对象的哈希值

int hashCode():获取对象的哈希值

Object中的hashCode方法，是根据对象的地址值计算获取的哈希值。

一般情况下，根据地址值计算哈希值，意义不大，更多的我们是希望根据属性值计算哈希值，如果两个对象的属性完全一样，那么他们的哈希值也应该相同.

如果要想自己定义哈希值的计算规则，我们可以对hashCode方法进行重写.

哈希值是对象的一个标识，但并不是唯一的标识，对象的哈希值允许重复。

 */

public class Demo01HashCode {
    public static void main(String[] args) {
        // 创建对象
        Person p = new Person("东方萨关",25);
        System.out.println(p.hashCode());//460141958
        Person p2 = new Person("东方萨关",25);
        System.out.println(p2.hashCode());//1163157884

    }
}

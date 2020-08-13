package cn.com.mryhl.demo03_enum;

public class Demo01Test {
    public static void main(String[] args) {
        //创建Person对象
        Person p = new Person();
        //调用set方法进行赋值
        p.setName("张三");
        p.setGender(Gender.BOY);
        //输出
        System.out.println(p);
    }
}
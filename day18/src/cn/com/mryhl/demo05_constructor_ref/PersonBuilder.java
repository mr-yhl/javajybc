package cn.com.mryhl.demo05_constructor_ref;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/12 16:37
 */
public interface PersonBuilder {
    //给我姓名和年龄，我就可以创建一个Person对象返回。
    Person createPerson(String name, int age);
}

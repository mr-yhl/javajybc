package cn.com.mryhl.demo01_collections;

import java.util.Comparator;
/*
Comparator
Tomparator这个接口表示比较器，当我们使用Rule类实现了这个接口，Rule表示也就是比较器。
*/
public class Rule implements Comparator<Student> {
    /*
    compare会在比较器排序时由系统自动调用,作用是比较两个对象谁大谁小

    如果方法的返回值是正数，表示第一个参数对象大于第二个参数对象（01大于02)
    如果方法的返回值是，表示两者相等
    如果方法的返回值是负数，表示第一个参数对象小于第二个参数对象（01小于02)

    公式：升序就是一减二
想要根据什么属性排序，就让什么属性相减
    */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}

package cn.com.mryhl.demo14_final;
/*
final修饰引用类型变量
 */
public class Demo02Test {
    public static void main(String[] args) {
        Student ss = new Student("时时彩", 24);
        System.out.println(ss.getName() + ss.getAge());
        // 修改对象
        ss.setName("df");
        ss.setAge(23);
        System.out.println(ss.getName() + ss.getAge());

    }

}

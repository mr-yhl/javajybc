package cn.com.mryhl_copy_ex.demo01_static;

public class Demo01StaticTest {;
    public static void main(String[] args) {
        // 通过类名调用静态的属性
        Student.school="中姓大学";//赋值
        //调用输出
        System.out.println(Student.school);//中姓大学
        Student.method();
        // 创建对象调用
        Student student = new Student();
        // 赋值
        student.name="小米";
        student.age=23;
        student.school="师范";
        // 通过对象调用
        System.out.println(student.name);//小米
        System.out.println(student.age);//23
        System.out.println(student.school);//师范
        // 创建第2个对象
        Student student1 = new Student();
        student1.name="小名";
        student1.age=26;
        System.out.println(student1.name);//小名
        System.out.println(student1.age);//26
        // 静态方法赋值后值不变,改变需要重写赋值
        System.out.println(student1.school);//师范
        // 本类调用静态方法
        ee();
    }
    public static void ee(){

    }
}

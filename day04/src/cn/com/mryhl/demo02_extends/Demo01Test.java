package cn.com.mryhl.demo02_extends;

public class Demo01Test {
    public static void main(String[] args) {
        // 创建教师类
        Teacher teacher = new Teacher();
        teacher.name="战神";
        teacher.age=19;
        System.out.println("姓名" + teacher.name + ",年龄" + teacher.age);
        teacher.teach();
    }
}

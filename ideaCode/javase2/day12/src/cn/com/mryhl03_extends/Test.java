package cn.com.mryhl03_extends;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "丹丹";
        s.age = 23;
        s.sleep();
        s.study();
        s.eat();
        Teacher teacher = new Teacher();
        teacher.name = "laoshi";
        teacher.age = 34;
        teacher.salary = 4567.77;
        teacher.sleep();
        teacher.teach();
        teacher.eat();

    }
}

package cn.com.mryhl02_StudentTest;

public class TestStudent {
    public static void main(String[] args) {
        Student s = new Student();
        s.id="10000";
        s.name="电信";
        s.age=15;
        System.out.println(s.id);
        System.out.println(s.name);
        System.out.println(s.age);
        s.eat();
        s.study("java");
    }
}

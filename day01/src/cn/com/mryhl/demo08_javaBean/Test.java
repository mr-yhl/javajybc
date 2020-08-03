package cn.com.mryhl.demo08_javaBean;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("佩奇", 10);
        System.out.println("姓名:" + student.getName() + ",年龄:" + student.getAge());
        Student student1 = new Student();
        student1.setName("乔治");
        student1.setAge(9);
        System.out.println("姓名:" + student1.getName() + ",年龄:" + student1.getAge());


    }
}

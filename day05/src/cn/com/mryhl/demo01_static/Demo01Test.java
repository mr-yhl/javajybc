package cn.com.mryhl.demo01_static;
/*
所有的学生的学校属性都相同，都是传智学院，那么此时其实就没有必要给每一个学生对象都分配一个学校属性了，这样就比较浪费了。
如果某个成员变量使用static关键字修饰，那么这个成员变量就不再属于对象了，属于类，会被该类所有的对象所共享，
 */

public class Demo01Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.name="李狗蛋";
        student.age=20;
        student.school="传智学院";
        System.out.println("姓名"+student.name+",年龄"+student.age+",学校"+student.school);
        Student student2 = new Student();
        student2.name="李蛋";
        student2.age=20;
        //student2.school="传智学院11";
        System.out.println("姓名"+student2.name+",年龄"+student2.age+",学校"+student2.school);
        Student student3 = new Student();
        student3.name="汪精卫";
        student3.age=20;
        //student3.school="传智学院22";
        System.out.println("姓名"+student3.name+",年龄"+student3.age+",学校"+student3.school);
        }
}

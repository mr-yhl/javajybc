package cn.com.mryhl.demo10_homework.t01;
/*

 */


import java.lang.reflect.Constructor;

public class StudentTest {
    public static void main(String[] args) throws Exception {
        Class forName = Class.forName("cn.com.mryhl.demo10_homework.t01.Student");
        Constructor c = forName.getConstructor(String.class, int.class);
        Object o = c.newInstance("柳岩",17);
        Student s = (Student) o;
        s.show();

    }
}

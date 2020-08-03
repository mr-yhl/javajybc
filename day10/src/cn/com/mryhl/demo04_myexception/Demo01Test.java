package cn.com.mryhl.demo04_myexception;

import java.util.Scanner;

/*

 */
public class Demo01Test {
    public static void main(String[] args) {
        try{
        Student student = createStudent();
        System.out.println(student);}
        catch (AgeException e){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    /*
        定义一个方法，该方法用来获取一个学生对象，学生的姓名和年龄来源于键盘录入
        并且必须保证年龄是正确的，如果年龄是非法的数字，那么我们就抛出异常
    */
    public static Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("键盘录入学生姓名");
        String s = scanner.nextLine();
        System.out.println("年龄");

        // 判断年龄是否合法,非法抛异常
        int i = Integer.parseInt(scanner.nextLine());
        if (i<0||i>200){
            throw new AgeException("年龄不合法");
        }


        Student student = new Student(s, i);
        return student;
    }
}

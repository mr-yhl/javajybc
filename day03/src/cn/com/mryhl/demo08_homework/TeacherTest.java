package cn.com.mryhl.demo08_homework;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherTest {

    public static void main(String[] args) {
        // 定义一个集合,保存TeacherClass对象
        ArrayList<TeacherClass> list = new ArrayList<>();
        // 在键盘上录入信息
        Scanner scanner = new Scanner(System.in);
        // 录入老师姓名、传授科目
        for (int i = 0; i < 4; i++) {
            System.out.println("请输入教师姓名");
            String name = scanner.nextLine();
            System.out.println("请输入传课科目");
            String subject = scanner.nextLine();
            // 创建教师对象
            TeacherClass test = new TeacherClass(name, subject);
            // 将教师对象添加到list中
            list.add(test);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("姓名："+list.get(i).getName()+"老师, 专业："+list.get(i).getSubject());
        }

    }
}

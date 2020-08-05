package cn.com.mryhl.demo08_homework.ti_ioliu;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Demo03StuTest {
    public static void main(String[] args) throws IOException {
        // 创建数组对象
        List<Student> stuList = new ArrayList<>();
        // 添加学生对象
        stuList.add(new Student("张三","男",20,80));
        stuList.add(new Student("李四","女",19,88));
        // 创建File对象
        Writer file = new FileWriter("student.txt");
        for (Student student : stuList) {
            file.write(student.toString()+"\r\n");
        }
        file.close();
    }
}

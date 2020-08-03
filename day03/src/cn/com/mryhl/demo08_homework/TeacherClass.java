package cn.com.mryhl.demo08_homework;
/*
请定义教师（Teacher）类，属性包含姓名和专业名称。
将若干教师对象存入ArrayList集合中，并遍历集合打印教师信息，格式如下：

姓名：果果老师, 专业：javase
姓名：张1老师, 专业：javaee
姓名：张2老师, 专业：php
姓名：张3老师, 专业：python
 */

public class TeacherClass {
    private String name;
    private String subject;

    public TeacherClass() {
    }

    public TeacherClass(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

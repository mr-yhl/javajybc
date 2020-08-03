package cn.com.mryhl.demo16_homework01;

public class UITeacher extends cn.com.mryhl.demo16_homework01.Employee implements cn.com.mryhl.demo16_homework01.Painting {
    @Override
    public void work() {
        System.out.println("教授设计知识");
    }

    @Override
    public void painting() {
        System.out.println("绘画中......");
    }
}

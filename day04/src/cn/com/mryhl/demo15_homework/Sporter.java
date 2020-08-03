package cn.com.mryhl.demo15_homework;

public class Sporter extends Human
{
    String classin;

    public Sporter() {
    }

    public Sporter(String id, String name, int age, String sex, String classin) {
        super(id, name, age, sex);
        this.classin = classin;
    }

    public String getClassin() {
        return classin;
    }

    public void setClassin(String classin) {
        this.classin = classin;
    }

    @Override
    public void eat() {
        System.out.println("吃营养餐");
    }
}

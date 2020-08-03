package cn.com.mryhl.demo16_homework01;
/*
定义员工类
属性:姓名,性别,年龄(私有)
行为:工作(抽象)
无惨,全参构造方法
get/set方法
 */
public abstract class Employee {
    private String name;
    private int age;
    private String ssex;

    public Employee() {
    }

    public Employee(String name, int age, String ssex) {
        this.name = name;
        this.age = age;
        this.ssex = ssex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
    public abstract void work();
}

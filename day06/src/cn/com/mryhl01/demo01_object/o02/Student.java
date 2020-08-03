package cn.com.mryhl01.demo01_object.o02;

public class Student {
    private String name;
    private String ssex;
    private int age;

    public Student() {
    }

    public Student(String name, String ssex, int age) {
        this.name = name;
        this.ssex = ssex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return ssex != null ? ssex.equals(student.ssex) : student.ssex == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ssex != null ? ssex.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}

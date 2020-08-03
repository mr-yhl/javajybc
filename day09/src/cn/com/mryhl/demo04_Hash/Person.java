package cn.com.mryhl.demo04_Hash;

public class Person {
    private String name;
    private int age;
    /*
    重写hashCode方法，自己定义哈希值的计算规则
    根号姓名和年龄计算哈希值，如对象的姓名和年龄相同，得到的哈希值也应该相同。

     */
    /*@Override
    public int hashCode() {
        // 获取姓名的哈希值再加上年龄就是对象的哈希值
        return this.name.hashCode()*31+age;
        // ×31是为了减少重复的可能性(31是科学计算的结果)
    }*/
    /*
    D1=new Person("张三",13);
    p2=new Person("李四",12);
    "张三",3      16
    "李四",4      16
     */


    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

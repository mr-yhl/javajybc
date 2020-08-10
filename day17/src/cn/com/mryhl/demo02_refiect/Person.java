package cn.com.mryhl.demo02_refiect;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 9:21
 */
public class Person {
    private String name;
    private int age;
    public void sleep(){
        System.out.println("睡觉");
    }
    public String eat(String food){
        System.out.println("吃" + food);
        return "饱了";
    }
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;

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
    public String
    toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

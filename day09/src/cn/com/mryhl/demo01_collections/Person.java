package cn.com.mryhl.demo01_collections;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    // 重写了Comparable的抽象方法
    /*

        使用自然排序时，内部会自动调用compareTo方法比较两个对象谁打谁小
        在使用自然排序时，内部会自动调用compareTo方法比较两个对象谁打谁小
        如果方法的返回值是正数，表示调用者对象大于参数对象
        如果方法的返回值是，相等
        如果方法的返回值是负数，表示调用者小于参数对象
        我们要做的是在compareTo定义排序规则。
        公式：升序就是我（调用者）减他（参数）。
        想要根据对象的什么属性进行排序，就让什么属性相减。
    */
    @Override
    public int compareTo(Person o) {
        // 根据age升序

        return this.age-o.age;
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

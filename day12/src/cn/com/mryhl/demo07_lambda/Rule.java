package cn.com.mryhl.demo07_lambda;

import java.util.Comparator;

public class Rule implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
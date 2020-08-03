package cn.com.mryhl.demo09_homework.work01;
/*
 请定义一个Collection类型的集合，存储以下字符串：

​              “JavaEE企业级开发指南”，”Oracle高级编程”，”MySQL从入门到精通”，

​              ”Java架构师之路”

​       请编程实现以下功能：

Ø  使用迭代器遍历所有元素，并打印

Ø  使用迭代器遍历所有元素，筛选书名小于10个字符的，并打印；

Ø  使用迭代器遍历所有元素，筛选书名中包含“Java”的，并打印

Ø  如果书名中包含“Oracle”，则删掉此书。删掉后，遍历集合，打印所有书名。
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01Collection {
    public static void main(String[] args) {
        // 创建Collection的集合
        Collection<String> slist = new ArrayList<>();
        //添加元素
        slist.add("JavaEE企业级开发指南");
        slist.add("Oracle高级编程");
        slist.add("MySQL从入门到精通");
        slist.add("Java架构师之路");
        // 使用迭代器遍历所有元素，并打印
        Iterator<String> iterator = slist.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        //使用迭代器遍历所有元素，筛选书名小于10个字符的，并打印；
        System.out.println("================");
        iterator = slist.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.length()<10)
                System.out.println(s);
        }
        System.out.println("===========");
        // 使用迭代器遍历所有元素，筛选书名中包含“Java”的，并打印
        iterator = slist.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.contains("Java"))
                System.out.println(s);
        }
        System.out.println("===========");
        // 如果书名中包含“Oracle”，则删掉此书。删掉后，遍历集合，打印所有书名。
        iterator = slist.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.contains("Oracle"))
                //注意此处不要使用slist.remove(s); 会有异常的风险，而应该使用迭代器的remove()方法
                iterator.remove();
            else
                System.out.println(s);
        }


    }
}

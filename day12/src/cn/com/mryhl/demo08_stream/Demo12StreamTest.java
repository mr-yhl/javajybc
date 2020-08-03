package cn.com.mryhl.demo08_stream;


/*
    现在有两个ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）
    依次进行以下若干操作步骤：
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 根据姓名创建Person 对象；
        7. 打印整个队伍的Person对象信息。
 */

import java.util.ArrayList;
import java.util.List;

public class Demo12StreamTest {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        one.add("欧阳锋");
        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");
        //1. 第一个队伍只要名字为3个字的成员姓名；
        List<String> oneA = new ArrayList<>();
        //遍历one，拿到每一个元素判断名字是否是三个字，如果是，就添加到oneA中
        for (String s : one) {
            if (s.length() == 3) {
                oneA.add(s);
            }
        }
        //2. 第一个队伍筛选之后只要前3个人；
        List<String> oneB = new ArrayList<>();
        //遍历oneA，只获取前三个元素添加到oneB
        for (int i = 0; i < 3; i++) {//0 1 2
            //获取元素
            String str = oneA.get(i);
            //添加到oneB中
            oneB.add(str);
        }
        //3. 第二个队伍只要姓张的成员姓名；
        List<String> twoA = new ArrayList<>();
        //遍历two，拿到里面的每一个元素，判断是否姓张，如果姓张，就添加到twoA集合
        for (String str : two) {
            if (str.startsWith("张")) {
                twoA.add(str);
            }
        }
        //4. 第二个队伍筛选之后不要前2个人；
        List<String> twoB = new ArrayList<>();
        //遍历twoA，跳过前两个元素，拿到后面的每一个元素添加到twoB
        for (int i = 2; i < twoA.size(); i++) {
            String str = twoA.get(i);
            twoB.add(str);
        }

        //5. 将两个队伍合并为一个队伍；
        List<String> totalList = new ArrayList<>();
        totalList.addAll(oneB);//将oneB中的所有的元素添加到totalList中。
        totalList.addAll(twoB);//将twoB中的所有的元素添加到totalList中

        //6. 根据姓名创建Person 对象；
        //将totalList中的每一个字符串姓名变成Person对象保存【映射】到新的集合
        List<Person> personList = new ArrayList<>();
        //遍历totalList集合，拿到每一个姓名，根据姓名创建Person对象，添加到personList集合
        for (String name : totalList) {
            personList.add(new Person(name));
        }

        //7. 遍历打印整个队伍的Person对象信息。
        for (Person person : personList) {
            System.out.println(person);
        }

    }

}

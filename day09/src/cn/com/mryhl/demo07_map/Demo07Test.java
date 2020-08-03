package cn.com.mryhl.demo07_map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
练习：键盘录入一个字符串，统计该字符串中每一个字符出现的次数

    举例： 键盘录入了aabbbc   a:2 b:3 c:1

    思路：
        1. 键盘录入一个字符串。
        2. 定义Map集合当做计数器，key是字符，value是该字符出现的次数
        3. 遍历字符串，拿到字符串中的每一个字符。
        4. 判断遍历到的字符在Map集合中是否存在。
           如果Map集合中包含该字符，说明之前统计过，那么获取该字符出现的次数，将次数加1，重新放回到集合中。
           如果Map集合中不包含该字符，说明之前没有统计过，那么就将该字符添加到Map集合中，将次数设置为1.

        5. 遍历Map集合，输出结果
 */
public class Demo07Test {
    public static void main(String[] args) {
        // 1. 键盘录入一个字符串。
        Scanner sc = new Scanner(System.in);
        System.out.println("亲输入一个要统计的字符串");
        String s = sc.nextLine();
        // 2. 定义Map集合当做计数器，key是字符，value是该字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        // 3. 遍历字符串，拿到字符串中的每一个字符。
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 判断遍历到的字符在Map集合中是否存在。
            /*if (map.containsKey(ch)) {
                // 如果Map集合中包含该字符，说明之前统计过，那么获取该字符出现的次数，将次数加1，重新放回到集合中。
                Integer integer = map.get(ch);
                map.put(ch,integer+1);
            }else {
                // 如果Map集合中不包含该字符，说明之前没有统计过，那么就将该字符添加到Map集合中，将次数设置为1.
                map.put(ch,1);

            }*/
            // 三元运算符
            map.put(ch,map.containsKey(ch)?map.get(ch)+1:1);
        }
        // 遍历输出
        // 获取Map集合中所有的键
        Set<Character> keySet = map.keySet();
        for (Character character : keySet) {
            Integer count = map.get(character);
            System.out.println(character + ":" + count);

        }
    }
}

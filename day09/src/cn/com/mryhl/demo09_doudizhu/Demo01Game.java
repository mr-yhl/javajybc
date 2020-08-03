package cn.com.mryhl.demo09_doudizhu;

import java.util.*;

/*
我们昨天学习的斗地主是在使用ArrayList<String>保存扑克牌，
里面的扑克牌都是♥3,♦2,♠5.这样特殊的字符串是无法进行排序的。
数字是可以直接进行排序的，那么我们就可以使用数字去表示每张扑克牌。
我们可以给每张扑克牌都定义一个数字编号，使用该编号表示对应的扑克牌，
让能力值越小的牌，编号也就越小，将来洗牌，发牌操作，直接对编号进行操作。如果要进行看牌，
我们还是要看到真正的扑克牌的，所以我们可以定义一个Map集合，用来保存每个编号以及牌的对应关系【可以看成字典】，
在看牌时，可以根据编号找到对应的牌，然后进行展示。

步骤：
1.准备牌
    a.定义List集合，保存扑克牌的编号
    b.定义Map集合，用来保存编号和牌的对应关系
    c.向List集合中添加编号，向Map中添加对应关系
2.洗牌
    操作的是编号
    直接打乱编号的顺序
3.发牌
    发牌的逻辑和昨天写的一样
    区别在于，今天真正发给玩家的是扑克牌的编号
4.看牌
    看牌我们真正希望看到的是扑克牌本身而不是满
    所以在看牌时，我们可以根据编号去Map集合中找到对应的扑克牌然后进行输出。
    步骤:
        a.定义方法，用来看牌
        b.先对玩家手中的编号进行排序。
        c.输出玩家姓名
d.遍历玩家手中的编号，拿到每一个编号，去Map集合中找到该编号对应的牌，进行输出
 */
@SuppressWarnings("all")//注解，该注解用来抑制警告
public class Demo01Game {
    public static void main(String[] args) {
        // 1.准备牌
        // a.定义List集合，保存扑克牌的编号
        List<Integer> poker = new ArrayList<>();
        // b.定义Map集合，用来保存编号和牌的对应关系
        Map<Integer, String> map = new HashMap<>();
        // c.向List集合中添加编号，向Map中添加对应关系
        // 定义数组保存花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 定义数组保存点数
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 编号
        int index = 0;
        //向List集合中添加编号，向Map中添加对应关系，使用族套循环遍历两个数组去实现
        for (String num : nums) {
            for (String color : colors) {
                // 添加编号
                poker.add(index);
                // 添加对应关系
                map.put(index,color+num);
                // 编号自增
                index++;
            }
        }
        // 添加大小王
        poker.add(index);
        map.put(index,"小王");
        index++;
        poker.add(index);
        map.put(index,"大王");
        // System.out.println(poker);
        // System.out.println(map);
        // 2.洗牌
        //         操作的是编号
        // 直接打乱编号的顺序
        Collections.shuffle(poker);
        //System.out.println(poker);
        // 3.发牌
        //         发牌的逻辑和昨天写的一样
        // 区别在于，今天真正发给玩家的是扑克牌的编号
        // 定义三个集合，用来保存三个玩家手里的牌【真正保存的是扑克牌的编号】
        List<Integer> play1 = new ArrayList<>();
        List<Integer> play2 = new ArrayList<>();
        List<Integer> play3 = new ArrayList<>();
        // 定义一个集合放底牌
        List<Integer> dp = new ArrayList<>();
        // 遍历保存扑克牌【编号】的集合，拿到每一张牌【编号】，根据牌【编号】在集合中的索引进行发牌。
        for (int i = 0; i <poker.size() ; i++) {
            Integer card = poker.get(i);
            // 根据索引发牌
            if (i>50){
                dp.add(card);
                continue;
            }
            if (i%3==0)
                play1.add(card);
            else if (i%3==1)
                play2.add(card);
            else
                play3.add(card);
        }
        // 看牌
        lookCard("舒嘏",play1,map);
        lookCard("何煞",play2,map);
        lookCard("何萨关",play3,map);
        lookCard("底牌",dp,map);


    }
    /*
    看牌方法
    参数：String name【玩家姓名】，List<Integer>List【玩家手中编号】，Map<Integer,String>map【字典】
    返回值:void
     */
    public static void lookCard(String name,List<Integer> list,Map<Integer,String> map){
        Collections.sort(list);
        System.out.print(name + " ");
        for (Integer id : list) {
            String s = map.get(id);
            System.out.print(s + " ");
        }
        System.out.println();

    }
}

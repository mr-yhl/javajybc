package cn.com.mryhl.demo08_game;
/*
斗地主小游戏
步骤：
1.准备牌
    a.创建一个集合,保存扑克牌
    b.向集合中添加54张牌
2.洗牌
    洗牌计算打乱集合顺序
    如果要打乱顺序，我们可以使用集合的工具类Collections中的shuffle方法完成。
    static void shuffle(List<?>List):随机打乱集合中元素的顺序。
3.发牌
    a.定义三个集合,保存三个玩家的牌
    b.定义一个集合保存底牌
    c.开始发牌
        i.遍历集合,拿到集合中发每一张pai
        ii.判断索引,根据集合中的索引进行发牌
            将索引为0,3,6...的牌发给第一个玩家【索引对3取余结果是，发给第一个玩家】
            将索引为1,4,7...的牌发给第二个玩家【索引对3取余结果是1,发给第二个玩家
            将素引为2,5,8...的牌发给第三个玩家【索引对3取余结果是2,发给第三个玩家】
4.看牌

 */

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Demo01Game {
    public static void main(String[] args) {
        // 1.准备牌
        // a.创建一个集合,保存扑克牌
        List<String> poker = new ArrayList<>();
        // b.向集合中添加54张牌
        //定义数组保存花色
        String[] colors = {"♠","♥","♣","♦"};
        String[] nums={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //使用循环遍历两个数组
        for (String num:nums) {
            for (String color:colors){
                // 将遍历的花色和点数进行拼接,在添加的集合中
                poker.add(color+num);
            }
        }
        // 添加大小王
        poker.add("🃏D");
        poker.add("🃏X");

        // System.out.println(poker);
        // 2.洗牌
        Collections.shuffle(poker);//随机打乱
        // System.out.println(poker);
        // a.定义三个集合,保存三个玩家的牌
        List<String> playOne = new ArrayList<>();
        List<String> playTwo = new ArrayList<>();
        List<String> playThree = new ArrayList<>();
        // b.定义一个集合保存底牌
        List<String> dipai = new ArrayList<>();
        // c.开始发牌
        // i.遍历集合,拿到集合中发每一张pai
        // ii.判断索引,根据集合中的索引进行发牌
        for (int i = 0; i < poker.size(); i++) {
            String card = poker.get(i);
            //给玩家发牌之前做一个判断，如果是最后三张牌了，就添加到底牌集合
            //最后三张牌的索引是53,52,51,如果索引大于等于51
            if (i>=51){
                dipai.add(card);
                continue;
            }

            if (i%3==0)
                playOne.add(card);
            else if (i%3==1)
                playTwo.add(card);
            else
                playThree.add(card);
        }
        // 看牌
        /*System.out.println(playOne);
        System.out.println(playTwo);
        System.out.println(playThree);*/
        lookCard("冯黛皋",playOne);
        lookCard("龚煞",playTwo);
        lookCard("公孙耒",playThree);
        lookCard("底牌",dipai);
    }
    /*
    * 定义一个方法,用来看牌
    *   参数:String(玩家姓名),List<String>(pai)
    *   返回值:void
    *  */
    public static void lookCard(String name,List<String> list){
        //输出姓名
        System.out.print(name+":");
        for (String s : list) {
            System.out.print(s + " ");

        }
        System.out.println();
    }
}

package cn.com.mryhl;
       /* 世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，假如我有一张足够大的纸，它的厚
        度是0.1毫米。请问，我折叠多少次，可以折的比珠峰还要高   ;
        参考步骤:
        1. 定义变量，表示折纸次数。
        2. 定义变量表示纸的厚度。
        3. 使用循环进行折纸（建议while循环）*/
public class Everest {
       public static void main(String[] args) {
           double parper = 0.1;
           int count=0;
           while (parper < 8844430){
               parper*=2;
               count++;
           }
           System.out.println("需要折叠"+count+"次,才能和珠峰高度相同");
       }
}

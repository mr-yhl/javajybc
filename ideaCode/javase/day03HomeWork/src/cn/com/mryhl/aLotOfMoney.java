package cn.com.mryhl;

/*
红茶妹妹有21元钱，她攒了几天钱之后自己的钱比原来的两倍还多三块。
绿茶妹妹有24元钱，她攒了几天钱之后自己的钱正好是原来的两倍。
那么红茶和绿茶现在的钱一样多，请问对么？请编写程序进行判断。
*/
public class aLotOfMoney {
    public static void main(String[] args) {
        int BlackTeaSister, GreenTeaSister;
        BlackTeaSister = 21 * 2 + 3;
        GreenTeaSister = 24 * 2;
        boolean bl = BlackTeaSister == GreenTeaSister ? true : false;
        System.out.println("They have the same money:" + bl);
        System.out.println('a'>20);
        int a=2,b=3;
        System.out.println((++a)==b);
        int i = 128,j=130;
        i = (i>j?128:130);
        j = (i<j?128:130);
        System.out.println("i:"+i+"j:"+j);

    }

}

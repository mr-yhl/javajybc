package cn.com.mryhl;
/*
某小伙想定一份外卖,商家的优惠方式如下:
鱼香肉丝单点24元,油炸花生米单点8元,米饭单点3元。
订单满30元8折优惠。
鱼香肉丝优惠价16元,但是优惠价和折扣不能同时使用,
那么这个小伙要点这三样东西,
最少要花多少钱?请编写程序计算。
*/
public class calcuThePrice {
    public static void main(String[] args) {
        int FishFlaPork=24,FriedPeanuts=8,Rice=3,FishFlaPorkYH=16;
        int CommoPrice1 = FishFlaPork+FriedPeanuts+Rice;
        double CommoPrice2 = CommoPrice1 > 30 ? CommoPrice1 * 0.8 : CommoPrice1;
        CommoPrice1 = FishFlaPorkYH+FriedPeanuts+Rice;
        CommoPrice2 = CommoPrice1 > CommoPrice2 ? CommoPrice2 * 0.8 : CommoPrice1;
        System.out.println("所需最少金额为"+CommoPrice2);
    }
}

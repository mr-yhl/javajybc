package cn.com.mryhl01;
/*
需求：
在控制台打印出1-100之间的满足逢七必过规则（数字包含7或者是7的倍数）的数据，以及总个数。
逢七必过规则（数字num包含7或者是7的倍数）:(个位==7或者十位==7)或者（num%7==0)
*/
public class Demo04F7G {
    public static void main(String[] args) {
        int count=0;
        for (int num = 1; num <=100 ; num++) {
            if(num%7==0 ||num%10==7 || num/10%10==7){
                count++;
                System.out.println(num);
            }
           
        }
        System.out.println(count);
    }
}

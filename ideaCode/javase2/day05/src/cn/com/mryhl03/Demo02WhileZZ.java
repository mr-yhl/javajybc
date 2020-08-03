package cn.com.mryhl03;
/*世界最高山峰是珠穆朗玛峰（8844.43米=8844430毫米）,
假如我有一张足够大的纸，它的厚度是0.1毫米。
请问，我折叠多少次，可以折成珠穆朗玛峰的高度？*/
public class Demo02WhileZZ {
    public static void main(String[] args) {
        double parper = 0.1;
        int count=0;
        while (parper < 8844430){
            parper*=2;
            count++;
            System.out.println("第"+count+"次折叠后,纸张的厚度"+parper);
        }
        System.out.println("需要折叠"+count+"次,才能和珠峰高度相同");
        System.out.println("折叠"+count+"次最终纸张高度:"+parper);
    }
}

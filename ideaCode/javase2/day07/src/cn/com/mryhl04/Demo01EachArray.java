package cn.com.mryhl04;
//数组的遍历
public class Demo01EachArray {
    public static void main(String[] args) {
        int[] arry={100,200,300};
        System.out.println(arry[0]);
        System.out.println(arry[1]);
        System.out.println(arry[2]);
        System.out.println("-----------");
        //循环遍历
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }
}

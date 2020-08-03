package cn.com.mryhl03;

//数组使用
public class Demo01UseArray {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        System.out.println(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        array[0]=100;
        array[1]=200;
        array[2]=300;
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        int count = array.length;
        System.out.println(count);
    }
}

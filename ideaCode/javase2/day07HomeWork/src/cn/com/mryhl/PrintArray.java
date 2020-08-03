package cn.com.mryhl;
/*请使用静态初始化的方式,创建一个长度为5的整数数组,
并为数组中的元素赋值,遍历数组,在同一行打印所有元素,
元素之间用空格隔开,比如:如果数组为{1,2,3,4,5}打印结果:1 2 3 4 5*/
public class PrintArray {
    public static void main(String[] args) {
        int[] array = new int[5];
        array = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
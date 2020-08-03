package cn.com.mryhl;
/*请定义一个方法，实现交换整数数组中两个索引上的元素值。并调用方法，查看运行效果。
例如，数组为{11, 22, 33, 44, 55, 66}，
交换索引1和索引5位置上的元素，
结果为{11, 66, 33, 44, 55, 22}*/
public class Demo03SwapArray {
    public static void main(String[] args) {
        int[] array={11, 22, 33, 44, 55, 66};
        System.out.println("原数组为:");
        printArray(array);
        swapArray(array);
        System.out.println("交换后的数组为:");
        printArray(array);
    }
    public static void swapArray(int[] array){
        int temp;
        temp = array[array.length-1];
        array[array.length-1]=array[array.length-3];
        array[array.length-3]=temp;
    }
    public static void printArray(int[] array){
        System.out.print("{");
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]);
            if(i==array.length-1)
                break;
            System.out.print(",");
        }
        System.out.println("}");
    }

}

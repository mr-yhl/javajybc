package cn.com.mryhl03;
/*已知一个数组 arr = {1, 2, 3, 4, 5};
用程序实现把数组中的元素值交换，
交换后的数组 arr = {5, 4, 3, 2, 1};
并在控制台输出交换后的数组元素。*/
public class Demo02MethodArrayjh {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5,6};
        System.out.println("原数组为");
        printArray(array);
        exchangeArray(array);
        System.out.println("交换后数组为");
        printArray(array);
    }
    public static void printArray(int[] array){
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i!=array.length-1)
                System.out.print(",");
        }
        System.out.println("}");
    }
    public static void exchangeArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            if (i>array.length-1-i)
                return;
            int temp = array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;

        }
    }
}

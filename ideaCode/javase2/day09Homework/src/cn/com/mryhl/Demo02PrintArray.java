package cn.com.mryhl;
/*请定义一个方法，该方法可以实现对int类型的数组进行遍历，在控制台打印所有元素。
实现方法后，请在主方法中调用方法，查看结果。
例如，
数组为{11, 22, 33}，
打印格式为：[11, 22, 33]
*/
public class Demo02PrintArray {
    public static void main(String[] args) {
        int[] array = {11,22,33};
        printArray(array);
    }
    public static void printArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]);
            if(i==array.length-1)
                break;
            System.out.print(",");
        }
        System.out.println("]");
    }
}

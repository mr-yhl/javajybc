package cn.com.mryhl03;
/*需求：
设计一个方法用于获取int数组中元素的最大值
举例：
原数组：(11,22,33,44,55)
最大值：55
设计一个方法用于获取int数组中元素的最大值
getArrayMax方法内部的实现步骤：
1.假设索引为0的元素是最大的，保存到int变量max中
2.使用for循环依次获取后面的（从素引1开始）每个元素
2.1如果当前元素值大于max,说明max中的元素已经不是最大的了
2.2把当前元素值，赋值给max
3.for循环结束后，返回max
*/
public class Demo03PrintMax {
    public static void main(String[] args) {
        int[] array = {11,22,33,44,55};
        System.out.println("原数组为:");
        printArray(array);
        System.out.println("最大值是"+getArrayMax(array));
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
    public static int getArrayMax(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max)
                max = array[i];
        }
        return max;
    }
}

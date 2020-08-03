package cn.com.mryhl03;

import java.util.Scanner;

/*已知一个数组arr=(19,28,37,46,50);
        健盘录入一个数据，查找该数据在数组中的索引
        并在控制台输出找到的索引值。如果没有查找到，则输出-1*/
public class Demo01MethodSy {
    public static void main(String[] args) {
        int[] array = {19,28,37,46,50};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的数据");
        int value = scanner.nextInt();
        int result = findElements(array,value);
        if(result==-1)
            System.out.println("这个元素在该数组中不存在");
        else
            System.out.println("这个元素在数组中第一次出现的索引为" + result);

    }
    public static int findElements(int[] array,int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==value)
                return i;
        }
        return -1;
    }
}

package cn.com.mryhl.demo02_search;

import java.util.Arrays;

public class Demo01Search {
    public static void main(String[] args) {
        // 定义有序数组
        int[] arr = {2,45,67,78,82,85,99};
        // 调用二分查找的方法,查找 82
        System.out.println("82的索引为:"+binarySearch(arr, 82));
        System.out.println(Arrays.binarySearch(arr, 85));
    }
    /*
    定义方法，该方法用来进行二分查找，查找某个元素在数组中的素引。
        参数：int[]arr【要在哪个数组中查找】，int value【要查找的元素】
        返回值：int【查找出的读元素的索引】
    注意,不存在返回-1
     */
    public static int binarySearch(int[] arr,int value){
        // 定义两个遍历表示光标,一个指向数组的左边一个指向右边
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        //循环执行,进行二分查找
        while (left<=right){
            mid = (left+right)/2;
            if (value > arr[mid])
                left = mid + 1;
            else if(value < arr[mid])
                right = mid - 1;
            else
                return mid;
        }
        //if (left>right)
        return -1;
    }
}

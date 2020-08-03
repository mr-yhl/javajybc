<center>快速排序</center>

把一个数当做基准数，一般会把数组中最左边的数当做基准数。然后从数组两边进行检索，先从右往左检索比基准数小的，再从左往右检索比基准数大的。如果检索到，就停下，然后交换这两个元素。交换完成之后，再继续检索。先由j从右往左检索比基准数小的。再由认左往右检索比基准数大的。如果和相遇，就停止检索。然后把相遇位置的元素和基准数位置的元素进行交换，此时第一轮排序就完成了。以同样的方式对基准数左边进行排序。再以同样的方式对基准数右边进行排序。

![](https://p.pstatp.com/origin/ffe50001b6bae14a4b4c)

```java
import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = new int[1000000];
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}
		//开始时间
		long start = System.currentTimeMillis();
		quickSort(arr);
		//结束时间
		long end = System.currentTimeMillis();
//		System.out.println(Arrays.toString(arr));
		System.out.println(end - start);
	}
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	/**
	 * 
	 * @param arr 要排序的数组
	 * @param left 从左边哪个开始拍
	 * @param right 要排到右边的哪一位
	 */
	public static void quickSort(int[] arr, int left, int right) { 
		if(left > right) {
			return;
		}
		//定义基准数  和 i 和 j
		int base = arr[left];
		//i从最左边开始
		int i = left;
		//j从最右边开始
		int j = right;
		//只要i和j不相遇，就一直检索
		while(i != j) {
			//如果j检索到的数比基准数大，就一直检索
			while(arr[j] >= base && i < j) {
				j--;
			}
			//检索i
			while(arr[i] <= base && i < j) {
				i++;
			}
			if(i < j) {
				//交换i和j位置上的数
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//代码能走到这里，代表i和j相遇。
		//把相遇位置的数和基准数交换
		int temp = arr[i];
		arr[i] = arr[left];
		arr[left] =temp;
		//排基准数左边
		quickSort(arr, left, i - 1);
		//排基准数右边
		quickSort(arr, j + 1, right);
	}
}

```


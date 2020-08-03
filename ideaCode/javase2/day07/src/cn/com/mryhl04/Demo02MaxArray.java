package cn.com.mryhl04;

/*需求：
数组元素最大值
实现步服：
1.定义int数组array,并初始化
2.假设素引为0的元素是最大的，保存到int变量max中
3.使用for循环获取后面的（从索引1开始）每个元素
3.1如果当前元素值大于max说明max中的值已经不是最大的了
3.2把当前元素值赋值给ma
4.for循环结束打印max的值
*/
public class Demo02MaxArray {
    public static void main(String[] args) {
        int max;//保存最大值
        int[] array = {5, 15, 2000, 10000, 100, 4000};
        max = array[0];//将以一个数赋值给max
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max)
                max=array[i];

        }
        System.out.println("数组元素最大值为:"+max);
    }
}

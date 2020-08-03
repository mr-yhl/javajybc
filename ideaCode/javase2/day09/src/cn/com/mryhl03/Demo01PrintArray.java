package cn.com.mryhl03;
/*需求（先不定义方法）:
完成数组的遍历（打印数组元素）,要求遍历的结果是在一行上的。
例如：[11,22,33,44,55]
举例：
原数组：(11,22,33,44,55)
打印格式：[11,22,33,44,55]
实现步骤：
1.定义int数组array,并初始化
2.打印“[”，不换行
3.使用for循环变量数组
3.1打印数组当前元素，不换行
4.打印“]”，可以换行也可以不换行
*/
public class Demo01PrintArray {
    public static void main(String[] args) {
        int[] array = {11,22,33,44,55};
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

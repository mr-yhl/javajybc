package cn.com.mryhlDn.demo03StringBuilder;
/*
字符串拼接
    定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，
    拼接格式： [11, 22, 33, 44, 55]
 */

public class Demo05StringBuilderTest {
    public static void main(String[] args) {
        int[] arr= {11,22,33,44,55};
        String s = arrayToString(arr);
        System.out.println("拼接后:"+s);

    }
    /*
    定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，
    参数: int[]
    返回值:字符串
     */
    public static String arrayToString(int[] arr){
        /*
        将arr数组中的内容转换成字符串并返回
        步骤:
            创建StringBuilder用来拼接
            拼接左半边的中括号
            遍历数组,拿到数组元素
            将遍历到的元素拼接到StringBuilder上
            判断遍历到的是否是最后一个元素,输出逗号
            拼接右边中括号
            转换成String返回
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            if(i<arr.length-1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        String s = stringBuilder.toString();
        return s;
    }
}

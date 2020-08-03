import java.util.Random;

/*定义返回值类型为int类型，名为 getScore(int[] arr)的静态方法，
方法内完成：获取指定数组arr中大于平均值的元素的个数，并返回
        定义main方法，方法内完成：
        1）.定义一个长度为5的int数组arr
        2）.使用随机数生成5个范围为1-99的数字存入arr中（包含1和99），之后打印数组
        3）.传递arr调用getScore(int[] arr)方法，获取方法返回值并在控制台打印输出该返回值
        */
public class Test03 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println("生成的数组为:");
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(99)+1;
            System.out.print(arr[i]);
            if(i!=arr.length-1)
                System.out.print(',');
        }
        System.out.println();
        int count=getScore(arr);
        System.out.println("大于平均值的数字个数为:" + count);

    }
    public static int getScore(int[] arr){
        int count=0,sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        double avg = sum/arr.length;
        System.out.println(avg);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>avg)
                count++;
        }
        return count;
    }
}

package cn.com.mryhl02;
/*案例需求
        有这样的一个数组，元素是{68,27,95,88,171,996,51,210}。
        打印该数组中满足要求的元素，满足要求的元素和以及总个数
        要求是：求和/计数的元素个位和十位都不能是7,并且只能是偶数
        假如数组元素是array[i]:
        */
public class Demo01ArraySum {
    public static void main(String[] args) {
        // 1.定义int数组array,并根据题目需求进行初始化
        int[] array={68,27,95,88,171,996,51,210};
        // 2.定义int变量sum,初始值，用来累加满足条件的元素的和
        int sum = 0;
        // 3.定义int变量count,初始值0,用来统计满足条件的元素的个数
        int count = 0;
        // 4.使用for循环遍历数组
        for (int i = 0; i <array.length ; i++) {
            int num = array[i];
            // 4.1计算数组当前元素的个位和十位，分别保存到int变量ge和shi中
            int ge = num % 10;
            int shi = num /10% 10;
            // 4.2判断如果数组当前元素的个位和十位都不是7而且该元素是偶数，说明是满足条件的元素
            if(ge!=7&&shi!=7&&num%2==0){
            // 4.2.1把满足条件的元素累加求和到sum变量中
                sum+=num;
            // 4.2.2打印满足条件的元素
                System.out.println(num);
            // 4.2.3计数器count的值增加
                count++;
            }
        }
        // 5.for循环结束后，打印求和变量sum和计数变量count的值
        System.out.println("和"+sum);
        System.out.println(count);
    }
}

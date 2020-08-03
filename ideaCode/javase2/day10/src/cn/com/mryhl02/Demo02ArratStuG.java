package cn.com.mryhl02;

import java.util.Random;
import java.util.Scanner;

/*数组统计学生成绩
案例需求
1.键盘录入班级人数
2.根据录入的班级人数创建数组
3.利用随机数产生0-100的成绩（包含0和100)
4.要求
(1)打印该班级的不及格人数
(2)打印该班级所有学生的平均分
(3)演示格式如下：
请输入班级人数：
键盘录入：100
控制台输出：
不及格人数：19
班级平均分：87
        */
public class Demo02ArratStuG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入本班学生人数");
        int stuNum = scanner.nextInt();
        int[] array = new int[stuNum];
        Random random = new Random();
        int count=0;
        double sum = 0;
        for (int i = 0; i < stuNum; i++) {
            array[i]=random.nextInt(101);
            sum +=array[i];
            if (array[i]<60)
                count++;

        }
        sum/=stuNum;
        System.out.println("不及格人数：" + count);
        System.out.println("班级平均分：" + sum);
        if (sum<60)
            System.out.println("这个班级整体较差");
        else if(sum<80)
            System.out.println("这个班级比较一般");
        else
            System.out.println("这个班级很优秀");


    }
}

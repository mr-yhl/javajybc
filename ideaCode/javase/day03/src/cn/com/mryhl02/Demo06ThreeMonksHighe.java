package cn.com.mryhl02;

public class Demo06ThreeMonksHighe {
    public static void main(String[] args) {
        /*
         一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm,
         请用程序实现获取这三个和尚的最高身高。
        实现步骤：
        1.定义3个int变量h1,h2,h3,分别代表三个和尚的身高，并根据题目需求进行初始化
        2.使用三元运算符获取h1和h2的最大身高，保存到int变量temp中
        3.使用三元运算符获取temp和h3的最大身高，保存到int变量max中
        4.打印max的值
         */
        int h1= 150,h2=210,h3=165;
        int temp=(h1>h2)?h1:h2;
        int max=h3>temp?h3:temp;
        System.out.println("三个和尚的最大身高为"+max+"厘米");

    }
}

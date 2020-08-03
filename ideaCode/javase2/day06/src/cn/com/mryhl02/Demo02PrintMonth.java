package cn.com.mryhl02;

//使用嵌套循环，打印2021年至2023年月份，格式：xxxx年x月
public class Demo02PrintMonth {
    public static void main(String[] args) {
        for (int i = 2021; i <= 2023; i++) {
            for (int j = 1; j <= 12 ; j++) {
                System.out.println(i+"年"+j+"月");
            }

        }
    }
}

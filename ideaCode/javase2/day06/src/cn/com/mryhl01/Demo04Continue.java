package cn.com.mryhl01;

public class Demo04Continue {
    public static void main(String[] args) {
        for (int i = 1; i <= 10 ; i++) {
            /*
            当i的值是5时,if后面()是true,执行语句continue,结束本次循环
            */
            if (i%5==0){

                continue;
            }
            System.out.println("helloworld........."+i);
        }
        System.out.println("main.........end........");
    }
}

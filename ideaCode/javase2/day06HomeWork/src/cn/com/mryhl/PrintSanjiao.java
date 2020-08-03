package cn.com.mryhl;
/*有一个输出语句System.out.print("@")。使用这个语句，在控制台打印出一个五行的三角形，效果如下：
        ​	@
​	@@
​	@@@
​	@@@@
​	@@@@@*/
public class PrintSanjiao {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("@");

            }
            System.out.println("@");
        }
    }
}

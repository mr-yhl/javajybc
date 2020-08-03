package cn.com.mryhl;
/*有一个输出语句System.out.print("@"),表示输出一个"@",
并且不换行,
使用这个语句,在控制台打印出一个四行五列的长方形,效果如下:
@@@@@
@@@@@
@@@@@
@@@@@
*/


public class PrintAT {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                System.out.print("@");
            }
            System.out.println("@");
        }
    }
}

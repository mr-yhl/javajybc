package cn.com.mryhl01;

public class Demo01Break {
    public static void main(String[] args) {
        for (int i = 1; i <= 4 ; i++) {
            /*当的值是2时，if后面（)中是true,执行if后面（}中的代码
        首先：执行输出语句打印一句话
        其次：执行break,一旦执行break,本次循环的循环体中break后面的代码将不再执行，而且剩余次数的循环也不再执行，
        也就是说会直接结束for循环，执行for循环后面的其它代码
        相当于执行break时，代码从break的位置跳转到了for循环后面的其它代码继续执行*/
            if (i==2){
                System.out.println("第二个包子上有个蟑螂");
                break;
            }
            System.out.println("正在吃包子"+i);
        }
        System.out.println("赔偿了");
    }
}

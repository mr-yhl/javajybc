package cn.com.mryhl04;
/*do-while循环练习：
        在控制台输出5次Helloworld*/
public class Demo01DowhileHelloworld {
    public static void main(String[] args) {
        int i=1;
        do{
            System.out.println("helloworld--"+i);
            i++;

        }while(i<=5);
        System.out.println("main....end.........");
    }
}

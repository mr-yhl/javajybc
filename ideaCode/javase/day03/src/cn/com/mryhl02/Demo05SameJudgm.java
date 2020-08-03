package cn.com.mryhl02;

public class Demo05SameJudgm {
    public static void main(String[] args) {
        /*
        动物园里有两只老虎，已知两只老虎的体重分别为180kg、200kg,
        请用程序实现判断两只老虎的体重是否相同。
        */
        int w1 = 180, w2 = 200;
        String s = w1 == w2 ? "相同" : "不同";
        System.out.println("两只老虎的体重" + s);
    }
}

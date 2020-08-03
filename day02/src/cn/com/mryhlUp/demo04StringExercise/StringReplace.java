package cn.com.mryhlUp.demo04StringExercise;
/*
程序模拟一个论坛发帖的过程，请用户输入一个发帖内容，例如：

​       “积分看电视了几分我特朗普将反恐文件风IE哦特朗普积分哦忘记特朗普”

​    请将字符串中所有的”特朗普”替换为”*”符号。
 */
public class StringReplace {
    public static void main(String[] args) {
        String s = "积分看电视了几分我特朗普将反恐文件风IE哦特朗普积分哦忘记特朗普";
        System.out.println(s.replace("特朗普", "**"));
    }
}

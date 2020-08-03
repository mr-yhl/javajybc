package cn.com.mryhlUp.demo04StringExercise;
/*
程序模拟一个论坛发帖的过程，请用户输入一个发帖内容，例如：

​       “积分看电视普京了几分我特朗普将反恐文件风IE哦特朗普积分哦忘记普京”

​    请定义一个关键字数组：

​       String[] keyArray = {“特朗普”,”普京”};

​    请将字符串中包含的数组中的关键字替换为*符号。
 */
public class StringReplace2 {
    public static void main(String[] args) {
        String[] keyArray = {"特朗普","普京"};
        String s = "积分看电视普京了几分我特朗普将反恐文件风IE哦特朗普积分哦忘记普京";
        for (int i = 0; i < keyArray.length; i++) {

            s=s.replace(keyArray[i], "**");
        }
        System.out.println(s);
    }
}

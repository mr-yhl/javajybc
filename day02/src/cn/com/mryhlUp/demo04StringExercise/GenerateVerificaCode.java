package cn.com.mryhlUp.demo04StringExercise;

import java.util.Random;

/*
请查看Random、StringBuilder相关API，定义方法，获取一个包含4个字符的验证码，每一位字符是随机选择的字母和数字，可包含a-z,A-Z,0-9。
步骤

1、定义方法，返回值是String，参数列表为空。

2、定义StringBuilder对象，将可选择的字符都放到StringBuilder对象中。

​	2.1、定义循环从a-z，使用StringBuilder的append方法依次添加所有小写字母

​	2.2、定义循环从A-Z，使用StringBuilder的append方法依次添加所有大写字母

​	2.3、定义循环从0-9，使用StringBuilder的append方法依次添加所有数字字符

3、创建Random对象。定义一个空字符串用于保存验证码。

4、定义一个执行4次的循环，用于获取4个字符。

​	4.1、在循环中，使用Random的nextInt方法，随机获取一个从索引0（包含）到字符串的长度（不包含）的索引。

​	4.2、使用StringBuilder的charAt方法，获取该索引上的字符，将其拼接到验证码字符串中。

5、返回结果，并在主方法中调用方法查看结果。
 */
public class GenerateVerificaCode {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            System.out.println(renturnCode());
        }
    }
    public static String renturnCode(){
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch='a';ch<='z';ch++)
            stringBuilder.append(ch);
        for (char ch='A';ch<='Z';ch++)
            stringBuilder.append(ch);
        for (char ch='0';ch<='9';ch++)
            stringBuilder.append(ch);
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            int num=random.nextInt(stringBuilder.length());
            code+=stringBuilder.charAt(num);
        }
        return code;

    }
}

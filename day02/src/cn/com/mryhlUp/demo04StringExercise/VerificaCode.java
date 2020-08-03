package cn.com.mryhlUp.demo04StringExercise;

import java.util.Random;
import java.util.Scanner;

/*
请编写程序模拟验证码的判断过程，如果输入正确，给出提示，结束程序。如果输入错误，给出提示，验证码刷新，重新输入，直至正确为止。
 */
public class VerificaCode {
    public static void main(String[] args) {
        while (true) {
            String s1 = renturnCode();
            System.out.println("生成的验证码为：" + s1);
            System.out.println("请输入验证码");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            if (s.equals(s1)) {
                System.out.println("输入正确");
                return;
            } else
                System.out.println("输入错误，请重新输入...");
        }


    }

    public static String renturnCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++)
            stringBuilder.append(ch);
        for (char ch = 'A'; ch <= 'Z'; ch++)
            stringBuilder.append(ch);
        for (char ch = '0'; ch <= '9'; ch++)
            stringBuilder.append(ch);
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(stringBuilder.length());
            code += stringBuilder.charAt(num);
        }
        return code;

    }

}

package cn.com.mryhlUp.demo04StringExercise;

/*
现有如下文本：
"Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的"。
请编写程序，统计该文本中"Java"一词出现的次数。
 */
public class CountJavaWords {
    public static void main(String[] args) {
        String s = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的";
        int java = -1;
        int count = 0;
        while ((java = s.indexOf("Java")) != -1) {
            count++;
            s = s.substring(java + 4);
        }
        System.out.println("Java一共出现了" + count + "次");
    }
}

package cn.com.mryhlUp.demo02String;
/*
字符串比较
- `public boolean equals (Object anObject) ` ：将此字符串与指定对象进行比较。

- ` public boolean equalsIgnoreCase (String anotherString) ` ：将此字符串与指定对象进行比较，忽略大小写。

- `public boolean contains (CharSequence s)`：判断参数字符串在当前字符串中是否存在(区分大小写)。存在，返回true，否则，返回false。

- `public boolean endsWith(String suffix)`：测试此字符串是否以指定的后缀结尾(区分大小写)。

- `public boolean startsWith(String prefix)`：测试此字符串是否以指定的前缀开始(区分大小写)
 */
public class Demo03StringMethod {
    public static void main(String[] args) {
        String s = "abcd";
        String s1 = new String("abcd");
        String s2 = "ABCD";
        // - `public boolean equals (Object anObject) ` ：将此字符串与指定对象进行比较。
        System.out.println(s.equals(s2));
        System.out.println(s.equals(s1));

        // - ` public boolean equalsIgnoreCase (String anotherString) ` ：将此字符串与指定对象进行比较，忽略大小写。
        System.out.println(s.equalsIgnoreCase(s2));
        System.out.println(s.equalsIgnoreCase(s1));

        // - `public boolean contains (CharSequence s)`：判断参数字符串在当前字符串中是否存在(区分大小写)。存在，返回true，否则，返回false。
        System.out.println(s.contains("c"));
        System.out.println(s.contains("cf"));

        // - `public boolean endsWith(String suffix)`：测试此字符串是否以指定的后缀结尾(区分大小写)。
        System.out.println(s.endsWith("d"));
        // - `public boolean startsWith(String prefix)`：测试此字符串是否以指定的前缀开始(区分大小写)
        System.out.println(s.startsWith("a"));

    }
}

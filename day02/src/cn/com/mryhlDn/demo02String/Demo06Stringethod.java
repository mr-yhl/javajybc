package cn.com.mryhlDn.demo02String;
/*
字符串的获取的方法
length() :返回此字符串的长度。
concat(String str) :将指定的字符串连接到该字符串的末尾。返回新字符串
charAt(int index) :返回 char指定索引处的值。
indexOf(String str) :返回指定子字符串第一次出现的字符串内的索引。没有找到返回-1
lastIndexOf(String str) :返回指定子字符串最后一次出现的字符串中的索引。没有找到返回-1
substring(int beginIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串
substring(int beginIndex, int endIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串,包含头,不包含尾

 */
public class Demo06Stringethod {
    public static void main(String[] args) {
        //length() :返回此字符串的长度。
        String s = "helloworld";
        System.out.println("字符串的长度为:" + s.length());
        System.out.println("================");
        // charAt(int index) :返回 char指定索引处的值。
        System.out.println("字符串索引为1的字符" + s.charAt(1));
        System.out.println("================");
        // indexOf(String str) :返回指定子字符串第一次出现的字符串内的索引。
        System.out.println("查找o在字符串第一次出现的索引" + s.indexOf("o"));
        System.out.println("查找owo在字符串第一次出现的索引" + s.indexOf("owo"));
        System.out.println("查找nihao在字符串第一次出现的索引" + s.indexOf("nihao"));
        System.out.println("================");
        // lastIndexOf(String str) :返回指定子字符串最后一次出现的字符串中的索引。
        System.out.println("查找o在字符串最后次出现的索引" + s.lastIndexOf("o"));
        System.out.println("查找or在字符串最后次出现的索引" + s.lastIndexOf("or"));
        System.out.println("查找abc在字符串最后次出现的索引" + s.lastIndexOf("abc"));
        System.out.println("================");
        // concat(String str) :将指定的字符串连接到该字符串的末尾。返回新字符串
        String s2=s.concat("hihao");
        System.out.println(s2);
        System.out.println("================");
        // substring(int beginIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串
        s.substring(5);
        System.out.println(s);
        System.out.println(s.substring(5));//从索引为5的位置进行截取
        System.out.println("================");
        // substring(int beginIndex, int endIndex) :返回一个字符串，该字符串是此字符串的子字符串。返回新字符串

        s.substring(5,7);
        System.out.println(s);
        System.out.println(s.substring(3,6));//从索引为5的位置进行截取

        System.out.println("================");
        

    }
}

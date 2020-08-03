/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 11:59:06
 * @Topic request: char和int的运算原理
 */
public class Demo10Char {
    public static void main(String[] args) {
        char ch = 'a';
        System.out.println(ch);

        System.out.println(ch + 1);
        System.out.println((char) (ch + 1));
    }
}
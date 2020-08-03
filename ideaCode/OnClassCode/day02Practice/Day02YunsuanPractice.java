/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 16:43:56
 * @Topic request: 定义一个int类型的变量,初始化值为1234,求这个数的个位,十位,百位,千位分别是多少?

运行效果:

​	1234的个位是4,十位是3,百位是2,千位是1
 */
public class Day02YunsuanPractice {
    public static void main(String[] args) {
        int num = 1234;
        int g, s, b, q;
        g = num % 10;
        s = num % 100 / 10;
        b = num % 1000 / 100;
        q = num / 1000;
        System.out.println(num + "的个位是" + g + ",十位是" + s + ",百位是" + b + "千位是" + q);

    }
}
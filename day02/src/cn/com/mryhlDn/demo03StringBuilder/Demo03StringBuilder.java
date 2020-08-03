package cn.com.mryhlDn.demo03StringBuilder;
/*
StringBuilder常见方法
    StringBuilder append(任何类型)： 拼接（追加）任何类型的数据。返回值为调用者对象本身。
        StringBuilder reverse(): 对StringBuilder的内容反转。返回值为调用者对象本身。
        String toString()： 将StringBuilder转成一个String。

 */
public class Demo03StringBuilder {
    public static void main(String[] args) {
        //创建StringBuilder对象
        StringBuilder sb = new StringBuilder();
        //StringBuilder append(任何类型)： 拼接（追加）任何类型的数据
        //StringBuilder newSb = sb.append("你好");
        //输出结果
        //System.out.println("sb:" + sb);
        //System.out.println("newSb:" + newSb);

        //向sb对象上拼接任何类型的数据


        //链式编程
        sb.append("你好").append("我好").append("大家好");
        System.out.println("反转前sb:" + sb);//你好我好10

        //StringBuilder reverse(): 对StringBuilder的内容反转。返回值为调用者对象本身。
        sb.reverse();
        System.out.println("反转后sb:" + sb);//01好我好你

        //String toString()： 将StringBuilder转成一个String。
        String ss = sb.toString();
        System.out.println("字符串ss:" + ss);//01好我好你
    }
}

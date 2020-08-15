package cn.com.mryhl.demo05_regex;
/*
    正则表达式可以验证一个字符串是否符合规则。

    String中有一个用来使用正则表达式验证规则方法
        boolean matches(String regex)：根据正则表达式验证字符串是否符合规则

    正则表达式的规则：
        [abc]：代表a或者b，或者c字符中的一个。
        [^abc]：代表除a,b,c以外的任何字符。
        [a-z]：代表a-z的所有小写字符中的一个。
        [A-Z]：代表A-Z的所有大写字符中的一个。
        [0-9]：代表0-9之间的某一个数字字符。
        [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
        [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。

        \d 数字：[0-9]
        \D 非数字： [^0-9]
        \s 空白字符：[ \t\n\x0B\f\r]
        \S 非空白字符：[^\s]
        \w 单词字符：[a-zA-Z_0-9]
        \W 非单词字符：[^\w]

        ?：0次或1次
        *：任意次
        +：1次或多次
        {n}：出现n次
        {n,}：至少n次
        {n,m}：至少n次，最多m次

 */



public class Demo01Regex {
    public static void main(String[] args) {
        //验证QQ号是否符合规则。要求： 必须是5-12位的数字， 首位不能是0
        String qq = "124959292";
        boolean flag = qq.matches("[1-9][0-9]{4,11}");
        System.out.println(flag);
        //验证手机号是否符合规则。 要求：必须是11位，第一位必须是1， 第二位必须是3,5,7,8,9，剩下的必须是0-9数字
        String phone = "16885885";
        boolean flag2 = phone.matches("1[35789][0-9]{9}");
        System.out.println(flag2);
        //验证邮箱 xxx@itcast.cn    xxx@sina.com.cn
        String email = "jags@126.com.cn.xxx";
        boolean flag3 = email.matches("\\w+@\\w+(\\.\\w+)+");
        System.out.println(flag3);
    }

}

package cn.com.mryhl.demo03_class;
/*
根据Student类创建Student对象

创建对象
1.导包
2.创建对象
    数据类型 对象名 = new 数据类型();
3.使用成员
    对象名.属性名
    对象名.成员方法()

    2个对象的内存图
*/


public class Demo02PhoneTest {
    public static void main(String[] args) {
        //创建对象
        Phone phone1 = new Phone();
        //赋值
        phone1.brand = "huawei";
        phone1.price = 2999;
        phone1.color = "幻夜黑";
        System.out.println(phone1);
        System.out.println("品牌" + phone1.brand);
        System.out.println("价格" + phone1.price);
        System.out.println("颜色" + phone1.color);
        // phone1.call("张三");
        // phone1.sendMessage();
        Phone phone2 = new Phone();
        phone2.brand = "honor";
        phone2.price = 1999;
        phone2.color = "珠光白";
        System.out.println(phone2);
        System.out.println("品牌" + phone2.brand);
        System.out.println("价格" + phone2.price);
        System.out.println("颜色" + phone2.color);


    }
}

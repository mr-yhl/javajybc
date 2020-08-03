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
*/



public class Demo01PhoneTest {
    public static void main(String[] args) {
        //创建对象
        Phone phone = new Phone();
        //输出默认
        System.out.println(phone);
        System.out.println("品牌"+phone.brand);
        System.out.println("价格"+phone.price);
        System.out.println("颜色"+phone.color);
        //赋值
        phone.brand="huawei";
        phone.price=2999;
        phone.color="幻夜黑";
        System.out.println("品牌"+phone.brand);
        System.out.println("价格"+phone.price);
        System.out.println("颜色"+phone.color);
        phone.call("张三");
        phone.sendMessage();




    }
}

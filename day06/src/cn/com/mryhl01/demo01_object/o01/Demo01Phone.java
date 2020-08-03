package cn.com.mryhl01.demo01_object.o01;
/*
  请按标准格式定义一个“手机类”，它有三个属性：品牌(String)、颜色(String)、价格(double)

​    请编写测试类，创建两个“手机对象”并为它们的属性赋值，并能直接打印手机对象的属性信息。
 */
public class Demo01Phone {
    public static void main(String[] args) {
        Phone p1 = new Phone("HUAWEI", "幻夜黑", 4999.0);
        Phone p2 = new Phone("HONOR", "冰河银", 3699.0);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}

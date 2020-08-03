package cn.com.mryhl.demo16_homework.c02;
/*
测试类
 */
public class Demo {
    public static void main(String[] args) {
        BenCar benCar = new BenCar("奔驰",250000);
        benCar.Run();
        BmwCar bmwCar = new BmwCar("宝马",630000);
        bmwCar.Run();
        bmwCar.gps();
        YaMMt yaMMt = new YaMMt("雅马哈摩托",25003);
        yaMMt.Run();
        BmwMt bmwMt = new BmwMt("宝马摩托",450000);
        bmwMt.Run();
        bmwMt.gps();
    }
}

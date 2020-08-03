package cn.com.mryhl.demo16_homework.c02;

public class BmwCar extends SmallCar implements Gps{
    @Override
    public void gps() {
        System.out.println("系统定位中");
    }

    public BmwCar() {
    }

    public BmwCar(String name, int price) {
        super(name, price);
    }
}

package cn.com.mryhl.demo16_homework.c02;
/*
机车类
    属性:品牌,价格
    行为:运行
 */

public  class Car {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void Run(){
        System.out.println(name + "车,价格为:" + price + "元的车正在运行");
    }
}

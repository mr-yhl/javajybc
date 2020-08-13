package cn.com.mryhl.demo04_factory;

/*
    用来生产小汽车的工厂
 */
public class CarFactory {
    /*
        定义方法，用来获取小汽车
     */
    public static Car getCar(String carName) {
        //判断如果carName是法拉利，就返回法拉利对象
        if (carName.equals("法拉利")) {
            return new FaLali();
        } else if (carName.equals("奥拓")) {
            return new AoTuo();
        } else {
            //其他的全部返回null值
            return null;
        }
    }
}
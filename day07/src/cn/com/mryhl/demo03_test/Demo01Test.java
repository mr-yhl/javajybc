package cn.com.mryhl.demo03_test;
/*
定义接口USB,并提供抽象方法run
在测试类中定义一个方法，该方法中接收USB接口作为参数，并在方法中让USB设备运行
再定义一个方法，该方法用来获取一个USB设备。【在方法中创建USB实现类对象并返回】



如果接口作为方法参数，我们需要传递他的实现类对象。

 */
public class Demo01Test {
    public static void main(String[] args) {
        //调用useUSB方法
        useUSB(new Mouse());
        USB usb = createUSB();
        useUSB(usb);
    }

    /*
    在测试类中定义一个方法，该方法中接收USB接口作为参数，并在方法中让USB设备运行
    参数:USB接口
    返回值:void
     */
    public static void useUSB(USB usb){
        usb.run();
    }
    /*
    再定义一个方法，该方法用来获取一个USB设备。【在方法中创建USB实现类对象并返回】
    参数:没有
    返回值: USB
     */

    public static USB createUSB(){
        return new KeyBoard();
    }

}

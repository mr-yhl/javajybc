package cn.com.mryhl.demo08_extends_interface;

public class JiDuDog extends Dog implements JiDuInterface{
    @Override
    public void say() {
        System.out.println("汪汪叫");
    }

    @Override
    public void eat() {
        System.out.println("排队吃");
    }

    @Override
    public void jiduMethod() {
        System.out.println("缉毒功能");
    }
}

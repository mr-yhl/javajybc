package cn.com.mryhl.deno09_proxy;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 16:54
 */
public class Car implements Carable{
    @Override
    public void run() {
        System.out.println("小汽车跑");
    }

    @Override
    public String say() {
        System.out.println("按喇叭");
        return "滴滴";
    }
}

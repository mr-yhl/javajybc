package cn.com.mryhl.demo08_anno_test;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/10 16:21
 */
public class TestDemo {
    public void methodOne(){
        System.out.println("methodOne");
    }
    @MyTest
    public void methodTwo(){
        System.out.println("methodTwo");
    }
    public void methodThree(){
        System.out.println("methodThree");
    }
    @MyTest
    public void methodFour(){
        System.out.println("methodFour");
    }
    public void methodFive(){
        System.out.println("methodFive");
    }
}

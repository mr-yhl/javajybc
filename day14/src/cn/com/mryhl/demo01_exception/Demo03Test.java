package cn.com.mryhl.demo01_exception;
/*
try...with...resource语句
在try小括号中创建的对象，必须要使用AutoCLoseable接口
*/
public class Demo03Test {
    public static void main(String[] args) {
        try (Person p = new Person()){//Person close

        }catch (Exception e){

        }
    }
}

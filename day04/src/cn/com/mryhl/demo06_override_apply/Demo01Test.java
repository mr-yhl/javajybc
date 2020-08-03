package cn.com.mryhl.demo06_override_apply;

public class Demo01Test {
    public static void main(String[] args) {
        // 创建对象
        NewPhone newPhone = new NewPhone();
        // v调用方法
        newPhone.call();
        newPhone.sendMessage();

        newPhone.show();
    }
}

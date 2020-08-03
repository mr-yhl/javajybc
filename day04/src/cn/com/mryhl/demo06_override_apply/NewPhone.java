package cn.com.mryhl.demo06_override_apply;

public class NewPhone extends Phone{
    // 来电显示功能更新

    @Override
    public void show() {
        System.out.println("号码+姓名+归属地");
        super.show();//调用父类的show方法
    }
}

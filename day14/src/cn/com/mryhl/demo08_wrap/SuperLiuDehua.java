package cn.com.mryhl.demo08_wrap;
// 超级
public class SuperLiuDehua implements Start{
    // 接收一个被装饰(增强)的对象
    private LiuDehua liudehua;
    // 创建构造方法,用来接收外界传来的对象
    public SuperLiuDehua(LiuDehua liudehua) {
        this.liudehua = liudehua;
    }
    // 增强了
    @Override
    public void sing() {
        System.out.println("超级刘德华在鸡窝唱歌,下面好的公鸡叫");
    }
    // 不对跳舞方法增强,直接通过普通的调用
    @Override
    public void dance() {
        liudehua.dance();
    }
}

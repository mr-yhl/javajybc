package cn.com.mryhl.demo14_noname;
/*
使用匿名内部类当参数传递
 */
public class Demo03Test {
    public static void main(String[] args) {
        // 调用showEat()
        showEat(new Dog());
        showEat(new Animal(){

            @Override
            void eat() {
                System.out.println("吃饭饭");
            }
        });

    }
    public static void showEat(Animal a){
        a.eat();
    }
}

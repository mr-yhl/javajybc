package cn.com.mryhl.demo15_ext;

/*
匿名内部类真正也是有名字的
名字:外部类$num
*/

public class Demo01Test {
    public static void main(String[] args) {
        new Animal(){

            @Override
            void eat() {
                System.out.println("吃饭");
            }
        }.eat();
        // Demo01Test$1.eat();
        // new Demo01Test$1();
        while (true){

        }
    }
}

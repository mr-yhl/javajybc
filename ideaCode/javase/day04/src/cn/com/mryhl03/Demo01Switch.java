package cn.com.mryhl03;
//switch简单练习
public class Demo01Switch {
    public static void main(String[] args) {
        int num = 1;
        switch (num){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("666");
                break;
        }
        System.out.println("main   end");
    }
}

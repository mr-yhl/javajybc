package cn.com.mryhl.ex;

public class Demo02TryCatchFinally {
    public static void main(String[] args) {
        try{
            System.out.println("1.....");
            Object obj = null;
            obj.toString();
            System.out.println("2.....");
        }catch (Exception e){
            System.out.println(e + "3.....");
        }finally {
            System.out.println("4.....");
        }
        System.out.println("main...end");
    }
}

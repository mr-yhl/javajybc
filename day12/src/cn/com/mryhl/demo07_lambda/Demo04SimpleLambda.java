package cn.com.mryhl.demo07_lambda;
/*Lambda标准格式：
        (参数类型 参数名) -> {
        方法体;
        return 返回值;
        }

        省略规则：
        1. 小括号中的参数类型可以省略。
        2. 如果小括号中只有一个参数，那么可以省略小括号。
        3. 如果大括号中只有一条语句，那么可以省略大括号，return，以及分号。*/
public class Demo04SimpleLambda {
    public static void main(String[] args) {
        //使用Lambda标准格式完成多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了");
        }).start();
        //使用Lambda表达式省略格式完成多线程
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "执行了")).start();
    }
}

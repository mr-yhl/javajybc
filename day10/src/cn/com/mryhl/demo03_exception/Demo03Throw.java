package cn.com.mryhl.demo03_exception;

/*
throw:用来手动向外抛出异常
格式：
    throw new 异常类名();
使用场景：
    如果我们想要手动制造一个问题，就可以用throw关键字，比如年龄录入的是错误的，我们希望程序直接报错，
    就可以使用throw关键字手动向外抛出异常

注意：
    在创建异常对象时，我们也可以通过在小括号中传递一个字符申类型的异常信息
 */

public class Demo03Throw {
    public static void main(String[] args) {
        int[] arr = new int[4];
        int value = getValue(arr, 10);
        System.out.println(value);
    }
    /*
       定义方法，该方法获取数组指定素引位置的元素
    */
    public static int getValue(int[] arr,int index){
        // 对索引进行一个判断,如果索引不合法,手动抛越界异常
        if (index<0||index>=arr.length){
            // 手动抛出异常
            //throw new ArrayIndexOutOfBoundsException("索引出问题了");
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int i = arr[index];
        return i;
    }
}

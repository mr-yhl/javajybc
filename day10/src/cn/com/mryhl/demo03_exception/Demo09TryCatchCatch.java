package cn.com.mryhl.demo03_exception;
/*

try后面可以追加任意个catch
格式：
    try{
        可能出现异常的代码；
    }catch(类名 变量名）{
        出现异常后执行的代码
    }catch(类名 变量名）{
        出现异常后执行的代码
    }catch(类名 变量名）{
        出现异常后执行的代码
    }catch(类名 变量名）{
        出现异常后执行的代码
    }
作用:
    用来捕获多种异常

执行流程：
第一种情况：如果try中的代码没有异常，所有的catch都不会执行
第二种情况：如果try中的代码有异常，那么哪个catch先铺获到这个异常，那么就执行哪个catch中的代码。
第三种情况：如果try中的代码有异常，但是所有的catch都没有描获到，那么这个异常会依旧向外地。

注意：如果多catch辅获异常时，父类异常不能放到子类异常的前面。

 */
public class Demo09TryCatchCatch {
    public static void main(String[] args) {
        try {
            System.out.println("1.....try Start");
            //Object obj = new Object();//1次
            Object obj = null;//次
            obj.toString();
            System.out.println("2.....try end");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("3...ArrayIndexOutOfBoundsException");
        }catch (NullPointerException e){
            System.out.println("4...NullPointerException");
        }catch (ClassCastException e){
            System.out.println("5...ClassCastException");
        }catch (Exception e){//3次,后加,注释NullPointerException
            System.out.println("6...Exception");
        }

        System.out.println("7.main   end");
    }
}
// 1次
/*
1.....try Start
2.....try end
6.main   end
 */
// 2次
/*
1.....try Start
4...NullPointerException
6.main   end
 */
// 3次
/*1.....try Start
6...Exception
7.main   end*/
//4次
/*1.....try Start
4...NullPointerException
7.main   end
*/
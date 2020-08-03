package cn.com.mryhl;
/*定义方法exist，该方法用来判断指定元素在数组中是否存在。
        在main方法中定义数组，数组中的元素为{3,5,2,6,1}，
        调用exist方法，判断该数组中是否包含2，并输出结果。*/
public class Fore {
    public static void main(String[] args) {
        int[] array = {3,5,2,6,1};
        int Glasses;
        boolean result = exist(array);
        System.out.println("数组中是否包含2:"+result);
    }
    public static boolean exist(int[] array){
        for (int i = 0; i <  array.length ; i++) {
           if (array[i]==2)
               return true;
        }
        return false;
    }
}

package cn.com.mryhl;

public class Demo99MultipliTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int i1 = 1; i1 <= i; i1++) {
                if(i1==i)
                    System.out.println(i+"*"+i1+"="+(i*i1)+";");
                else
                    System.out.print(i+"*"+i1+"="+(i*i1)+";\t");
            }

        }
    }
}

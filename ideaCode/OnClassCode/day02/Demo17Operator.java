/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 14:38:41
 * @Topic request: 自增自减练习题
 */ 
public class Demo17Operator {
    public static void main(String[] args) {
        int x=4;
        /*
        4+6+60=70
        
        */
        int y =(x++)+(++x)+(x*10);

        System.out.println(x);//6
        System.out.println(y);//70
    }

}

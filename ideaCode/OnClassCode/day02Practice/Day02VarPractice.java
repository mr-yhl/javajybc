import jdk.nashorn.internal.ir.Flags;

/*
  * @Autor: 杨海林
  * 
  * @Date: 2020-06-26 16:08:19
  * 
  * @Topic request: 请根据下列描述，选用合适的数据类型定义变量，并输出变量的值。
    1)班级里有100个学员。  int
    2)某商品价格55.55元。  double
    3)地球已经诞生超过46亿年。  long  (int最大大约21亿)
    4)“5是偶数”这句话的描述是假的。String  s = “5是偶数”;
  */
public class Day02VarPractice {
    public static void main(String[] args) {
        int numStudent = 100;
        double priceCommodity = 55.55;
        long earthAge = 4600000000l;
        String s = "“5是偶数”";
        System.out.println("班级里有" + numStudent + "个学员。");
        System.out.println("某商品价格" + priceCommodity + "元。");
        System.out.println("地球已经诞生超过" + earthAge + "年。");
        System.out.println(s + "这句话的描述是假的。");
    }
}

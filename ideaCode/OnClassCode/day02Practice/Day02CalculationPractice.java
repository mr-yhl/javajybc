/*
 * @Autor: 杨海林
 * @Date: 2020-06-26 16:24:18
 * @Topic request: 子女的身高和父母的身高有一定的关系。假定，父母和子女的身高遗传关系如下：

​	儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2

​	女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2

现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？
 */
public class Day02CalculationPractice {
    public static void main(String[] args) {
        int heightFu = 177, heightMu = 165;
        int heightSon, heightD;
        heightSon = (int) ((heightFu + heightMu) * 1.08 / 2);
        heightD = (int) (heightFu * 0.923 + heightMu) / 2;
        System.out.println("儿子的身高是" + heightSon);
        System.out.println("女儿的身高是" + heightD);
    }
}
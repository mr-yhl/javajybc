package cn.com.mryhl.demo09_shouji;
/*在Stream中有一个方法叫做toArray，可以将流中的内容收集到数组中（将流转成数组）
Object[] toArray():将流转成数组
 */

import java.util.Arrays;
import java.util.stream.Stream;
public class Demo02StreamToArray {
     public static void main(String[] args) {
         //获取Stream流
         Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
         Object[] objects = stream.toArray();
         //输出
         System.out.println(Arrays.toString(objects));
     }
}

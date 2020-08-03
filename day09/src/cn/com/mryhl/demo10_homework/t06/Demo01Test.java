package cn.com.mryhl.demo10_homework.t06;

import java.util.HashMap;
import java.util.StringJoiner;

/*String str = “fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew”;

​       请编程统计每个字符出现的次数*/
public class Demo01Test {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String str = "fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch,map.containsKey(ch)?map.get(ch)+1:1);
        }
        System.out.println(map);
        // {你=2, A=2, a=1, D=1, e=4, E=2, f=4, F=5, j=4, k=1, o=1, 我=2, Q=1, 2=1, 他=2, w=2}
    }
}

package cn.com.mryhl.demo07_map;
/*

Map集合不能直接通过送代器或者增强for遍历
如果要遍历Map集合，我们可以先获取到Map集合中所有的键，将所有的键放在set集合中,遍历set集合.
拿到set集合中的键,根据键获取对应的值.

Map中获取所有键的方法:
  Set<K> keySet():可以获取到所有的键，并将所有的键放入到Set集合中返回 .
KeySet遍历步骤:
    1. 调用Map集合的keySet方法获取到所有的键，然后放入到Set集合中。
    2. 遍历Set集合，拿到里面的每一个键。
    3. 调用Map集合的get方法，根据键获取对应的值。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo02KeySet {
    public static void main(String[] args) {
        // 创建集合
        Map<String, String> map = new HashMap<>();
        // 添加元素
        map.put("it001","龚大索");
        map.put("it002","严勃");
        map.put("it003","欧安");
        map.put("it004","讽德郭");
        //  调用Map集合的keySet方法获取到所有的键，然后放入到Set集合中。
        Set<String> keys = map.keySet();
        //遍历set集合,拿到key值
        for (String key : keys) {
            //根据遍历到的继获取对应的值【变量key表示每一个键】
            String s = map.get(key);
            System.out.println(key + "-" + s);
            /*
            it004-讽德郭
            it003-欧安
            it002-严勃
            it001-龚大索
             */
            // System.out.println(key);
            /*
            it004
            it003
            it002
            it001
             */
        }

    }
}

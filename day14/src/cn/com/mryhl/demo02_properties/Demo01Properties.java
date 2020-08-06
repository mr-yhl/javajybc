package cn.com.mryhl.demo02_properties;
/*
Properties是一个双列集合，也叫做属性集
特点：
    1.Properties实现JMap接口，拥有Map接口中的所有的方法。
    2.Properties没有泛型，键和值都是字符申。
    3.Properties可以从流【文件中】中读取键值对

Properties构造方法：
    Properties():空参数的构造方法
Properties其他方法：
    Object setProperty(string key, String value):添加键值对
    String getProperty(String key):根据键获取值。
    Set<String>stringPropertyNames():获取所有的健并放入到Set集合中返回。
 */


import java.util.Properties;
import java.util.Set;

public class Demo01Properties {
    public static void main(String[] args) {
        // 创建Properties
        Properties p = new Properties();
        // 添加键值对元素
        p.setProperty("mryhl1","sgds");
        p.setProperty("mryhl2","sgds");
        p.setProperty("mryhl3","sgds");
        // 可以用,不推荐
        p.put("mryhl4","sfgssg");
        // 输出
        //System.out.println(p);//{mryhl3=sgds, mryhl2=sgds, mryhl1=sgds}
        // String getProperty(String key):根据键获取值。
        System.out.println(p.getProperty("mryhl1"));//sgds
        System.out.println("=====");
        Set<String> set = p.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+"-"+p.getProperty(s));
        }
    }
}

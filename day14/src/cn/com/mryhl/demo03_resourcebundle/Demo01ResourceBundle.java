package cn.com.mryhl.demo03_resourcebundle;
/*
除了Properties之外，Java中还提供了ResourceBundle用来读取properties配置文件中的内容。
ResourceBundle操作更简便。

ResourceBundle是一个抽象类，如果要用，需要使用子类，他的子类对象不是需要我们自己new的，而是
要通过ResourceBundLe的静态方法获取的

ResourceBundle方法：
    static ResourceBundle getBundle(String baseName):获取ResourceBundle子类对象。参数表示要操作的配置文件的路径。
    String getString(String key):根据键获取值。

ResourceBundle读取的properties必须放到src目录下,在调用getBundle传递文件路径时,不要带拓展名
 */


import java.util.ResourceBundle;

public class Demo01ResourceBundle {
    public static void main(String[] args) {
        // 获取ResourceBundle.参数文件的路径是从src下面开始找,参数不带扩展名
        ResourceBundle bundle = ResourceBundle.getBundle("file04");
        // 调用方法,根据键获取值
        System.out.println("username=" + bundle.getString("username"));
        System.out.println("password=" + bundle.getString("password"));
    }

}

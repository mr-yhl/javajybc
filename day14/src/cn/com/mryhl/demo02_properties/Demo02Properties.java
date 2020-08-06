package cn.com.mryhl.demo02_properties;
/*
Properties有关流方法，可以从文件中读取键值对
    void Load(Inputstream inStream):参数要传递字节输入流
    void Load(Reader reader):参数要传递字符输入流
上面的Load方法可以传递输入流，该输入流绑定的文件是什么，就可以从该文件中加载（读取）键值对。

文件的要求：
    1.文件一般以.properties结店【软性规定，properties文件也叫做配置文件】
    2.文件中的健值对必须按照指定格式存放【硬性规定】
    键=值
    键和值之间用=号隔开，每一个键值对之间换行。
Properties从文件读取键值对的步骤
    1.创建Properties对象
    2.创建输入流，绑定文件。
    3.调用Properties的Load从文件中读取健值对
    4.释放资源
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo02Properties {
    public static void main(String[] args) throws IOException {
        // 创建properties
        Properties p = new Properties();
        // 创建输入流,绑定文件
        FileInputStream is = new FileInputStream("day14\\file03.properties");
        // 调用Load方法，从文件读取键值对
        // 因为输入流绑定的是fiLe03.properties文件，所以调用Load方法，是将该文件的键值对读取到Properties

        p.load(is);
        // 关闭流
        is.close();
        System.out.println(p);

    }
}

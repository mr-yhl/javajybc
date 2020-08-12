package cn.com.mryhl.demo01_parse;
/*
xpath可以根据一个表达式获取指定的元素。

步骤：
    1.导包（dom4j-1.6.1.jar和jaxen-1.1-beta-6.jar）
    2. 通过SAXReader读取xml获取document对象。
    3. 调用方法，根据xpath表达式获取元素。

document中根据xpath获取元素的方法主要有两个：
    List selectNodes("xpath表达式")：获取多个满足要求的元素
    Node selectSingleNode("xpath表达式")：获取一个满足要求的元素(第一个)

表达式的规则：
    1. 绝对路径表达式方式 例如: /元素/子元素/子子元素...  [绝对路径从根开始找]
    2. 相对路径表达式方式 例如: 子元素/子子元素.. 或者 ./子元素/子子元素..  [相对路径从当前元素]
    3. 全文搜索路径表达式方式 例如: //子元素//子子元素
    4. 谓语（条件筛选）方式 例如: //元素[@属性名=属性值]
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo03XPath {
    public static void main(String[] args) throws DocumentException {
        // 创建SAXPReader
        SAXReader reader = new SAXReader();
        // 调用read方法获取
        Document document = reader.read("day18\\book.xml");
        // 4. 谓语（条件筛选）方式 例如: //元素[@属性名=属性值]
        Node node3 = document.selectSingleNode("//book[@id=0002]//author");
        System.out.println(node3.getText());

        System.out.println("====");
        // 3. 全文搜索路径表达式方式 例如: //子元素//子子元素
        Node node2 = document.selectSingleNode("//author");
        System.out.println(node2.getText());

        System.out.println("====");
        // 2. 相对路径表达式方式 例如: 子元素/子子元素.. 或者 ./子元素/子子元素..  [相对路径从当前元素]
        Element rootElement = document.getRootElement();
        Node node1 = rootElement.selectSingleNode("book/name");
        System.out.println(node1.getText());

        System.out.println("====");
        //  1. 绝对路径表达式方式 例如: /元素/子元素/子子元素...  [绝对路径从根开始找]
        // 获取一个元素
        // Node node = document.selectSingleNode("/books/book/sale");
        // 获取元素的文本输出
        // System.out.println(node.getText());
        // 获取所有author
        List<Node> list = document.selectNodes("/books/book/author");
        for (Node node : list) {
            System.out.println(node.getText());
        }
    }
}

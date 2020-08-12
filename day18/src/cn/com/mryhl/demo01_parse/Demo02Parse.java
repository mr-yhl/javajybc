package cn.com.mryhl.demo01_parse;
/*
使用DOM4J解析XML

准备：
1. 导入jar包（dom4j-1.6.1.jar）
2. 准备读取相关的xml
3. 相关API
    SAXReader核心类
        read方法可以读取xml文件，生成dom树并创建Document对象
    Document表示整个的xml文档
        getRootElement获取根元素
    Element表示元素
        List elements() 获得指定名称的所有子元素。可以不指定名称
        Element element(String ele) 获得指定名称第一个子元素。可以不指定名称
        String getName() 获得当前元素的元素名
        String attributeValue(String attrName) 获得指定属性名的属性值
        String elementText(Sting ele) 获得指定名称子元素的文本值
        String getText() 获得当前元素的文本内容
步骤:
1. 创建SAXReader对象
2. 调用read方法，读取xml文件，创建Document对象
3. 调用getRootElement获取根元素
4. 解析...
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo02Parse {
    public static void main(String[] args) throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //调用read方法，读取xml文件，创建Document对象
        Document document = reader.read("day18\\book.xml");
        //调用getRootElement获取根元素
        Element rootElement = document.getRootElement();
        //调用elements获取子元素
        List<Element> bookList = rootElement.elements();
        //遍历集合，拿到集合中的每一个book元素
        for (Element bookElement : bookList) {
            //获取book元素上的id属性值
            String id = bookElement.attributeValue("id");
            System.out.println("id = " + id);
            //获取book元素中的所有的子元素
            List<Element> bookChildList = bookElement.elements();
            //遍历集合，拿到里面的每一个子元素
            for (Element bookChildElement : bookChildList) {
                //调用getName获取元素的名字
                String name = bookChildElement.getName();
                //调用getText获取元素中的文本内容
                String value = bookChildElement.getText();
                System.out.println(name + ":" + value);
            }
        }


    }
}

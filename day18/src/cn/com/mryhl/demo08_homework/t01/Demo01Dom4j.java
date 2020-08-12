package cn.com.mryhl.demo08_homework.t01;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Author: 杨海林(Harley)
 * @Date: 2020/8/12 19:42
 */
public class Demo01Dom4j {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("day18\\homework\\books.xml");
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                String name = element1.getName();
                String text = element1.getText();
                System.out.println(name + "=" + text);
            }
        }

    }
}

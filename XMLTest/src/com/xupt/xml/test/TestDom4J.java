package com.xupt.xml.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-13 16:13
 */
public class TestDom4J {

    /**
     * dom4j 获取Documet 对象
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    /**
     * 读取XML的内容
     */
    @Test
    public void test2() throws Exception {
        // 第一步，通过创建SAXReader 对象。来读取xml 文件，获取Document 对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        // 第二步，通过Document 对象。拿到XML 的根元素对象
        Element root = document.getRootElement();
        // 打印测试
        // Element.asXML() 它将当前元素转换成为String 对象
        // System.out.println( root.asXML() );
        // 第三步，通过根元素对象。获取所有的book 标签对象
        // Element.elements(标签名)它可以拿到当前元素下的指定的子元素的集合
        List<Element> books = root.elements("book");
        // 第四小，遍历每个book 标签对象。然后获取到book 标签对象内的每一个元素，
        for (Element book : books) {
        // 测试
        // System.out.println(book.asXML());
        // 拿到book 下面的name 元素对象
        Element nameElement = book.element("name");
        // 拿到book 下面的price 元素对象
        Element priceElement = book.element("price");
        // 拿到book 下面的author 元素对象
        Element authorElement = book.element("author");
        // 再通过getText() 方法拿到起始标签和结束标签之间的文本内容
        System.out.println("书名" + nameElement.getText() + " , 价格:"
                    + priceElement.getText() + ", 作者：" + authorElement.getText());
        }

    }
}

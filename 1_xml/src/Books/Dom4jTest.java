package Books;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
   public void test() throws Exception{
       SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/book.xml");
        System.out.println(document);

        //得到根元素，没有父标签的标签对象
        Element rootElement = document.getRootElement();
        //根据标签名查找子类标签
        List<Element> books = rootElement.elements("book");
        //遍历，处理每个book标签为book类
        for (Element book:books){
            //标签对象转换为标签字符串
            Element name = book.element("name");
            //提取字符标签的内容
            String bookName = name.getText();
            //直接提取字符串内容
            String authorName = book.elementText("author");
            String bookPrice = book.elementText("price");
            //标签属性的字符串内容提取方法
            String bookSn = book.attributeValue("sn");


            System.out.println(new Book(bookName,authorName,bookSn, BigDecimal.valueOf(Double.parseDouble(bookPrice))));
        }
    }
}
